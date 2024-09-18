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
          <button @click="googleSignIn" class="google-btn">Google 登錄</button>
        </div>

        <!-- 掃碼登錄按鈕 -->
        <div class="qr-login-container">
          <h4>或使用掃碼登錄</h4>
          <button @click="generateQrCode" class="google-btn">生成 QR 掃碼登錄</button>
          <!-- 顯示 QR Code -->
          <canvas id="qrcode" style="margin-top: 20px;"></canvas>
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
import { ref, onMounted, nextTick } from 'vue';  // 引入 nextTick
import { useRouter } from 'vue-router';
import useUserStore from '@/stores/user.js';  // 引用 Pinia 的 store
import QRCode from 'qrcode'; // 引入 qrcode 用來生成 QR code

const userStore = useUserStore();
const router = useRouter();
const username = ref("");
const password = ref("");
const message = ref("");
const qrCodeUrl = ref("");

// 普通登入邏輯
function login() {
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
  userStore.setLogin(false);

  axiosapi.post("/ajax/secure/login", body).then(function (response) {
    if (response.data.success) {
      // 使用 Pinia 存储登录状态和 token
      userStore.setLogin(true);
      userStore.setRealname(response.data.realname);
      userStore.setToken(response.data.token); // 不再需要手动存储 token 到 localStorage

      axiosapi.defaults.headers.authorization = `Bearer ${response.data.token}`;
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
  }).catch(function (error) {
    Swal.fire({
      text: "錯誤：" + error.message,
      icon: "error",
    });
  });
}

// Google 登錄邏輯
function googleSignIn() {
  google.accounts.id.prompt();  // 手動觸發 Google 登錄提示框
}

// 掃碼登錄邏輯
async function generateQrCode() {
  // 使用實際的 Google OAuth 掃碼登錄 URL
  qrCodeUrl.value = `https://accounts.google.com/o/oauth2/auth?response_type=code&client_id=817520602073-7t549n8e39okn7hg67oql84u71kp0e5t.apps.googleusercontent.com&redirect_uri=http://localhost:8080/ajax/secure/google-login&scope=email%20profile&state=${generateState()}`;

  console.log("Before nextTick: QR Code URL is", qrCodeUrl.value);

  // 等待 DOM 更新，確保 #qrcode 容器已被插入
  await nextTick();

  const canvasElement = document.getElementById('qrcode');
  if (canvasElement) {
    try {
      QRCode.toCanvas(canvasElement, qrCodeUrl.value, function (error) {
        if (error) {
          console.error("QR Code generation error:", error);
        } else {
          console.log("QR code generated successfully for OAuth URL");
        }
      });
    } catch (error) {
      console.error("QRCode generation error:", error);
    }
  } else {
    console.error('QR Code container not found after DOM update');
  }
}


// 生成一個唯一的 state 用於 OAuth2 驗證
const generateState = () => {
  return Math.random().toString(36).substring(2, 15);
};

// 初始化 Google 登錄
onMounted(() => {
  window.handleCredentialResponse = function (response) {
    const idToken = response.credential;

    axiosapi.post('/ajax/secure/google-login', { token: idToken }).then(res => {
      if (res.data.success) {
        // 使用 Pinia 存储登录状态和 token
        userStore.setLogin(true);
        userStore.setRealname(res.data.realname);
        userStore.setToken(res.data.token);  // 不再需要手动存储 token 到 localStorage

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

  google.accounts.id.initialize({
    client_id: '817520602073-7t549n8e39okn7hg67oql84u71kp0e5t.apps.googleusercontent.com',
    callback: handleCredentialResponse
  });
});
</script>

<style scoped>
/* 样式保持不变 */
.login-page {
  display: flex;
  justify-content: center;
  align-items: flex-start; /* 讓內容貼近上方 */
  height: 100vh;
  background-color: white;
  padding-top: 0; /* 可選，移除 padding */
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
  background-image: url('/public/rent1.jpg');  /* 設置背景圖片 */
  background-size: cover;  /* 確保圖片完全覆蓋容器 */
  background-position: center;  /* 讓圖片在容器中居中 */
  border-radius: 10px;  /* 圖片的圓角效果 */
}

.login-image {
  max-width: 100%;
  height: auto;
  border-radius: 10px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
  color: white; /* 字體顏色設置為白色 */
}
h3,h4 {
  color: white ;
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
</style>
