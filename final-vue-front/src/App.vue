<template>
  <div :class="layoutClass">
    <!-- 動態導航列 -->
    <component :is="currentNavbar"></component>

    <!-- 右側內容區 -->
    <div v-if="isEmpNavbar" class="flex-grow-1 p-3">
      <router-view></router-view>
    </div>
    <div v-else>
      <router-view></router-view>
    </div>
  </div>
</template>

<script setup>
import useUserStore from './stores/user'; // 引入 Pinia 的 store
import { computed, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import EmpNavbar from './views/product_and_emp/EmpNavbar.vue';
import PublicNavbar from './views/Navbar.vue';

const route = useRoute();
const userStore = useUserStore();

// 檢查當前的導航列是否為 EmpNavbar
const isEmpNavbar = computed(() => {
  return route.meta.navbar === 'EmpNavbar';
});

// 根據導航列決定佈局類別：EmpNavbar 時左右佈局，PublicNavbar 時上下佈局
const layoutClass = computed(() => {
  return isEmpNavbar.value ? 'd-flex flex-row' : 'd-flex flex-column';
});

// 確認 Pinia 是否恢復了 token 和 login 狀態，這裡只是用來 debug
onMounted(() => {
  console.log('Token from Pinia after refresh:', userStore.token);
  console.log('Login status from Pinia after refresh:', userStore.login);
});

// 動態設置當前導航列
const currentNavbar = computed(() => {
  return isEmpNavbar.value ? EmpNavbar : PublicNavbar;
});
</script>

<style scoped>
#app {
  height: 100vh; /* 保持全屏高度 */
}

.flex-grow-1 {
  margin-left: 0; /* 恢復預設的佈局，移除左側邊欄的間距 */
}
</style>
