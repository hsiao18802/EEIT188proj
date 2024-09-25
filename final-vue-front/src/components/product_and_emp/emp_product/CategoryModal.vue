<template>
    <div ref="exampleModal" class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">分類管理</h1>
                    <button type="button" class="btn-close" @click="hideModal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">分類順序</th>
                                <th scope="col">分類名稱</th>
                                <th scope="col">修改刪除</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>{{ category.categoryId }}</td>
                                <th scope="row">{{ category.categoryName }}</th>
                                <td><span>這裡放按鈕</span></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted, nextTick } from 'vue';
import Swal from 'sweetalert2';
import bootstrap from 'bootstrap/dist/js/bootstrap.bundle.min.js';
import axiosapi from '@/plugins/axios';  // 確保你有正確配置 axios

// // Props and emits
const props = defineProps(["category"]);

// // Modal handling
const exampleModal = ref(null);
const exampleObj = ref(null);
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
    hideModal
});



</script>

<style></style>