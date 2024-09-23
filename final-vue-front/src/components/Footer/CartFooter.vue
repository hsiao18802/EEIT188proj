<template>
    <div class="cart-footer" v-if="cartList.length > 0">
      <span>🛒共 {{ totalItemCount }} 件商品</span>
      <div class="cart-summary">
        <p>小計: {{ totalPrice }} 元</p>
      </div>
      <div class="footer-buttons">
        <v-btn @click="viewCart">查看購物車</v-btn>
        <v-btn @click="checkout">結帳</v-btn>
        <v-btn color="error" @click="clearCart">清空購物車</v-btn>
      </div>
    </div>
  </template>
  
  <script setup>
  import { computed } from 'vue';
  import { useCartStore } from '@/stores/cartStore';
  
  const cartStore = useCartStore();
  const cartList = computed(() => cartStore.cartList);
  
  const totalPrice = computed(() =>
    cartList.value.reduce((total, item) => total + item.count * item.dailyFeeOriginal, 0)
  );
  
  const totalItemCount = computed(() =>
    cartList.value.reduce((total, item) => total + item.count, 0)
  );
  
  const viewCart = () => {
    // 查看購物車邏輯實作
  };
  
  const checkout = () => {
    // 結帳邏輯實作
  };
  
  const clearCart = () => {
    cartStore.clearCart();
    cartStore.rentalStartDate = null;
    cartStore.rentalEndDate = null;
  };
  </script>
  
  <style scoped>
.cart-footer {
  position: sticky; /* 固定在底部 */
  bottom: 0;
  background: white;
  padding: 10px;
  z-index: 1000; /* 確保在產品列表上方 */
  display: flex; /* 使用 Flexbox */
  justify-content: space-between; /* 均勻分配空間 */
}

.cart-footer v-btn {
  flex: 1; /* 每個按鈕都佔相同的空間 */
  margin: 0 5px; /* 按鈕之間的間距 */
}

.cart-footer {
  position: sticky; /* 固定在底部 */
  bottom: 0;
  background: white;
  padding: 10px 0;
  z-index: 1000; /* 確保在其他元素之上 */
  display: flex; /* 使用 Flexbox */
  justify-content: space-between; /* 均勻分配空間 */
}

  </style>
  