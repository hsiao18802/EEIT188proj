<template>
  <div v-if="!isLoading">
    <div v-if="employeeAccount">
      <h1 class="welcome-message">
        歡迎回來，{{ employeeAccount }}
      </h1>

      <!-- 這裡是大的登出按鈕 -->
      <button v-if="employeeAccount" @click="logout" class="logout-button">
        登出
      </button>
    </div>

    <!-- placeholder: 當未登入時，顯示登入表單 -->
    <div v-else class="login-container left-aligned">
      <h2>後台登入</h2>
      <form @submit.prevent="handleLogin">
        <div class="form-group">
          <label for="account">帳號</label>
          <input type="text" id="account" v-model="account" placeholder="請輸入帳號" required />
        </div>
        <div class="form-group">
          <label for="password">密碼</label>
          <input type="password" id="password" v-model="password" placeholder="請輸入密碼" required />
        </div>
        <button type="submit">登入</button>
        <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axiosapi from '@/plugins/axios'; // 依據你的 axios 設置
import Swal from 'sweetalert2'; // 引入 SweetAlert2

// 登入和登出相關變數
const employeeAccount = ref(null); // 定義一個變數來存放員工帳號
const account = ref(''); // 登入帳號
const password = ref(''); // 登入密碼
const errorMessage = ref(''); // 錯誤訊息
const isLoading = ref(true); // 用於控制是否顯示內容

// 當頁面掛載時，從 localStorage 取得 employee_id
onMounted(async () => {
  const employeeId = localStorage.getItem('employee_id');

  if (employeeId) {
    try {
      // 使用 employeeId 查詢對應的 employeeAccount
      const response = await axiosapi.get(`/api/employee/account/${employeeId}`);
      employeeAccount.value = response.data; // 設置查詢結果
    } catch (error) {
      console.error('無法查詢員工帳號', error);
    }
  }

  // 當資料加載完成後，設定 isLoading 為 false
  isLoading.value = false;
});

// 登入邏輯
const handleLogin = async () => {
  try {
    const response = await axiosapi.post('/api/employee/login', {
      account: account.value,
      password: password.value,
    });

    // 假設 response.data 包含 employeeId
    const employeeId = response.data.employeeId;

    // 將 employeeId 存入 localStorage
    localStorage.setItem('employee_id', employeeId);

    // 刷新頁面以更新登入狀態
    window.location.reload();
  } catch (error) {
    errorMessage.value = '帳號或密碼錯誤，請重新嘗試';
  }
};

// 登出邏輯
const logout = () => {
  Swal.fire({
    icon: 'success',
    title: '成功登出',
    confirmButtonText: '確定',
    confirmButtonColor: '#28a745', // 綠色背景
  }).then(() => {
    // 清除本地登入資訊
    localStorage.removeItem('employee_id');

    // 重刷頁面
    window.location.reload();
  });
};

</script>

<style scoped>
.welcome-message {
  margin-top: 50px;
  margin-left: 50px;
  font-family: '微軟正黑體', sans-serif;
  font-size: xx-large;
  font-weight: bold;
}

.logout-button {
  margin-top: 20px;
  padding: 10px;
  font-size: medium;
  background-color: #dc3545;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  width: 100%;
  max-width: 400px;
  display: block;
  margin-left: 50px;
}

/* 將 login-container 也對齊到左上角 */
.left-aligned {
  margin-top: 50px;
  margin-left: 50px;
}

.logout-button:hover {
  background-color: #c82333;
}

.login-container {
  max-width: 400px;
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
