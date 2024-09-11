<template>
    <div class="col-lg-3 col-md-6">
        <div class="card">
            <img class="card-img-top" :alt="item.productName" v-default-img="item.mainPhoto">
            <div class="card-body">
                <h5 class="card-title">{{ item.productName }}</h5> <!-- 顯示產品名稱 -->
                <div class="row">
                    <div class="col text-start">
                        <button type="button" class="btn btn-primary"
                                @click="emits('openRent', 'rent', item.productId)">預定產品</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
    
<script setup>
    // const path = import.meta.env.VITE_DETAIL_URL; // 如果需要用其他方式載入圖片
    const props = defineProps(["item"]);
    const emits = defineEmits(["openRent"]);
</script>
    
<style>
</style>
