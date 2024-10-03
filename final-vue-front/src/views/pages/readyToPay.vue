<template>
    <el-card class="order-card">
        <h2>訂單已建立！</h2>
        <p>訂單編號：{{ orderStore.orderId }}</p>
        <canvas id="countdownClock" width="200" height="200"></canvas>
        <p class="countdown-time" aria-live="polite">{{ formatTime(remainingTime) }}</p>
        <p v-if="isExpired" class="expired-message">已逾期，訂單取消。</p>
        <p v-else-if="!isExpired">總金額: {{ formatPrice(orderStore.totalPrice) }} 元</p>
        <el-button type="success" size="large" @click="proceedToPayment" :disabled="isExpired" class="payment-button">
            使用綠界支付
        </el-button>
    </el-card>

    <el-card class="info-card">
        <p class="info-message">30分鐘內沒付款，訂單將會過期！</p>
    </el-card>
</template>

<script setup>
import { ref, onMounted, onBeforeUnmount } from 'vue';
import { ecpayAPI } from '@/apis/order';
import { useOrderStore } from '@/stores/orderStore';

const countdownTime = 1; // 倒數30分鐘
const remainingTime = ref(countdownTime * 60); // 倒數秒數
const isExpired = ref(false);
const orderStore = useOrderStore();
let timer; // 計時器變數

const drawClock = () => {
    const canvas = document.getElementById('countdownClock');
    const context = canvas.getContext('2d');
    const centerX = canvas.width / 2;
    const centerY = canvas.height / 2;
    const radius = Math.min(centerX, centerY) - 10;

    // 清空畫布
    context.clearRect(0, 0, canvas.width, canvas.height);

    // 畫圓形表盤
    context.beginPath();
    context.arc(centerX, centerY, radius, 0, Math.PI * 2);
    context.strokeStyle = '#000';
    context.lineWidth = 5;
    context.stroke();

    const second = remainingTime.value % 60;
    const secondAngle = (second / 60) * 2 * Math.PI;

    // 畫秒鐘指針
    context.save();
    context.translate(centerX, centerY);
    context.rotate(-secondAngle);
    context.beginPath();
    context.moveTo(0, 0);
    context.lineTo(0, -radius * 0.8);
    context.strokeStyle = 'red'; // 秒針顏色
    context.stroke();
    context.restore();
};

const startCountdown = () => {
    timer = setInterval(() => {
        remainingTime.value--;
        if (remainingTime.value <= 0) {
            clearInterval(timer);
            isExpired.value = true; // 訂單過期
        }
        drawClock(); // 每次更新時鐘
    }, 1000); // 每秒更新一次
};

// 在組件被銷毀時清理計時器
onBeforeUnmount(() => {
    clearInterval(timer); // 清除計時器
});

// 格式化時間
const formatTime = (time) => {
    const minutes = Math.floor(time / 60);
    const seconds = time % 60;
    return `${String(minutes).padStart(2, '0')} : ${String(seconds).padStart(2, '0')}`; // 顯示分鐘和秒數
};

// 格式化價格，確保是有效的整數
const formatPrice = (price) => {
    return new Intl.NumberFormat('zh-TW', {
        style: 'currency',
        currency: 'TWD',
        minimumFractionDigits: 0,
        maximumFractionDigits: 0,
    }).format(Math.round(price)); // 確保傳入的是有效的整數
};

// 前往綠界支付
const proceedToPayment = async () => {
    try {
        const ecpayForm = await ecpayAPI(orderStore.orderId);
        console.log("綠界付款表單:", ecpayForm);

        const formWrapper = document.createElement('div');
        formWrapper.innerHTML = ecpayForm.data;
        document.body.appendChild(formWrapper);

        const paymentForm = formWrapper.querySelector('form');
        if (paymentForm) {
            paymentForm.submit(); // 自動提交表單
        }
    } catch (error) {
        console.error("支付API錯誤:", error);
        await Swal.fire({
            title: '支付失敗',
            text: '請稍後重試或聯繫客服',
            icon: 'error',
            confirmButtonText: '確定'
        });
    }
};

// 在組件掛載時啟動倒數計時
onMounted(() => {
    drawClock(); // 初始化時鐘
    startCountdown();
});

// 確認訂單金額是否正確
console.log("訂單金額:", orderStore.totalPrice);
</script>

<style scoped>
.order-card {
    max-width: 400px;
    margin: 20px auto;
    padding: 20px;
    text-align: center;
    border-radius: 10px;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
    background-color: #f9f9f9;
}

.info-card {
    max-width: 400px;
    margin: 20px auto;
    padding: 15px;
    text-align: center;
    border-radius: 10px;
    background-color: #fff3cd;
    /* 提示信息的背景顏色 */
    border: 1px solid #ffeeba;
    /* 边框颜色 */
}

h2 {
    color: green;
}

canvas {
    display: block;
    margin: 0 auto;
}

.countdown-time {
    font-size: 24px;
    margin-top: 10px;
}

.expired-message {
    color: red;
}

.payment-button {
    width: 100%;
    font-size: 18px;
    padding: 15px;
    /* 放大按鈕 */
}

.info-message {
    font-size: 18px;
    color: #856404;
    /* 提示文字颜色 */
    margin: 0;
    /* 去除默认边距 */
}
</style>
