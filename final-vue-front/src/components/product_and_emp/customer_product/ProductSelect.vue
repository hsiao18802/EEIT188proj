<template>
    <span>共{{ total }}筆資料，</span>
    <span class="d-inline-flex align-items-center">
        每頁顯示
        <select :value="modelValue" @change="dochange" class="form-select mx-2 shadow1" style="width: auto;">
            <option v-for="option in options" :key="option" :value="option">{{ option }}</option>
        </select>
        筆
    </span>
</template>
    
<script setup>
    const props = defineProps(["total", "options", "modelValue"])
    const emits = defineEmits(["maxChange", "update:modelValue"])
    function dochange(event) {
        emits('update:modelValue', event.target.value);
        emits('maxChange');
    }
</script>
    
<style>
      /* 調整陰影 */
  .shadow1 {
    box-shadow: 0 1px 1.5px rgba(0, 0, 0, 0.5); /* 給輸入框和按鈕加上陰影 */
  }
</style>