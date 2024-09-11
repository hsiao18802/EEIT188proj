<template>
  <div class="register-container">
      <h2>註冊</h2>
      <form @submit.prevent="register" class="register-form">
          <div class="form-group">
              <label for="username">用戶名：</label>
              <input type="text" id="username" v-model="username" required>
          </div>

          <div class="form-group">
              <label for="password">密碼：</label>
              <input type="password" id="password" v-model="password" required>
          </div>

          <div class="form-group">
              <label for="realName">真實姓名：</label>
              <input type="text" id="realName" v-model="realName">
          </div>

          <div class="form-group">
              <label for="email">電子郵件：</label>
              <input type="email" id="email" v-model="email" required>
          </div>

          <div class="form-group">
              <label for="phone">電話：</label>
              <input type="text" id="phone" v-model="phone">
          </div>

          <div class="form-group">
              <label for="address">地址：</label>
              <input type="text" id="address" v-model="address">
          </div>

          <button type="submit" class="submit-btn">註冊</button>
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
const username = ref('');
const password = ref('');
const realName = ref('');
const email = ref('');
const phone = ref('');
const address = ref('');
const message = ref('');

const register = async () => {
  Swal.fire({
      text: "註冊中......",
      showConfirmButton: false,
      allowOutsideClick: false,
  });

  let body = {
      "username": username.value,
      "password": password.value,
      "realName": realName.value,
      "email": email.value,
      "phone": phone.value,
      "address": address.value
  };

  axiosapi.post("/ajax/secure/register", body).then(function (response) {
      console.log("response", response);
      message.value = response.data.message;

      if (response.data.success) {
          Swal.fire({
              text: response.data.message,
              icon: "success",
          }).then(function (result) {
              // 如果註冊成功，跳轉到登入頁面
              router.push({ name: "secure-login-link" });
          });
      } else {
          Swal.fire({
              text: response.data.message,
              icon: "error",
          });
      }
  }).catch(function (error) {
      console.log("error", error);
      Swal.fire({
          text: "註冊失敗：" + error.message,
          icon: "error",
      });
  }).finally(function () {
      console.log("finally");
  });
};
</script>

<style scoped>
.register-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h2 {
  text-align: center;
  margin-bottom: 20px;
}

.register-form {
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
