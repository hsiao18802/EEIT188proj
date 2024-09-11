<template>
    <div>
      <h3>產品詳細資訊</h3>
      <div v-if="product">
        <h4>{{ product.name }}</h4>
        <p>價格: {{ product.price }} 台幣/天</p>
        <p>描述: {{ product.description }}</p>
        <p>型號: {{ product.type }}</p>
        <p>不可租借日期: {{ product.unavailableDates.join(', ') }}</p>
        <button @click="addToCart">加入購物車</button>
        <router-link :to="{ name: 'products' }">返回產品列表</router-link>
      </div>
      <div v-else>
        <p>載入中...</p>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import { useRoute } from 'vue-router';
  import axiosapi from '@/plugins/axios';
  
  const route = useRoute();
  const product = ref(null);
  
  async function fetchProduct() {
    try {
      const response = await axiosapi.get(`/api/tent/${route.params.id}`);
      product.value = response.data;
    } catch (error) {
      console.error("Error fetching product:", error);
    }
  }
  
  function addToCart() {
    // 此處添加到購物車的邏輯
  }
  
  onMounted(fetchProduct);
  </script>
  