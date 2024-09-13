import { createApp } from 'vue';
import App from './App.vue';
import router from './router/router.js';
import pinia from './plugins/pinia.js';
import useUserStore from '@/stores/user.js';  // �ޤJ Pinia �� store



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
    const defaultImg = '/public/NoPic256.jpg'; // ���N�Ϥ����|
    el.onerror = () => {
      el.src = defaultImg; // �p�G�Ϥ��[�����ѡA�h��ܴ��N�Ϥ�
    };
    el.src = binding.value ? 'data:image/jpeg;base64,' + binding.value : defaultImg; // �p�G�Ϥ��� null�A�h��ܴ��N�Ϥ�
  }
});

app.mount('#app');

// ���αҰʫ��ˬd Pinia ���A�O�_�q sessionStorage ��_
const userStore = useUserStore();
const savedLogin = localStorage.getItem('login');
if (savedLogin !== null) {
  userStore.setLogin(savedLogin === 'true');  // ��_ login ���A�� true �� false
  console.log('Login status manually set to:', savedLogin);
} else {
  console.log('No login status found in sessionStorage');
}

console.log('Token from Pinia after refresh:', userStore.token);
console.log('Login status from Pinia after refresh:', userStore.isLogin);
