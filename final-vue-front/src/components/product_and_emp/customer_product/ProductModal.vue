<template>
    <div ref="exampleModal" class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Product</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <img class="card-img-top"  :alt="product.productName" v-default-img="product.mainPhoto">
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
import { ref, onMounted } from 'vue';
import bootstrap from 'bootstrap/dist/js/bootstrap.bundle.min.js';
import { useCartStore } from '@/stores/cartStore';
import useUserStore from '@/stores/user.js';

const cartModal = ref(null); // 確保這裡是 null 或適當的引用

// 當 modal 元素存在時初始化
onMounted(() => {
    if (cartModal.value) {
        exampleObj.value = new bootstrap.Modal(cartModal.value, null);
    }
});

const props = defineProps({
    product: Object
});

const exampleModal = ref(null);
const exampleObj = ref(null);

const cartStore = useCartStore();
const userStore = useUserStore(); 
const count = ref(1);

// 當組件掛載時，設置 membersId
onMounted(() => {
    const membersId = userStore.membersId;
    if (membersId) {
        cartStore.setMembersId(membersId);
    } else {
        console.error('未找到 membersId，請檢查用戶登入狀態');
    }
});

const doInput = (name, event) => {
    console.log(name, event.target.value);
};


// 添加商品到購物車
const addCart = async () => {
    const membersId = userStore.membersId;
   

    try {
        const response = await cartStore.addCart({
            productId: props.product.productId,
            productName: props.product.productName,
            dailyFeeOriginal: props.product.dailyFeeOriginal,
            count: count.value,
            membersId: membersId
        });

        console.log('API response from addCart:', response);
        
        // 檢查 response 是否存在
        if (response && response.success) {
            console.log('商品已加入購物車', response.message);

            // 顯示購物車視窗
            showModal();
        } else {
            console.error('添加到購物車失敗:', response?.message || '未知錯誤');
        }
    } catch (error) {
        console.error('添加到購物車失敗:', error);
    }
};



// Modal 的掛載與顯示控制
onMounted(() => {
    exampleObj.value = new bootstrap.Modal(exampleModal.value, null);
});

function showModal() {
    exampleObj.value.show();
}

function hideModal() {
    exampleObj.value.hide();
}

defineExpose({
    showModal,
    hideModal,
});
</script>

<style>
</style>
