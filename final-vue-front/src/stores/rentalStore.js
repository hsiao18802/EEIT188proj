import { defineStore } from 'pinia';
import { ref } from 'vue';

export const useRentalStore = defineStore('rentalStore', () => {
    // 初始化為 Date 物件
    const rentalStartDate = ref(new Date());
    const rentalEndDate = ref(new Date());

    const setRentalDates = (startDate, endDate) => {
        // 確保傳入的日期是 Date 物件
        rentalStartDate.value = new Date(startDate);
        rentalEndDate.value = new Date(endDate);
    };

    return {
        rentalStartDate,
        rentalEndDate,
        setRentalDates
    };
});
