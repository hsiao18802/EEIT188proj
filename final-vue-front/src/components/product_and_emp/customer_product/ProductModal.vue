<template>
    <div ref="exampleModal" class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Product</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <!-- <img class="card-img-top" :alt="product.productName" v-default-img="product.mainPhoto" ref="productImage"> -->
                    <img :src="`data:image/jpeg;base64,${product.mainPhoto}`" :alt="product.productName" style="max-width: 400px;">
                    <div class="animation-container">
                        <div class="animation-ball" ref="animationBall"></div>
                    </div>
                    <table>
                        <tr>
                            <td hidden>編號</td>
                            <td><input type="text" name="id" v-model="product.productId" readonly hidden></td>
                        </tr>
                        <tr>
                            <td>名稱</td>
                            <td>{{ product.productName }}</td>
                        </tr>
                        <tr>
                            <td>價格</td>
                            <td>{{ product.dailyFeeOriginal }}</td>
                        </tr>
                        <tr>
                            <td>商品簡介</td>
                            <td>{{ product.description }}</td>
                        </tr>
                        <tr>
                            <td>租用數量</td>
                            <td><input type="number" v-model="count" @input="doInput('count', $event)"></td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" @click="addCart">加入購物車</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">關閉</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted, nextTick } from 'vue';
import bootstrap from 'bootstrap/dist/js/bootstrap.bundle.min.js';
import { useCartStore } from '@/stores/cartStore';
import useUserStore from '@/stores/user.js';
import { gsap } from 'gsap';
import { useRouter } from 'vue-router';




const exampleModal = ref(null);
const exampleObj = ref(null);
const cartStore = useCartStore();
const userStore = useUserStore();
const count = ref(1);
const animationBall = ref(null);
const router = useRouter();


onMounted(() => {
    if (exampleModal.value) {
        exampleObj.value = new bootstrap.Modal(exampleModal.value);
    }
});

const props = defineProps({
    product: Object,
    rentalStartDate: String,  // 新增租用開始日期
    rentalEndDate: String      // 新增租用結束日期
});

const doInput = (name, event) => {
    console.log(name, event.target.value);
};

// 添加商品到購物車
const addCart = async () => {
    const membersId = userStore.membersId;

    // if (!userStore.isLogin) {
    //     // 未登入，跳轉到登入頁面
    //     router.push('/secure/login');
    //     return;
    // } else {
    //     try {
    //         // 確認傳入了正確的商品資訊
    //         await cartStore.addCart({
    //             productId: props.product.productId,
    //             productName: props.product.productName,
    //             dailyFeeOriginal: props.product.dailyFeeOriginal,
    //             count: count.value,
    //             membersId: membersId,
    //             mainPhoto: props.product.mainPhoto,
    //             startDate: props.rentalStartDate, 
    //             endDate: props.rentalEndDate  ,
    //             cartId:null
            

                
    //         });

    //         // 執行動畫效果
    //         await nextTick();
    //         if (animationBall.value) {
    //             animationBall.value.style.display = 'block';
    //             await nextTick();
                
    //             // GSAP 動畫
    //             gsap.fromTo(animationBall.value, 
    //                 { x: 0, y: 0, scale: 1 }, 
    //                 { 
    //                     duration: 1, 
    //                     x: 400, 
    //                     y: -300, 
    //                     scale: 0, 
    //                     ease: "power2.out",
    //                     onComplete: async () => {
    //                         animationBall.value.style.display = 'none';
    //                         if (exampleObj.value) {
    //                             exampleObj.value.hide();
    //                         }
    //                     }
    //                 }
    //             );
    //         }
    //     } catch (error) {
    //         console.error('加入購物車失敗:', error);
    //         Swal.fire({
    //             title: '錯誤',
    //             text: "加入購物車失敗，請稍後再試。",
    //             icon: "error",
    //             confirmButtonText: '確定',
    //             position: 'center'
    //         });
    //     }
    // }
};

        

// 顯示 Modal
function showModal() {
    if (exampleObj.value) {
        exampleObj.value.show();
    } else {
        console.error('Modal instance is not initialized.');
    }
}

// 隱藏 Modal
function hideModal() {
    if (exampleObj.value) {
        exampleObj.value.hide();
    } else {
        console.error('Modal instance is not initialized.');
    }
}

defineExpose({
    showModal,
    hideModal
});

</script>

<style >
/* 動畫容器 */
.animation-container {
    position: absolute;
    top: 50%;
    right: 10%;
    width: 100px;
    height: 100px;
    overflow: hidden;
    z-index: 9999;
}

/* 球體樣式 */
.animation-ball {
    width: 20px;
    height: 20px;
    background-color: #ff5722;
    border-radius: 50%;
    position: absolute;
    bottom: 10px;
    display: none; /* 初始隱藏 */
}

/* 動畫效果 */
@keyframes bounceToCart {
    0% {
        transform: translate(0, 0);
    }
    50% {
        transform: translate(200px, -100px);
    }
    100% {
        transform: translate(300px, 0);
        opacity: 0;
    }
}

/* 球體線條樣式 */
.animation-ball::before {
    content: "";
    position: absolute;
    width: 2px;
    height: 100px;
    background: #ff5722;
    top: 0;
    left: 50%;
    transform: translateX(-50%);
    border-radius: 2px;
    animation: drawLine 1s ease-in-out forwards;
    display: none; /* 初始隱藏 */
}

@keyframes drawLine {
    0% {
        height: 0;
    }
    100% {
        height: 100px;
    }
}

/* 讓動畫球跳到右邊的購物車 */
.product-animation {
    animation: bounceToCart 1s ease-in-out forwards;
}
</style>
