<template>
    <div class="cart-content">
      <div v-for="product in cartList" :key="product.productId" class="product-item">
        <div class="product-image">
          <img :src="product.mainPhoto" alt="product image" />
        </div>
        <div class="product-info">
          <div class="product-title">{{ product.productName }}</div>
          <div class="product-details">
            單價: ${{ product.dailyFeeOriginal }} / 每日
            <br />
            租借數量: {{ product.count }}
            <br />
            小計: ${{ product.dailyFeeOriginal * product.count }}
          </div>
          <div class="product-actions">
            <button class="quantity-btn" @click="minusOne(product.productId)">-</button>
            <span>{{ product.count }}</span>
            <button class="quantity-btn" @click="plusOne(product.productId)">+</button>
            <button class="quantity-btn delete-btn" @click="removeFromCart(product.productId)">刪除</button>
          </div>
        </div>
      </div>
      <div v-if="isCartEmpty" class="empty-cart-message">
        購物車是空的
      </div>
    </div>
  </template>
  
  <script setup>
  import { computed } from 'vue';
  import { useCartStore } from '@/stores/cartStore';
  
  const cartStore = useCartStore();
  const cartList = computed(() => cartStore.cartList);
  const isCartEmpty = computed(() => cartList.value.length === 0);
  
  const minusOne = (productId) => {
    cartStore.minusOne(productId);
  };
  
  const plusOne = (productId) => {
    cartStore.plusOne(productId);
  };
  
  const removeFromCart = (productId) => {
    cartStore.delCart(productId);
  };
  </script>
  
  <style scoped>
 .cart-content {
  flex: 1; /* 使其填滿剩餘空間 */
  overflow-y: auto; /* 允許垂直滾動 */
  margin-bottom: 20px; /* 留出空間給 footer */
}



.product-item {
  margin-bottom: 16px;
  padding: 16px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: #f9f9f9;
}

.product-title {
  font-weight: bold;
}

.product-details {
  margin: 10px 0;
}

.product-actions {
  display: flex;
  gap: 8px;
}


.quantity-btn {
  background-color: #f0f0f0;
  border: 1px solid #ccc;
  border-radius: 4px;
  padding: 5px 10px;
  cursor: pointer;
  font-size: 16px;
  line-height: 1;
}

  </style>
  