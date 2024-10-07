<template>
    <div class="product-section">
      <div class="image-container">
        <img :src="imageSrc" alt="Product Image" class="product-image" />
      </div>
      <div class="text-container">
        <h2>{{ title }}</h2>
        <p>{{ description }}</p>
        <router-link :to="link" class="cta-button">{{ buttonText }}</router-link>
      </div>
    </div>
  </template>
  
  <script setup>
  defineProps({
    title: String,
    description: String,
    imageSrc: String,
    buttonText: String,
    link: String,
  });
  </script>
  
  <style scoped>
  .product-section {
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
    margin: 20px;
  }
  
  .image-container {
    width: 100%;
    height: 200px; /* 可以根據需要調整 */
  }
  
  .product-image {
    width: 100%;
    height: 100%;
    object-fit: cover; /* 保持圖片比例 */
  }
  
  .text-container {
    margin-top: 15px;
  }
  
  .cta-button {
    display: inline-block;
    padding: 10px 20px;
    background-color: #007bff;
    color: white;
    text-decoration: none;
    border-radius: 5px;
    margin-top: 10px;
  }
  </style>
  