import axiosapi from "@/plugins/axios";

const BASE_URL = '/rent/discount';

// 驗證優惠碼
export const validateCouponAPI = (code) => {
  return axiosapi.get(`${BASE_URL}/validate?code=${code}`);
};