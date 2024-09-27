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

    <!-- 聊天組件，全局顯示 -->
    <ChatComponent />
      <!-- 全局頁腳 -->
     <!-- <Footer></Footer> -->
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
import CartDrawer from './components/cart/CartDrawer.vue'
import CartIcon from './components/cart/CartIcon.vue'
import Footer from './components/Footer/Footer.vue';
// 引入聊天組件
import ChatComponent from './views/ChatComponent.vue';


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

.chat-container {
  position: fixed; /* 固定位置 */
  bottom: 20px; /* 距離頁面底部 */
  right: 20px; /* 距離頁面右側 */
  width: 300px; /* 固定寬度 */
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 10px;
  background: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  z-index: 1000; /* 保證在最上層顯示 */
}

.messages {
  max-height: 300px;
  overflow-y: auto;
  margin-bottom: 20px;
}

.user {
  text-align: right;
  color: blue;
}

.bot {
  text-align: left;
  color: green;
}

input {
  width: calc(100% - 60px);
  padding: 10px;
  margin-right: 10px;
}

button {
  padding: 10px;
}
</style>
