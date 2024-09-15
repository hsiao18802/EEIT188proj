<template>
    <div class="forgot-password-page">
      <div class="forgot-password-container">
        <h3>忘記密碼</h3>
        <form @submit.prevent="sendResetCode">
          <div class="form-group">
            <label for="email">輸入您的電子信箱：</label>
            <input type="email" id="email" v-model="email" required />
          </div>
          <button type="submit" class="submit-btn">傳送驗證碼</button>
        </form>
        
        <!-- 輸入驗證碼和新密碼的部分 -->
        <div v-if="codeSent">
          <h3>輸入驗證碼</h3>
          <form @submit.prevent="resetPassword">
            <div class="form-group">
              <label for="code">驗證碼：</label>
              <input type="text" id="code" v-model="verificationCode" required />
            </div>
            <div class="form-group">
              <label for="newPassword">新密碼：</label>
              <input type="password" id="newPassword" v-model="newPassword" required />
            </div>
            <button type="submit" class="submit-btn">重設密碼</button>
          </form>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import Swal from 'sweetalert2';
  import axiosapi from '@/plugins/axios.js';
  import { useRouter } from 'vue-router';
  
  const email = ref('');
  const verificationCode = ref('');
  const newPassword = ref('');
  const codeSent = ref(false);
  const router = useRouter();
  
  // 嘗試從 localStorage 中恢復之前的狀態
  onMounted(() => {
    const savedEmail = localStorage.getItem('forgot_password_email');
    const savedCodeSent = localStorage.getItem('forgot_password_code_sent');
  
    if (savedEmail) {
      email.value = savedEmail;
    }
    if (savedCodeSent === 'true') {
      codeSent.value = true;
    }
  });
  
  // 發送驗證碼並將 email 存儲在 localStorage
  function sendResetCode() {
    axiosapi.post('/api/forgot-password/send-code', { email: email.value })
      .then(response => {
        if (response.data.success) {
          Swal.fire('驗證碼已發送', '請檢查您的信箱', 'success');
          codeSent.value = true;
  
          // 將 email 和 codeSent 狀態存儲在 localStorage
          localStorage.setItem('forgot_password_email', email.value);
          localStorage.setItem('forgot_password_code_sent', 'true');
        } else {
          Swal.fire('錯誤', '發送失敗，請確認電子信箱是否正確', 'error');
        }
      })
      .catch(error => {
        Swal.fire('錯誤', '發送失敗，請稍後再試', 'error');
      });
  }
  
  // 重設密碼並在成功後清除 localStorage
  function resetPassword() {
    axiosapi.post('/api/forgot-password/reset-password', {
      email: email.value,
      code: verificationCode.value,
      newPassword: newPassword.value
    })
      .then(response => {
        if (response.data.success) {
          Swal.fire('成功', '密碼已重設', 'success').then(() => {
            // 清除 localStorage 中的狀態
            localStorage.removeItem('forgot_password_email');
            localStorage.removeItem('forgot_password_code_sent');
  
            router.push('/secure/login'); // 密碼重設後返回登錄頁面
          });
        } else {
          Swal.fire('錯誤', '驗證碼無效或已過期', 'error');
        }
      })
      .catch(error => {
        Swal.fire('錯誤', '重設失敗，請稍後再試', 'error');
      });
  }
  </script>
  
  <style scoped>
  .forgot-password-page {
    display: flex;
    justify-content: center;
    align-items: flex-start;
    height: 100vh;
    background-color: white;
  }
  
  .forgot-password-container {
    background-color: #413f3f;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    max-width: 500px;
    width: 100%;
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
  </style>
  