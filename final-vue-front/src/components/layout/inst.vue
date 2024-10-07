<template>
    <div class="instagram-section">
      <h2>Follow Us On Instagram!</h2>
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
        media_url: 'https://scontent.cdninstagram.com/v/t51.29350-15/447843429_993081762283004_7856535013924751952_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=18de74&_nc_ohc=vBEugAeut34Q7kNvgHhnRYC&_nc_ht=scontent.cdninstagram.com&edm=AM6HXa8EAAAA&_nc_gid=Accg6nsA-G6cYyyKssnjQsx&oh=00_AYBxPI7yqOovXLQspsM0xJVLNaZn9c4socny0gySf0dPQA&oe=67089664',
        caption: '越野車比賽好刺激!那天天氣超好...'
      },
      {
        id: 2,
        media_url: 'https://scontent.cdninstagram.com/v/t51.29350-15/445550962_1171127580703623_8114276794702001926_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=18de74&_nc_ohc=ztB0zV6tcPEQ7kNvgEW-_dS&_nc_ht=scontent.cdninstagram.com&edm=AM6HXa8EAAAA&_nc_gid=Accg6nsA-G6cYyyKssnjQsx&oh=00_AYBzMN5SW1lrfRCLJIVhD1RAUsbR4GfSHIAV8jikd-nG6g&oe=67089842',
        caption: '泛舟超好玩的雖然很冷.....'
      },
      {
        id: 3,
        media_url: 'https://scontent.cdninstagram.com/v/t51.29350-15/445418207_1742030389931040_2412169838932498547_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=18de74&_nc_ohc=H0h1-G6gjnYQ7kNvgHlTHjX&_nc_ht=scontent.cdninstagram.com&edm=AM6HXa8EAAAA&_nc_gid=AGk6hBhJSf5i1By7SgVrhfc&oh=00_AYCZrjwJSyTgaQMhPgYIEqK5yCqPMvvciaa60cGKH-Y6Ug&oe=6709523A',
        caption: '我跟我媽一起租腳踏!我媽體力比我好....'
      },
      {
        id: 4,
        media_url: 'https://scontent.cdninstagram.com/v/t51.29350-15/449757210_3956269338031400_7085097138128283998_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=18de74&_nc_ohc=xU322CAfXP4Q7kNvgF1Oz_5&_nc_ht=scontent.cdninstagram.com&edm=AM6HXa8EAAAA&_nc_gid=AGk6hBhJSf5i1By7SgVrhfc&oh=00_AYBWKKznHcAwILndwDBUTUuCpuVn06fSTy13xjtN64if5A&oe=67094CDE',
        caption: '去美國比賽我很緊張......'
      },
      {
        id: 5,
        media_url: 'https://scontent.cdninstagram.com/v/t51.29350-15/446100056_3822401937980275_2356870262720441223_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=18de74&_nc_ohc=chnxrPpWK1YQ7kNvgHAdCDQ&_nc_ht=scontent.cdninstagram.com&edm=AM6HXa8EAAAA&_nc_gid=AGk6hBhJSf5i1By7SgVrhfc&oh=00_AYBpVCSmGiqjLCgdIt0b2PPALqkxk1sIMXCi9FUNshmNPw&oe=67097796',
        caption: '大家快來!臨時快閃攤位~~唷'
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
  