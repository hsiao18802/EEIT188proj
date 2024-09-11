import { createApp } from 'vue';
import App from './App.vue';
import router from './router/router.js';
import pinia from './plugins/pinia.js';
import useUserStore from '@/stores/user.js';  // 引入 Pinia 的 store

const app = createApp(App)
  .use(router)
  .use(pinia)

app.directive('default-img', {
  mounted(el, binding) {
    const defaultImg = '/public/NoPic256.jpg'; // 替代圖片路徑
    el.onerror = () => {
      el.src = defaultImg; // 如果圖片加載失敗，則顯示替代圖片
    };
    el.src = binding.value ? 'data:image/jpeg;base64,' + binding.value : defaultImg; // 如果圖片為 null，則顯示替代圖片
  }
});

app.mount('#app');

// 應用啟動後檢查 Pinia 狀態是否從 sessionStorage 恢復
const userStore = useUserStore();
const savedLogin = localStorage.getItem('login');
if (savedLogin !== null) {
  userStore.setLogin(savedLogin === 'true');  // 恢復 login 狀態為 true 或 false
  console.log('Login status manually set to:', savedLogin);
} else {
  console.log('No login status found in sessionStorage');
}

console.log('Token from Pinia after refresh:', userStore.token);
console.log('Login status from Pinia after refresh:', userStore.isLogin);
