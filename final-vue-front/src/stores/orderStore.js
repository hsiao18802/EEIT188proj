import { defineStore } from 'pinia';
import { ref } from 'vue';
import { createOrderAPI, getOrdersByMemberIdAPI, getOrderByIdAPI, getAllOrdersAPI, updateOrderStatusAPI, deleteOrderAPI } from '@/apis/order'; // 假設這些是你的 API 調用

export const useOrderStore = defineStore('order', () => {
    const orders = ref([]); // 儲存訂單列表
    const currentOrder = ref(null); // 儲存當前正在創建或查看的訂單

    // 創建新訂單
    const createOrder = async (orderData) => {
        try {
            const response = await createOrderAPI(orderData);
            currentOrder.value = response.data; // 保存創建成功的訂單
            return response.data;
        } catch (error) {
            console.error("創建訂單失敗:", error);
            throw error;
        }
    };

    // 根據會員 ID 獲取訂單
    const fetchOrdersByMember = async (memberId) => {
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

    return {
        orders,
        currentOrder,
        createOrder,
        fetchOrdersByMember,
        clearCurrentOrder,
    };
});
