<template>
   <div>
    <el-tabs v-model="activeTab" @tab-click="fetchOrders">
      <el-tab-pane label="所有訂單" name="ALL"></el-tab-pane>
      <el-tab-pane label="待付款" name="PENDING"></el-tab-pane>
      <el-tab-pane label="已付款" name="PAID"></el-tab-pane>
      <el-tab-pane label="運送中" name="SHIPPED"></el-tab-pane>
      <el-tab-pane label="已送達" name="DELIVERED"></el-tab-pane>
      <el-tab-pane label="交易完成" name="DONE"></el-tab-pane>
      <el-tab-pane label="不成立" name="CANCELLED"></el-tab-pane>
      <el-tab-pane label="退貨/退款" name="RETURNED"></el-tab-pane>
    </el-tabs>

    <order-list :orders="filteredOrders" @viewOrder="viewOrder" @deleteOrder="deleteOrder" />
  </div>

    <!-- 產品詳情對話框 -->
    <el-dialog :visible.sync="isProductDialogVisible" title="產品詳情">
      <order-product-details :order="currentOrder" />
      <span slot="footer" class="dialog-footer">
        <el-button @click="isProductDialogVisible = false">關閉</el-button>
      </span>
    </el-dialog>

    <!-- 送貨資訊對話框 -->
    <el-dialog :visible.sync="isShippingDialogVisible" title="送貨資訊">
      <order-shipping-info :order="currentOrder" />
      <span slot="footer" class="dialog-footer">
        <el-button @click="isShippingDialogVisible = false">關閉</el-button>
      </span>
    </el-dialog>


</template>

<script setup>
import { ref, computed, onMounted } from 'vue';
import { useOrderStore } from '@/stores/orderStore';
import OrderList from '@/components/orders/OrderList.vue';
import OrderProductDetails from '@/components/orders/OrderProductDetails.vue';
import OrderShippingInfo from '@/components/orders/OrderShippingInfo.vue';

// 使用 orderStore
const orderStore = useOrderStore();

// 狀態管理
const activeTab = ref('PENDING'); // 默認顯示待付款
const isProductDialogVisible = ref(false);
const isShippingDialogVisible = ref(false);
const currentOrder = ref(null);


// 獲取所有訂單
const fetchOrders = async () => {
  await orderStore.getAllOrders();
};

// 初始化訂單
onMounted(fetchOrders);

// 計算過濾的訂單
const filteredOrders = computed(() => {
  if (activeTab.value === 'ALL') {
    return orderStore.orders; // 返回所有訂單
  }
  return orderStore.orders.filter(order => order.orderStatus === activeTab.value);
});

// 查看訂單詳情
const viewOrder = (order) => {
  currentOrder.value = order;
  isProductDialogVisible.value = true;
};

// 刪除訂單
const deleteOrder = async (orderId) => {
  await orderStore.deleteOrder(orderId);
  await fetchOrders(); // 刪除後重新獲取訂單
};

// 更新訂單狀態
const updateOrderStatus = async (orderId, status) => {
  await orderStore.updateOrderStatus(orderId, status);
  await fetchOrders(); // 更新後重新獲取訂單
};
</script>

<style scoped>
.dialog-footer {
  text-align: right;
}
</style>
