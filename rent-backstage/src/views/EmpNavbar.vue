<template>
  <div class="d-flex flex-column flex-shrink-0 p-3 bg-dark text-white" style="width: 280px;">
    <!-- 管理系統變成超連結，指向系統首頁 -->
    <RouterLink to="/employee/emphome"
      class="fs-4 mb-3 link-body-emphasis text-white d-inline-flex text-decoration-none rounded">管理系統</RouterLink>
    <hr>

    <!-- 如果已登入，顯示其他選項 -->
    <ul v-if="employeeId" class="list-unstyled ps-0">
      <li class="mb-1">
        <RouterLink to="/employee/order"
          class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">會員訂單
        </RouterLink>
      </li>
      <li class="mb-1">
        <RouterLink to="/employee/empproduct"
          class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">商品管理
        </RouterLink>
      </li>
      <li class="mb-1">
        <RouterLink to="/employee/member"
          class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">會員一覽
        </RouterLink>
      </li>
      <li class="mb-1">
        <RouterLink to="/plceholder/forphoto/remembertodelete"
          class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">員工管理
        </RouterLink>
      </li>
      <li class="mb-1">
        <RouterLink to="/customersupport"
          class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">客服頁面
        </RouterLink>
      </li>
    </ul>

    <hr>

    <!-- 修改登出按鈕樣式，使其看起來像超連結 -->
    <ul v-if="employeeId" class="list-unstyled ps-0">
      <li class="mb-1">
        <a @click="logout"
          class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">登出
        </a>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, watchEffect } from 'vue'; // 引入 ref 和 watchEffect
import { useRouter } from 'vue-router'; // 引入 useRouter 來進行路由操作
import Swal from 'sweetalert2'; // 引入 SweetAlert2

// 獲取 Vue Router 的實例
const router = useRouter();

// 設置 employeeId 為 null
const employeeId = ref(null);

// 動態監控 localStorage 中的 employee_id
watchEffect(() => {
  employeeId.value = localStorage.getItem('employee_id');
});

// 登出方法
const logout = async () => {
  try {
    // 清除本地的登入資訊
    localStorage.removeItem('employee_id'); // 清除員工 ID

    // 彈出成功提示
    Swal.fire({
      icon: 'success',
      title: '成功登出',
      confirmButtonText: '確定',
      confirmButtonColor: '#28a745', // 綠色背景
    }).then(() => {
      // 先跳轉到 /employee/emphome
      router.push('/employee/emphome').then(() => {
        // 然後刷新 navbar
        window.location.reload();
      });
    });

  } catch (error) {
    console.error('登出失敗', error);

    // 彈出失敗提示
    Swal.fire({
      icon: 'error',
      title: '登出失敗',
      text: '請稍後再試',
      confirmButtonText: '確定',
      confirmButtonColor: '#28a745', // 綠色背景
    });
  }
};


</script>

<style scoped>
/* 自定義 SweetAlert2 的確認按鈕樣式 */
.swal2-confirm-btn {
  color: white;
  /* 白色文字 */
}

.link-body-emphasis {
  padding: 0.1875rem 0.5rem;
  margin-top: 0.125rem;
  margin-bottom: 0.125rem;
  font-weight: 600;
  color: #fff;
  border-radius: 0.375rem;
}

.link-body-emphasis:hover {
  background-color: LightSlateGray;
}

.link-body-emphasis:focus,
.link-body-emphasis:active {
  background-color: white;
  color: #000;
  border: 2px solid white;
  border-radius: 0.375rem;
  outline: none;
}

.flex-shrink-0 {
  min-height: 100vh;
}

.bg-dark {
  background-color: #343a40 !important;
}
</style>
