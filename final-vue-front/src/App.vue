<template>
  <div :class="layoutClass">
    <!-- 動態導航列  :style="maxwidth" -->

    <component :is="currentNavbar"></component>

    <CartDrawer></CartDrawer>

   <!-- 根據路由判斷是否顯示購物車圖標 -->
   <CartIcon v-if="!isCartPage" />

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
//hsiao
import CartDrawer from './components/cart/CartDrawer.vue'
import CartIcon from './components/cart/CartIcon.vue'



const route = useRoute();
const userStore = useUserStore();

// 檢查當前的導航列是否為 EmpNavbar
const isEmpNavbar = computed(() => {
  return route.meta.navbar === 'EmpNavbar';
});

// 根據導航列決定佈局類別：EmpNavbar 時左右佈局，PublicNavbar 時上下佈局
const layoutClass = computed(() => {

  return isEmpNavbar.value ? 'container-fluid d-flex flex-row' : 'container-xxl d-flex flex-column';
});

onMounted(() => {
  console.log('Token from Pinia after refresh:', userStore.token);
  console.log('Login status from Pinia after refresh:', userStore.login);
});

// 動態設置當前導航列
const currentNavbar = computed(() => {
  return isEmpNavbar.value ? EmpNavbar : PublicNavbar;
});

// 檢查當前路由是否為購物車頁面
const isCartPage = computed(() => {
  return route.path === '/pages/Cart'; // 假設購物車的路由是 '/pages/Cart'
});



</script>

<style scoped>
#app {

height: 100vh;

}
</style>
