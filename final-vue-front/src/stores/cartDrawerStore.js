// stores/cartDrawerStore.js
import { defineStore } from 'pinia';
import { ref } from 'vue';

export const useCartDrawerStore = defineStore('cartDrawerStore', () => {
    const isDrawerOpen = ref(false);

    const openDrawer = () => {
        isDrawerOpen.value = true;
    };

    const closeDrawer = () => {
        isDrawerOpen.value = false;
    };

    const toggleDrawer = () => {
        isDrawerOpen.value = !isDrawerOpen.value;
    };

    return {
        isDrawerOpen,
        openDrawer,
        closeDrawer,
        toggleDrawer
    };
});
