<template>
    <div class="countdown-timer">
        <span>{{ formattedTime }}</span>
    </div>
</template>

<script setup>
import { ref, watch } from 'vue';

const props = defineProps({
    time: {
        type: Number,
        required: true,
    },
    format: {
        type: String,
        default: 'mm:ss',
    },
});

const remainingTime = ref(props.time); // 剩餘時間
const formattedTime = ref('');

const formatTime = (time) => {
    const minutes = Math.floor(time / 60);
    const seconds = time % 60;
    return `${String(minutes).padStart(2, '0')}:${String(seconds).padStart(2, '0')}`;
};

const updateFormattedTime = () => {
    formattedTime.value = formatTime(remainingTime.value);
};

// 監視時間變化，更新格式化的時間
watch(remainingTime, (newTime) => {
    if (newTime <= 0) {
        emit('end'); // 觸發結束事件
        remainingTime.value = 0; // 確保不會顯示負數
    }
    updateFormattedTime();
});

// 開始計時
const timer = setInterval(() => {
    remainingTime.value--;
}, 1000);

// 在組件銷毀時清理計時器
onBeforeUnmount(() => {
    clearInterval(timer);
});

// 初始化格式化時間
updateFormattedTime();
</script>

<style scoped>
.countdown-timer {
    font-size: 36px;
    /* 可以根據需求調整字體大小 */
    color: #333;
    /* 字體顏色 */
}
</style>
