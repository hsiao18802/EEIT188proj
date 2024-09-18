import { createApp } from 'vue';
import App from './App.vue';
import router from './router/router.js';
import pinia from './plugins/pinia.js';
import useUserStore from '@/stores/user.js';

// Vuetify
import { createVuetify } from 'vuetify';
import 'vuetify/styles';
import { aliases, fa } from 'vuetify/iconsets/fa'; // 或使用其他圖標集
import * as components from 'vuetify/components';
import * as directives from 'vuetify/directives';



import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

// CSS 和 JavaScript 引入
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import '@mdi/font/css/materialdesignicons.css'; // Material Design Icons
import 'element-plus/dist/index.css'; // Element Plus
//Element Plus 
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'
// v-click-outside
import vClickOutside from 'v-click-outside';


const vuetify = createVuetify({
  components,
  directives,
  theme: {
    themes: {
      light: {
        // 自訂主題顏色
        primary: '#1976D2',
        secondary: '#424242',
        accent: '#82B1FF',
        error: '#FF5252',
        info: '#2196F3',
        success: '#4CAF50',
        warning: '#FFC107'
      }
    }
  },
  icons: {
    defaultSet: 'fa', // 使用 Font Awesome 圖標集
    aliases,
    sets: {
      fa
    }
  }
});






pinia.use(piniaPluginPersistedstate)


const app = createApp(App)
  .use(router)
  .use(ElementPlus)
  .use(pinia)
  .use(vuetify)
  .use(vClickOutside);

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
