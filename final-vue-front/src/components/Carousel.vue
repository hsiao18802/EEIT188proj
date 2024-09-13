
<template>



<div class="elementor-column elementor-col-50">
  <div class="elementor-widget-wrap">
    <div class="elementor-widget-image-box">
      <div class="elementor-widget-container">
        <div class="elementor-image-box-wrapper">
          <figure class="elementor-image-box-img">
            <img 
              decoding="async"
              width="1300"
              height="500"
              src="https://instagearoutdoors.com/wp-content/uploads/2022/02/shutterstock_565451494-scaled.jpg"
              alt=""
            />
          </figure>
          <div class="elementor-image-box-content">
            <h3>Gear Rental</h3>
            <p>
              透過頂級戶外租賃來提升您的下一次冒險體驗。我們有電動自行車、背包裝備、露營裝備、戶外遊戲、活動用品等等！在下面預訂裝備！
            </p>
          </div>
        </div>
      </div>
    </div>
    <!-- 按鈕 -->
    <v-row class="mt-4">
      <v-col class="text-center">
        <v-btn color="primary" href="/rentals" large>
          Rent Gear Here
        </v-btn>
      </v-col>
    </v-row>
  </div>
</div>

<br>












  <el-carousel :interval="5000" arrow="always">
    <el-carousel-item v-for="item in images" :key="item.id">
      <div class="carousel-item-container">
          <img :src="`/carousel/${item.fileName}`" :alt="item.alt" class="carousel-img" />
          <div class="carousel-text">
         
            <h3>{{ item.description }}</h3>
          </div>
        </div>
    </el-carousel-item>
  </el-carousel>



<br>
<br>
<br>
<br>

  </template>
  
  <script setup>
  const images = [
    { id: 1, fileName: '01.jpg', alt: 'Image 1', description: '享受人生' },
    { id: 2, fileName: '02.jpg', alt: 'Image 2', description: '要什麼來什麼' },
    { id: 3, fileName: '03.jpg', alt: 'Image 3',  description: '冒險' },
    { id: 4, fileName: '04.jpg', alt: 'Image 4',  description: '露營新手友善' }
  ];
  </script>

<style scoped>
.carousel-item-container {
  position: relative; /* 使容器具有定位能力 */
}

.carousel-img {
  width: 100%;
  height: 300px;
  object-fit: cover;
}

.carousel-text h3 {
  margin: 0;
  font-size: 1rem;
}

.carousel-text p {
  margin: 5px 0 0;
  font-size: 1rem;
}

.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>