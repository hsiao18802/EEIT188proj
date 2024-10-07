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
       <div :class="['welcome-text', 'animate__animated', animationClass]" @animationend="handleAnimationEnd">
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
        <v-btn color="primary" href="/productpage" large>點擊探索</v-btn>
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
  
 <div class="main-container">
    <ProductSection
      title="豪華露營車盛宴開催中"
      description="親愛的戶外探險愛好者，準備好迎接一場前所未有的盛宴！我們誠摯邀請您參加我們的豪華露營車與越野車盛宴，這將是一個充滿刺激與奢華的週末，讓您體驗到最頂級的露營樂趣與越野冒險！帶上您的家人和朋友，一起來感受大自然的美好，讓我們一起啟程吧！"
      imageSrc="https://instagearoutdoors.com/wp-content/uploads/2024/04/RexRover-43.jpg" 
      buttonText="活動詳情"
      link="/ebike-sales"
    />
    
    <ProductSection
      title="慶祝國慶日，與我們一起轉動幸運之輪！"
      description="在這個充滿喜慶的日子裡，我們特別舉辦 雙十國慶日折扣碼活動，讓您在購物時也能感受到節日的熱情與樂趣！參加我們的轉盤抽獎，贏取各種驚喜折扣碼，讓您的購物更加實惠！"
      imageSrc="https://ethergifts.com.tw/cdn/shop/files/LINE_ALBUM___240814_2_20f465e8-0cf1-43b3-bb6a-60549a5f10da.jpg?v=1723618187&width=2000" 
      buttonText="試試手氣"
      link="/coupon"
    />
  </div>





      <!-- 引入消費者心得組件 -->
      <Testimonials :testimonials="testimonials" />
      <HowTo></HowTo>
      
</template>

<script setup>
import { ref, onMounted } from 'vue';
import Testimonials from './Testimonials.vue'; // 引入消費者心得組件
import ProductSection from '@/components/layout/ProductSection.vue'; 
import HowTo from '@/components/layout/HowTo.vue'; 





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
    text: '這次的租賃體驗非常棒！設備品質高，服務人員Giselle很有耐心~人美心善~老闆要幫她加薪喔!',
    author: 'Debbie Wang',
    avatar: 'https://img2.woyaogexing.com/2018/04/03/3007055ca9c001c8!400x400_big.jpg', // 大頭貼 URL
    rating: 5, // 評分
  },
  {
    id: 2,
    text: '上次參加網站的一起趣露營活動!謝謝讓我們一家人留下美好回憶~裝備超豪華不說,工作人員很會帶氣氛~讓我們露營新手從此愛上!推薦新手來這接受洗禮喔!',
    author: '戴姿穎',
    avatar: 'https://img2.woyaogexing.com/2018/04/03/77035b5251765fba!400x400_big.jpg', // 大頭貼 URL
    rating: 5, // 評分
  },
  {
    id: 3,
    text: '之前租了一個Coleman LDX一房一廳帳,但忘了把營釘給我們,我們急著走也沒檢查,結果到營地才發現裝不起來!很生氣!跟客服聯絡,結果30分鐘內就把營釘送到我們這,超快速!從大安區到陽明山,真的是超有效率!服務我給五星,扣的這一星是這次的疏失,請記得改進!下次還是會到貴店租裝備的!',
    author: '小李',
    avatar: 'https://png.pngtree.com/png-clipart/20210128/ourmid/pngtree-cute-villain-with-surprised-expression-png-image_2829431.jpg', // 大頭貼 URL
    rating: 4, // 評分
  },
];

// 控制動畫
const animationClass = ref('animate__fadeIn'); // 初始為淡入動畫



// 動畫結束後的處理
const handleAnimationEnd = () => {
  // 可以在這裡更新動畫狀態，讓文字保持在上面
  animationClass.value = ''; // 清除動畫類別
}


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

/* 歡迎文字樣式 */
.welcome-text {
  position: absolute;
  top: 50%; /* 垂直置中 */
  left: 50%; /* 水平置中 */
  transform: translate(-50%, -50%); /* 調整位置 */
  color: white; /* 文字顏色 */
  font-size: 35px; /* 文字大小 */
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.6); /* 添加陰影以提高可讀性 */
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

.main-container {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: flex-start;
  background-color: transparent; /* 將底色改為透明 */
  padding: 20px;
}

.product-section {
  flex: 1; /* 使兩個區塊平分寬度 */
  color: black; /* 設定文字顏色為黑色 */
}


</style>
