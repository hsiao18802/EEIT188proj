<template>
    <div v-for="cartItem in cartList" :key="cartItem.productId">
      <p>{{ cartItem.productName }}</p>
      <p>{{ cartItem.dailyFeeOriginal }}</p>
      <img :src="cartItem.mainPhotoBase64" alt="Product Image" v-if="cartItem.mainPhotoBase64" />
      <img src="/NoPic256.jpg" alt="Default Image" v-else />
    </div>
  </template>
  
  <script setup>
  import { useCartStore } from '@/stores/cartStore';
  import { ref } from 'vue';
  
  const cartStore = useCartStore();
  const cartList = ref(cartStore.cartList);
  
  // 調試用
  console.log('Initial cartList:', JSON.parse(JSON.stringify(cartList.value)));
  </script>
  