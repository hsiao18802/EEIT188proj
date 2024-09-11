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
                        <tr>
                            <td>選擇圖片</td>
                            <td><input type="file" accept="image/*" @change="onImageSelected"></td>
                        </tr>                        
                    </table>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" @click="emits('changepic')">上傳圖檔</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">關閉</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>

    const props = defineProps(["product"])
    const emits = defineEmits(["update:product", "changepic", 'imageSelected'])

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
    function onImageSelected(event) {
    const file = event.target.files[0];
    if (file) {
        console.log("圖片已選擇:", file);
        emits('imageSelected', file);  // 通過 emit 傳遞圖片文件給父組件
    }
}
    defineExpose({
        showModal, hideModal
    });
</script>

<style>

</style>
