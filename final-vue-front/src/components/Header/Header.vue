<template>
    <header class="header">
      <div class="container">
        <h1 class="title">購物車</h1>
        <div class="cart-info">
          <p>商品數量: {{ totalItems }}</p>
          <router-link to="/cart" class="cart-link">
            前往購物車
          </router-link>
        </div>
      </div>
    </header>
  </template>
  
  <script setup>
  import { computed } from 'vue';
  import { useCartStore } from '../stores/cartStore'; // 假設你使用 pinia 作為狀態管理
  
  const cartStore = useCartStore();
  
  // 計算總商品數量
  const totalItems = computed(() => cartStore.totalItems);
  </script>
  
  <style scoped>
  .header {
    background-color: #f8f9fa;
    padding: 10px 20px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-bottom: 1px solid #ddd;
  }
  
  .title {
    font-size: 24px;
    color: #333;
  }
  
  .cart-info {
    display: flex;
    align-items: center;
  }
  
  .cart-info p {
    margin-right: 20px;
    font-size: 18px;
  }
  
  .cart-link {
    text-decoration: none;
    padding: 10px 15px;
    background-color: #007bff;
    color: white;
    border-radius: 5px;
  }
  
  .cart-link:hover {
    background-color: #0056b3;
  }
  </style>
  