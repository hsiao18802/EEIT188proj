<template>
  <div class="homepage">
    <!-- 背景圖片區塊 -->
    <div class="background-container">
      <img
        decoding="async"
        width="1300"
        height="500"
        src="https://instagearoutdoors.com/wp-content/uploads/2022/02/shutterstock_565451494-scaled.jpg"
        alt="背景圖片"
        class="background-img"
      />
      <!-- 歡迎文字，帶有 Animate.css 特效 -->
      <div :class="['welcome-text', 'animate__animated', animationClass]">
        打開世界之窗 展開新冒險
      </div>
    </div>

    <!-- 介紹區塊 -->
    <div class="elementor-widget-container">
      <h3 class="section-title">Gear Rental</h3>
      <p class="section-description">
        透過頂級戶外租賃來提升您的下一次冒險體驗。我們有電動自行車、背包裝備、露營裝備、戶外遊戲、活動用品等等！在下面預訂裝備！
      </p>
    </div>

    <!-- 預訂按鈕 -->
    <v-row class="mt-4">
      <v-col class="text-center">
        <v-btn color="primary" href="/rentals" large>Rent Gear Here</v-btn>
      </v-col>
    </v-row>

    <br />



    <!-- 圖片輪播 -->
    <el-carousel :interval="5000" arrow="always">
      <el-carousel-item v-for="item in images" :key="item.id">
        <div class="carousel-item-container">
          <img
            :src="`/carousel/${item.fileName}`"
            :alt="item.alt"
            class="carousel-img"
          />
          <div class="carousel-text">
            <h3>{{ item.description }}</h3>
          </div>
        </div>
      </el-carousel-item>
    </el-carousel>

    <br />
  </div>

      <!-- 引入消費者心得組件 -->
      <Testimonials :testimonials="testimonials" />
</template>

<script setup>
import { ref, onMounted } from 'vue';
import Testimonials from './Testimonials.vue'; // 引入消費者心得組件

// 輪播圖片
const images = [
  { id: 1, fileName: '01.jpg', alt: 'Image 1', description: '享受人生' },
  { id: 2, fileName: '02.jpg', alt: 'Image 2', description: '要什麼來什麼' },
  { id: 3, fileName: '03.jpg', alt: 'Image 3', description: '冒險' },
  { id: 4, fileName: '04.jpg', alt: 'Image 4', description: '露營新手友善' },
];

// 消費者心得範例資料
const testimonials = [
  {
    id: 1,
    text: '這次的租賃體驗非常棒！設備品質高，服務人員友善！',
    author: '小明',
    avatar: 'https://img2.woyaogexing.com/2018/04/03/3007055ca9c001c8!400x400_big.jpg', // 大頭貼 URL
    rating: 5, // 評分
  },
  {
    id: 2,
    text: '租了露營裝備，回來後每個人都很滿意，會推薦給朋友！',
    author: '小華',
    avatar: 'https://img2.woyaogexing.com/2018/04/03/77035b5251765fba!400x400_big.jpg', // 大頭貼 URL
    rating: 4, // 評分
  },
  {
    id: 3,
    text: '超方便的租賃平台，下次一定再來！',
    author: '小李',
    avatar: 'https://png.pngtree.com/png-clipart/20210128/ourmid/pngtree-cute-villain-with-surprised-expression-png-image_2829431.jpg', // 大頭貼 URL
    rating: 5, // 評分
  },
];

// 控制動畫
const animationClass = ref('animate__fadeIn'); // 初始為淡入動畫

onMounted(() => {
  setTimeout(() => {
    animationClass.value = 'animate__fadeOutDown'; // 2 秒後觸發淡出動畫
  }, 2000);
});
</script>

<style scoped>
/* 從 CDN 引入 Animate.css */
@import url("https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css");

/* 背景圖片樣式 */
.background-container {
  position: relative;
  width: 100%;
  height: 500px;
  overflow: hidden;
}

.background-img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

/* 歡迎文字 */
.welcome-text {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  font-size: 3rem;
  color: white;
  text-align: center;
  z-index: 10;
}

/* 介紹文字樣式 */
.section-title {
  font-size: 2rem;
  font-weight: bold;
  text-align: center;
  margin-top: 1.5rem;
}

.section-description {
  text-align: center;
  font-size: 1.2rem;
  margin-top: 1rem;
}

/* 輪播圖片樣式 */
.carousel-item-container {
  position: relative;
}

.carousel-img {
  width: 100%;
  height: 300px;
  object-fit: cover;
}

.carousel-text {
  position: absolute;
  bottom: 10px;
  left: 50%;
  transform: translateX(-50%);
  color: white;
  font-size: 1.5rem;
  background-color: rgba(0, 0, 0, 0.5);
  padding: 5px 10px;
  border-radius: 5px;
  text-align: center;
}
</style>
