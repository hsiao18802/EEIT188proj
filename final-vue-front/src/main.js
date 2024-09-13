import { createApp } from 'vue';
import App from './App.vue';
import router from './router/router.js';
import pinia from './plugins/pinia.js';
import useUserStore from '@/stores/user.js';



// Vuetify
import 'vuetify/styles';
import { createVuetify } from 'vuetify';
import * as components from 'vuetify/components';
import * as directives from 'vuetify/directives';

// CSS 重置或其他樣式 (如果需要)
import 'vuetify/styles';
import '@mdi/font/css/materialdesignicons.css'; // Material Design Icons

const vuetify = createVuetify({
  components,
  directives,
});

//Element Plus 
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';







import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'


pinia.use(piniaPluginPersistedstate)


const app = createApp(App)
  .use(router)
  .use(ElementPlus)
  .use(pinia)
  .use(vuetify)

app.directive('default-img', {
  mounted(el, binding) {
    const defaultImg = '/public/NoPic256.jpg';
    el.onerror = () => {
      el.src = defaultImg;
    };
    el.src = binding.value ? 'data:image/jpeg;base64,' + binding.value : defaultImg;
  }
});

app.mount('#app');


const userStore = useUserStore();
const savedLogin = localStorage.getItem('login');
if (savedLogin !== null) {
  userStore.setLogin(savedLogin === 'true');
  console.log('Login status manually set to:', savedLogin);
} else {
  console.log('No login status found in sessionStorage');
}

console.log('Token from Pinia after refresh:', userStore.token);
console.log('Login status from Pinia after refresh:', userStore.isLogin);
