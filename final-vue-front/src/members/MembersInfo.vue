<template>
  <div class="member-info">
    <h1>會員資料</h1>
    <div v-if="member">
      <p><strong>使用者名稱:</strong> {{ member.username }}</p>
      <p><strong>姓名:</strong> {{ member.realName }}</p>
      <p><strong>電子郵件:</strong> {{ member.email }}</p>
      <p><strong>電話號碼:</strong> {{ member.phone }}</p>
      <p><strong>地址:</strong> {{ member.address }}</p>
      <p><strong>註冊日期:</strong> {{ member.registrationDate }}</p>
      <!-- <p><strong>會員照片:</strong> <img :src="'data:image/jpeg;base64,' + member.memberPhoto" alt="會員照片"></p> -->
    </div>
    <div v-else>
      <p>載入中...</p>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import axiosapi from '@/plugins/axios.js';

const member = ref(null);

onMounted(() => {
  const token = localStorage.getItem('token');  // 從 localStorage 取得 JWT

  if (token) {
    axiosapi.get('/rent/member/info', {
      headers: {
        'Authorization': `Bearer ${token}`
      }
    }).then(response => {
      member.value = response.data;  // 設置會員資料
    }).catch(error => {
      console.error("獲取會員資料失敗", error);
      member.value = null;
    });
  }
});
</script>

<style scoped>
.member-info {
  max-width: 600px;
  margin: 20px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 10px;
  background-color: #f9f9f9;
}
</style>
