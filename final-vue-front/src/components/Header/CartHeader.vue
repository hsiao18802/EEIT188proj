<template>
<div class="cart-header">
        <h3>My reservation</h3>
      </div>

<script setup>
import { computed } from 'vue';
import { useCartStore } from '@/stores/cartStore';

const cartStore = useCartStore();
const cartList = computed(() => cartStore.cartList);
const rentalStartDate = computed(() => cartStore.rentalStartDate);
const rentalEndDate = computed(() => cartStore.rentalEndDate);
</script>

<style scoped>
.cart-header {
  background-color: #004d00; /* 墨綠色背景 */
  color: white; /* 文字顏色為白色 */
  padding: 10px; /* 上下內邊距 */
  text-align: center; /* 文字置中 */
  position: sticky;
  top: 0;
  z-index: 1000;
  padding: 10px 0;
}

</style>
