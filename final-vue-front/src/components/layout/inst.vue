<template>
    <div class="instagram-section">
      <h2>來Instagram追蹤我們唷!</h2>
      <div class="instagram-grid">
        <div v-for="post in instagramPosts" :key="post.id" class="instagram-post">
          <img :src="post.media_url" alt="Instagram Post" />
          <div class="post-overlay">
            <div class="post-content">
              <p>{{ post.caption }}</p> <!-- 貼文內容 -->
            </div>
            <i class="fab fa-instagram icon instagram-icon"></i> <!-- Instagram Logo -->
            <i class="fas fa-heart icon heart-icon"></i> <!-- 愛心圖標 -->
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import '@fortawesome/fontawesome-free/css/all.css'; // 引入 FontAwesome CSS
  
  const instagramPosts = ref([]);
  
  // 使用假資料來填充 Instagram 帳號的媒體內容
  onMounted(() => {
    instagramPosts.value = [
      {
        id: 1,
        media_url: '/public/i1.jpg',
        caption: '想念北海道的海邊與夕陽....'
      },
      {
        id: 2,
        media_url: '/public/i2.jpg',
        caption: '真的有外星人嗎?金字塔好高啊!!!...'
      },
      {
        id: 3,
        media_url: '/public/i3.jpg',
        caption: '謝謝趣露營教練帶我們去潛水~那天天氣超好的!好愛!'
      },
      {
        id: 4,
        media_url: '/public/i4.jpg',
        caption: '謝謝趣露營辦的滑雪行程!超好玩的!我滑到腿痠了!'
      },
      {
        id: 5,
        media_url: '/public/i55.jpg',
        caption: '台灣也可以划水喔!!還有裝備提供....'
      }
    ];
  });
  </script>
  
  <style>
  .instagram-section {
    margin-bottom: 50px; /* 與 footer 保持距離 */
  }
  
  .instagram-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
    gap: 20px;
  }
  
  .instagram-post {
    position: relative;
    overflow: hidden;
  }
  
  .instagram-post img {
    width: 100%;
    height: auto;
    object-fit: cover;
    transition: transform 0.3s ease; /* 滑鼠懸停時的放大效果 */
  }
  
  .instagram-post:hover img {
    transform: scale(1.1); /* 放大圖片 */
  }
  
  .post-overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5); /* 半透明黑色背景 */
    display: flex;
    flex-direction: column;
    justify-content: flex-end; /* 讓內容對齊到底部 */
    align-items: center;
    color: white;
    opacity: 0;
    transition: opacity 0.3s ease;
  }
  
  .instagram-post:hover .post-overlay {
    opacity: 1; /* 懸停時顯示覆蓋層 */
  }
  
  .post-content {
    margin-bottom: 40px; /* 調整貼文內容位置 */
  }
  
  .icon {
    font-size: 30px;
    position: absolute;
    color: white;
    opacity: 0;
    transition: opacity 0.3s ease;
  }
  
  .instagram-icon {
    top: 10px; /* 右上角 */
    right: 10px;
  }
  
  .heart-icon {
    bottom: 10px; /* 右下角 */
    right: 10px;
  }
  
  .instagram-post:hover .icon {
    opacity: 1; /* 懸停時顯示圖標 */
  }
  </style>
  