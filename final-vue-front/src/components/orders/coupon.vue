<template>
  <div class="wheel-container">
    <div class="wheel" :style="{ transform: `rotate(${rotationAngle}deg)` }">
      <div v-for="(prize, index) in prizes" :key="index" class="segment" :style="{ transform: `rotate(${index * segmentAngle}deg)` }">
        <span class="prize-label">{{ prize.label }}</span>
      </div>
    </div>
    <div class="pointer"></div>
    <button @click="spinWheel" :disabled="isSpinning">Spin the Wheel</button>
    <p v-if="selectedCoupon" class="coupon-message">
      恭喜!你抽到的優惠碼是:
      <span class="coupon-code">{{ selectedCoupon }}</span>
    </p>
    <button v-if="selectedCoupon" class="copy-button" @click="copyCoupon">複製優惠碼</button>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const rotationAngle = ref(0)
const isSpinning = ref(false)

// 獎品內容及其對應的優惠碼
const prizes = [
  { label: '超特價✨✨✨✨✨', coupon: 'COUPON50' },
  { label: '超划算✨✨✨✨', coupon: 'COUPON40' },
  { label: '不騙你✨✨✨✨✨', coupon: 'COUPON30' },
  { label: '神秘大獎✨✨✨✨', coupon: '下次再來' },
  { label: '跳樓拍賣✨✨✨✨', coupon: 'COUPON50' },
  { label: '超值得✨✨✨✨✨', coupon: 'COUPON40' },
  { label: '超好玩✨✨✨✨✨', coupon: 'COUPON30' },
  { label: '猜猜看✨✨✨✨✨✨', coupon: 'COUPON123' }
]

const selectedCoupon = ref(null)

const totalSegments = prizes.length
const segmentAngle = 360 / totalSegments

const spinWheel = () => {
  if (isSpinning.value) return

  isSpinning.value = true
  const randomIndex = Math.floor(Math.random() * totalSegments)
  const randomAngle = 360 * 5 + randomIndex * segmentAngle + (Math.random() * segmentAngle)

  rotationAngle.value = randomAngle

  setTimeout(() => {
    const actualIndex = Math.floor((randomAngle % 360) / segmentAngle) % totalSegments; // 計算實際中獎的索引
    selectedCoupon.value = prizes[actualIndex].coupon; // 顯示對應的優惠碼
    isSpinning.value = false
  }, 4000) // 延遲以便動畫結束
}

// 複製優惠碼
const copyCoupon = () => {
  navigator.clipboard.writeText(selectedCoupon.value).then(() => {
    alert('優惠碼已複製！');
  }).catch(err => {
    console.error('複製失敗:', err);
  });
}
</script>

<style scoped>
.wheel-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 50px;
  position: relative;
  background-color: #f0f8ff; /* 明亮的背景色 */
  padding: 20px;
  border-radius: 15px; /* 圓潤的邊角 */
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1); /* 添加陰影 */
}

.wheel {
  width: 450px; 
  height: 450px; 
  border-radius: 50%;
  border: 10px solid #ff6347; /* 明亮的邊框顏色 */
  position: relative;
  overflow: hidden;
  transition: transform 4s ease-out;
}

.segment {
  position: absolute;
  width: 50%;
  height: 50%;
  background: linear-gradient(135deg, #ffcc00, #ff6699); /* 漸變色 */
  border: 2px solid #fff;
  clip-path: polygon(100% 100%, 0 100%, 0 0);
  transform-origin: 100% 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /* 增加陰影效果 */
}

.prize-label {
  transform: rotate(-90deg);
  transform-origin: center;
  font-size: 26px; /* 調整字體大小 */
  font-weight: bold;
  color: #fff; /* 使用白色字體 */
  text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.3); /* 添加文字陰影 */
}

.pointer {
  position: absolute;
  top: -60px; 
  left: 50%;
  transform: translateX(-50%) rotate(180deg);
  width: 0;
  height: 0;
  border-left: 20px solid transparent;
  border-right: 20px solid transparent;
  border-bottom: 60px solid #ff6347; /* 明亮的指針顏色 */
  z-index: 1; 
}

button {
  margin-top: 20px;
  padding: 10px 20px;
  font-size: 18px; /* 調整字體大小 */
  color: white; /* 白色文字 */
  background-color: #ff6347; /* 明亮的按鈕顏色 */
  border: none; /* 去除邊框 */
  border-radius: 5px; /* 圓角按鈕 */
  cursor: pointer; /* 鼠標變成手指 */
  transition: background-color 0.3s; /* 添加過渡效果 */
}

button:disabled {
  background-color: #ccc; /* 禁用狀態的顏色 */
  cursor: not-allowed; /* 禁用狀態的鼠標樣式 */
}

button:hover:not(:disabled) {
  background-color: #ff4500; /* 懸停狀態的顏色 */
}

.coupon-message {
  margin-top: 20px;
  font-size: 24px; /* 調整字體大小 */
  font-weight: bold; /* 加粗 */
  color: #333; /* 深色文字 */
}

.coupon-code {
  font-size: 48px; /* 超大字體 */
  color: #ff6347; /* 使用優惠碼顏色 */
  font-weight: bold; /* 加粗 */
}

.copy-button {
  margin-top: 10px;
}
</style>
