import { createApp } from 'vue';
import App from './App.vue';
import router from './router/router.js';

import pinia from './plugins/pinia.js'; // 这里已经导入配置好的 Pinia
import useUserStore from '@/stores/user.js';

// Vuetify
import { createVuetify } from 'vuetify';
import 'vuetify/styles';

import { aliases, fa } from 'vuetify/iconsets/fa'; // 或使用其他圖標集
import * as components from 'vuetify/components';
import * as directives from 'vuetify/directives';
import 'vuetify/dist/vuetify.min.css';




// CSS 和 JavaScript 引入
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import '@mdi/font/css/materialdesignicons.css'; // Material Design Icons
import 'element-plus/dist/index.css'; // Element Plus
//Element Plus import ElementPlus from 'element-plus';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';

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








const app = createApp(App)
  .use(router)
  .use(ElementPlus)

  .use(pinia) // 使用配置好的 Pinia 实例
  .use(vuetify)
  .use(vClickOutside);

// 默认图片指令
app.directive('default-img', {
  mounted(el, binding) {

    const defaultImg = '/NoPic256.jpg';
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
