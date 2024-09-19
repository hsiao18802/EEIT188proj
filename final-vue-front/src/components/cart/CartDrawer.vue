<template>
  <div v-if="showCartDrawer">

    <!-- 半透明遮罩，點擊時關閉購物車 -->
    <div class="overlay" @click="toggleCart"></div>

    <!-- 購物車側邊欄 -->
    <div class="cart-drawer">
      <!-- 產品列表 -->
      <div class="cart-content">
        <div v-for="product in cartList" :key="product.productId" class="product-item">
          
          <!-- 產品圖片 -->
          <div class="product-image">
            <img :src="product.mainPhoto" alt="product image" />
          </div>

          <!-- 產品名稱與詳情 -->
          <div class="product-info">
            <!-- 產品名稱 -->
            <div class="product-title">{{ product.productName }}</div>

            <!-- 產品租借天數與單價 -->
            <div class="product-details">
              單價: ${{ product.dailyFeeOriginal }} / 每日
              <br />
              租借數量: {{ product.count }}
              <br />
              小計: ${{ product.dailyFeeOriginal * product.count }}
            </div>

            <!-- 數量操作按鈕 -->
            <div class="product-actions">
              <button class="quantity-btn" @click="minusOne(product.productId)">-</button>
              <span>{{ product.count }}</span>
              <button class="quantity-btn" @click="plusOne(product.productId)">+</button>
              <!-- 刪除按鈕 -->
              <button class="quantity-btn delete-btn" @click="removeFromCart(product.productId)">刪除</button>
            </div>
          </div>
        </div>
      </div>

      <!-- 小計 -->
      <div class="cart-summary" v-if="cartList.length > 0">
        <p>小計: {{ totalPrice }} 元</p>
      </div>

      <!-- 按鈕 -->
      <div class="cart-footer">
        <v-btn @click="viewCart">查看購物車</v-btn>
        <v-btn @click="checkout">結帳</v-btn>
        <!-- 清空購物車按鈕 -->
        <v-btn color="error" @click="clearCart">清空購物車</v-btn>
      </div>
    </div>
  </div>

  <!-- 購物車圖示 -->
  <div v-if="shouldShowCartIcon" class="cart-icon" @click="toggleCart">
    <span>🛒</span>
  </div>
</template>




<script setup>
import { computed, onMounted, watch } from 'vue';
import { useCartStore } from '@/stores/cartStore';
import { useRentalStore } from '@/stores/rentalStore';
import useUserStore from '@/stores/user.js';

const userStore = useUserStore();

// 引入 Pinia store
const cartStore = useCartStore();
const rentalStore = useRentalStore();

// 控制購物車顯示
const showCartDrawer = computed(() => cartStore.showCartDrawer);
// 購物車列表
const cartList = computed(() => cartStore.cartList);
// 計算總價
/*
const totalPrice = computed(() =>
  cartList.value.reduce((total, item) => total + item.count * item.dailyFeeOriginal, 0)
);
*/

onMounted(() => {
  cartStore.updateNewList(); // 初始化時就確保加載購物車數據
  console.log('購物車內容:', cartStore.cartList.value); // 查看購物車是否有數據
});

watch(showCartDrawer, (newVal) => {
  if (newVal && cartList.value.length === 0) {
    // cartStore.loadCartFromLocalStorage(); // 確保打開時能正確加載數據
  }
});

// 是否顯示購物車圖示 (登入且購物車有商品)
const shouldShowCartIcon = computed(() => {
  return userStore.isLogin && cartList.value.length > 0;
});

// 號租借時間
const rentalStartDate = computed(() => rentalStore.rentalStartDate);
const rentalEndDate = computed(() => rentalStore.rentalEndDate);

// 處理租借時間更新
const handleRentalDatesUpdate = ({ startDate, endDate }) => {
  rentalStore.setRentalDates(startDate, endDate);
};

// 顯示或隱藏購物車小視窗
const toggleCart = () => {
  cartStore.toggleCartDrawer();
};

// 查看購物車
const viewCart = () => {
  // 查看購物車邏輯實作
};

// 結帳邏輯
const checkout = () => {
  // 結帳邏輯實作
};

// 數量增減方法
const minusOne = (productId) => {
  cartStore.minusOne(productId);
};

const plusOne = (productId) => {
  cartStore.plusOne(productId);
};

// 移除購物車中的產品
const removeFromCart = (productId) => {
  cartStore.delCart(productId);
};

// 清空購物車
const clearCart = () => {
  cartStore.clearCart();
};



</script>

<style scoped>
.overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  z-index: 998;
}

.cart-drawer {
  position: fixed;
  right: 0;
  top: 0;
  width: 300px;
  height: 100%;
  background: white;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  padding: 20px;
  z-index: 999;
  overflow-y: auto;
}

.cart-content {
  margin-bottom: 20px;
}

.product-item {
  margin-bottom: 16px;
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

.cart-summary {
  margin-bottom: 20px;
}

.cart-footer {
  display: flex;
  justify-content: space-between;
}

.cart-icon {
  position: fixed;
  bottom: 20px;
  right: 20px;
  background-color: #ff9800;
  color: white;
  padding: 10px;
  border-radius: 50%;
  cursor: pointer;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
  z-index: 1000;
}
</style>
