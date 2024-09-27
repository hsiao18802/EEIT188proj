<template>
    <div ref="exampleModal" class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel" v-show="isShowInsert">新增商品</h1>
                    <h1 class="modal-title fs-5" id="exampleModalLabel" v-show="isShowUpdate">修改商品資料</h1>
                    <h1 class="modal-title fs-5" id="exampleModalLabel" v-show="isShowChangepic">新增商品圖片</h1>
                    <button type="button" class="btn-close" @click="handleCloseClick" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <table>
                        <tr v-show="!isShowInsert">
                            <td>商品編號</td>
                            <td>{{ product.productId }}</td>
                        </tr>
                        <tr>
                            <td>商品名稱</td>
                            <td>
                                <span v-show="isShowChangepic">{{ product.productName }}</span>
                                <input v-show="!isShowChangepic" type="text" name="name" v-model="product.productName" @input="onNameInserted">
                            </td>
                        </tr>
                        <tr v-show="!isShowChangepic">
                            <td>商品價格</td>
                            <td><input type="number" name="price" v-model="product.dailyFeeOriginal"
                                    @input="onFieldInteraction"></td>
                        </tr>
                        <tr v-show="!isShowChangepic">
                            <td>商品庫存</td>
                            <td><input type="number" name="maxQuantity" v-model="product.maxAvailableQuantity"
                                    @input="onFieldInteraction"></td>
                        </tr>
                        <tr v-show="isShowUpdate">
                            <td>現有圖片</td>
                            <td v-if="product.mainPhoto">
                                <img :src="`data:image/jpeg;base64,${product.mainPhoto}`" :alt="product.productName" style="max-width: 100px; max-height: 100px;">
                            </td>
                            <td v-else style="color: red;">
                                沒有圖片，請上傳檔案
                            </td>
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
                        <tr v-show="!isShowChangepic">
                            <td>商品描述</td>
                            <td><textarea name="description" v-model="product.description"
                                    @input="onFieldInteraction"></textarea></td>
                        </tr>
                        <tr v-show="!isShowChangepic">
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
                            <td v-if="isShowInsert">
                                <input type="hidden" name="statusId" v-model="product.statusId">
                                <span>預設為上架，如果不加功能記得要隱藏</span>
                            </td>
                            <td v-else>
                                <select name="statusId" v-model="product.statusId" @input="onFieldInteraction">
                                    <option v-for="status in statuslist" :key="status.statusId"
                                        :value="status.statusId">
                                        {{ status.status }}
                                    </option>
                                </select>
                            </td>
                        </tr>
                        <tr v-show="isShowUpdate">
                            <td>新增員工ID</td>
                            <td><input type="number" name="addEmployeeId" v-model="product.addEmployeeId" readonly></td>
                        </tr>
                        <tr v-show="isShowUpdate">
                            <td>新增日期</td>
                            <td>{{ formatDate(product.addDatetime) }}</td>
                        </tr>
                        <tr v-show="isShowUpdate">
                            <td>最後更新員工ID</td>
                            <td><input type="number" name="lastUpdateEmployeeId" v-model="product.lastUpdateEmployeeId"
                                    readonly></td>
                        </tr>
                        <tr v-show="isShowUpdate">
                            <td>最後更新日期</td>
                            <td>{{ formatDate(product.lastUpdateDatetime) }}</td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" v-show="isShowInsert" @click="handleIAClick" :disabled="isDisabled">新增</button>
                    <button class="btn btn-primary" v-show="isShowUpdate" @click="handleIAClick" :disabled="isDisabled">修改</button>
                    <button class="btn btn-primary" v-show="isShowChangepic" @click="emits('changepic')">上傳圖檔</button>
                    <button type="button" class="btn btn-secondary" @click="handleCloseClick">關閉</button>
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

// Props and emits
const props = defineProps(["product", "isShowInsert", "isShowUpdate", "isShowChangepic"]);
const emits = defineEmits(["update:product", "insert", "update", "clearImage"]);

// Image preview and interaction tracking
const selectedImage = ref(null);
const imagePreviewUrl = ref('');
const imageInput = ref(null);
const fieldsInteracted = ref(false);
const isDisabled = ref(false);

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
    nextTick(() => {
        if (props.isShowInsert) {
            isDisabled.value = true;
        }
    });
}
function hideModal() {
    fieldsInteracted.value = false;
    exampleObj.value.hide();
    clearImage();  // 清除圖片
    isDisabled.value = false;
}
defineExpose({
    showModal,
    hideModal
});

// Handling field interaction
function onFieldInteraction() {
    fieldsInteracted.value = true;
}

function onNameInserted(){
    onFieldInteraction();
    isDisabled.value = false;
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

function handleIAClick(){
    const nameIsEmpty = !props.product.productName;
    const isEmpty = !props.product.dailyFeeOriginal || !props.product.maxAvailableQuantity ||
        !props.product.description || !props.product.categoryId || !(selectedImage.value || props.product.mainPhoto);
    console.log("props.product.mainPhoto = " + props.product.mainPhoto + ", isEmpty  = " + isEmpty);
    if (nameIsEmpty){
        Swal.fire({
            title: '請輸入產品名稱',
            icon: 'error',
            showConfirmButton: false,
            showCancelButton: true,
            cancelButtonText: '確定'
        });
    } else if (isEmpty){
            Swal.fire({
            title: '產品資料尚未完成',
            text: '新增產品至「未上架」？',
            icon: 'question',
            showCancelButton: true,
            confirmButtonText: '確定新增',
            cancelButtonText: '繼續編輯',
        }).then((result) => {
            if (result.isConfirmed) {
                props.product.statusId = 1;
                if (props.isShowInsert){
                    emits('insert');
                } else {
                    emits('update');
        }
            }
        });
    } else {
        if (props.isShowInsert){
            emits('insert');
        } else {
            emits('update');
        }
    }
}

// Handle modal close with confirmation
function handleCloseClick() {
    // 檢查所有欄位是否為 null 或空值
    const isEmpty = !props.product.productName && !props.product.dailyFeeOriginal &&
        !props.product.maxAvailableQuantity && !props.product.description &&
        !props.product.categoryId && !selectedImage.value;
    
    // console.log("props.isShowInsert = " + props.isShowInsert + ", isEmpty = " + isEmpty)
    // console.log("!props.isShowInsert = " + !props.isShowInsert + ", selectedImage.value = " + selectedImage.value + ", fieldsInteracted.value = " + fieldsInteracted.value)

    if ((props.isShowInsert && isEmpty) || (!props.isShowInsert && !selectedImage.value && !fieldsInteracted.value)) {
        hideModal();  // 直接關閉模組
    } else {
        const confirmMessage = props.isShowInsert ? '確定放棄新增？' : props.isShowChangepic ? '確定放棄上傳？' : '確定放棄修改？';
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