<template>
    <div ref="exampleModal" class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                                <!-- <th scope="col">分類順序</th> -->
                                <th scope="col">調整順序</th>
                                <th scope="col">分類名稱</th>
                                <th scope="col">修改刪除</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(category, index) in sortedCategories" :key="category.categoryId">
                                <!-- 調整順序 -->
                                <td><i class="fas fa-bars"></i></td>
                                
                                <!-- 根據是否處於編輯狀態來切換顯示 input 或文本 -->
                                <td scope="row">
                                    <template v-if="editIndex === index">
                                        <input type="text" v-model="categoryEditName" @keydown.enter.prevent="submitEdit(category)" />
                                    </template>
                                    <template v-else>
                                        {{ category.categoryName }}
                                    </template>
                                </td>
                                
                                <!-- 按鈕區 -->
                                <td>
                                    <div class="btn-group col text-end">
                                        <template v-if="editIndex === index">
                                            <a class="btn btn-success" @click="submitEdit(category)">送出</a>
                                            <a class="btn btn-secondary" @click="cancelEdit">放棄</a>
                                        </template>
                                        <template v-else>
                                            <a class="btn btn-primary" @click="startEdit(index, category)">修改</a>
                                            <a class="btn btn-danger" @click="emits('catDelete', category.categoryId)">刪除</a>
                                        </template>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted, computed  } from 'vue';
import bootstrap from 'bootstrap/dist/js/bootstrap.bundle.min.js';
import Swal from 'sweetalert2';
import axiosapi from '@/plugins/axios';  // 確保你有正確配置 axios

// // Props and emits
const props = defineProps(["categories"]);
const emits = defineEmits(['update:categories, catDelete, catUpdate']);

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

// 定義一個 computed 來根據 displaySequence 排序 categories
const sortedCategories = computed(() => {
    return props.categories.slice().sort((a, b) => a.displaySequence - b.displaySequence);
});

// 追蹤當前處於編輯狀態的分類
const editIndex = ref(null);  // 用於存儲當前編輯的行的索引
const categoryEditName = ref("");  // 用於存儲當前編輯的分類名稱

// 開始編輯
function startEdit(index, category) {
    editIndex.value = index;
    categoryEditName.value = category.categoryName;

    // 將當前正在編輯的 category 賦值給 category
    category.value = { ...category };  // 確保 category.value 被正確賦值
}


// 取消編輯
function cancelEdit() {
    editIndex.value = null;
    categoryEditName.value = "";
}

// 提交編輯
function submitEdit(category) {
    console.log("(submitEdit(1)) category.value.categoryId: ", category.value.categoryId);
    console.log("(submitEdit(1)) category.value.categoryName: ", category.value.categoryName);
    // 明確賦值修改後的 categoryName
    category.value.categoryName = categoryEditName.value;

    console.log("(submitEdit(2)) category.value.categoryId: ", category.value.categoryId);
    console.log("(submitEdit(2)) category.value.categoryName: ", category.value.categoryName);

    // 發送更新後的 category
    emits('catUpdate', { ...category.value });
    cancelEdit();
}
</script>

<style scoped>
    .fa-bars {
        cursor: move;
    }

    table td {
    vertical-align: middle;
    }
    
</style>