<template>
  <div>
    <el-tabs v-model="activeTab" @tab-click="filterOrdersByStatus">
      <el-tab-pane label="待付款" name="PENDING"></el-tab-pane>
      <el-tab-pane label="已付款" name="PAID"></el-tab-pane>
      <el-tab-pane label="運送中" name="SHIPPED"></el-tab-pane>
      <el-tab-pane label="已送達" name="DELIVERED"></el-tab-pane>
      <el-tab-pane label="交易完成" name="DONE"></el-tab-pane>
      <el-tab-pane label="不成立" name="CANCELLED"></el-tab-pane>
      <el-tab-pane label="退貨/退款" name="RETURNED"></el-tab-pane>
    </el-tabs>

    <div v-if="orderList.length > 0">
      <el-row :gutter="20" v-for="order in filteredOrders" :key="order.orderId">
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
                      <div>{{ order.paymentMethod || '信用卡支付' }}</div>
                    </div>
                  </el-col>
                  <el-col :span="6" style="text-align: right;">
                    <el-button type="primary" size="small" @click="viewOrderDetail(order.orderId)">查看詳細</el-button>
                  </el-col>
                </el-row>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>

    <p v-else>暫無訂單</p>
  </div>
</template>

  
  <script setup>
  import { ref, computed } from 'vue';
  import { getOrdersByMemberIdAPI } from '@/apis/order';
  import { ElMessage } from 'element-plus';
  import { useCartStore } from '@/stores/cartStore';
  
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
    minimumFractionDigits: 0, // 不顯示小數點
    maximumFractionDigits: 0, // 不顯示小數點
  }).format(price);
};
  
  const cartStore = useCartStore();
  const membersId = cartStore.membersId;
  const activeTab = ref(OrderStatus.PENDING);
  const orderList = ref([]);
  const filteredOrders = computed(() => {
    return orderList.value.filter(order => order.orderStatus === activeTab.value);
  });
  
  // 格式化日期函數
  const formatDate = (date) => {
    const options = { year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit', second: '2-digit', hour12: false };
    return new Date(date).toLocaleString('zh-TW', options);
  };
  
  const getOrdersByMember = async (membersId) => {
    try {
      const response = await getOrdersByMemberIdAPI(membersId);
      orderList.value = response.data;
    } catch (error) {
      ElMessage.error("獲取訂單失敗: " + error);
    }
  };
  
  const filterOrdersByStatus = (tab) => {
    activeTab.value = tab.name;
  };
  
  const viewOrderDetail = (orderId) => {
    console.log(`查看訂單 ${orderId} 的詳細資料`);
  };
  
  getOrdersByMember(membersId);
  </script>
  
  <style scoped>
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
    justify-content: space-between; /* 使按鈕與其他內容分開 */
    align-items: flex-end; /* 將所有內容靠右對齊 */
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

  /* 查看詳情按鈕樣式 */
  .view-details-btn {
    margin-top: 10px;
    padding: 10px 20px;
    background-color: #007bff;
    color: white;
    border: none;
    cursor: pointer;
    border-radius: 5px;
    align-self: flex-end; /* 將按鈕靠右對齊 */
  }

  .view-details-btn:hover {
    background-color: #0056b3;
  }
</style>


