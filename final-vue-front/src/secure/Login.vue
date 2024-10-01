<template>
  <div class="login-page">
    <div class="login-container">
      <!-- 登錄框 -->
      <div class="login-form-container">
        <h3>登入</h3>
        <form @submit.prevent="login" class="login-form">
          <div class="form-group">
            <label for="username">帳號：</label>
            <input type="text" id="username" v-model="username" required />
            <span class="error">{{ message }}</span>
          </div>
          <div class="form-group">
            <label for="password">密碼：</label>
            <input type="password" id="password" v-model="password" required />
            <span class="error"></span>
          </div>
          <div class="form-group">
            <button type="submit" class="submit-btn">登入</button>
          </div>
        </form>

        <!-- 忘記密碼按鈕 -->
        <div class="forgot-password-container">
          <router-link to="/secure/forget" class="forgot-password-link">忘記密碼？</router-link>
        </div>

        <!-- Google 登錄 -->
        <div class="google-login-container">
          <h4>或使用 Google 登錄</h4>
          <button id="google-button" class="google-btn">Google 登錄</button>
        </div>
      </div>

      <!-- 圖片部分 -->
      <div class="login-image-container"></div>
    </div>
  </div>
</template>

<script setup>
import Swal from 'sweetalert2';
import axiosapi from '@/plugins/axios.js';
import { ref, onMounted, nextTick } from 'vue';
import { useRouter } from 'vue-router';
import useUserStore from '@/stores/user.js';
import { useCartStore } from '@/stores/cartStore';

const userStore = useUserStore();
const router = useRouter();
const username = ref("");
const password = ref("");
const message = ref("");
const cartStore = useCartStore();

async function login() {
  message.value = "";

  if (!username.value || !password.value) {
    message.value = "請輸入帳號和密碼";
    return;
  }

  Swal.fire({
    text: "Loading......",
    showConfirmButton: false,
    allowOutsideClick: false,
  });

  let body = { "username": username.value, "password": password.value };

  // 重置状态
  axiosapi.defaults.headers.authorization = "";
  userStore.setRealname("");
  userStore.setMembersId("");
  userStore.setLogin(false);

  try {
    const response = await axiosapi.post("/ajax/secure/login", body);

    if (response.data.success) {
      // 使用 Pinia 存储登录状态和 token
      userStore.setLogin(true);
      userStore.setRealname(response.data.realname);
      userStore.setToken(response.data.token);
      userStore.setMembersId(response.data.membersId);
      axiosapi.defaults.headers.authorization = `Bearer ${response.data.token}`;

      // 確保獲取最新的購物車內容
      await cartStore.updateNewList();

      // 判斷購物車內容，更新 shouldShowCartIcon 狀態
      cartStore.shouldShowCartIcon = cartStore.cartList.length > 0;

      Swal.fire({
        text: response.data.message,
        icon: "success",
      }).then(() => {
        router.push({ name: "home-link" });
      });
    } else {
      Swal.fire({
        text: response.data.message,
        icon: "error",
      });
    }
  } catch (error) {
    Swal.fire({
      text: "錯誤：" + error.message,
      icon: "error",
    });
  }
}

// Google 登錄邏輯
function googleSignIn() {
  google.accounts.id.prompt(); // 手動觸發 Google 登錄提示框
}

onMounted(async () => {
  // 等待 DOM 更新，確保 Google 登錄按鈕已被插入
  await nextTick();

  window.handleCredentialResponse = function (response) {
    const idToken = response.credential;
    console.log("Received ID Token from Google:", idToken);

    axiosapi.post('/ajax/secure/google-login', { token: idToken }).then(res => {
      if (res.data.success) {
        userStore.setLogin(true);
        userStore.setRealname(res.data.realname);
        userStore.setToken(res.data.token);
        userStore.setMembersId(res.data.membersId);

        axiosapi.defaults.headers.authorization = `Bearer ${res.data.token}`;
        Swal.fire({
          text: 'Google 登錄成功',
          icon: 'success'
        }).then(() => {
          router.push({ name: 'home-link' });
        });
      } else {
        Swal.fire({
          text: res.data.message,
          icon: 'error'
        });
      }
    }).catch(error => {
      Swal.fire({
        text: 'Google 登錄失敗，請稍後再試',
        icon: 'error'
      });
    });
  };

  // 初始化 Google 登錄
  google.accounts.id.initialize({
    client_id: '817520602073-7t549n8e39okn7hg67oql84u71kp0e5t.apps.googleusercontent.com',
    callback: handleCredentialResponse,
    cancel_on_tap_outside: true
  });

  // 渲染 Google 登錄按鈕
  google.accounts.id.renderButton(
    document.getElementById('google-button'),
    { theme: 'outline', size: 'large' }
  );

  // 檢查登入框是否成功顯示
  google.accounts.id.prompt((notification) => {
    if (notification.isNotDisplayed() || notification.isSkippedMoment()) {
      console.error('Google Sign-In prompt not displayed');
    }
  });
});
</script>

<style scoped>
.login-page {
  display: flex;
  justify-content: center;
  align-items: flex-start;
  height: 100vh;
  background-color: white;
  padding-top: 0;
}

.login-container {
  display: flex;
  justify-content: space-between;
  background-color: #413f3f;
  padding: 20px;
  margin-top: 0;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  max-width: 900px;
  width: 100%;
}

.login-form-container {
  flex: 1;
  padding-right: 20px;
}

.login-form {
  display: flex;
  flex-direction: column;
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
  color: white;
}

.form-group input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 16px;
}

.submit-btn {
  width: 100%;
  padding: 10px;
  background-color: #53575a;
  color: white;
  border: none;
  border-radius: 5px;
  font-size: 18px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.submit-btn:hover {
  background-color: #0056b3;
}

.forgot-password-container {
  margin-top: 10px;
  text-align: center;
}

.forgot-password-link {
  color: #357ae8;
  cursor: pointer;
  text-decoration: none;
}

.forgot-password-link:hover {
  text-decoration: underline;
}

.google-login-container {
  margin-top: 20px;
  text-align: center;
}

.google-btn {
  background-color: #53575a;
  color: white;
  border: none;
  border-radius: 5px;
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.google-btn:hover {
  background-color: #357AE8;
}

.error {
  color: red;
  font-size: 14px;
  margin-top: 10px;
  text-align: center;
}

.login-image-container {
  flex: 1;
  background-image: url('/public/rent1.jpg');
  background-size: cover;
  background-position: center;
  border-radius: 10px;
}

.login-image {
  max-width: 100%;
  height: auto;
  border-radius: 10px;
}

h3, h4 {
  color: white;
}
</style>
