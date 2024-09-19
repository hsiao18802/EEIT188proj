<template>
    <div class="modal fade" id="cartModal" tabindex="-1" aria-labelledby="cartModalLabel" aria-hidden="true" ref="exampleModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="cartModalLabel">購物車</h5>
                    <button type="button" class="btn-close" @click="hideModal"></button>
                </div>
                <div class="modal-body">
                    <p v-if="cartItems.length === 0">購物車內沒有商品。</p>
                    <ul v-else>
                        <li v-for="item in cartItems" :key="item.productId">
                            <img :src="item.mainPhoto" alt="Product Image" class="img-thumbnail" style="width: 100px;">
                            <p>商品名稱: {{ item.productName }}</p>
                            <p>數量: {{ item.count }}</p>
                            <p>價格: {{ item.dailyFeeOriginal }}</p>
                        </li>
                    </ul>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" @click="hideModal">關閉</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted, computed } from 'vue';
import bootstrap from 'bootstrap/dist/js/bootstrap.bundle.min.js';
import { useCartStore } from '@/stores/cartStore';
import useUserStore from '@/stores/user.js';

const cartModalRef = ref(null); // 參考 modal 元素
let modalInstance = null;       // Modal 實例

// 參考 modal 元素和 modal 實例
const exampleModal = ref(null);
const exampleObj = ref(null);

const cartStore = useCartStore();
const userStore = useUserStore(); 

// 獲取 cartItems，直接來自 Pinia cartStore
const cartItems = computed(() => cartStore.cartList); // 確保 cartList 是存儲購物車商品的數組

// 透過 computed 獲取 membersId
const membersId = computed(() => userStore.membersId);

// 當組件掛載時，設置 membersId 並初始化 Modal
onMounted(() => {
    if (membersId.value) {
        cartStore.setMembersId(membersId.value);
    } else {
        console.error('未找到 membersId，請檢查用戶登入狀態');
    }
    onMounted(() => {
    // 初始化 Modal
    if (cartModalRef.value) {
        modalInstance = new bootstrap.Modal(cartModalRef.value);
    }
});

    // 初始化 Modal
    exampleObj.value = new bootstrap.Modal(exampleModal.value, {
        backdrop: true, // 設置 backdrop
        keyboard: true // 設置 keyboard
    });
});

// 添加商品到購物車
const addCart = async () => {
    if (!membersId.value) {
        console.error('未找到 membersId，無法添加到購物車');
        return;
    }

    try {
        const response = await cartStore.addCart({
            productId: props.product.productId,
            productName: props.product.productName,
            dailyFeeOriginal: props.product.dailyFeeOriginal,
            count: 1, // 默認為 1
            membersId: membersId.value
        });

        console.log('API response from addCart:', response);
        if (response && response.data) {
            console.log('商品已加入購物車', response.data.message);

            // 顯示購物車視窗
            showModal();
        }
    } catch (error) {
        console.error('添加到購物車失敗:', error);
    }
};

// Modal 的顯示與隱藏控制
function showModal() {
    if (exampleObj.value) {
        exampleObj.value.show();
    }
}

function hideModal() {
    if (exampleObj.value) {
        exampleObj.value.hide();
    }
}

defineExpose({
    showModal,
    hideModal,
});
</script>

<style>
/* 自定義樣式（可根據需求調整） */
</style>
