import axios from 'axios';
import useUserStore from '@/stores/user';  // 引用 Pinia 的 store
import router from '../router/router.js';  // 引入 Vue Router 的實例

const axiosapi = axios.create({
  baseURL: import.meta.env.VITE_API_URL,
});

// 攔截請求，確保每個請求都附帶 Pinia 中的 token
axiosapi.interceptors.request.use(function (config) {
  const userStore = useUserStore();  // 動態獲取 Pinia store
  const token = userStore.token;     // 從 Pinia 讀取 token
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
}, function (error) {
  return Promise.reject(error);
});

// 攔截回應，處理 403 錯誤
axiosapi.interceptors.response.use(function (response) {
  return response;
}, function (error) {
  // 處理 403 錯誤
  if (error.response && error.response.status === 403) {
    const userStore = useUserStore();
    const token = userStore.token;  // 從 Pinia 讀取 token

    if (token) {
      // 如果有 token，且仍然收到 403，可能是 token 過期了
      console.log('Token expired or invalid, clearing user data.');
      userStore.setToken('');  // 清除 Pinia 中的 token
      userStore.setLogin(false); // 清除登入狀態
      userStore.setRealname('');   // 清除 email 等用戶信息

      // 清除 localStorage 中的狀態
      localStorage.removeItem('forgot_password_email');
      localStorage.removeItem('forgot_password_code_sent');

      // 跳轉到 403 頁面或登錄頁面
      router.push({ name: 'secure-login-link' });  // 使用 router 實例進行跳轉
    } else {
      console.log('No token found, redirecting to login.');
      router.push({ name: 'secure-login-link' });  // 使用 router 實例進行跳轉
    }
  }
  return Promise.reject(error);
});

export default axiosapi;
