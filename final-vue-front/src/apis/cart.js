// apis/cart.js

import axiosapi from "@/plugins/axios";

const BASE_URL = '/rent/cart';


export const addCartAPI = (data) => {
  return axiosapi.post(`${BASE_URL}/add`, data);
};



// 獲取購物車列表
export const findNewCartListAPI = (membersId) => {
  console.log('Requesting cart list for membersId:', membersId); // 調試用
  return axiosapi.get(`${BASE_URL}/members/${membersId}/cart`);
};

// 從購物車中刪除商品
export const removeFromCartAPI = (data) => axios.delete(`${BASE_URL}/remove`, { params: data })

// API 請求方法
export const plusOneAPI = (params) => {
  return axiosapi.post(`${BASE_URL}/plusOne`, null, { params });
};

export const minusOneAPI = (params) => {
  return axiosapi.post(`${BASE_URL}/minusOne`, null, { params });
};


