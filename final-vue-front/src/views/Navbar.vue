<template>
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
      <div class="navbar-brand d-flex align-items-center">
        <!-- 加入LOGO -->
        <img src="/logo.webp" alt="Logo" width="40" height="40" class="me-2">
        <span>趣露營</span>
      </div>
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
                <RouterLink class="dropdown-item" to="/members/info">會員資料</RouterLink>
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
import { useCartStore } from '@/stores/cartStore';

const userStore = useUserStore();
const router = useRouter();
const cartStore = useCartStore();

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
      await axiosapi.post('/ajax/secure/logout');

      // 清除 Pinia 狀態
      userStore.setLogin(false);
      userStore.setRealname('');
      userStore.setToken('');
      userStore.setMembersId('');
      // 清除購物車資料
      cartStore.clearCart(); 


      // 清除 sessionStorage 中的狀態
      sessionStorage.removeItem('token');
      sessionStorage.removeItem('login');

      // 清除 localStorage 中的狀態
      localStorage.removeItem('token');
      localStorage.removeItem('login');
      localStorage.removeItem('cartList');  // 清除 cartList
      console.log('登出後 localStorage:', localStorage); // 檢查清除結果


      // 清除 Google 的客戶端狀態
      google.accounts.id.disableAutoSelect();
      google.accounts.id.revoke(userStore.realname, done => {
        console.log('Google user revoked.');
      });

      // 跳轉到登入頁面
      router.push({ name: 'secure-login-link' }).then(() => {
        // 等導航完成後自動刷新頁面
        window.location.reload(); // 強制刷新頁面
      });
    }
  } catch (error) {
    console.error('登出失敗', error);
    Swal.fire({
      title: '登出失敗',
      text: '請稍後再試。',
      icon: 'error',
    });
  }
}

</script>

<style>






</style>