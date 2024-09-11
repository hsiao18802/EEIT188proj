<template>
    <div ref="exampleModal" class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Product</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <table>
                        <tr v-show="!isShowInsertButton">
                            <td>編號</td>
                            <td>{{ product.productId }}</td>
                        </tr>
                        <tr>
                            <td>名稱</td>
                            <td>{{ product.productName }}</td>
                        </tr>
                        
                        <!-- <tr>
                            <td>選擇圖片</td>
                            <td>選擇圖片的按鈕會放這裡</td>
                        </tr> -->
                        
                    </table>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" v-show="isShowInsertButton" @click="emits('insert')">新增</button>
                    <button class="btn btn-primary" v-show="!isShowInsertButton" @click="emits('update')">修改</button>
                    <!-- <button class="btn btn-primary" v-show="!isShowInsertButton" @click="emits('???')">上傳圖檔</button> -->
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">關閉</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
    const props = defineProps(["product", "isShowInsertButton"])
    const emits = defineEmits(["update:product", "insert", "update"])
    function doInput(key, event) {
        emits("update:product", {
            ...props.product,
            [key]: event.target.value
        });
    }

    import bootstrap from 'bootstrap/dist/js/bootstrap.bundle.min.js'
    import { ref, onMounted } from 'vue';
    const exampleModal = ref(null);
    const exampleObj = ref(null);
    onMounted(function () {
        exampleObj.value = new bootstrap.Modal(exampleModal.value, null);
        
    });
    function showModal() {
        exampleObj.value.show();
    }
    function hideModal() {
        exampleObj.value.hide();
    }

    defineExpose({
        showModal, hideModal
    });

    // 定義一個函數來格式化日期並調整時區
    function formatDate(utcDateString) {
        if (!utcDateString) return ""; // 防止空值報錯
        const date = new Date(utcDateString);
        // 調整時區+8
        // date.setHours(date.getHours() + 8);

        // 格式化為 yyyy-MM-dd HH:mm:ss
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, "0");
        const day = String(date.getDate()).padStart(2, "0");
        const hours = String(date.getHours()).padStart(2, "0");
        const minutes = String(date.getMinutes()).padStart(2, "0");
        // const seconds = String(date.getSeconds()).padStart(2, "0");

        return `${year}年${month}月${day}日 ${hours}時${minutes}分`;
    }
</script>

<style>

</style>
