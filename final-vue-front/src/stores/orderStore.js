import { defineStore } from 'pinia';
import { ref } from 'vue';
import { createOrderAPI, getOrdersByMemberIdAPI, getOrderByIdAPI, getAllOrdersAPI, updateOrderStatusAPI, deleteOrderAPI } from '@/apis/order';
import Swal from 'sweetalert2';




export const useOrderStore = defineStore('order', () => {
  const orders = ref([]); // 儲存訂單列表
  const currentOrder = ref(null); // 儲存當前正在創建或查看的訂單
  const orderData = ref(null); // 暫存訂單資料
  const orderId = ref(null); // 儲存當前訂單 ID
  const totalPrice = ref(null); // 儲存當前






  // 設置訂單資料，這個方法用於結帳前保存訂單資料
  function setOrderData(data) {
    orderData.value = data;
    console.log("設置的訂單資料:", orderData.value); // 確認設置的資料
  }




  // 獲取所有訂單
  const getAllOrders = async () => {
    try {
      const response = await getAllOrdersAPI();
      orders.value = response.data;
    } catch (error) {
      console.error('獲取所有訂單失敗:', error);
    }
  };

  // 根據訂單 ID 獲取單一訂單
  const getOrderById = async (orderId) => {
    try {
      const response = await getOrderByIdAPI(orderId);
      currentOrder.value = response.data;
    } catch (error) {
      console.error('獲取訂單失敗:', error);
    }
  };


  const createOrder = async (newOrderData) => {
    try {
      if (!newOrderData) {
        throw new Error("沒有可用的訂單資料");
      }
      console.log("即將創建的訂單資料:", newOrderData);

      const response = await createOrderAPI(newOrderData); // 使用暫存的訂單資料創建訂單
      currentOrder.value = response.data; // 保存創建成功的訂單
      orderId.value = response.data.orderId; // 儲存 orderId
      totalPrice.value = response.data.totalPrice;
      console.log("創建的訂單 ID:", orderId.value); // 確認訂單 ID
      console.log("創建的訂單 totalPrice:", totalPrice.value); // 確認訂單 ID

      return response.data;
    } catch (error) {
      console.error("創建訂單失敗:", error);
      if (error.response) {
        console.error("後端返回的錯誤:", error.response.data); // 獲取後端錯誤信息
      }
      // 這裡可以使用 SweetAlert 通知用戶失敗原因
      await Swal.fire({
        title: '訂單創建失敗',
        text: error.response ? error.response.data.message : '請檢查輸入的資料',
        icon: 'error',
        confirmButtonText: '確定'
      });
      throw error;
    }
  };



  // 根據會員 ID 獲取訂單
  const getOrdersByMember = async (memberId) => {
    try {
      const response = await getOrdersByMemberAPI(memberId);
      orders.value = response.data;
    } catch (error) {
      console.error("獲取訂單失敗:", error);
    }
  };

  // 清空當前訂單
  const clearCurrentOrder = () => {
    currentOrder.value = null;
  };

  // 刪除訂單
  const deleteOrder = async (orderId) => {
    try {
      await deleteOrderAPI(orderId);
      orders.value = orders.value.filter(order => order.orderId !== orderId);
      console.log('訂單已刪除');
    } catch (error) {
      console.error('刪除訂單失敗:', error);
    }
  };



  // 更新訂單狀態
  const updateOrderStatus = async (orderId, status) => {
    try {
      await updateOrderStatusAPI(orderId, status);
      console.log('訂單狀態已更新');
    } catch (error) {
      console.error('更新訂單狀態失敗:', error);
    }
  };



  return {
    orders,
    currentOrder,
    getOrdersByMember,
    clearCurrentOrder,
    orderData, // 暫存的訂單資料
    setOrderData, // 設置暫存訂單資料
    createOrder, // 創建最終訂單
    getAllOrders,
    updateOrderStatus,
    deleteOrder,
    getOrderById,
    orderId,
    totalPrice,
  };
});
