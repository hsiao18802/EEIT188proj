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
                            <td><input type="text" name="name" v-model="product.productName"></td>
                        </tr>
                        <tr>
                            <td>價格</td>
                            <td><input type="number" name="price" v-model="product.dailyFeeOriginal"></td>
                        </tr>
                        <tr>
                            <td>庫存量</td>
                            <td><input type="number" name="maxQuantity" v-model="product.maxAvailableQuantity"></td>
                        </tr>
                        <tr>
                            <td>選擇圖片</td>
                            <td><input type="file" accept="image/*" @change="onImageSelected"></td>
                        </tr> 
                        <tr>
                            <td>描述</td>
                            <td><textarea name="description" v-model="product.description"></textarea></td>
                        </tr>
                        <tr>
                            <td>商品分類</td>
                            <td>
                                <select name="categoryId" v-model="product.categoryId">
                                    <option v-for="category in categories" :key="category.categoryId" :value="category.categoryId">
                                    {{ category.categoryId }}：{{ category.categoryName }}
                                    </option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>上架設定</td>
                            <td  v-if="!isShowInsertButton">
                                <select name="statusId" v-model="product.statusId">
                                    <option v-for="status in statuslist" :key="status.statusId" :value="status.statusId">
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
                            <td><input type="number" name="lastUpdateEmployeeId" v-model="product.lastUpdateEmployeeId" readonly></td>
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

    import axiosapi from '@/plugins/axios';  // 確保你有正確配置 axios

const categories = ref([]);  // 儲存後端回傳的分類資料

async function fetchCategories() {
    try {
        const response = await axiosapi.get('/rent/category/find');
        console.log("fetchCategories 成功 response:", response);

        if (response.data) {
            categories.value = response.data;  // 將回傳的資料賦值給 categories
        } else {
            console.log("fetchCategories 無有效的數據:", response);
        }
    } catch (error) {
        console.log("fetchCategories 發生錯誤:", error);
    }
}

const statuslist = ref([]);  // 儲存後端回傳的狀態列表資料

async function fetchStatuses() {
    try {
        const response = await axiosapi.get('/rent/status/find');
        console.log("fetchStatuses 成功 response:", response);

        if (response.data) {
            statuslist.value = response.data;  // 將回傳的資料賦值給 statuslist
        } else {
            console.log("fetchStatuses 無有效的數據:", response);
        }
    } catch (error) {
        console.log("fetchStatuses 發生錯誤:", error);
    }
}

// 在 onMounted 的時候調用該函數
onMounted(() => {
    fetchCategories();
});

onMounted(() => {
    fetchStatuses();
});

</script>

<style>

</style>
