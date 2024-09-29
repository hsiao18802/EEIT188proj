<template>
  <div id="app" class="app-container">
    <!-- 動態導航列 -->
    <component :is="currentNavbar"></component>

    <CartDrawer></CartDrawer>
    <CartIcon v-if="!isCartPage" />

    <!-- 主內容區域，包裹住 router-view -->
    <div class="content">
      <router-view></router-view>
    </div>


    <ChatComponent></ChatComponent>
    <!-- 全局頁腳 -->
    <Footer></Footer>
  </div>
</template>

<script setup>
import useUserStore from './stores/user';
import { computed, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import EmpNavbar from './views/product_and_emp/EmpNavbar.vue';
import PublicNavbar from './views/Navbar.vue';
import CartDrawer from './components/cart/CartDrawer.vue'
import CartIcon from './components/cart/CartIcon.vue'
import Footer from './components/Footer/Footer.vue';
import ChatComponent from './views/ChatComponent.vue';

const route = useRoute();
const userStore = useUserStore();
const isEmpNavbar = computed(() => route.meta.navbar === 'EmpNavbar');
const layoutClass = computed(() => isEmpNavbar.value ? 'container-fluid d-flex flex-row' : 'container-xxl d-flex flex-column');
onMounted(() => {
  console.log('Token from Pinia after refresh:', userStore.token);
  console.log('Login status from Pinia after refresh:', userStore.login);
});
const currentNavbar = computed(() => isEmpNavbar.value ? EmpNavbar : PublicNavbar);
const isCartPage = computed(() => route.path === '/pages/Cart');
</script>

<style scoped>
/* 根容器確保最小高度覆蓋整個視窗 */
.app-container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

/* 內容區域填充剩餘空間，將 footer 推至底部 */
.content {
  flex-grow: 1;
}

/* footer 正常顯示在底部，當內容不足時也在頁面底部 */
footer {
  background-color: #333;
  color: #fff;
  padding: 20px;
  text-align: center;
  width: 100%;
  position: relative;
}

.chat-container {
  position: fixed;
  bottom: 20px;
  right: 20px;
  width: 300px;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 10px;
  background: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  z-index: 1000;
}
</style>
