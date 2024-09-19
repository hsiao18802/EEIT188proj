<!-- components/RentalDates.vue -->
<template>
    <v-card>
        <v-card-text>
            <v-form>
                <v-date-picker v-model="localStartDate" label="租借開始時間" @input="updateStartDate" />
                <v-date-picker v-model="localEndDate" label="租借結束時間" @input="updateEndDate" />
            </v-form>
        </v-card-text>
    </v-card>
</template>

<script setup>
import { ref, watch, defineProps, defineEmits } from 'vue';
import { useRentalStore } from '@/stores/rentalStore';

// 從 props 接收預設值
const props = defineProps({
    initialStartDate: String,
    initialEndDate: String
});

// 定義 emit 事件
const emit = defineEmits(['update-rental-dates']);

// 初始化租借日期
const localStartDate = ref(props.initialStartDate);
const localEndDate = ref(props.initialEndDate);

// 監控日期變更
watch(localStartDate, (newVal) => {
    emit('update-rental-dates', { startDate: newVal, endDate: localEndDate.value });
});

watch(localEndDate, (newVal) => {
    emit('update-rental-dates', { startDate: localStartDate.value, endDate: newVal });
});

// 更新開始日期
const updateStartDate = (date) => {
    localStartDate.value = date;
};

// 更新結束日期
const updateEndDate = (date) => {
    localEndDate.value = date;
};
</script>

<style scoped>
.rental-dates {
    margin-bottom: 20px;
}
</style>