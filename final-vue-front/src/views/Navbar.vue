<template>
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
      <span class="navbar-brand">購物首頁</span>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
        aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
          <li class="nav-item">
            <RouterLink class="nav-link active" aria-current="page" to="/">首頁</RouterLink>
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link active" aria-current="page" to="/productpage">我們的商品</RouterLink>
          </li>
          <li class="nav-item">
                        <RouterLink class="nav-link active" aria-current="page" to="/pages/Cart">購物車</RouterLink>
                    </li>

                    <li class="nav-item">
                        <RouterLink class="nav-link active" aria-current="page" to="/pages/Order">訂單詳情</RouterLink>
                    </li>



                    <li class="nav-item dropdown">
                        <span class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">功能</span>
                        <ul class="dropdown-menu">
                  
                            <li><RouterLink class="dropdown-item" to="/pages/products">產品</RouterLink></li>
                            <li><RouterLink class="dropdown-item" to="/cart">購物車</RouterLink></li>
                            <li><RouterLink class="dropdown-item" to="/pages/Card">訂單管理</RouterLink></li>
                        </ul>
                    </li>
        </ul>
        <ul class="navbar-nav ms-auto">
          

          <li class="nav-item" v-if="!userStore.isLogin">
            <RouterLink class="nav-link active" aria-current="page" to="/secure/login">登入</RouterLink>
          </li>
          <li class="nav-item" v-if="!userStore.isLogin">
            <RouterLink class="nav-link active" aria-current="page" to="/secure/register">註冊</RouterLink>
          </li>

          <li class="nav-item" v-if="userStore.isLogin">
            <a class="nav-link" href="#" @click="logout">登出</a>
          </li>

          <li class="nav-item dropdown">
            <span class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown"
              aria-expanded="false">會員頁面</span>
            <ul class="dropdown-menu">
              <li>
                <RouterLink class="dropdown-item" to="/member/memberdata">會員資料</RouterLink>
              </li>
              <li>
                <RouterLink class="dropdown-item" to="/member/memberorder">會員訂單</RouterLink>
              </li>

            </ul>
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link active" aria-current="page" to="/employee/emphome">管理系統</RouterLink>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>


<script setup>
import { useRouter } from 'vue-router';
import axiosapi from '@/plugins/axios';
import useUserStore from '@/stores/user'; // 引入 Pinia 的 store
import Swal from 'sweetalert2';

const userStore = useUserStore();
const router = useRouter();

async function logout() {
  try {
    const result = await Swal.fire({
      title: '確定要登出嗎？',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: '是的',
      cancelButtonText: '取消',
    });

    if (result.isConfirmed) {
      // 發送登出請求到後端
      await axiosapi.post('/ajax/secure/logout');  // 發送請求到後端

      // 清除 Pinia 狀態
      userStore.setLogin(false);
      userStore.setRealname('');
      userStore.setToken('');

      // 清除 sessionStorage 中的 token
      localStorage.removeItem('token');
      localStorage.removeItem('login');

      // 跳轉到登入頁面
      router.push({ name: 'secure-login-link' }).then(() => {
        // 等導航完成後自動刷新頁面
        window.location.reload();  // 強制刷新頁面
      });
    }
  } catch (error) {
    console.error('登出失敗', error);
  }
}
</script>

<style></style>