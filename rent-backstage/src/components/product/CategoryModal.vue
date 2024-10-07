<template>
    <div ref="exampleModal" class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-2" id="exampleModalLabel">分類管理</h1>
                    <button type="button" class="btn-close" @click="closeModalWithCheck" aria-label="Close"></button>
                </div>
                <div class="modal-body">

                    <!-- 渲染表格 -->
                    <table class="table" v-if="sortedCategories.length > 0">
                        <thead>
                            <tr>
                                <!-- 開啟拖曳按鈕 -->
                                <th scope="col">
                                    <template v-if="isDragging">
                                        <!-- 送出與捨棄按鈕 -->
                                        <div class="btn-group">
                                            <button class="btn btn-success" @click="submitDrag">送出</button>
                                            <button class="btn btn-secondary" @click="cancelDrag">捨棄</button>
                                        </div>
                                    </template>
                                    <template v-else>
                                        <!-- 拖曳調整按鈕 -->
                                        <button type=" button" class="btn btn-success"
                                            @click="emitAddCategory">新增分類</button><br>
                                        <button class="btn btn-primary" @click="startDrag">拖曳調整</button>
                                    </template>
                                </th>
                                <th scope="col">分類名稱</th>
                                <th scope="col">商品數量</th>
                                <th scope="col">修改刪除</th>
                            </tr>
                        </thead>
                        <draggable v-model="sortedCategories" tag="tbody" handle=".fa-bars" :disabled="!isDragging">
                            <template #item="{ element, index }">
                                <tr :class="{ 'table-secondary fst-italic': categoryCount[element.categoryId] === 0 }">
                                    <td>
                                        <i class="fas fa-bars"></i>
                                    </td>
                                    <td>
                                        <template v-if="editIndex === index">
                                            <input type="text" v-model="categoryEditName"
                                                @keydown.enter.prevent="submitEdit(element)" />
                                        </template>
                                        <template v-else>
                                            {{ element.categoryName }}
                                        </template>
                                    </td>
                                    <td>
                                        {{ categoryCount[element.categoryId] }}
                                    </td>
                                    <td>
                                        <div class="btn-group col">
                                            <template v-if="editIndex === index">
                                                <a class="btn btn-success" @click="submitEdit(element)">送出</a>
                                                <a class="btn btn-secondary" @click="cancelEdit">取消</a>
                                            </template>
                                            <template v-else>
                                                <a class="btn btn-primary" @click="startEdit(index, element)">修改</a>
                                                <a class="btn btn-danger"
                                                    @click="emitDeleteCategory(element.categoryId)">刪除</a>
                                            </template>
                                        </div>
                                    </td>
                                </tr>
                            </template>
                        </draggable>

                    </table>

                    <!-- 渲染錯誤時顯示提示 -->
                    <div v-else>
                        <p>無法加載分類數據，請稍後再試。</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted, watch } from 'vue';
import bootstrap from 'bootstrap/dist/js/bootstrap.bundle.min.js';
import Swal from 'sweetalert2';
import axiosapi from '@/plugins/axios';
import draggable from 'vuedraggable';

// Props and emits
const props = defineProps(["categories"]);
const emits = defineEmits(['update:categories', 'catDelete', 'catUpdate', 'callFetchRearrange']);

// Modal handling
const exampleModal = ref(null);
const exampleObj = ref(null);

// 排序後的 categories 列表
const sortedCategories = ref([]);
const categoryCount = ref({}); // 存放分類對應的數量

// 拖曳狀態
const isDragging = ref(false);

// 初始化
onMounted(() => {
    exampleObj.value = new bootstrap.Modal(exampleModal.value, null);
    if (props.categories && props.categories.length > 0) {
        sortedCategories.value = props.categories.slice().sort((a, b) => a.displaySequence - b.displaySequence);
        fetchCategoryCount();
    } else {
        console.warn('No categories data received');
    }
});

// 監聽 categories 變動，確保數據動態更新
watch(() => props.categories, (newCategories) => {
    if (newCategories && newCategories.length > 0) {
        sortedCategories.value = newCategories.slice().sort((a, b) => a.displaySequence - b.displaySequence);
        fetchCategoryCount();  // 當分類改變時重新獲取數量
    }
});

// 從後端獲取每個分類的數量
const fetchCategoryCount = async () => {
    try {
        const categoryList = sortedCategories.value; // 使用當前的分類列表

        // 遍歷每個分類，並獲取對應的產品數量
        for (const category of categoryList) {
            try {
                // 發送請求來獲取對應分類的產品數量
                const countResponse = await axiosapi.get(`/rent/product/countByCategory/${category.categoryId}`);
                const productCount = countResponse.data;

                // 將分類與對應的產品數量一起存儲到 categoryCount 對應的分類 ID 中
                categoryCount.value[category.categoryId] = productCount;
            } catch (countError) {
                console.error(`獲取分類 ${category.categoryName} 的產品數量失敗：`, countError);
                // 如果請求失敗，數量設為 0
                categoryCount.value[category.categoryId] = 0;
            }
        }
    } catch (error) {
        console.error('獲取分類數量失敗：', error);
    }
};

// 檢查拖曳或編輯是否正在進行
function checkPendingActions(actionCallback) {
    if (isDragging.value || editIndex.value !== null) {
        Swal.fire({
            title: '操作未完成',
            text: '請先儲存您的排序或修改操作，再進行其他操作。',
            icon: 'warning',
            confirmButtonColor: '#3085d6',
            confirmButtonText: '確定'
        });
    } else {
        actionCallback(); // 執行你原本要做的動作
    }
}

// 其他功能邏輯（例如編輯、拖曳、送出等保持不變）
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

// 追蹤當前處於編輯狀態的分類
const editIndex = ref(null);
const categoryEditName = ref("");
const originalCategoryName = ref("");  // 用來保存原始的分類名稱

// 開始編輯
function startEdit(index, category) {
    checkPendingActions(() => {
        editIndex.value = index;
        categoryEditName.value = category.categoryName;  // 設置當前編輯名稱
        originalCategoryName.value = category.categoryName;  // 保存原始名稱，用來比較
    });
}

// 提交編輯
function submitEdit(category) {
    category.categoryName = categoryEditName.value; // 更新分類名稱
    emits('catUpdate', category); // 發送更新事件
    clearEditState();
}

// 取消編輯
function cancelEdit() {
    if (categoryEditName.value !== originalCategoryName.value) {
        Swal.fire({
            title: '未保存的更改',
            text: '您有未保存的更改，確定要放棄編輯嗎？',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '確定放棄',
            cancelButtonText: '繼續編輯'
        }).then((result) => {
            if (result.isConfirmed) {
                clearEditState();
            }
        });
    } else {
        clearEditState();
    }
}

// 清除編輯狀態
function clearEditState() {
    editIndex.value = null;
    categoryEditName.value = "";
    originalCategoryName.value = "";
}

// 開始拖曳排序
function startDrag() {
    checkPendingActions(() => {
        isDragging.value = true;
    });
}

// 取消拖曳
function cancelDrag() {
    Swal.fire({
        title: '確認取消',
        text: '您確定要放棄目前的排序更改嗎？',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: '確定放棄',
        cancelButtonText: '繼續調整'
    }).then((result) => {
        if (result.isConfirmed) {
            sortedCategories.value = props.categories.slice().sort((a, b) => a.displaySequence - b.displaySequence);
            isDragging.value = false;
        }
    });
}

// 送出拖曳結果
function submitDrag() {
    const newOrder = sortedCategories.value.map((category, index) => ({
        categoryId: category.categoryId,
        displaySequence: index + 1 // 更新順序
    }));

    axiosapi.post('/rent/category/rearrange', newOrder)
        .then(response => {
            Swal.fire('成功', '順序已更新', 'success');
            // 更新完成後重新加載分類數據
            emits('callFetchRearrange');
            fetchCategories();  // 在這裡重新獲取最新數據
            isDragging.value = false;
        })
        .catch(error => {
            Swal.fire('錯誤', '更新失敗，請重試', 'error');
        });
}

// 從後端獲取最新分類數據
function fetchCategories() {
    axiosapi.get('/rent/category/find')
        .then(response => {
            sortedCategories.value = response.data.slice().sort((a, b) => a.displaySequence - b.displaySequence);
        })
        .catch(error => {
            console.error('獲取分類失敗：', error);
        });
}

// // 新增分類
function emitAddCategory() {
    checkPendingActions(() => {
        emits('add-category'); // 觸發 'add-category' 事件，讓父組件來處理新增
    });
}

// 刪除分類
function emitDeleteCategory(categoryId) {
    checkPendingActions(() => {
        emits('catDelete', categoryId); // 觸發 'catDelete' 事件，讓父組件來處理刪除
    });
}

function closeModalWithCheck() {
    if (isDragging.value || editIndex.value !== null) {
        Swal.fire({
            title: '操作未完成',
            text: '您有未保存的排序或修改操作，是否要離開？',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: '離開',
            cancelButtonText: '繼續編輯'
        }).then((result) => {
            if (result.isConfirmed) {
                clearEditState(); // 清除當前編輯狀態
                isDragging.value = false; // 結束拖曳狀態
                hideModal(); // 關閉組件
            }
        });
    } else {
        hideModal(); // 如果沒有未保存的操作，直接關閉
    }
}

</script>

<!-- // 
// 3.如果排序 / 修改正在進行，就打叉叉的話，要跳提示問說是要捨棄編輯進度還是繼續編輯 -->
<style scoped>
.fa-bars {
    cursor: grab;
}

table td {
    vertical-align: middle;
}
</style>
