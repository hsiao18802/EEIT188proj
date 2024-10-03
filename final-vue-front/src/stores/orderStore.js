import { defineStore } from 'pinia';
import { ref, computed, onMounted, onBeforeUnmount } from 'vue';
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
  const getOrdersByMember = async (membersId) => {
    try {
      const response = await getOrdersByMemberIdAPI(membersId);
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




  // 開始倒數計時

  const remainingTime = ref(0); // 默認為0
  const countdownInterval = ref(null);
  const orderStatus = ref(null);



  const startCountdown = (duration) => {
    if (duration > 0) {
      remainingTime.value = duration; // 設定初始倒數時間
      countdownInterval.value = setInterval(() => {
        if (remainingTime.value > 0) {
          remainingTime.value--;
        } else {
          clearInterval(countdownInterval.value);
          countdownInterval.value = null; // 停止計時器
        }
      }, 1000); // 每秒減少一次
    } else {
      remainingTime.value = 0; // 若 duration 為負數，則設為 0
    }
  };

  // 停止倒數計時
  const stopCountdown = () => {
    if (countdownInterval.value) {
      clearInterval(countdownInterval.value);
      countdownInterval.value = null;
    }
  };

  const getRemainingTime = (orderDate) => {
    const now = Math.floor(Date.now() / 1000); // 當前時間的秒數
    const orderTimestamp = new Date(orderDate).getTime() / 1000; // 訂單時間的秒數
    const elapsedTime = now - orderTimestamp; // 計算已經過去的時間
    return Math.max(0, 1800 - elapsedTime); // 計算剩餘時間，假設設置30分鐘（1800秒）
  };

  const fetchOrderStatus = async () => {
    if (orderId.value) {
      try {
        const order = await getOrderByIdAPI(orderId.value); // 獲取訂單 API
        orderStatus.value = order.orderStatus;
        const time = getRemainingTime(order.orderDate);
        remainingTime.value = time;
        startCountdown(time); // 啟動倒數計時
      } catch (error) {
        console.error("獲取訂單狀態失敗:", error);
      }
    }
  };

  return {
    orders,
    currentOrder,
    getOrdersByMember,
    clearCurrentOrder,
    orderData,
    setOrderData,
    createOrder,
    getAllOrders,
    updateOrderStatus,
    deleteOrder,
    getOrderById,
    orderId,
    totalPrice,
    remainingTime,
    getRemainingTime,
    orderStatus,
    fetchOrderStatus,
    startCountdown,
    stopCountdown,
  };
});
