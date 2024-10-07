<template>
    <div class="background">
  <div class="register-container">
    <h2>用戶註冊</h2>
    <form @submit.prevent="register" class="register-form">
      <div class="form-group">
        <label for="username">用戶名：</label>
        <input
          type="text"
          id="username"
          v-model="username"
          @blur="validateUsername"
          required
        />
        <span v-if="usernameError" class="error-message">✘ 用戶名必須包含大小寫字母，且只能包含字母和數字。</span>
        <span v-else-if="usernameValid" class="success-message">✔ 符合格式</span>
      </div>

      <div class="form-group">
        <label for="password">密碼：</label>
        <input
          type="password"
          id="password"
          v-model="password"
          @blur="validatePassword"
          required
        />
        <span v-if="passwordError" class="error-message">✘ 密碼必須包含至少6個字元，並且至少包含一個大寫字母、一個小寫字母。</span>
        <span v-else-if="passwordValid" class="success-message">✔ 符合格式</span>
      </div>

      <div class="form-group">
        <label for="realName">真實姓名：</label>
        <input
          type="text"
          id="realName"
          v-model="realName"
          @blur="validateRealName"
        />
        <span v-if="realNameError" class="error-message">✘ 不能輸入數字</span>
        <span v-else-if="realNameValid" class="success-message">✔ 符合格式</span>
      </div>

      <div class="form-group">
        <label for="email">電子郵件：</label>
        <input
          type="email"
          id="email"
          v-model="email"
          @blur="validateEmail"
          required
        />
        <span v-if="emailError" class="error-message">✘ 請輸入正確的信箱格式</span>
        <span v-else-if="emailValid" class="success-message">✔ 符合格式</span>
      </div>

      <div class="form-group">
        <label for="phone">電話：</label>
        <input
          type="text"
          id="phone"
          v-model="phone"
          @blur="validatePhone"
          required
        />
        <!-- 只有輸入非數字字符時顯示錯誤 -->
        <span v-if="phoneError" class="error-message">✘ 只能輸入數字</span>
        <span v-else-if="phoneValid" class="success-message">✔ 符合格式</span>
      </div>

      <div class="form-group">
        <label for="address">地址：</label>
        <input type="text" id="address" v-model="address" />
      </div>

      <button type="submit" class="submit-btn">註冊</button>
    </form>
  </div>
  </div>
</template>


<script setup>
import { ref } from "vue";
import Swal from "sweetalert2"; // 引入 SweetAlert2
import axiosapi from "@/plugins/axios.js";
import { useRouter } from "vue-router";
import useUserStore from "@/stores/user.js"; // 引用 Pinia 的 store

const userStore = useUserStore();
const router = useRouter();
const username = ref("");
const password = ref("");
const realName = ref("");
const email = ref("");
const phone = ref("");
const address = ref("");
const message = ref("");

// 錯誤和正確訊息狀態
const usernameError = ref(false);
const usernameValid = ref(false);
const passwordError = ref(false);
const passwordValid = ref(false);
const realNameError = ref(false);
const realNameValid = ref(false);
const emailError = ref(false);
const emailValid = ref(false);
const phoneError = ref(false);
const phoneValid = ref(false);

// 簡化的用戶名驗證邏輯
const validateUsername = () => {
  const usernameRegex = /^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]+$/;
  if (usernameRegex.test(username.value)) {
    usernameError.value = false;
    usernameValid.value = true;
  } else {
    usernameError.value = true;
    usernameValid.value = false;
  }
};

// 密碼驗證邏輯：至少6個字元，且包含大小寫字母和數字
const validatePassword = () => {
  const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$/;
  if (passwordRegex.test(password.value)) {
    passwordError.value = false;
    passwordValid.value = true;
  } else {
    passwordError.value = true;
    passwordValid.value = false;
  }
};

// 真實姓名驗證邏輯：只有在輸入內容時才驗證是否包含數字
const validateRealName = () => {
  if (realName.value === "") {
    realNameError.value = false;
    realNameValid.value = false;
    return;
  }
  
  const realNameRegex = /^[^\d]+$/;
  if (realNameRegex.test(realName.value)) {
    realNameError.value = false;
    realNameValid.value = true;
  } else {
    realNameError.value = true;
    realNameValid.value = false;
  }
};

// 電子郵件驗證邏輯：檢查是否符合電子郵件格式
const validateEmail = () => {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (emailRegex.test(email.value)) {
    emailError.value = false;
    emailValid.value = true;
  } else {
    emailError.value = true;
    emailValid.value = false;
  }
};

// 電話驗證邏輯：只有當輸入非數字字符時才顯示錯誤
const validatePhone = () => {
  if (phone.value === "") {
    phoneError.value = false;
    phoneValid.value = false;
    return;
  }

  const phoneRegex = /^\d+$/;
  if (phoneRegex.test(phone.value)) {
    phoneError.value = false;
    phoneValid.value = true;
  } else {
    phoneError.value = true;
    phoneValid.value = false;
  }
};

const register = async () => {
  // 註冊之前再次驗證用戶名、密碼、真實姓名、電子郵件和電話
  validateUsername();
  validatePassword();
  validateRealName();
  validateEmail();
  validatePhone();

  if (usernameError.value || passwordError.value || realNameError.value || emailError.value || phoneError.value) {
    // 如果有錯誤，不進行註冊
    return;
  }

  let body = {
    username: username.value,
    password: password.value,
    realName: realName.value,
    email: email.value,
    phone: phone.value,
    address: address.value,
  };

  axiosapi
    .post("/ajax/secure/register", body)
    .then(function (response) {
      console.log("response", response);
      message.value = response.data.message;

      if (response.data.success) {
        // 註冊成功，彈出 SweetAlert 提示框
        Swal.fire({
          title: "註冊成功",
          text: "您的帳號已成功創建！",
          icon: "success",
          confirmButtonText: "確認",
        }).then(() => {
          // SweetAlert 確認後跳轉到登入頁面
          router.push({ name: "secure-login-link" });
        });
      }
    })
    .catch(function (error) {
      console.log("error", error);
    });
};
</script>




<style scoped>
.register-container {
  max-width: 380px;
  margin: 50px auto;
  padding: 40px;
  background-color: #382d2d;
  border-radius: 12px;
  box-shadow: 0 10px 30px rgba(126, 118, 118, 0.1);
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

h2 {
  text-align: center;
  font-size: 26px;
  font-weight: 600;
  color: #eedddd;
  margin-bottom: 30px;
}

.register-form {
  display: flex;
  flex-direction: column;
}

.form-group {
  margin-bottom: 20px;
}

.form-group label {
  font-size: 14px;
  font-weight: 500;
  color: #eedddd;
  margin-bottom: 8px;
  display: block;
}

.form-group input {
  width: 100%;
  padding: 12px 15px;
  border: 1px solid #ddd;
  border-radius: 8px;
  font-size: 16px;
  color: #eedddd;
  background-color: #f9f9f9;
  transition: border-color 0.3s ease, background-color 0.3s ease;
}

.form-group input:focus {
  border-color: #007bff;
  background-color: #fff;
  color: #333;
}

.submit-btn {
  width: 100%;
  padding: 14px 0;
  background-color: #0d151d;
  color: white;
  border: none;
  border-radius: 8px;
  font-size: 18px;
  font-weight: 600;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.submit-btn:hover {
  background-color: #0056b3;
}

/* 設置錯誤訊息為紅色 */
.error-message {
  color: red;
  font-size: 14px;
  margin-top: 5px;
  display: block;
}

/* 設置正確訊息為綠色 */
.success-message {
  color: green;
  font-size: 14px;
  margin-top: 5px;
  display: block;
}

@media (max-width: 480px) {
  .register-container {
    padding: 30px 20px;
  }

  h2 {
    font-size: 22px;
  }

  .submit-btn {
    font-size: 16px;
  }
}



</style>
