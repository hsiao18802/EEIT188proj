import axiosapi from "@/plugins/axios";

const BASE_URL = '/rent/order';





// 創建新訂單
export const createOrderAPI = (data) => {
  return axiosapi.post(`${BASE_URL}/create`, data);
};

// 根據訂單 ID 獲取訂單
export const getOrderByIdAPI = (orderId) => {
  return axiosapi.get(`${BASE_URL}/${orderId}`);
};

// 獲取所有訂單
export const getAllOrdersAPI = () => {
  return axiosapi.get(`${BASE_URL}/all`);
};

export const updateOrderStatusAPI = (orderId, status) => {
  return axiosapi.put(`${BASE_URL}/${orderId}/status?status=${status}`);
};


// 刪除訂單
export const deleteOrderAPI = (orderId) => {
  return axiosapi.delete(`${BASE_URL}/delete/${orderId}`);
};

// 獲取指定會員的所有訂單
export const getOrdersByMemberIdAPI = (membersId) => {
  return axiosapi.get(`${BASE_URL}/member/${membersId}`);
};

