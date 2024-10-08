<template>
    <div class="rentals-work">
      <h2 class="section-title">如何租借</h2>
      <div class="instructions">
        <div class="instruction">
          <h3>1. 預約裝備</h3>
          <p>可以在線或通過電話預約。</p>
          <v-btn color="green" @click="reserveOnline">在線預約</v-btn>
          <v-btn color="blue" @click="callUs">撥打 208-206-9011</v-btn>
        </div>
        <div class="instruction">
          <h3>2. 裝備交付/取件</h3>
          <p>裝備可以在我們的位置取件或送到您的住處。</p>
          <p>要安排送貨，請致電 208-206-9011。租用裝備的送貨服務基於先到先得的原則。</p>
        </div>
        <div class="instruction">
          <h3>3. 裝備歸還</h3>
          <p>所有租用的裝備租期為 24 小時。裝備必須在此期間內歸還，否則會收取額外租金。</p>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  const reserveOnline = () => {
    // 實現在線預約的邏輯
    console.log('在線預約按鈕被點擊');
  };
  
  const callUs = () => {
    // 實現撥打電話的邏輯
    window.location.href = "tel:208-206-9011";
  };
  </script>
  
  <style scoped>



.rentals-work {
    position: relative; /* 確保偽元素相對於此元素定位 */
    display: flex;
    align-items: flex-start;
    padding: 2rem;
    border-radius: 8px;
    max-width: 2000px; /* 增加最大寬度 */
    margin: 0 auto; /* 自動邊距使其居中 */
    flex-direction: row; /* 設置為橫向排列 */
    overflow: hidden; /* 隱藏超出範圍的內容 */
    margin-bottom: 2rem; /* 設定底部邊距，增加與FOOTER的距離 */
}

.rentals-work::before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-image: url('https://cdn.pixabay.com/photo/2021/10/09/00/15/landscape-6692712_1280.jpg');
    background-repeat: no-repeat;
    background-position: center;
    background-size: 200% 100%; /* 設置圖片寬度為 200%，高度為 100% */
    opacity: 0.2;
    z-index: 0;
}


.rentals-work > * { /* 確保文字層在偽元素之上 */
    position: relative; /* 使子元素相對於此元素定位 */
    z-index: 1; /* 置於上層 */
    color: #000; /* 調整文字顏色 */
}

  
  .section-title {
    font-size: 2.5rem; /* 增加字體大小 */
    margin-right: 2rem;
    flex: 0 0 30%; /* 使標題區域佔用 30% 寬度 */
    text-align: left; /* 左對齊 */
  }
  
  .instructions {
    display: flex;
    flex-direction: column;
    flex: 1; /* 使指令區域佔用剩餘空間 */
  }
  
  .instruction {
    margin: 1rem 0;
    text-align: left;
  }
  
  .instruction h3 {
    font-size: 1.75rem; /* 增加子標題字體大小 */
    margin-bottom: 0.5rem;
  }
  
  .v-btn {
    margin: 0.5rem 0; /* 上下間距 */
    margin-right: 1rem; /* 增加右側邊距，讓兩個按鈕之間有間隔 */
    padding: 0.75rem 1.5rem; /* 調整內部邊距 */
    border-radius: 5px; /* 圓角 */
    font-size: 1rem; /* 調整字型大小 */
    transition: background-color 0.3s; /* 背景顏色過渡效果 */
}

.v-btn:hover {
    filter: brightness(85%); /* 懸停時變亮效果 */
}

  
  </style>
  