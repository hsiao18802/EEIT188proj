<template>
  <div class="login-container">
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
      userStore.setToken(response.data.token);
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
    userStore.setToken(res.data.token);
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
.login-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h3 {
  text-align: center;
  margin-bottom: 20px;
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
  background-color: #007bff;
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
  background-color: #4285F4;
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
</style>
