// 1. 和第二段完全相同的部分：
import { createApp } from 'vue';
import App from './App.vue';
import router from './router/router.js';






const app = createApp(App)
  .use(router)


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



let vuetifyLoaded = false; // **新增這一行以追踪 Vuetify 是否已加載**




// 動態導入其他資源
await import('bootstrap/dist/css/bootstrap.min.css'); // 引入 Bootstrap CSS
await import('bootstrap/dist/js/bootstrap.bundle.min.js'); // 引入 Bootstrap JS




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