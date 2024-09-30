import { defineStore } from 'pinia';
import { ref } from 'vue';
import { createOrderAPI, getOrdersByMemberIdAPI, getOrderByIdAPI, getAllOrdersAPI, updateOrderStatusAPI, deleteOrderAPI } from '@/apis/order'; 



export const useOrderStore = defineStore('order', () => {
    const orders = ref([]); // 儲存訂單列表
    const currentOrder = ref(null); // 儲存當前正在創建或查看的訂單
    const orderData = ref(null); // 暫存訂單資料

    

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


   // 創建新訂單
   const createOrder = async (newOrderData) => {
    try {
        if (!orderData.value) {
            throw new Error("沒有可用的訂單資料");
        }
          // 確保 orderData 包含地址信息
        const response = await createOrderAPI(newOrderData); // 使用暫存的訂單資料創建訂單
        currentOrder.value = response.data; // 保存創建成功的訂單
        return response.data;
    } catch (error) {
        console.error("創建訂單失敗:", error);
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
        getOrderById
    };
});
