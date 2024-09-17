import { createApp } from 'vue';
import App from './App.vue';
import router from './router/router.js';
import pinia from './plugins/pinia.js'; // 这里已经导入配置好的 Pinia
import useUserStore from '@/stores/user.js';

// Vuetify
import 'vuetify/styles';
import { createVuetify } from 'vuetify';
import * as components from 'vuetify/components';
import * as directives from 'vuetify/directives';
import '@mdi/font/css/materialdesignicons.css'; // Material Design Icons

const vuetify = createVuetify({
  components,
  directives,
});

// Element Plus 
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';

const app = createApp(App)
  .use(router)
  .use(ElementPlus)
  .use(pinia) // 使用配置好的 Pinia 实例
  .use(vuetify);

// 默认图片指令
app.directive('default-img', {
  mounted(el, binding) {
    const defaultImg = '/public/NoPic256.jpg';
    el.onerror = () => {
      el.src = defaultImg;
    };
    el.src = binding.value ? 'data:image/jpeg;base64,' + binding.value : defaultImg;
  }
});

// 挂载应用
app.mount('#app');

// Pinia 自动管理 token 和 login，不再需要手动从 localStorage 获取
const userStore = useUserStore();

// 调试：确认 Pinia 是否正确恢复状态
console.log('Token from Pinia after refresh:', userStore.token);
console.log('Login status from Pinia after refresh:', userStore.isLogin);
