<template>
    <div class="wheel-container">
      <div class="wheel" :style="{ transform: `rotate(${rotationAngle}deg)` }">
        <div v-for="(prize, index) in prizes" :key="index" class="segment" :style="{ transform: `rotate(${index * segmentAngle}deg)` }">
          <span class="prize-label">{{ prize.label }}</span>
        </div>
      </div>
      <div class="pointer"></div>
      <button @click="spinWheel" :disabled="isSpinning">Spin the Wheel</button>
      <p v-if="selectedCoupon">恭喜!你抽到的優惠碼是: {{ selectedCoupon }} !</p>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  
  const rotationAngle = ref(0)
  const isSpinning = ref(false)
  
  // 獎品內容及其對應的優惠碼
  const prizes = [
    { label: '超特價✨✨✨✨', coupon: 'COUPON50' },
    { label: '超划算✨✨✨✨', coupon: 'COUPON40' },
    { label: '不騙你✨✨✨✨✨', coupon: 'COUPON30' },
    { label: '神秘大獎✨✨✨✨', coupon: '下次再來' },
    { label: '皮卡啾✨✨✨✨✨', coupon: 'COUPON50' },
    { label: '超值得✨✨✨✨✨', coupon: 'COUPON40' },
    { label: '超好玩✨✨✨✨✨', coupon: 'COUPON30' },
    { label: '猜猜看✨✨✨✨', coupon: 'COUPON123' }
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
  </script>
  
  <style scoped>
  .wheel-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 50px;
    position: relative;
  }
  
  .wheel {
    width: 450px; 
    height: 450px; 
    border-radius: 50%;
    border: 5px solid #000;
    position: relative;
    overflow: hidden;
    transition: transform 4s ease-out;
  }
  
  .segment {
    position: absolute;
    width: 50%;
    height: 50%;
    background: rgba(243, 156, 18, 0.8); 
    border: 2px solid #fff;
    clip-path: polygon(100% 100%, 0 100%, 0 0);
    transform-origin: 100% 100%;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  .prize-label {
    transform: rotate(-90deg);
    transform-origin: center;
    font-size: 24px; 
    font-weight: bold;
    color: white;
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
    border-bottom: 60px solid red; 
    z-index: 1; 
  }
  
  button {
    margin-top: 20px;
    padding: 10px 20px;
    font-size: 16px;
  }
  </style>
  