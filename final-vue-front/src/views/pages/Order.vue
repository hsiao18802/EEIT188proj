<template>
  <div>
    <!-- Tabs: 訂單分類 -->
    <el-tabs v-model="activeTab" @tab-click="filterOrdersByStatus">
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
    </el-row>

    <!-- 骨架屏: 加載中提示 -->
    <el-skeleton v-if="loading" :rows="5"></el-skeleton>

  <!-- 訂單列表 -->
<el-table v-else :data="paginatedOrders">
  <el-table-column label="訂單編號">
    <template #default="scope">
      <el-link @click="viewOrderDetails(scope.row.orderId)" style="cursor: pointer;">
        {{ scope.row.orderId }}
      </el-link>
    </template>
  </el-table-column>
  
  <el-table-column label="會員ID">
    <template #default="scope">
      <el-link @click="getOrdersByMember(scope.row.membersId)" style="cursor: pointer;">
        {{ scope.row.membersId }}
      </el-link>
    </template>
  </el-table-column>
  
  <el-table-column label="下單日期">
    <template #default="scope">
      {{ formatDate(scope.row.orderDate) }}
    </template>
  </el-table-column>
  
  <el-table-column :label="`總金額`" :prop="'totalPrice'">
    <template v-slot="scope">
      {{ formatPrice(scope.row.totalPrice) }}
    </template>
  </el-table-column>
  
  <el-table-column prop="shippingMethod" label="運送方式"></el-table-column>
  <el-table-column prop="orderStatus" label="訂單狀態"></el-table-column>
  
  <el-table-column label="操作">
    <template #default="scope">
      <el-button @click="viewOrderDetails(scope.row.orderId)">查看</el-button>
      <el-button type="danger" @click="deleteOrder(scope.row.orderId)">刪除訂單</el-button>
      <el-dropdown @command="handleUpdateOrderStatus(scope.row.orderId, $event)">
        <el-button>更改狀態</el-button>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="PENDING">待付款</el-dropdown-item>
          <el-dropdown-item command="PAID">已付款/等待取貨</el-dropdown-item>
          <el-dropdown-item command="SHIPPED">運送中</el-dropdown-item>
          <el-dropdown-item command="DELIVERED">已領貨</el-dropdown-item>
          <el-dropdown-item command="DONE">交易完成</el-dropdown-item>
          <el-dropdown-item command="CANCELLED">不成立</el-dropdown-item>
          <el-dropdown-item command="RETURNED">退貨/退款</el-dropdown-item>
          <el-dropdown-item command="DAMAGED">商品損壞</el-dropdown-item>
        </el-dropdown-menu>
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
      <p>送貨地址: {{ currentOrder?.shippingAddress }}</p>
      <!-- 其他訂單詳情展示 -->
      <el-table :data="currentOrder?.products">
        <el-table-column prop="productName" label="商品名稱"></el-table-column>
        <el-table-column prop="days" label="租賃天數"></el-table-column>
        <el-table-column :label="`單價`" :prop="'dailyFeeOriginal'"></el-table-column>
      </el-table>
      <template #footer>
        <el-button @click="closeOrderDialog">關閉</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue';
import { useOrderStore } from '@/stores/orderStore'; // 正確引入
import Swal from 'sweetalert2';
import { updateOrderStatusAPI } from '@/apis/order'; // 引入更新訂單狀態的API

// Pinia 的訂單狀態管理
const orderStore = useOrderStore();
const activeTab = ref('ALL'); // 當前選中的 Tab
const searchQuery = ref(''); // 搜尋欄的訂單號碼
const loading = ref(false); // 是否正在加載數據
const orderDialog = ref(false); // 控制彈窗顯示
const currentOrder = ref(null); // 當前顯示的訂單
const currentPage = ref(1); // 當前頁碼
const pageSize = ref(5); // 每頁顯示的訂單數量

// 取得所有訂單
onMounted(async () => {
  loading.value = true;
  await orderStore.getAllOrders();
  loading.value = false;
});

// 根據會員 ID 獲取訂單
const getOrdersByMember = async (membersId) => {
  await orderStore.getOrdersByMember(membersId);
  // 這裡可以根據需求顯示獲取到的訂單
};

// 過濾顯示的訂單
const filteredOrders = computed(() => {
  let orders = orderStore.orders;

  // 根據搜尋框中的訂單號碼進行過濾
  if (searchQuery.value) {
    orders = orders.filter(order =>
      order.orderId.toLowerCase().includes(searchQuery.value.toLowerCase())
    );
  }

  // 根據當前選中的 Tab 過濾訂單
  if (activeTab.value !== 'ALL') {
    orders = orders.filter(order => order.orderStatus === activeTab.value);
  }

  return orders;
});

// 分頁後的訂單
const paginatedOrders = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value;
  const end = start + pageSize.value;
  return filteredOrders.value.slice(start, end);
});

// 根據選中的訂單狀態過濾
const filterOrdersByStatus = () => {
  searchQuery.value = ''; // 切換狀態時清空搜尋框
  currentPage.value = 1; // 重置當前頁碼
};

// 搜尋訂單功能
const searchOrder = () => {
  if (!searchQuery.value) {
    Swal.fire('請輸入訂單號碼進行搜尋');
  }
  currentPage.value = 1; // 搜尋後重置頁碼
};

// 查看訂單詳情
const viewOrderDetails = async (orderId) => {
  await orderStore.getOrderById(orderId);
  currentOrder.value = orderStore.currentOrder;
  orderDialog.value = true;
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
    await orderStore.deleteOrder(orderId);
    Swal.fire('訂單已刪除', '', 'success');
    await orderStore.getAllOrders(); // 刪除後刷新訂單列表
  }
};

// 更新訂單狀態功能
const handleUpdateOrderStatus = async (orderId, status) => {
  const confirmed = await Swal.fire({
    title: '確定要更改訂單狀態嗎？',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: '確定',
    cancelButtonText: '取消',
  });

  if (confirmed.isConfirmed) {
    await updateOrderStatusAPI(orderId, status);
    Swal.fire('訂單狀態已更新', '', 'success');
    await orderStore.getAllOrders(); // 更新後刷新訂單列表
  }
};

// 關閉訂單詳情彈窗
const closeOrderDialog = () => {
  orderDialog.value = false;
  currentOrder.value = null; // 清空當前訂單
};

// 格式化日期
const formatDate = (dateString) => {
  const options = { year: 'numeric', month: '2-digit', day: '2-digit' };
  return new Date(dateString).toLocaleDateString('zh-TW', options);
};

// 格式化價格
const formatPrice = (price) => {
  return new Intl.NumberFormat('zh-TW', {
    style: 'currency',
    currency: 'TWD',
  }).format(price);
};
</script>

<style scoped>
/* 自定義樣式 */
.mb-4 {
  margin-bottom: 1rem;
}
</style>
