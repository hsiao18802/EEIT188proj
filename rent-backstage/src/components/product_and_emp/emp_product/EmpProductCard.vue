<template>
    <div class="col-lg-3 col-md-6">
        <div class="card">
            <img class="card-img-top" :alt="item.productName" v-default-img="item.mainPhoto">

            <div class="card-body">
                <h5 class="card-title">{{ item.productName }}</h5> <!-- 顯示產品名稱 -->
                <!-- <div class="row">
                    <div class="btn-group col text-start">
                        <a class="btn btn-primary"
                            @click="$emit('openUpdate', 'update', item.productId)">修改</a>
                        <a class="btn btn-outline-primary"
                            @click="$emit('openChangePic', 'changePic', item.productId)">換圖</a>
                    </div>
                    <div class="col text-end">
                        <button class="btn btn-danger"
                                @click="emits('delete', item.productId)">刪除</button>
                    </div> -->

                    <!-- 拍照用 -->
                    <div class="btn-group col text-end">
                        <a class="btn btn-primary"
                            @click="$emit('openUpdate', 'update', item.productId)">修改</a>
                        <a class="btn btn-danger"
                                @click="emits('delete', item.productId)">刪除</a>
                    </div>
                <!-- </div> -->
            </div>
        </div>
    </div>
</template>
    
<script setup>
    const props = defineProps(["item"]);
    const emits = defineEmits(["delete", "openUpdate", "openChangePic"]);
</script>
    
<style>
</style>
