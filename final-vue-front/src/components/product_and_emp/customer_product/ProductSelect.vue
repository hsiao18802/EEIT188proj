<template>
    <!-- <span v-if="total>0">查到{{ total }}筆資料，</span>
    <span v-else>查無資料，</span> -->
    每頁顯示
    <select :value="modelValue" @change="dochange">
        <option v-for="option in options" :key="option" :value="option">{{option}}</option>
    </select>筆
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
    
</style>