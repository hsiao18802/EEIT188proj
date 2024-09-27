<template>
    <div>
      <!-- 聯繫我們內容 -->
      <div class="contact-container">
        <h1>聯繫我們</h1>
        <div class="contact-content">
          <p>感謝您使用我們的服務！如果您有任何問題或建議，請透過以下方式聯繫我們：</p>
          <div class="contact-info">
            <h2>LINE 官方帳號</h2>
            <div class="line-info">
              <!-- 引用 public 資料夾中的圖片 -->
              <img src="/lineqrcode.png" alt="LINE 官方帳號 QR Code" class="qr-code" />
              <p>line id:@505llfle</p>
              <p>掃描上方的 QR Code 加入我們的 LINE 官方帳號，獲取更多資訊！</p>
            </div>
            <!-- 額外聯繫方式 -->
            <div class="additional-contact">
              <h2>其他聯繫方式</h2>
              <p>電子郵件：kk111@gmail.com</p>
              <p>電話：+886 888 8888</p>
            </div>
          </div>
        </div>
      </div>
  
      
   
    </div>
  </template>
  
  <script>
  
  
  export default {

    data() {
      return {
        // 因為使用 public 資料夾，不需要在 data 中進行圖片導入
      };
    }
  };
  </script>
  
  <style scoped>
  .contact-container {
    max-width: 800px;
    margin: 50px auto;
    padding: 30px 20px; /* 增加 padding 讓空間更加寬鬆 */
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
    text-align: center;
  }
  
  .contact-content {
    margin-top: 20px;
  }
  
  .contact-info {
    margin-top: 30px;
  }
  
  .line-info {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  
  .qr-code {
    width: 200px;
    height: 200px;
    margin: 20px 0;
    border-radius: 10px; /* 給 QR Code 添加一些圓角效果 */
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2); /* 添加陰影讓它更加突出 */
  }
  
  .additional-contact {
    margin-top: 30px; /* 增加額外聯繫方式與上方內容的間距 */
  }
  
  h1 {
    color: #007bff;
    font-size: 28px; /* 增大標題字體大小 */
    font-weight: bold; /* 讓標題字體更加突出 */
    margin-bottom: 20px; /* 增加標題與其他內容之間的距離 */
  }
  
  h2 {
    color: #333;
    font-size: 22px;
    margin-bottom: 10px; /* 增加副標題與其他內容之間的距離 */
  }
  
  p {
    color: #666;
    font-size: 16px;
    line-height: 1.5; /* 增加行距讓文本更加易讀 */
    margin-bottom: 15px; /* 增加段落間的距離 */
  }
  </style>
  