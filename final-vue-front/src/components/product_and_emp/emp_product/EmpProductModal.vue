<template>
    <div ref="exampleModal" class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Product</h1>
                    <button type="button" class="btn-close" @click="handleCloseClick" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <table>
                        <tr v-show="!isShowInsertButton">
                            <td>編號</td>
                            <td>{{ product.productId }}</td>
                        </tr>
                        <tr>
                            <td>名稱</td>
                            <td><input type="text" name="name" v-model="product.productName"
                                    @input="onFieldInteraction"></td>
                        </tr>
                        <tr>
                            <td>價格</td>
                            <td><input type="number" name="price" v-model="product.dailyFeeOriginal"
                                    @input="onFieldInteraction"></td>
                        </tr>
                        <tr>
                            <td>庫存量</td>
                            <td><input type="number" name="maxQuantity" v-model="product.maxAvailableQuantity"
                                    @input="onFieldInteraction"></td>
                        </tr>
                        <tr>
                            <td>選擇圖片</td>
                            <td><input ref="imageInput" type="file" accept="image/*" @change="onImageSelected"></td>
                        </tr>
                        <tr>
                            <td>預覽圖片</td>
                            <td v-if="selectedImage">
                                <img :src="imagePreviewUrl" alt="預覽圖片" style="max-width: 100px; max-height: 100px;">
                            </td>
                            <td v-else>
                                <!-- 沒有選擇圖片時，這裡什麼都不顯示 -->
                            </td>
                        </tr>
                        <tr>
                            <td>描述</td>
                            <td><textarea name="description" v-model="product.description"
                                    @input="onFieldInteraction"></textarea></td>
                        </tr>
                        <tr>
                            <td>商品分類</td>
                            <td>
                                <select name="categoryId" v-model="product.categoryId">
                                    <option v-for="category in categories" :key="category.categoryId"
                                        :value="category.categoryId">
                                        {{ category.categoryId }}：{{ category.categoryName }}
                                    </option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>上架設定</td>
                            <td v-if="!isShowInsertButton">
                                <select name="statusId" v-model="product.statusId" @input="onFieldInteraction">
                                    <option v-for="status in statuslist" :key="status.statusId"
                                        :value="status.statusId">
                                        {{ status.status }}
                                    </option>
                                </select>
                            </td>
                            <td v-else>
                                <input type="hidden" name="statusId" v-model="product.statusId">
                                <span>預設為上架，如果不加功能記得要隱藏</span>
                            </td>
                        </tr>
                        <tr v-show="!isShowInsertButton">
                            <td>新增員工ID</td>
                            <td><input type="number" name="addEmployeeId" v-model="product.addEmployeeId" readonly></td>
                        </tr>
                        <tr v-show="!isShowInsertButton">
                            <td>新增日期</td>
                            <td>{{ formatDate(product.addDatetime) }}</td>
                        </tr>
                        <tr v-show="!isShowInsertButton">
                            <td>最後更新員工ID</td>
                            <td><input type="number" name="lastUpdateEmployeeId" v-model="product.lastUpdateEmployeeId"
                                    readonly></td>
                        </tr>
                        <tr v-show="!isShowInsertButton">
                            <td>最後更新日期</td>
                            <td>{{ formatDate(product.lastUpdateDatetime) }}</td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" v-show="isShowInsertButton" @click="emits('insert')">新增</button>
                    <button class="btn btn-primary" v-show="!isShowInsertButton" @click="emits('update')">修改</button>
                    <button type="button" class="btn btn-secondary" @click="handleCloseClick">關閉</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import Swal from 'sweetalert2';
import bootstrap from 'bootstrap/dist/js/bootstrap.bundle.min.js';
import axiosapi from '@/plugins/axios';  // 確保你有正確配置 axios

// Props and emits
const props = defineProps(["product", "isShowInsertButton"]);
const emits = defineEmits(["update:product", "insert", "update", "clearImage"]);

// Image preview and interaction tracking
const selectedImage = ref(null);
const imagePreviewUrl = ref('');
const imageInput = ref(null);
const fieldsInteracted = ref(false);

// Modal handling
const exampleModal = ref(null);
const exampleObj = ref(null);
onMounted(() => {
    exampleObj.value = new bootstrap.Modal(exampleModal.value, null);
    fetchCategories();
    fetchStatuses();
});
function showModal() {
    exampleObj.value.show();
}
function hideModal() {
    fieldsInteracted.value = false;
    exampleObj.value.hide();
    clearImage();  // 清除圖片
}
defineExpose({
    showModal,
    hideModal
});

// Handling field interaction
function onFieldInteraction() {
    fieldsInteracted.value = true;
}

// Handle image selection and preview
function onImageSelected(event) {
    const file = event.target.files[0];
    if (file) {
        console.log("圖片已選擇:", file);
        selectedImage.value = file;
        imagePreviewUrl.value = URL.createObjectURL(file);  // 生成預覽 URL
        emits('imageSelected', file);  // 通過 emit 傳遞圖片文件給父組件
    }
}

// Handle modal close with confirmation
function handleCloseClick() {
    // 檢查所有欄位是否為 null 或空值
    const isEmpty = !props.product.productName && !props.product.dailyFeeOriginal &&
        !props.product.maxAvailableQuantity && !props.product.description &&
        !props.product.categoryId && !selectedImage.value;

    if ((props.isShowInsertButton && isEmpty) || (!props.isShowInsertButton && !selectedImage.value && !fieldsInteracted.value)) {
        hideModal();  // 直接關閉模組
    } else {
        const confirmMessage = props.isShowInsertButton ? '確定放棄新增？' : '確定放棄修改？';
        Swal.fire({
            title: confirmMessage,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '確定',
            cancelButtonText: '取消'
        }).then((result) => {
            if (result.isConfirmed) {
                clearImage();
                hideModal();
            }
        });
    }
}

// 清除圖片及 file input 的值
function clearImage() {
    selectedImage.value = null;
    imagePreviewUrl.value = '';
    emits('clearImage');
    if (imageInput.value) {
        imageInput.value.value = '';  // 清空 file input 的值
    }
}

// Format date
function formatDate(utcDateString) {
    if (!utcDateString) return ""; // 防止空值報錯
    const date = new Date(utcDateString);
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, "0");
    const day = String(date.getDate()).padStart(2, "0");
    const hours = String(date.getHours()).padStart(2, "0");
    const minutes = String(date.getMinutes()).padStart(2, "0");

    return `${year}年${month}月${day}日 ${hours}時${minutes}分`;
}

// Fetch categories and statuses
const categories = ref([]);
const statuslist = ref([]);
async function fetchCategories() {
    try {
        const response = await axiosapi.get('/rent/category/find');
        console.log("fetchCategories 成功 response:", response);
        if (response.data) {
            categories.value = response.data;
        } else {
            console.log("fetchCategories 無有效的數據:", response);
        }
    } catch (error) {
        console.log("fetchCategories 發生錯誤:", error);
    }
}
async function fetchStatuses() {
    try {
        const response = await axiosapi.get('/rent/status/find');
        console.log("fetchStatuses 成功 response:", response);
        if (response.data) {
            statuslist.value = response.data;
        } else {
            console.log("fetchStatuses 無有效的數據:", response);
        }
    } catch (error) {
        console.log("fetchStatuses 發生錯誤:", error);
    }
}

</script>

<style></style>