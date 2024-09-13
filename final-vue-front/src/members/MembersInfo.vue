<template>
  <div class="member-info">
    <h1>會員資料</h1>
    <div v-if="member">
      <!-- 大頭貼顯示，點擊圖片觸發文件選擇 -->
      <p class="profile-photo-container" @click="onClickPhoto">
        <img :src="photoPreviewUrl || defaultPhoto" alt="會員照片" class="profile-photo" />
      </p>

      <!-- 隱藏的文件選擇器 -->
      <input type="file" ref="fileInput" style="display: none;" @change="onFileChange" />

      <!-- 基本資料編輯表單 -->
      <p><strong>使用者名稱:</strong> {{ member.username }}</p>

      <p>
        <label><strong>姓名:</strong></label>
        <input type="text" v-model="member.realName" />
      </p>

      <p>
        <label><strong>電子郵件:</strong></label>
        <input type="email" v-model="member.email" />
      </p>

      <p>
        <label><strong>電話號碼:</strong></label>
        <input type="text" v-model="member.phone" />
      </p>

      <p>
        <label><strong>地址:</strong></label>
        <input type="text" v-model="member.address" />
      </p>

      <!-- 更新基本資料按鈕 -->
      <button  @click="updateMemberInfo">更新基本資料</button>

    </div>
    <div v-else>
      <p>載入中...</p>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axiosapi from '@/plugins/axios.js';
import { useRouter } from 'vue-router';  // 引入 router 來實現跳轉
import Swal from 'sweetalert2';  // 引入 SweetAlert2 顯示提示

const member = ref(null);
const router = useRouter();  // 初始化 Vue Router
const selectedFile = ref(null);  // 存儲用戶選擇的文件
const photoPreviewUrl = ref(null);  // 預覽圖片的 URL
const defaultPhoto = '/public/640.jpeg';  // 你的默认占位符图片路径
const fileInput = ref(null);  // 參考文件選擇器元素

onMounted(() => {
  const token = localStorage.getItem('token');  // 從 localStorage 取得 JWT token

  if (!token) {
    // 如果沒有 token，顯示提示並跳轉到登入頁面
    Swal.fire({
      title: '未登入',
      text: '請先登入會員',
      icon: 'warning',
      timer: 2000,  // 顯示 2 秒後跳轉
      showConfirmButton: false
    }).then(() => {
      router.push({ name: 'secure-login-link' });  // 跳轉到登入頁面
    });
    return;
  }

  // 如果有 token，發送 API 請求獲取會員資料
  axiosapi.get('/rent/member/info', {
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then(response => {
    member.value = response.data;  // 設置會員資料
    // 初始化時顯示已存儲的會員圖片，如果沒有圖片，使用占位符
    if (member.value.memberPhoto) {
      photoPreviewUrl.value = 'data:image/jpeg;base64,' + member.value.memberPhoto;
    }
  }).catch(error => {
    console.error("獲取會員資料失敗", error);
    member.value = null;
  });
});

// 當點擊圖片時觸發文件選擇器
function onClickPhoto() {
  fileInput.value.click();  // 觸發隱藏的文件選擇器
}

// 當用戶選擇圖片時觸發，將圖片存儲到 selectedFile 中，並即時預覽
function onFileChange(event) {
  selectedFile.value = event.target.files[0];  // 獲取用戶選擇的文件

  // 使用 FileReader 來顯示圖片的即時預覽
  const reader = new FileReader();
  reader.onload = (e) => {
    photoPreviewUrl.value = e.target.result;  // 顯示圖片預覽
  };
  reader.readAsDataURL(selectedFile.value);

  // 自動觸發上傳圖片功能
  uploadPhoto();
}

// 上傳大頭貼圖片到後端
function uploadPhoto() {
  if (!selectedFile.value) {
    Swal.fire({
      title: '請選擇圖片',
      text: '您尚未選擇任何圖片',
      icon: 'warning',
    });
    return;
  }

  const formData = new FormData();
  formData.append('file', selectedFile.value);  // 將選擇的圖片添加到 FormData
  formData.append('username', member.value.username);  // 傳遞 username 作為參數

  const token = localStorage.getItem('token');  // 從 localStorage 取得 JWT token

  // 發送上傳請求到後端
  axiosapi.post('/rent/member/upload-photo', formData, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'multipart/form-data'
    }
  }).then(response => {
    Swal.fire({
      title: '更新成功',
      text: '您的大頭貼已成功更新',
      icon: 'success',
    });
    // 更新顯示新的大頭貼
    member.value.memberPhoto = response.data.memberPhoto;
    photoPreviewUrl.value = 'data:image/jpeg;base64,' + response.data.memberPhoto;  // 更新圖片預覽
  }).catch(error => {
    Swal.fire({
      title: '更新失敗',
      text: '上傳圖片失敗，請稍後再試',
      icon: 'error',
    });
    console.error("圖片上傳失敗", error);
  });
}

// 更新會員基本資料
function updateMemberInfo() {
  const token = localStorage.getItem('token');  // 從 localStorage 取得 JWT token

  // 發送更新會員基本資料的請求
  axiosapi.put('/rent/member/update', member.value, {
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then(response => {
    Swal.fire({
      title: '更新成功',
      text: '您的基本資料已成功更新',
      icon: 'success',
    });
  }).catch(error => {
    Swal.fire({
      title: '更新失敗',
      text: '更新資料失敗，請稍後再試',
      icon: 'error',
    });
    console.error("更新資料失敗", error);
  });
}
</script>

<style scoped>
.member-info {
  max-width: 600px;
  margin: 20px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 10px;
  background-color: #aaa0a0;
  position: relative;  /* 讓整個 member-info 區塊成為相對定位元素 */
}

.profile-photo {
  width: 200px;  /* 固定框的寬度 */
  height: 200px;  /* 固定框的高度 */
  border-radius: 50%;  /* 使大頭貼圓形 */
  object-fit: cover;  /* 確保圖片在框內填滿，且保持比例 */
  object-position: center;  /* 圖片在框內置中 */
  position: absolute;
  top: -50px;  /* 調整圖片位置 */
  right: 10px;
  cursor: pointer;
}


input {
  display: block;
  margin: 5px 0;
}

button {
  margin-top: 10px;
  padding: 10px 20px;
  background-color: #53575a;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
