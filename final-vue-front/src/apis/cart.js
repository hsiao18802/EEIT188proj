// apis/cart.js

import axios from 'axios'

const BASE_URL = 'http://localhost:8080/rent/cart';


export const addCartAPI = (data) => {
    return axios.post(`${BASE_URL}/add`, data);
};



// 獲取購物車列表
export const findNewCartListAPI = (membersId) => {
    console.log('Requesting cart list for membersId:', membersId); // 調試用
    return axios.get(`${BASE_URL}/members/${membersId}/cart`);
};

// 從購物車中刪除商品
export const removeFromCartAPI = (data) => axios.delete(`${BASE_URL}/remove`, { params: data })

// 增加商品數量
export const plusOneAPI = (data) => axios.post(`${BASE_URL}/plusOne`, data);

// 減少商品數量
export const minusOneAPI = (data) => axios.post(`${BASE_URL}/minusOne`, data);

