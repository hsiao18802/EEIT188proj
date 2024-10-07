<template>
    <div>
        <span v-if="total > 0">查到{{ total }}筆資料，</span>
        <span v-else>查無資料，</span>
        每頁顯示
        <select :value="modelValue" @change="onMaxChange">
            <option v-for="option in options" :key="option" :value="option">{{ option }}</option>
        </select>筆

        <!-- 狀態選單 -->
        <select v-model="selectedStatusId" @change="onStatusChange">
            <option value="">所有狀態</option> <!-- 預設選項：所有狀態 -->
            <option v-for="status in sortedStatuses" :key="status.statusId" :value="status.statusId">
                {{ status.status }} <!-- 這裡改成 status 而不是 statusName -->
            </option>
        </select>
        <!-- 分類選單 -->
        <select v-model="selectedCategoryId" @change="onCategoryChange">
            <option value="">全部分類</option> <!-- 預設選項：所有分類 -->
            <option v-for="category in sortedCategories" :key="category.categoryId" :value="category.categoryId">
                {{ category.categoryName }}
            </option>
        </select>

    </div>
</template>


<script setup>
import { ref, onMounted } from 'vue';
import axiosapi from '@/plugins/axios';

const props = defineProps(["total", "options", "modelValue"]);
const emits = defineEmits(["maxChange", "update:modelValue", "categoryChange", "statusChange"]);

// 儲存分類資料和狀態資料
const sortedCategories = ref([]);
const sortedStatuses = ref([]);
const selectedCategoryId = ref("");
const selectedStatusId = ref("");

// 取得分類資料
async function fetchCategories() {
    try {
        const response = await axiosapi.get('/rent/category/find');
        if (response.data) {
            // 將分類進行排序
            sortedCategories.value = response.data.slice().sort((a, b) => a.displaySequence - b.displaySequence);
        } else {
            console.log("fetchCategories 無有效的數據:", response);
        }
    } catch (error) {
        console.log("fetchCategories 發生錯誤:", error);
    }
}

// 取得狀態資料
async function fetchStatuses() {
    try {
        const response = await axiosapi.get('/rent/status/find');
        console.log("fetchStatuses response:", response);  // 檢查返回的內容
        if (response.data) {
            sortedStatuses.value = response.data;
            console.log("statuslist:", sortedStatuses.value);  // 確認狀態數據是否正確
        } else {
            console.log("fetchStatuses 無有效的數據:", response);
        }
    } catch (error) {
        console.log("fetchStatuses 發生錯誤:", error);
    }
}

// 呼叫父組件事件來更新每頁顯示的數量
function onMaxChange(event) {
    emits('update:modelValue', event.target.value);
    emits('maxChange');
}

// 呼叫父組件事件來更新選中的分類
function onCategoryChange() {
    emits('categoryChange', selectedCategoryId.value);
}

// 呼叫父組件事件來更新選中的狀態
function onStatusChange() {
    emits('statusChange', selectedStatusId.value);
}

// 初次載入時取得分類和狀態資料
onMounted(() => {
    fetchCategories();
    fetchStatuses();
});
</script>
