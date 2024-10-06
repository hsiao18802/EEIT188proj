<template>
  <div>
    <!-- Tabs: 訂單分類 -->
   <el-tabs v-model="activeTab">
      <el-tab-pane label="待付款" name="PENDING"></el-tab-pane>
      <el-tab-pane label="已付款/等待取貨" name="PAID"></el-tab-pane>
      <el-tab-pane label="運送中" name="SHIPPED"></el-tab-pane>
      <el-tab-pane label="已領貨" name="DELIVERED"></el-tab-pane>
      <el-tab-pane label="交易完成" name="DONE"></el-tab-pane>
      <el-tab-pane label="不成立" name="CANCELLED"></el-tab-pane>
      <el-tab-pane label="退貨/退款" name="RETURNED"></el-tab-pane>
      <el-tab-pane label="商品損壞" name="DAMAGED"></el-tab-pane>
      <el-tab-pane label="全部訂單" name="ALL"></el-tab-pane>
    </el-tabs>

    <!-- 搜尋框: 根據訂單號碼搜尋 -->
    <el-row class="mb-4">
      <el-col :span="12">
        <el-input
          v-model="searchQuery"
          placeholder="輸入訂單號碼搜尋"
          clearable
        />
      </el-col>
      <el-col :span="12">
        <el-button type="primary" @click="searchOrder">搜尋訂單</el-button>
      </el-col>
      <el-col :span="12">
  <el-button @click="clearSearch">清除搜尋</el-button>
</el-col>
    </el-row>

    <!-- 骨架屏: 加載中提示 -->
    <el-skeleton v-if="loading" :rows="5"></el-skeleton>

    <!-- 訂單列表 -->
    <el-table v-else :data="paginatedOrders">
      <el-table-column label="訂單編號">
        <template v-slot="scope">
          <el-link @click="viewOrderDetails(scope.row.orderId)" style="cursor: pointer;">
            {{ scope.row.orderId }}
          </el-link>
        </template>
      </el-table-column>

      <el-table-column label="會員ID">
        <template v-slot="scope">
          <el-link @click="getOrdersByMember(scope.row.membersId)" style="cursor: pointer;">
            {{ scope.row.membersId }}
          </el-link>
        </template>
      </el-table-column>

      <el-table-column label="下單日期">
        <template v-slot="scope">
          {{ formatDateTime(scope.row.orderDate) }}
        </template>
      </el-table-column>

      <el-table-column label="總金額" :prop="'totalPrice'">
        <template v-slot="scope">
          {{ formatPrice(scope.row.totalPrice) }}
        </template>
      </el-table-column>
      <el-table-column prop="shippingMethod" label="運送方式"></el-table-column>
      <el-table-column prop="orderStatus" label="訂單狀態"></el-table-column>

      <el-table-column label="操作">
        <template v-slot="scope">
          <el-button type="danger" @click="deleteOrder(scope.row.orderId)">刪除訂單</el-button>
          <el-dropdown @command="handleUpdateOrderStatus(scope.row.orderId, $event)">
  <el-button>更改狀態</el-button>
  <template #dropdown>
    <el-dropdown-menu>
      <el-dropdown-item command="PENDING">待付款</el-dropdown-item>
      <el-dropdown-item command="PAID">已付款/等待取貨</el-dropdown-item>
      <el-dropdown-item command="SHIPPED">運送中</el-dropdown-item>
      <el-dropdown-item command="DELIVERED">已領貨</el-dropdown-item>
      <el-dropdown-item command="DONE">交易完成</el-dropdown-item>
      <el-dropdown-item command="CANCELLED">不成立</el-dropdown-item>
      <el-dropdown-item command="RETURNED">退貨/退款</el-dropdown-item>
      <el-dropdown-item command="DAMAGED">商品損壞</el-dropdown-item>
    </el-dropdown-menu>
  </template>
</el-dropdown>

        </template>
      </el-table-column>
    </el-table>

    <!-- 分頁器 -->
    <el-pagination
      v-model:current-page="currentPage"
      :page-size="pageSize"
      layout="prev, pager, next, total"
      :total="filteredOrders.length"
    />

    <!-- 訂單詳情彈窗 -->
    <el-dialog v-model="orderDialog" title="訂單詳情" width="600px">
      <p>訂單編號: {{ currentOrder?.orderId }}</p>
      <p>領貨者姓名: {{ currentOrder?.shippingName }}</p>
      <p>聯絡號碼: {{ currentOrder?.shippingPhoneNum }}</p>
      <p>開租日期: {{ currentOrder?.rentalEndDate }}</p>
      <p>退回日期: {{ currentOrder?.rentalStartDate }}</p>
      <p>租賃天數: {{ currentOrder?.rentalDays }}</p>
      <p>送貨方式: {{ currentOrder?.shippingMethod }}</p>
      <p>送貨地址: {{ currentOrder?.shippingAddress }}</p>

      


      <!-- 其他訂單詳情展示 -->
      <el-table :data="currentOrder?.orderProducts">
  <el-table-column prop="productName" label="商品名稱"></el-table-column>
  <el-table-column prop="count" label="數量"></el-table-column>

  <!-- 單價，使用 formatPrice 格式化 -->
  <el-table-column label="單價">
    <template v-slot="scope">
      {{ formatPrice(scope.row.price) }}
    </template>
  </el-table-column>

  <!-- 小計，使用 formatPrice 格式化 -->
  <el-table-column label="小計">
    <template v-slot="scope">
      {{ formatPrice(calculateSubtotal(scope.row.count, scope.row.price, currentOrder?.rentalDays)) }}
    </template>
  </el-table-column>
</el-table>

      <template #footer>
        <el-button @click="closeOrderDialog">關閉</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue';
import Swal from 'sweetalert2';
import { updateOrderStatusAPI, getAllOrdersAPI, getOrderByIdAPI, deleteOrderAPI, getOrdersByMemberIdAPI } from '@/apis/order';

const activeTab = ref('ALL'); // 當前選中的 Tab
const searchQuery = ref(''); // 搜尋欄的訂單號碼
const loading = ref(false); // 是否正在加載數據
const orderDialog = ref(false); // 控制彈窗顯示
const currentOrder = ref(null); // 儲存當前訂單，初始為 null
const orders = ref([]); // 儲存訂單列表
const currentPage = ref(1); // 當前頁碼
const pageSize = ref(10); // 每頁顯示的訂單數量
const orderProducts = ref([]);

// 取得所有訂單
const getAllOrders = async () => {
  loading.value = true;
  try {
    const response = await getAllOrdersAPI();
    orders.value = response.data || []; // 確保資料存在
    console.log('獲取所有訂單:', orders.value); // 查看獲取的所有訂單
  } catch (error) {
    console.error('獲取所有訂單失敗:', error);
  } finally {
    loading.value = false;
  }
};

// 監聽組件掛載
onMounted(async () => {
  await getAllOrders(); // 確保這行在任何 await 語句之前
});

// 根據會員 ID 獲取訂單
const getOrdersByMember = async (membersId) => {
  loading.value = true;
  try {
    const response = await getOrdersByMemberIdAPI(membersId);
    orders.value = response.data || []; // 確保資料存在
  } catch (error) {
    console.error("獲取訂單失敗:", error);
  } finally {
    loading.value = false;
  }
};

// 過濾顯示的訂單
const filteredOrders = computed(() => {
  let filtered = orders.value;

  // 根據搜尋框中的訂單號碼進行過濾
  if (searchQuery.value) {
    filtered = filtered.filter(order => {
      const orderId = order.orderId?.toString() || ""; // 確保是字符串
      return orderId.includes(searchQuery.value); // 不轉為小寫，直接進行包含比對
    });
  }

  // 根據當前選中的 Tab 過濾訂單
  if (activeTab.value !== 'ALL') {
    filtered = filtered.filter(order => order.orderStatus === activeTab.value);
  }

  return filtered;
});

// 分頁後的訂單
const paginatedOrders = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value;
  const end = start + pageSize.value;
  return filteredOrders.value.slice(start, end);
});

const viewOrderDetails = async (orderId) => {
  loading.value = true;
  try {
    const response = await getOrderByIdAPI(orderId);
    console.log('當前訂單:', response.data); // 查看返回的訂單資料

    // 確保訂單資料中的 orderProducts 不為空
    if (response.data && response.data.orderProducts) {
      orderProducts.value = response.data.orderProducts; // 更新 orderProducts
    } else {
      console.warn('Order products is empty or undefined.'); // 加入警告提示
    }

    currentOrder.value = response.data; // 保存當前訂單
    orderDialog.value = true; // 顯示彈窗

  } catch (error) {
    console.error('獲取訂單詳情失敗:', error);
  } finally {
    loading.value = false;
  }
};

// 刪除訂單功能
const deleteOrder = async (orderId) => {
  const confirmed = await Swal.fire({
    title: '確定要刪除訂單嗎？',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: '確定',
    cancelButtonText: '取消',
  });

  if (confirmed.isConfirmed) {
    try {
      await deleteOrderAPI(orderId);
      Swal.fire('訂單已刪除', '', 'success');
      await getAllOrders(); // 刪除後刷新訂單列表
    } catch (error) {
      console.error('刪除訂單失敗:', error);
    }
  }
};

// 改變訂單狀態
const handleUpdateOrderStatus = async (orderId, status) => {
  loading.value = true;
  try {
    await updateOrderStatusAPI(orderId, status);
    Swal.fire('訂單狀態已更新', '', 'success');
    await getAllOrders(); // 更新後刷新訂單列表
  } catch (error) {
    console.error('更新訂單狀態失敗:', error);
  } finally {
    loading.value = false;
  }
};

// 搜尋訂單
const searchOrder = async () => {
  currentPage.value = 1; // 搜尋時重置到第一頁
  loading.value = true; // 顯示加載狀態

  try {
    if (searchQuery.value) {
      searchQuery.value = searchQuery.value.trim(); // 去掉前後空白
      console.log('搜尋查詢:', searchQuery.value); // 檢查輸入的搜尋查詢
      await getAllOrders(); // 重新獲取所有訂單以便搜尋

      // 過濾出符合條件的訂單
      const filtered = orders.value.filter(order => {
        const orderId = order.orderId?.toString() || ""; // 確保是字符串
        return orderId.includes(searchQuery.value);
      });

      orders.value = filtered; // 更新為搜尋結果

      console.log('搜尋結果:', orders.value); // 確認搜尋後的結果

      if (orders.value.length === 0) {
        Swal.fire('未找到相關訂單', '', 'info'); // 提示未找到相關訂單
      }
    } else {
      await getAllOrders(); // 如果搜尋欄為空，則重新獲取所有訂單
    }
  } catch (error) {
    console.error('獲取訂單時出現錯誤:', error); // 捕獲並顯示錯誤
    Swal.fire('獲取訂單數據錯誤', '請檢查服務器或網路連接', 'error');
  } finally {
    loading.value = false; // 隱藏加載狀態
  }
};

// 清除搜尋
const clearSearch = () => {
  searchQuery.value = ''; // 重置搜尋欄
  getAllOrders(); // 重新獲取所有訂單
};

// 關閉訂單詳情彈窗
const closeOrderDialog = () => {
  orderDialog.value = false;
  currentOrder.value = null; // 關閉時重置當前訂單
};

const calculateSubtotal = (count, price, rentalDays) => {
  return count * price * rentalDays;
};

// 日期和時間格式化
const formatDateTime = (date) => {
  const options = { year: 'numeric', month: 'short', day: 'numeric', hour: '2-digit', minute: '2-digit' };
  return new Date(date).toLocaleString('zh-TW', options);
};

const formatPrice = (price) => {
  return new Intl.NumberFormat('zh-TW', {
    style: 'currency',
    currency: 'TWD',
    minimumFractionDigits: 0,
    maximumFractionDigits: 0,
  }).format(Math.round(price)); // 確保傳入的是有效的整數
};
</script>


<style scoped>
.mb-4 {
  margin-bottom: 1rem;
}
</style>