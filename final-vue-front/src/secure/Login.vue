<template>
  <div class="login-container">
    <h3>登入</h3>
    <form @submit.prevent="login" class="login-form">
      <div class="form-group">
        <label for="username">帳號：</label>
        <input type="text" id="username" v-model="username" required>
        <span class="error">{{ message }}</span>
      </div>
      <div class="form-group">
        <label for="password">密碼：</label>
        <input type="password" id="password" v-model="password" required>
        <span class="error"></span>
      </div>
      <div class="form-group">
        <button type="submit" class="submit-btn">登入</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import Swal from 'sweetalert2';
import axiosapi from '@/plugins/axios.js';
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import useUserStore from '@/stores/user.js';  // 引用 Pinia 的 store

const userStore = useUserStore();
const router = useRouter();
const username = ref("");
const password = ref("");
const message = ref("");

function login() {
  // 清除先前的錯誤訊息
  message.value = "";

  // 檢查帳號與密碼是否輸入
  if (!username.value || !password.value) {
    message.value = "請輸入帳號和密碼";
    return;
  }

  // 開始顯示加載提示
  Swal.fire({
    text: "Loading......",
    showConfirmButton: false,
    allowOutsideClick: false,
  });

  // 登入請求資料
  let body = {
    "username": username.value,
    "password": password.value,
  };

  // 清除先前的授權標頭
  axiosapi.defaults.headers.authorization = "";
  userStore.setRealname("");
  userStore.setLogin(false);

  // 發送登入請求
  axiosapi.post("/ajax/secure/login", body).then(function (response) {
    console.log("response", response);
    message.value = response.data.message;

    if (response.data.success) {
      // 成功後更新 Pinia 狀態並設置 token
      userStore.setToken(response.data.token); // 存入 Pinia，Pinia 會自動持久化 token。
      userStore.setLogin(true);
      userStore.setRealname(response.data.realname);

      // 手動將 token 存入 localStorage
      localStorage.setItem('token', response.data.token);
      console.log("Token manually stored in sessionStorage:", localStorage.getItem('token'));

      // 設置 axios 授權標頭
      axiosapi.defaults.headers.authorization = `Bearer ${response.data.token}`;

      // 顯示成功提示並跳轉到首頁
      Swal.fire({
        text: response.data.message,
        icon: "success",
      }).then(() => {
        router.push({ name: "home-link" });
      });

    } else {
      // 顯示後端回傳的錯誤訊息
      Swal.fire({
        text: response.data.message,
        icon: "error",
      });
    }

  }).catch(function (error) {
    console.log("error", error);
    // 處理請求錯誤並顯示提示
    Swal.fire({
      text: "錯誤：" + error.message,
      icon: "error",
    });
  });
}
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

.error {
    color: red;
    font-size: 14px;
    margin-top: 10px;
    text-align: center;
}
</style>
