<template>
  <nav class="navbar navbar-expand-lg navbar-modern">
    <div class="container-fluid">
      <div class="navbar-brand d-flex align-items-center">
        <!-- LOGO -->
        <RouterLink  to="/">
          <img src="/logo.webp" alt="Logo" width="60" height="60" class="me-2 logo-jump" />
      </RouterLink>
   <!-- 趣露營商店名稱帶有連結 -->
   <RouterLink class="brand-logo" to="/">
          <span>趣露營</span>
        </RouterLink>
       
      </div>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
        aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
          <li class="nav-item">
            <RouterLink class="nav-link active" aria-current="page" to="/coupon">關於我們</RouterLink>
          </li>

          <li class="nav-item">
       
            <RouterLink class="nav-link active" aria-current="page" to="/productpage">租借產品</RouterLink>
          </li>
    
          
        </ul>
        <ul class="navbar-nav ms-auto">
          <li class="nav-item" v-if="!userStore.isLogin">
            <RouterLink class="nav-link active" aria-current="page" to="/secure/login">登入</RouterLink>
          </li>
          <li class="nav-item" v-if="!userStore.isLogin">
            <RouterLink class="nav-link active" aria-current="page" to="/secure/register">註冊</RouterLink>
          </li>

          <!-- 顯示會員大頭貼與 "你好 realName" -->
          <li class="nav-item d-flex align-items-center" v-if="userStore.isLogin">
        
            <!-- 如果 memberPhoto 沒有值，則顯示預設圖片 -->
            <img 
              :src="userStore.memberPhoto ? 'data:image/jpeg;base64,' + userStore.memberPhoto : defaultPhoto" 
              alt="會員大頭貼" 
              class="member-photo me-2" 
            />
            <span class="text-white">你好，{{ userStore.realname }} !!</span>
          </li>

          <li class="nav-item" v-if="userStore.isLogin">
            <a class="nav-link" href="#" @click="logout">登出</a>
          </li>

          <li class="nav-item dropdown" v-if="userStore.isLogin">
            <span class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">會員頁面</span>
            <ul class="dropdown-menu">
              <li><RouterLink class="dropdown-item" to="/members/info">會員資料</RouterLink></li>
              <li><RouterLink class="dropdown-item" to="/members/memberOrder">會員訂單</RouterLink></li>

              <li><RouterLink class="dropdown-item" to="/support/memberchat">即時人工客服</RouterLink></li>
            </ul>
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
const defaultPhoto = '/640.jpeg'; // 設置你的預設圖片路徑

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
      await axiosapi.post('/ajax/secure/logout');
      userStore.setLogin(false);
      userStore.setRealname('');
      userStore.setToken('');
      userStore.setMembersId('');
      userStore.setMemberPhoto(''); // 清除會員大頭貼
      cartStore.clearCart(); 
      sessionStorage.removeItem('token');
      sessionStorage.removeItem('login');
      localStorage.clear(); 
      google.accounts.id.disableAutoSelect();
      google.accounts.id.revoke(userStore.realname, done => {
        console.log('Google user revoked.');
      });
      router.push({ name: 'secure-login-link' }).then(() => {
        window.location.reload();
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

<style scoped>
/* 現代化的導航欄樣式 */
.navbar-modern {
  background: linear-gradient(135deg, #51595e, #004080);
  padding: 15px 30px;
  border-radius: 0 0 15px 15px;
}

.navbar-brand {
  font-size: 26px;
  font-weight: 600;
  color: white;
}

.navbar-toggler {
  border-color: white;
}

.nav-link {
  color: white;
  font-size: 18px;
  padding: 10px 20px;
  transition: color 0.3s ease, background-color 0.3s ease;
}

.nav-link:hover {
  color: #ffcc00;
  background-color: rgba(255, 255, 255, 0.1);
  border-radius: 8px;
}

.nav-link.active {
  color: white; /* 修改活躍鏈接的顏色，與普通鏈接保持一致 */
  background-color: transparent; /* 去除背景色 */
}

/* 當活躍鏈接被懸停時，應用懸停效果 */
.nav-link.active:hover {
  color: #ffcc00;  /* 懸停時同樣應用黃色 */
  background-color: rgba(255, 255, 255, 0.1);  /* 懸停時應用背景 */
  border-radius: 8px;
}

/* 會員大頭貼樣式 */
.member-photo {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  object-fit: cover;
}

.dropdown-menu {
  background-color: #5b6672;
  border-color: #4e5d64;
  border-radius: 10px;
}

.dropdown-item {
  color: white;
  padding: 10px;
  transition: background-color 0.3s ease;
}

.dropdown-item:hover {
  background-color: #ffcc00;
  color: #56626e;
}

/* 手機端的響應式樣式 */
@media (max-width: 768px) {
  .navbar-nav {
    text-align: center;
    padding: 15px 0;
  }

  .nav-link {
    padding: 10px;
  }
}



.brand-logo {
  font-size: 28px;
  font-weight: 700; /* 使用適中的粗度來保留優雅感 */
  font-family: 'Raleway', sans-serif; /* 更圓潤且現代的字體選擇 */
  color: white; 
  text-transform: uppercase; /* 全大寫字母，提升標誌感 */
  letter-spacing: 3px; /* 增加字距讓設計更開放 */
  text-decoration: none;
  transition: color 0.3s ease;
  display: inline-block; /* 使動畫效果能正常運作 */
}



.logo-jump {
  display: inline-block; /* 使圖片能進行變形動畫 */
  transition: transform 0.3s ease; /* 變形過渡效果 */
}

/* 在滑鼠懸停時添加跳躍動畫 */
.logo-jump:hover {
  animation: jump 0.5s ease; /* 加入跳躍動畫 */
}

@keyframes jump {
  0% {
    transform: translateY(0); /* 起始位置 */
  }
  50% {
    transform: translateY(-10px); /* 向上移動 */
  }
  100% {
    transform: translateY(0); /* 回到起始位置 */
  }
}


</style>
