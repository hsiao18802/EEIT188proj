<template>
  <div v-if="!isLoading">
    <div v-if="employeeAccount" class="centered-container">
      <h1 class="welcome-message">
        歡迎回來，{{ employeeAccount }}
      </h1>

      <!-- Button Group：左右兩顆按鈕 -->
      <div class="btn-group" role="group" aria-label="Button group">
        <button @click="goToAdmin" class="btn btn-primary">進入管理系統</button>
        <button @click="logout" class="btn btn-danger">登出</button>
      </div>
    </div>

    <!-- 當未登入時，顯示登入表單 -->
    <div v-else class="login-container centered-container">
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
        <button type="submit" class="btn btn-primary w-100">登入</button>
        <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axiosapi from '@/plugins/axios'; // 依據你的 axios 設置
import { useRouter } from 'vue-router'; // 引入 useRouter 來進行路由操作
import Swal from 'sweetalert2'; // 引入 SweetAlert2

// 登入和登出相關變數
const employeeAccount = ref(null); // 定義一個變數來存放員工帳號
const account = ref(''); // 登入帳號
const password = ref(''); // 登入密碼
const errorMessage = ref(''); // 錯誤訊息
const isLoading = ref(true); // 用於控制是否顯示內容


// 獲取 router 實例
const router = useRouter();

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
  isLoading.value = false;
});

// 修改後的 handleLogin 方法
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

    // 跳轉到後台首頁
    router.push('/employee/emphome');
  } catch (error) {
    errorMessage.value = '帳號或密碼錯誤，請重新嘗試';
  }
};

// 進入管理系統方法
const goToAdmin = () => {
  router.push('/employee/emphome');
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
/* 置中樣式 */
.centered-container {
  max-width: 400px;
  margin: 50px auto;
  text-align: center;
}

.welcome-message {
  font-family: '微軟正黑體', sans-serif;
  font-size: xx-large;
  font-weight: bold;
  margin-bottom: 30px;
}

.btn-group {
  display: flex;
  justify-content: space-between;
}

.login-container {
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
  padding: 10px;
  border-radius: 4px;
  cursor: pointer;
}

.error-message {
  color: red;
  text-align: center;
  margin-top: 20px;
}
</style>
