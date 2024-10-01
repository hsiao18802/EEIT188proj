import { fileURLToPath, URL } from 'node:url';
import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';

// https://vitejs.dev/config/
export default defineConfig({
  base: '/',  // 設置為根目錄
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  define: {
    global: 'window', // 將 global 定義為 window
  },
  server: {
    port: 3000 // 這裡可以改成你想要的 Port 號
  },
  build: {
    target: ['chrome91', 'firefox89', 'safari15', 'edge91'],  // 設置目標瀏覽器
  },
  esbuild: {
    supported: {
      'top-level-await': true,  // 確保支持 Top-level await
    },
  },
});
