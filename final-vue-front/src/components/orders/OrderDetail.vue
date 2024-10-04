<template>
    <div>
        <h2 class="title">訂單詳細</h2>
        <el-card shadow="hover" style="max-width: 600px; margin: 0 auto;">
            <div class="card-content">
                <el-divider></el-divider>

                <!-- 使用 Skeleton 顯示載入狀態 -->
                <el-skeleton v-if="isLoading" :rows="8" animated />

                <!-- 當資料加載完成後顯示內容 -->
                <div v-else>
                    <p class="order-detail">
                        <i class="fa fa-user" aria-hidden="true"></i>
                        <strong>收件人姓名：</strong> {{ order.shippingName }}
                    </p>
                    <p class="order-detail">
                        <i class="fa fa-phone" aria-hidden="true"></i>
                        <strong>收件人電話：</strong> {{ order.shippingPhoneNum }}
                    </p>
                    <p class="order-detail">
                        <i class="fa fa-map-marker" aria-hidden="true"></i>
                        <strong>收件地址：</strong> {{ order.shippingAddress }}
                    </p>
                    <p class="order-detail">
                        <i class="fa fa-truck" aria-hidden="true"></i>
                        <strong>運送方式：</strong> {{ order.shippingMethod }}
                    </p>
                    <p class="order-detail">
                        <i class="fa fa-credit-card" aria-hidden="true"></i>
                        <strong>付款方式：</strong> {{ order.payMethod }}
                    </p>
                    <p class="order-detail">
                        <i class="fa fa-comment" aria-hidden="true"></i>
                        <strong>備註：</strong> {{ order.remarks }}
                    </p>
                    <p class="order-detail">
                        <i class="fa fa-calendar" aria-hidden="true"></i>
                        <strong>租借開始日期：</strong> {{ order.rentalStartDate }}
                    </p>
                    <p class="order-detail">
                        <i class="fa fa-calendar-check-o" aria-hidden="true"></i>
                        <strong>租借結束日期：</strong> {{ order.rentalEndDate }}
                    </p>
                    <p class="order-detail">
                        <i class="fa fa-clock" aria-hidden="true"></i>
                        <strong>租借天數：</strong> {{ order.rentalDays }}
                    </p>
                </div>

                <el-divider></el-divider>
                <el-button type="primary" icon="el-icon-arrow-left" @click="goBack" class="back-button">
                    返回上一頁
                </el-button>
            </div>
        </el-card>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { getOrderByIdAPI } from '@/apis/order';
import { useRoute, useRouter } from 'vue-router';
import { useCartStore } from '@/stores/cartStore';
import { ElMessage } from 'element-plus';
import { ElMessageBox } from 'element-plus';


const route = useRoute();
const router = useRouter();
const cartStore = useCartStore();
const orderId = route.params.orderId; // 假設路由參數為 orderId

const order = ref({}); // 用來儲存訂單詳細資料
const isLoading = ref(true); // 資料加載狀態

// 當組件掛載時獲取訂單詳細資料
onMounted(async () => {
    try {
        const response = await getOrderByIdAPI(orderId);
        order.value = response.data; // 將獲取的訂單資料賦值給 order

        // 檢查用戶是否有權查看此訂單
        if (order.value.membersId !== cartStore.membersId) {
            await ElMessageBox.alert("您無權查看此訂單", "錯誤", {
                confirmButtonText: "確定",
                customClass: 'full-screen-message', // 可以用來指定 CSS 類
            });
            router.push('/'); // 重定向回訂單列表
        }
    } catch (error) {
        console.error("獲取訂單詳細資料失敗: ", error.response ? error.response.data : error.message);
    } finally {
        isLoading.value = false; // 載入完成後設定為 false
    }
});

// 返回上一頁的功能
const goBack = () => {
    router.back();
};
</script>

<style scoped>
.title {
    text-align: center;
    margin-bottom: 20px;
    color: #42b983;
    /* 標題顏色 */
    font-size: 2rem;
    font-weight: bold;
}

.card-content {
    padding: 20px;
}

/* 訂單詳細資料樣式 */
.order-detail {
    transition: transform 0.3s ease, color 0.3s ease;
    padding: 10px 0;
    /* 增加上下內邊距 */
    font-size: 1.1rem;
    /* 字體大小 */
    color: #333;
    /* 基本文字顏色 */
}

.order-detail:hover {
    transform: scale(1.05);
    /* 放大 */
    color: #409eff;
    /* 更活潑的顏色 */
    background-color: rgba(64, 158, 255, 0.1);
    /* 輕微的背景顏色 */
    border-radius: 5px;
    /* 圓角效果 */
}

/* 返回按鈕樣式 */
.back-button {
    width: 100%;
    margin-top: 20px;
    transition: background-color 0.3s ease, transform 0.3s ease;
    background-color: #42b983;
    /* 按鈕背景顏色 */
    color: white;
    /* 按鈕字體顏色 */
}

.back-button:hover {
    background-color: #36a76b;
    /* 改變背景色 */
    transform: translateY(-2px);
    /* 向上移動 */
}

.full-screen-message .el-message-box {
    width: 100vw;
    /* 寬度設置為視窗的 100% */
    height: 100vh;
    /* 高度設置為視窗的 100% */
    top: 0;
    /* 固定在頂部 */
    left: 0;
    /* 固定在左側 */
    position: fixed;
    /* 使用固定定位 */
    display: flex;
    /* 使用 Flexbox 來居中內容 */
    justify-content: center;
    /* 水平居中 */
    align-items: center;
    /* 垂直居中 */
}

.full-screen-message .el-message-box__content {
    font-size: 1.5rem;
    /* 調整字體大小 */
    color: #ff4d4f;
    /* 設置字體顏色 */
    text-align: center;
    /* 文字居中 */
}
</style>
