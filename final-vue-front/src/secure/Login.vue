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

        <!-- Google 登錄 -->
        <div class="google-login-container">
          <h4>或使用 Google 登錄</h4>
          <button @click="googleSignIn" class="google-btn">Google 登錄</button>
        </div>
      </div>

      <!-- 圖片部分 -->
    <!-- 圖片部分 -->
    <div class="login-image-container"></div> <!-- 圖片改為背景 -->
    </div>
  </div>
</template>

<script setup>
import Swal from 'sweetalert2';
import axiosapi from '@/plugins/axios.js';
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import useUserStore from '@/stores/user.js';  // 引用 Pinia 的 store

const userStore = useUserStore();
const router = useRouter();
const username = ref("");
const password = ref("");
const message = ref("");

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

  axiosapi.defaults.headers.authorization = "";
  userStore.setRealname("");
  userStore.setLogin(false);

  axiosapi.post("/ajax/secure/login", body).then(function (response) {
    console.log("Realname from login response:", response.data.realname);  // 調試這裡
    if (response.data.success) {
      // userStore.setToken(response.data.token);
      userStore.setLogin(true);
      userStore.setRealname(response.data.realname);  // 確保這裡的 realname 設置成功

      localStorage.setItem('token', response.data.token);
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

// 初始化 Google 登錄
onMounted(() => {
  window.handleCredentialResponse = function (response) {
    const idToken = response.credential;

    axiosapi.post('/ajax/secure/google-login', { token: idToken }).then(res => {
      console.log("Realname from Google login response:", res.data.realname);  // 調試這裡
      if (res.data.success) {
        // userStore.setToken(res.data.token);
        userStore.setLogin(true);
        userStore.setRealname(res.data.realname);  // 確保這裡的 realname 設置成功
        console.log("Realname stored in Pinia:", userStore.realname);  // 檢查 realname 是否正確存入

        localStorage.setItem('token', res.data.token);
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

  // 初始化 Google 登錄 API
  google.accounts.id.initialize({
    client_id: '817520602073-7t549n8e39okn7hg67oql84u71kp0e5t.apps.googleusercontent.com',  // 替換為你的 Google 客戶端 ID
    callback: handleCredentialResponse
  });
});
</script>

<style scoped>
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

</style>
