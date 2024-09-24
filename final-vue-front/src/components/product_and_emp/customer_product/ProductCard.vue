<template>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@mdi/font/css/materialdesignicons.min.css">
    

    <div class="col-lg-3 col-md-6">
        <div class="card">
            <img class="card-img-top" :alt="item.productName" v-default-img="item.mainPhoto">
            <div class="card-body">
                <h5 class="card-title">{{ item.productName }}</h5> <!-- 顯示產品名稱 -->
                <div class="row">
                    <!-- 將兩個按鈕放在同一行 -->
                    <div class="d-flex justify-content-between">
                          <button type="button" class="btn btn-primary me-8" 
                                @click="emits('openRent', 'rent', item.productId)">商品詳細</button>
                        
                                <button type="button" class="btn-light" @click="addCart" alt="加入購物車">
                                    <i class="mdi mdi-cart-plus cart-icon"></i><!-- 使用 MDI 購物車圖標 -->
                                </button>
                    </div>
                </div>
            </div>
        </div>
        
    </div>

</template>
    
<script setup>
    import { useRouter } from 'vue-router';
    import { useCartStore } from '@/stores/cartStore';
    import useUserStore from '@/stores/user.js';
    import {  ref } from 'vue';
    import { gsap } from 'gsap';
    import '@mdi/font/css/materialdesignicons.css';



const props = defineProps(["item"]);
const emits = defineEmits(["openRent"]);

// 取得 userStore 和 cartStore
const cartStore = useCartStore();
const userStore = useUserStore();
const router = useRouter();

// 動畫元素
const animationBall = ref(null); 
const exampleObj = ref(null); // 用於隱藏動畫後的效果

// 添加商品到購物車
const addCart = async () => {
    const membersId = userStore.membersId;

    if (!userStore.isLogin) {
        // 未登入，跳轉到登入頁面
        router.push('/secure/login');
        return;
    } else {
        try {
            // 加入購物車
            await cartStore.addCart({
                productId: props.item.productId,
                productName: props.item.productName,
                dailyFeeOriginal: props.item.dailyFeeOriginal,
                count: 1, // 假設預設加入購物車數量為1
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

.cart-icon:hover {
    color: #191b1a; 
    text-shadow: 2px 2px 8px rgba(0, 0, 0, 0.7); /* 懸停時增加陰影 */
}


</style>
