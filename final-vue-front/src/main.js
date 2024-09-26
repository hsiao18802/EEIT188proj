// 1. 和第二段完全相同的部分：
import { createApp } from 'vue';
import App from './App.vue';
import router from './router/router.js';
import pinia from './plugins/pinia.js';
import useUserStore from '@/stores/user.js';

import piniaPluginPersistedstate from 'pinia-plugin-persistedstate';

pinia.use(piniaPluginPersistedstate);

const app = createApp(App)
  .use(router)
  .use(pinia);

// app.directive('default-img', {
//   mounted(el, binding) {
//     const defaultImg = '/public/NoPic256.jpg';
//     el.onerror = () => {
//       el.src = defaultImg;
//     };
//     el.src = binding.value ? 'data:image/jpeg;base64,' + binding.value : defaultImg;
//   }
// });

app.directive('default-img', {
  mounted(el, binding) {
    // 如果圖片 src 加載失敗時觸發 onerror，將 src 設為一個無效值
    el.onerror = () => {
      el.src = ''; // 設為空字符串，觸發瀏覽器的內建「圖片讀取失敗」顯示
    };

    // 綁定值存在，則設置圖片 src，否則不做任何處理
    if (binding.value) {
      el.src = 'data:image/jpeg;base64,' + binding.value;
    }
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

let vuetifyLoaded = false; // **新增這一行以追踪 Vuetify 是否已加載**


// 動態載入和移除資源
router.beforeEach(async (to, from, next) => {
  if (to.meta.style !== 'default'&& !vuetifyLoaded) { // **這裡加上條件檢查**
    // 動態導入 Vuetify
    const { createVuetify } = await import('vuetify');
    const { aliases, fa } = await import('vuetify/iconsets/fa');
    const components = await import('vuetify/components');
    const directives = await import('vuetify/directives');
    await import('vuetify/dist/vuetify.min.css');
    await import('vuetify/styles');

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
            warning: '#FFC107',
          },
        },
      },
      icons: {
        defaultSet: 'fa', // 使用 Font Awesome 圖標集
        aliases,
        sets: {
          fa,
        },
      },
    });

    app.use(vuetify); // 使用 Vuetify
    vuetifyLoaded = true; // **新增這一行以標記 Vuetify 已加載**


    // 動態導入其他資源
    await import('bootstrap/dist/css/bootstrap.min.css'); // 引入 Bootstrap CSS
    await import('bootstrap/dist/js/bootstrap.bundle.min.js'); // 引入 Bootstrap JS
    await import('@mdi/font/css/materialdesignicons.css'); // 引入 Material Design Icons
    await import('element-plus/dist/index.css'); // 引入 Element Plus 的 CSS
    const ElementPlus = (await import('element-plus')).default;
    app.use(ElementPlus); // 使用 Element Plus

    // 動態導入 v-click-outside 插件
    const vClickOutside = (await import('v-click-outside')).default;
    app.use(vClickOutside); // 使用 v-click-outside 插件
  }

  next();
});

// beforeEach 邏輯負責正常導航
//outer.beforeEach((to, from, next) => {
 // next(); // 正常進行導航
//});

// afterEach 邏輯來處理重整
router.afterEach((to, from) => {
  if (to.meta.style === 'default' && from.meta.style !== 'default') {
    // 檢查 sessionStorage 中是否已標記重整
    const hasReloaded = sessionStorage.getItem('hasReloaded');

    if (!hasReloaded) {
      // 標記已經重整過，避免無限重整
      sessionStorage.setItem('hasReloaded', 'true');
      window.location.reload(); // 強制重新加載頁面
    }
  } else if (to.meta.style !== 'default') {
    // 如果進入的是非 default 的頁面，清除重整標記
    sessionStorage.removeItem('hasReloaded');
  }
});