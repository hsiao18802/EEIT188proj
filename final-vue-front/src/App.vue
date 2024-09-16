<template>
  <div :class="[layoutClass, navbarClass]">
    <!-- 動態導航列 -->
    <component :is="currentNavbar"></component>

    <!-- 右側內容區 -->
    <div class="flex-grow-1 p-3">
      <router-view></router-view>
    </div>
  </div>
</template>

<script setup>
import useUserStore from './stores/user';
import { onMounted, computed } from 'vue';
import { useRoute } from 'vue-router';
import 'bootstrap/dist/css/bootstrap.min.css';  // 靜態引入合併的 Bootstrap

import EmpNavbar from './views/product_and_emp/EmpNavbar.vue';
import PublicNavbar from './views/Navbar.vue';

const route = useRoute();
const userStore = useUserStore();

// 檢查當前的導航列是否為 EmpNavbar
const isEmpNavbar = computed(() => route.meta.navbar === 'EmpNavbar');

// 動態設置當前導航列
const currentNavbar = computed(() => isEmpNavbar.value ? EmpNavbar : PublicNavbar);

// 根據導航列決定佈局類別：EmpNavbar 時左右佈局，PublicNavbar 時上下佈局
const layoutClass = computed(() => isEmpNavbar.value ? 'd-flex flex-row' : 'd-flex flex-column');

// 根據導航列動態套用 .emp-navbar 類或 .public-navbar 類
const navbarClass = computed(() => isEmpNavbar.value ? 'emp-navbar' : 'public-navbar');

onMounted(() => {
  const token = localStorage.getItem('token');
  if (token) {
    userStore.setToken(token);
    userStore.setLogin(true);
    console.log('Login state restored');
  } else {
    console.log('No token found in sessionStorage');
  }
});
</script>

<style scoped>
#app {
  height: 100vh; /* 保持全屏高度 */
}
</style>
