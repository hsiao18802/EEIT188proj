<template>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@mdi/font/css/materialdesignicons.min.css">

    <div class="col-lg-3 col-md-6">
        <!-- 將 @click 綁定到整個卡片上 -->
        <div class="card position-relative shadow1 mb-4" @click="openRent">
            <!-- 圖片 -->
            <div class="image-container">
                <img class="card-img-top" :alt="item.productName" v-default-img="item.mainPhoto">
                <!-- 根據 isDateSelected 的值來決定是否顯示色塊 -->
                <div v-if="isDateSelected" :class="rentBarClass">
                    <span>{{ rentBarText }}</span>
                </div>
            </div>
            <div class="card-body position-relative">
                <h4 class="card-title">{{ item.productName }}</h4> <!-- 顯示產品名稱 -->
                <h5>{{ item.dailyFeeOriginal }} 元/天</h5> <!-- 顯示產品名稱 -->
                <!-- 購物車圖示放置於卡片右下角 -->
                <button
                    type="button"
                    class="btn-light cart-button"
                    :class="{ 'disabled-cart': !canAddToCart }"
                    @click.stop="handleCartClick"
                    alt="加入購物車"
                >
                    <i class="mdi mdi-cart-plus cart-icon"></i><!-- 使用 MDI 購物車圖標 -->
                </button>
            </div>
        </div>
    </div>
</template>

<script setup>
import { computed } from 'vue';
import { useRouter } from 'vue-router';
import { useCartStore } from '@/stores/cartStore';
import useUserStore from '@/stores/user.js';
import Swal from 'sweetalert2';

const props = defineProps({
    item: Object,
    availableQuantity: { type: Number, default: 0 },
    isDateSelected: { type: Boolean, default: false }
});
const emits = defineEmits(["openRent"]);

// 取得 userStore 和 cartStore
const cartStore = useCartStore();
const userStore = useUserStore();
const router = useRouter();

// 將點擊卡片的行為與 emits('openRent', 'rent', item.productId) 綁定
const openRent = () => {
    emits('openRent', 'rent', props.item.productId);
};

// 計算色塊的類別和顯示的文字
const rentBarClass = computed(() => {
    if (props.availableQuantity <= 0) {
        return 'rent-bar no-stock';  // 紅底
    } else if (props.availableQuantity > 0 && props.availableQuantity <= 3) {
        return 'rent-bar low-stock';  // 黃底
    } else {
        return 'rent-bar in-stock';   // 藍底
    }
});

const rentBarText = computed(() => {
    if (props.availableQuantity <= 0) {
        return '該日期無庫存😭';
    } else if (props.availableQuantity > 0 && props.availableQuantity <= 3) {
        return `最後 ${props.availableQuantity} 件！`;
    } else {
        return `可租用數量：${props.availableQuantity}`;
    }
});

// 計算按鈕是否可用
const canAddToCart = computed(() => {
    return props.availableQuantity > 0;
});

// 處理購物車按鈕點擊事件
const handleCartClick = () => {
    if (!canAddToCart.value) {
        Swal.fire({
            title: '很抱歉',
            html: '您所選擇的日期已經沒有庫存😭',
            icon: 'error',
            confirmButtonText: '確定'
        });
        return;
    }
    addCart();
};

// 添加商品到購物車
const addCart = async () => {
    const membersId = userStore.membersId;

    if (!userStore.isLogin) {
        router.push('/secure/login');
        return;
    } else {
        try {
            await cartStore.addCart({
                productId: props.item.productId,
                productName: props.item.productName,
                dailyFeeOriginal: props.item.dailyFeeOriginal,
                count: 1,
                membersId: membersId,
                mainPhoto: props.item.mainPhoto,
                startDate: props.rentalStartDate, 
                endDate: props.rentalEndDate,
                cartId: null
            });
        } catch (error) {
            console.error('加入購物車失敗:', error);
            Swal.fire({
                title: '錯誤',
                text: "加入購物車失敗，請稍後再試。",
                icon: "error",
                confirmButtonText: '確定',
                position: 'center'
            });
        }
    }
};
</script>

<style scoped>
/* 圖片和長條形色塊的樣式 */
.image-container {
    position: relative;
    width: 100%;
    height: auto;
}

.card-img-top {
    width: 100%;
    height: auto;
    display: block;
}

/* 長條形色塊樣式，位於圖片的下方，圖片穿過長條形 */
.rent-bar {
    position: absolute;
    bottom: 0;
    left: 50%;
    transform: translateX(-50%) translateY(50%); /* 讓色塊跨過圖片的下緣 */
    width: 80%;
    color: white;
    text-align: center;
    padding: 5px 0;
    border-radius: 50px; /* 讓色塊兩邊呈現半圓形 */
    font-size: 16px;
}

/* 沒有庫存時的樣式（紅色背景） */
.no-stock {
    background-color: rgba(255, 0, 0, 0.7); /* 半透明紅色背景 */
    color: white;
}

/* 低庫存時的樣式（黃色背景） */
.low-stock {
    background-color: rgba(255, 255, 0, 0.7); /* 半透明黃色背景 */
    color: black; /* 改為黑字 */
}

/* 有庫存時的樣式（藍色背景） */
.in-stock {
    background-color: rgba(0, 0, 255, 0.7); /* 半透明藍色背景 */
    color: white;
}

/* 購物車圖標樣式 */
.cart-icon {
    font-size: 40px; /* 調整圖標大小 */
    color: #131212; 
    transition: color 0.3s ease; /* 過渡效果 */
    background: linear-gradient(45deg, #181816, #1b6614); /* 漸層背景 */
    -webkit-background-clip: text; /* 只顯示文本的背景 */
    background-clip: text; /* 標準屬性 */
    color: transparent; /* 隱藏文本顏色 */
    padding: 5px; /* 增加內邊距 */
    border-radius: 5px; /* 圓角效果 */
}

/* 禁用 hover 效果 */
.disabled-cart .cart-icon:hover {
    color: #131212; /* 禁用時不變色 */
    text-shadow: none; /* 禁用時無陰影效果 */
}

/* 將購物車圖標置於卡片的右下角 */
.cart-button {
    position: absolute;
    right: 10px;
    bottom: 10px;
    background-color: transparent;
    border: none;
}

/* 禁用購物車按鈕時的樣式 */
.disabled-cart {
    cursor: not-allowed;
}

.cart-icon:hover {
    color: #191b1a; 
    text-shadow: 2px 2px 8px rgba(0, 0, 0, 0.7); /* 懸停時增加陰影 */
}

.card {
    cursor: pointer;
}

      /* 調整陰影 */
  .shadow1 {
    box-shadow: 0 1px 1.5px rgba(0, 0, 0, 0.5); /* 給輸入框和按鈕加上陰影 */
  }
</style>
