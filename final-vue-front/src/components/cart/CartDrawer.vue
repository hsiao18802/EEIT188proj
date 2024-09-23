<template>
  <div v-if="showCartDrawer">
    <div class="overlay" @click="toggleCart"></div>

    <div class="cart-drawer">
      <div class="cart-header">
        <h3>My reservation</h3>
        <p>租借日期: {{ rentalStartDate }} 到 {{ rentalEndDate }}</p>
      </div>

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

      <div>
            <label>
              <input
                type="checkbox"
                v-model="selectedServices.delivery1"
                @change="handleServiceSelection(1)"
              />
              大安區店 自取 ($0)
            </label>
            <label>
              <input
                type="checkbox"
                v-model="selectedServices.delivery2"
                :disabled="selectedServices.delivery1"
                @change="handleServiceSelection(2)"
              />
              大安區店 附近 1-20公里內的送貨和取貨 ($300)
            </label>
            <label>
              <input
                type="checkbox"
                v-model="selectedServices.delivery3"
                :disabled="selectedServices.delivery1"
                @change="handleServiceSelection(3)"
              />
              大安區店 附近 20-40公里內的送貨和取貨 ($500)
            </label>
            <label>
              <input type="checkbox" v-model="selectedServices.insurance4" />
              安心保安心用：意外不便險 ($600)
            </label>
          </div>
      

      <div class="cart-footer" v-if="cartList.length > 0">
        <span>🛒共 {{ totalItemCount }} 件商品</span>
        <div class="cart-summary">
          <p>小計: {{ totalPrice }} 元</p>
        </div>
        <div class="footer-buttons">
          
          <v-btn @click="viewCart">查看購物車</v-btn>
          <v-btn @click="checkout">結帳</v-btn>
          <v-btn class="clear-cart-btn"  @click="clearCart">清空購物車</v-btn>
          
        </div>
      </div>
    </div>
  </div>

  <div v-if="!showCartDrawer && shouldShowCartIcon" class="cart-icon" @click="toggleCart">
    <span>🛒</span>
  </div>
</template>

<script setup>
import { computed,ref } from 'vue';
import { useCartStore } from '@/stores/cartStore';

const cartStore = useCartStore();
const showCartDrawer = computed(() => cartStore.showCartDrawer);
const cartList = computed(() => cartStore.cartList);
const rentalStartDate = computed(() => cartStore.rentalStartDate);
const rentalEndDate = computed(() => cartStore.rentalEndDate);


const selectedServices = ref({
  delivery1: false, // 自取
  delivery2: false, // 1-20 公里
  delivery3: false, // 20-40 公里
  insurance4: false, // 意外不便險
});

// 計算選擇服務的總價格
const selectedServicesPrice = computed(() => {
  let total = 0;
  if (selectedServices.value.delivery2) total += 300;
  if (selectedServices.value.delivery3) total += 500;
  if (selectedServices.value.insurance4) total += 600;
  return total;
});
// 計算總小計
const totalPrice = computed(() =>
  cartList.value.reduce((total, item) => total + item.count * item.dailyFeeOriginal, 0) + selectedServicesPrice.value
);

// 當選擇不同服務時，控制互斥邏輯
const handleServiceSelection = (selectedOption) => {
  if (selectedOption === 1) {
    // 如果選擇了自取，禁用 1-20 和 20-40 公里選項
    selectedServices.value.delivery2 = false;
    selectedServices.value.delivery3 = false;
  } else {
    // 如果選擇了 1-20 或 20-40 公里，禁用自取選項
    selectedServices.value.delivery1 = false;
  }
};



const totalItemCount = computed(() =>
  cartList.value.reduce((total, item) => total + item.count, 0)
);

const isCartEmpty = computed(() => cartList.value.length === 0);
const shouldShowCartIcon = computed(() => cartList.value.length > 0);

const toggleCart = () => {
  cartStore.toggleCartDrawer();
};

const viewCart = () => {};
const checkout = () => {};
const minusOne = (productId) => cartStore.minusOne(productId);
const plusOne = (productId) => cartStore.plusOne(productId);
const removeFromCart = (productId) => cartStore.delCart(productId);
const clearCart = () => {
  cartStore.clearCart();
  cartStore.rentalStartDate = null;
  cartStore.rentalEndDate = null;
};
</script>

<style scoped>
.cart-drawer {
  display: flex;
  flex-direction: column; /* 使內容和 footer 垂直排列 */
  position: fixed;
  right: 20px; /* 距離右邊 20px */
  top: 70px; /* 增加頂部邊距 */
  bottom: 30px; /* 增加底部邊距 */
  width: 400px;
  background: white;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2); /* 更柔和的陰影 */
  border-radius: 10px; /* 圓角邊框 */
  padding: 20px;
  z-index: 999;
  overflow: hidden; /* 隱藏超出內容 */
}

/* 在鼠標懸停時強調 */
.cart-drawer:hover {
  transform: scale(1.02); /* 輕微放大效果 */
}

.overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  z-index: 998;
}


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

.cart-content {
  flex: 1;
  margin-bottom: 20px;
  overflow-y: auto;
}

.product-item {
  margin-bottom: 16px;
  padding: 16px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: #f9f9f9;
  display: flex; /* 使用 Flexbox 進行排列 */
  align-items: center; /* 垂直居中 */
}

.product-image img {
  width: 80px; /* 限制圖片寬度 */
  height: auto; /* 自動保持比例 */
  border-radius: 4px; /* 圓角 */
}

.product-info {
  flex: 1; /* 讓產品信息區域填滿剩餘空間 */
  margin-left: 16px; /* 左邊距 */
}

.product-title {
  font-weight: bold;
  font-size: 1.2em; /* 調整字體大小 */
}

.product-details {
  margin: 10px 0;
  font-size: 0.9em; /* 小一點的字體 */
  color: #555; /* 深灰色 */
}

.product-actions {
  display: flex;
  align-items: center; /* 垂直居中 */
  gap: 10px; /* 按鈕間距 */
}

.quantity-btn {
  background-color: #007bff; /* 藍色背景 */
  color: white; /* 白色文字 */
  border: none; /* 去掉邊框 */
  border-radius: 4px; /* 圓角 */
  padding: 5px 10px; /* 內邊距 */
  cursor: pointer; /* 鼠標指針 */
  transition: background-color 0.3s; /* 漸變效果 */
}

.quantity-btn:hover {
  background-color: #0056b3; /* 深藍色 hover */
}

.delete-btn {
  background-color: #dc3545; /* 紅色背景 */
}

.delete-btn:hover {
  background-color: #c82333; /* 深紅色 hover */
}

.cart-footer {
  position: sticky;
  bottom: 0;
  background: white;
  padding: 10px 0;
  z-index: 1000;
  display: flex;
  flex-direction: column; /* 垂直排列 */
  align-items: center; /* 置中對齊 */
  
}

.footer-buttons .v-btn {
  
  background-color: #004d00; /* 墨綠色按鈕背景 */
  color: white; /* 按鈕文字顏色 */
}

.footer-buttons .v-btn:hover {
  width: 100%; /* 按鈕寬度與視窗相同 */

  background-color: #003300; /* 按鈕懸停時的顏色 */
}

.footer-buttons {
  display: flex;
  justify-content: center; /* 水平置中 */
  gap: 10px; /* 按鈕間距 */
  margin-top: 10px; /* 按鈕的上邊距 */
  flex-direction: column; /* 按鈕上下排列 */
  width: 100%; /* 按鈕寬度與視窗相同 */


}


.cart-icon {
  position: fixed;
  bottom: 30px; /* 增加底部邊距 */
  right: 30px; /* 增加右邊距 */
  background-color: #ff9800; /* 背景顏色 */
  color: white; /* 文字顏色 */
  padding: 15px; /* 增加內邊距 */
  border-radius: 50%; /* 圓形 */
  cursor: pointer; /* 鼠標指針 */
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); /* 更明顯的陰影 */
  z-index: 1000;
  font-size: 2em; /* 增加字體大小 */
  transition: transform 0.3s; /* 增加平滑過渡 */
}

.cart-icon:hover {
  transform: scale(1.6); /* 滑鼠懸停時放大效果 */
}




.empty-cart-message {
  color: red;
  font-weight: bold;
  text-align: center;
}

.footer-buttons .clear-cart-btn {
  background-color: #dc3545; /* 紅色背景 */
  color: white; /* 白色文字 */
  transition: background-color 0.3s; /* 漸變效果 */
}

.footer-buttons .clear-cart-btn:hover {
  background-color: #c82333; /* 深紅色 hover */
}

</style>

