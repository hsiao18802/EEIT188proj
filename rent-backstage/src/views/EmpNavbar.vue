<template>
  <div class="d-flex flex-column flex-shrink-0 p-3 bg-dark text-white" style="width: 280px;">
    <!-- 管理系統變成超連結，指向系統首頁 -->
    <RouterLink to="/employee/emphome" class="fs-4 mb-3 link-body-emphasis text-white d-inline-flex text-decoration-none rounded">管理系統</RouterLink>
    <hr>
    <ul class="list-unstyled ps-0">
      <li class="mb-1">
        <RouterLink to="/employee/order" class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">會員訂單</RouterLink>
      </li>
      <li class="mb-1">
        <RouterLink to="/employee/empproduct" class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">商品管理</RouterLink>
      </li>
      <li class="mb-1">
        <RouterLink to="/employee/member" class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">會員一覽</RouterLink>
      </li>
      <li class="mb-1">
        <RouterLink to="/plceholder/forphoto/remembertodelete" class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">員工管理</RouterLink>
      </li>
      <li class="mb-1">
        <RouterLink to="/customerservice" class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">客服頁面</RouterLink>
      </li>
    </ul>

    <hr>

    <!-- 修改登出按鈕樣式 -->
    <button @click="logout" class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded mb-2" style="background: none; border: none;">登出</button>

    <!-- 回到顧客頁面
    <RouterLink to="/" class="link-body-emphasis text-white d-inline-flex text-decoration-none rounded">回到顧客頁面</RouterLink> -->
  </div>
</template>

<script setup>
import { RouterLink, useRouter } from 'vue-router'; // 引入 useRouter 來進行路由跳轉
import axiosapi from '../plugins/axios';

// 獲取 Vue Router 的實例
const router = useRouter();

// 登出方法
const logout = async () => {
  try {
    // 調用後端登出 API
    // await axiosapi.post('/api/employee/logout');
    
    // 清除本地的登入資訊
    // localStorage.removeItem('user');

    // 跳轉到登錄頁面
    location.href = '/emp/login';
  } catch (error) {
    console.error('登出失敗', error);
  }
};
</script>

<style scoped>
.link-body-emphasis {
  padding: 0.1875rem 0.5rem;
  margin-top: 0.125rem;
  margin-bottom: 0.125rem;
  font-weight: 600;
  color: #fff;
  border-radius: 0.375rem;
}

.link-body-emphasis:hover {
  background-color: LightSlateGray;
}

.link-body-emphasis:focus, .link-body-emphasis:active {
  background-color: white;
  color: #000;
  border: 2px solid white;
  border-radius: 0.375rem;
  outline: none;
}

.flex-shrink-0 {
  min-height: 100vh;
}

.bg-dark {
  background-color: #343a40 !important;
}
</style>
