<template>
    <div class="login-container">
      <h2>後台登入</h2>
      <form @submit.prevent="handleLogin">
        <div class="form-group">
          <label for="account">帳號</label>
          <input
            type="text"
            id="account"
            v-model="account"
            placeholder="請輸入帳號"
            required
          />
        </div>
        <div class="form-group">
          <label for="password">密碼</label>
          <input
            type="password"
            id="password"
            v-model="password"
            placeholder="請輸入密碼"
            required
          />
        </div>
        <button type="submit">登入</button>
        <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
      </form>
    </div>
  </template>
  
  <script>
  import axiosapi from '../plugins/axios'; // 使用你配置好的 axios 實例
  
  export default {
    data() {
      return {
        account: '',
        password: '',
        errorMessage: '',
      };
    },
    methods: {
      async handleLogin() {
        try {
          // 發送登錄請求到後端 API
          const response = await axiosapi.post('/api/employee/login', {
            account: this.account,
            password: this.password,
          });
  
          // 如果登錄成功，可以將 token 或其他信息保存到 localStorage 或 Vuex
          alert(response.data);
          this.$router.push('/employee/emphome'); // 登錄成功後跳轉到儀表板頁面
        } catch (error) {
          this.errorMessage = '帳號或密碼錯誤，請重新嘗試';
        }
      },
    },
  };
  </script>
  
  <style scoped>
  .login-container {
    max-width: 400px;
    margin: 100px auto;
    padding: 20px;
    border: 1px solid #ddd;
    border-radius: 4px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
  
  h2 {
    text-align: center;
  }
  
  .form-group {
    margin-bottom: 20px;
  }
  
  label {
    display: block;
    margin-bottom: 5px;
  }
  
  input {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
    border: 1px solid #ddd;
    border-radius: 4px;
  }
  
  button {
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  
  button:hover {
    background-color: #0056b3;
  }
  
  .error-message {
    color: red;
    text-align: center;
    margin-top: 20px;
  }
  </style>
  