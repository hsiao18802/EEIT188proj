<template>
  <div>
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

    <el-skeleton v-if="loading" :rows="5">

    </el-skeleton>

    <div v-if="paginatedOrders.length > 0">
      <el-row :gutter="20" v-for="order in paginatedOrders" :key="order.orderId">
        <el-col :span="24">
          <el-card shadow="hover">
            <div class="order-header">
              <span>下單時間：{{ formatDate(order.orderDate) }}</span>
              <span style="margin-left: 5px;">訂單編號：{{ order.orderId }}</span>
            </div>
            <div class="order-body-summary">
              <div class="order-body">
                <el-row v-for="product in order.orderProducts" :key="product.orderProductId" class="product-item">
                  <el-col :span="2">
                    <img :src="`data:image/jpeg;base64,${product.mainPhoto}`" alt="product image" class="product-img" />
                  </el-col>
                  <el-col :span="8" class="product-name">{{ product.productName }}</el-col>
                  <el-col :span="8" class="product-price">{{ formatPrice(product.price) }}</el-col>
                  <el-col :span="4" class="product-count">{{ product.count }}</el-col>
                </el-row>
              </div>
              <div class="order-summary">
                <el-row align="middle">
                  <el-col :span="8" class="order-status">{{ order.orderStatus }}</el-col>
                  <el-col :span="8" class="order-price">
                    <div class="price-container">
                      <div>{{ formatPrice(order.totalPrice + order.shippingFee) }}</div>
                      <div>(含運費：{{ formatPrice(order.shippingFee) }})</div>
                      <div v-if="!['PENDING', 'CANCELLED'].includes(order.orderStatus)">
                        {{ order.paymentMethod || '信用卡支付' }}
                      </div>
                    </div>
                  </el-col>
                  <el-col :span="6" style="text-align: right;">
                    <el-button type="primary" size="small" @click="viewOrderDetail(order.orderId)">查看詳細</el-button>
                    <el-button v-if="order.orderStatus === 'PENDING'" type="success" size="small"
                      @click="goToCheckout(order.orderId)">點擊付款</el-button>
                    <el-button v-if="['CANCELLED', 'DONE'].includes(order.orderStatus)" type="warning" size="small"
                      @click="buyAgain(order.orderId)">再買一次</el-button>
                  </el-col>
                </el-row>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>

      <!-- 分頁 -->
      <el-pagination :current-page="currentPage" :page-size="pageSize" :total="filteredOrders.length"
        @current-change="handleCurrentChange" layout="prev, pager, next">
      </el-pagination>
    </div>

    <p v-else-if="!loading">暫無訂單</p>




  </div>
</template>

<script setup>
import { ref, computed } from 'vue';
import { getOrdersByMemberIdAPI } from '@/apis/order';
import { ElMessage } from 'element-plus';
import Swal from 'sweetalert2';
import { useCartStore } from '@/stores/cartStore';
import { useRouter } from 'vue-router';

const router = useRouter();


const OrderStatus = {
  PENDING: 'PENDING',
  PAID: 'PAID',
  SHIPPED: 'SHIPPED',
  DELIVERED: 'DELIVERED',
  DONE: 'DONE',
  CANCELLED: 'CANCELLED',
  RETURNED: 'RETURNED'
};

const formatPrice = (price) => {
  return new Intl.NumberFormat('zh-TW', {
    style: 'currency',
    currency: 'TWD',
    minimumFractionDigits: 0,
    maximumFractionDigits: 0,
  }).format(price);
};

const cartStore = useCartStore();
const membersId = cartStore.membersId;
const activeTab = ref('PENDING');
const orderList = ref([]);
const currentPage = ref(1);
const pageSize = ref(2); // 每頁顯示的訂單數量
const loading = ref(true); // 新增 loading 狀態



// 計算過濾後的訂單
const filteredOrders = computed(() => {
  if (activeTab.value === 'ALL') {
    return orderList.value; // 返回所有訂單
  }
  return orderList.value.filter(order => order.orderStatus === activeTab.value);
});

// 計算當前頁面顯示的訂單
const paginatedOrders = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value;
  return filteredOrders.value.slice(start, start + pageSize.value);
});

// 格式化日期函數
const formatDate = (date) => {
  const options = { year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit', second: '2-digit', hour12: false };
  return new Date(date).toLocaleString('zh-TW', options);
};

// 獲取會員訂單
const getOrdersByMember = async (membersId) => {
  loading.value = true; // 設定為加載中
  try {
    const response = await getOrdersByMemberIdAPI(membersId);
    orderList.value = response.data;
  } catch (error) {
    ElMessage.error("獲取訂單失敗: " + error);
  } finally {
    loading.value = false; // 加載完成
  }
};

const filterOrdersByStatus = (tab) => {
  activeTab.value = tab.name;
  currentPage.value = 1; // 重置頁碼
};

const viewOrderDetail = (orderId) => {
  router.push({ name: 'OrderDetail', params: { orderId } });
};


const goToCheckout = (orderId) => {
  console.log(`前往結帳頁面，訂單編號: ${orderId}`);
  // 這裡可以導航到結帳頁面
};

const buyAgain = async (orderId) => {
  console.log(`再買一次，訂單編號: ${orderId}`);
  try {
    // 從 orderList 中根據 orderId 找到該訂單
    const order = orderList.value.find(order => order.orderId === orderId);
    console.log("找到的訂單：", order); // 測試訂單是否正確

    if (!order) {
      ElMessage.error('訂單不存在');
      return;
    }

    // 確認是否要再次購買
    const result = await Swal.fire({
      title: '再次購買？',
      text: `將訂單 ${orderId} 的所有產品加入購物車`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: '確認',
      cancelButtonText: '取消',
    });

    if (!result.isConfirmed) {
      return;
    }

    // 將每個產品加入購物車
    order.orderProducts.forEach(product => {
      console.log("正在加入購物車的產品：", product); // 檢查每個產品資料

      cartStore.addCart({
        productId: product.productId,
        productName: product.productName,
        membersId: product.membersId,
        dailyFeeOriginal: product.price, // 單價
        count: product.count, // 數量
        mainPhoto: product.mainPhoto,
        // 其他產品相關的資料，如租賃起始結束日期、押金等，可以根據需求加入
      });

    });
    console.log("當前購物車狀態：", cartStore.cartList);

    ElMessage.success('產品已加入購物車');
  } catch (error) {
    ElMessage.error('再買一次失敗: ' + error.message);
  }
};

const handleCurrentChange = (page) => {
  currentPage.value = page; // 更新當前頁碼
};

getOrdersByMember(membersId);
</script>


<style scoped>
/* 可以添加自定義樣式以提高專業外觀 */
.el-tabs {
  margin-bottom: 20px;
}

.el-tab-pane {
  font-weight: bold;
  font-size: 16px;
}

/* 自定義選中狀態的樣式 */
.el-tabs__item.is-active {
  color: #409EFF;
  /* 選中時的顏色 */
  border-bottom: 2px solid #409EFF;
  /* 選中時的底部邊框 */
}

.custom-row {
  width: 100%;
  padding: 10px;
  box-sizing: border-box;
}

.order-header {
  display: flex;
  justify-content: flex-start;
  background-color: rgba(128, 128, 128, 0.911);
  padding: 10px;
}

.order-body-summary {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  margin-top: 10px;
}

.order-body {
  flex: 1;
}

.order-summary {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: flex-end;
  margin-left: 20px;
  border-left: 2px solid #ebeef5;
  padding-left: 10px;
}

.price-container {
  display: flex;
  flex-direction: column;
  width: 200px;
}

.product-item {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.product-img {
  width: 50px;
  height: 50px;
  object-fit: cover;
  margin-right: 10px;
}

.product-count {
  text-align: center;
}

.order-price {
  margin-left: 5px;
}

.order-status {
  margin-right: 5px;
}
</style>
