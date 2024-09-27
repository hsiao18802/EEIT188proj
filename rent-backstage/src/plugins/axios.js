import axios from 'axios';

import router from '../router/router.js';  // 引入 Vue Router 的實例



const axiosapi = axios.create({
  baseURL: import.meta.env.VITE_API_URL,
});



export default axiosapi;
