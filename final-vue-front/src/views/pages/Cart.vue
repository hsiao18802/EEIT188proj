
<template>
  <div class="cart-page">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <div v-if="!isCartEmpty" class="cart-header">
      <h3>購物車確認</h3>
      <div class="rental-dates-card" @click="!rentalStartDate && !rentalEndDate ? showDatePicker = true : null">
        <div class="rental-date rental-start">
          <p>開始日期</p>
          <p>{{ formattedRentalStartDate }}</p>
        </div>
        <div class="rental-date rental-end">
          <div class="rental-date rental-gap"></div>
          <p>結束日期</p>
          <p>{{ formattedRentalEndDate }}</p>
        </div>
      </div>
      <p class="rental-days">共 {{ rentalDays }} 天</p>
    </div>



    <div class="cart-content">
      <div v-if="isCartEmpty" class="empty-cart-message">
        購物車無物品
      </div>
      <div v-else>
        <h4 class="rental-content-title">租借內容</h4>
        <div v-for="product in cartStore.sortedCartList" :key="product.cartId" class="product-item">
          <div class="product-image">
            <img :src="product.mainPhoto" alt="產品圖片" />
          </div>
          <div class="product-info">
            <div class="product-title">{{ product.productName }}</div>
          </div>
          <div class="product-details">
            <div class="product-price">單價: ${{ product.dailyFeeOriginal }} / 每日</div>
            <div class="product-actions">
              <button class="quantity-btn delete-btn" @click="removeFromCart(product.productId)">
                <i class="fas fa-trash"></i>
              </button>
              <button class="quantity-btn" @click="minusOne(product.productId)">-</button>
              <v-chip>{{ product.count }}</v-chip>
              <button class="quantity-btn" @click="plusOne(product.productId)">+</button>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="service-summary" v-if="!isCartEmpty">
      <div class="service-card">
        <h3>加價服務</h3>
        <label>
          <input
            type="checkbox"
            v-model="selectedServices.delivery1"
            @change="handleServiceSelection(1)"
          />
          大安區店 上門自取 ($0)*請注意營業時間
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

      <div class="summary-card">
        <div class="cart-summary">
          <p>小計: {{ totalPrice }} 元</p>
        </div>
        <div class="footer-buttons">
          <v-btn @click="checkout">結帳</v-btn>
          <v-btn @click="continueShopping">繼續購物</v-btn>
        </div>
      </div>
    </div>

    <CartIcon v-if="!isCartPage" />

    <!-- 日期選擇模態框 -->
    <v-dialog v-model="showDatePicker" max-width="500px">
      <v-card>
        <v-card-title>選擇租借日期</v-card-title>
        <v-card-text>
          <v-row>
            <v-col>
              <v-date-picker v-model="selectedStartDate" label="開始日期"></v-date-picker>
            </v-col>
            <v-col>
              <v-date-picker v-model="selectedEndDate" label="結束日期"></v-date-picker>
            </v-col>
          </v-row>
        </v-card-text>
        <v-card-actions>
          <v-btn text @click="showDatePicker = false">取消</v-btn>
          <v-btn color="primary" @click="updateRentalDates">確定</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>




<script setup>
import { computed, ref,watch } from 'vue';
import { useCartStore } from '@/stores/cartStore';
import { useRouter } from 'vue-router';
import dayjs from 'dayjs'; // 引入 dayjs 函式庫 算天數




// 計算租借天數
const rentalDays = computed(() => {
  if (rentalStartDate.value && rentalEndDate.value) {
    const start = new Date(rentalStartDate.value);
    const end = new Date(rentalEndDate.value);
    const diffTime = Math.abs(end - start);
    return Math.ceil(diffTime / (1000 * 60 * 60 * 24)); // 轉換為天數
  }
  return 0; // 如果日期未定義，則返回0
});

const cartStore = useCartStore();
const router = useRouter();

const isCartPage = computed(() => {
  return router.currentRoute.value.name === 'Cart'; // 確保路由名稱正確
});

const cartList = computed(() => cartStore.cartList);
const rentalStartDate = computed(() => cartStore.rentalStartDate);
const rentalEndDate = computed(() => cartStore.rentalEndDate);

// 彈出視窗的狀態
const showDateModal = ref(false);
const newStartDate = ref(rentalStartDate.value);
const newEndDate = ref(rentalEndDate.value);

// 新增狀態管理日期選擇器
const showDatePicker = ref(false);
const selectedStartDate = ref(rentalStartDate.value);
const selectedEndDate = ref(rentalEndDate.value);

watch(rentalStartDate, (newValue) => {
  selectedStartDate.value = newValue;
});

watch(rentalEndDate, (newValue) => {
  selectedEndDate.value = newValue;
});

// 格式化日期
const formattedRentalStartDate = computed(() => {
  return rentalStartDate.value ? dayjs(rentalStartDate.value).format('YYYY-MM-DD') : '';
});

const formattedRentalEndDate = computed(() => {
  return rentalEndDate.value ? dayjs(rentalEndDate.value).format('YYYY-MM-DD') : '';
});

// 更新日期
const updateDates = () => {
  cartStore.rentalStartDate = newStartDate.value;
  cartStore.rentalEndDate = newEndDate.value;
  showDateModal.value = false;
};

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
  cartList.value.reduce((total, item) => total + item.count * item.dailyFeeOriginal * rentalDays.value, 0) + selectedServicesPrice.value
);

const totalItemCount = computed(() =>
  cartList.value.reduce((total, item) => total + item.count, 0)
);

const isCartEmpty = computed(() => cartList.value.length === 0);

const handleServiceSelection = (selectedOption) => {
  if (selectedOption === 1) {
    selectedServices.value.delivery2 = false;
    selectedServices.value.delivery3 = false;
  } else {
    selectedServices.value.delivery1 = false;
  }
};

const minusOne = (productId) => cartStore.minusOne(productId);
const plusOne = (productId) => cartStore.plusOne(productId);
const removeFromCart = (productId) => cartStore.delCart(productId);
const clearCart = () => {
  cartStore.clearCart();
  cartStore.rentalStartDate = null;
  cartStore.rentalEndDate = null;
};

const continueShopping = () => {
  router.push('/productpage'); // 返回主頁或產品列表頁面
};

const checkout = () => {
  // 這裡可以添加結帳邏輯，例如跳轉到結帳頁面
  router.push('/pages/checkout');
};

const updateRentalDates = () => {
  if (!selectedStartDate.value || !selectedEndDate.value) {
    alert("請選擇租借日期");
    return;
  }
  cartStore.rentalStartDate = selectedStartDate.value;
  cartStore.rentalEndDate = selectedEndDate.value;
  showDatePicker.value = false; // 關閉模態框
};

</script>

<style scoped>

.rental-content-title {
  margin-top: 20px; /* 標題上方距離 */
  font-size: 1.5em; /* 標題字體大小 */
  font-weight: bold; /* 標題字體加粗 */
}
.cart-page {
  padding: 20px;
}

.cart-header {

  background-color: #fff; /* 白底 */
  padding: 10px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  max-width: 6000px; /* 或者使用你產品 card 的最大寬度 */
  margin: 10px auto;
  text-align: center;
}

.rental-dates-card {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 5px;
  background-color: #fff; /* 白底 */
  border: 1px solid grey; /* 黑框線 */
  border-radius: 8px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  margin-bottom: 10px;
  max-width: 6000px; /* 設定最大寬度 */
  margin: 0 auto; /* 中心對齊 */
}

.rental-date {
  flex: 1;
  padding: 10px;
  text-align: center;
}

.rental-gap {
  width: 30px; /* 設定間隔寬度 */
}

.rental-date p {
  margin: 0;
  font-size: 20px;
  color: #0056b3
}

.rental-days {
  font-size: 20px;
  font-weight: bold;
  color: #0056b3
}

@media (max-width: 600px) {
  .rental-dates-card {
    flex-direction: column;
  }

  .rental-date {
    border-bottom: 1px solid #ddd;
    padding-bottom: 10px;
  }

  .rental-gap {
    display: none; /* 在小螢幕上隱藏間隔 */
  }

  .rental-end {
    border-bottom: none;
  }
}


.cart-content {
  margin-bottom: 20px;
  
}

.product-item {
  display: flex;
  justify-content: space-between; /* 使內容左右分開 */
  align-items: center;
  margin-bottom: 16px;
  padding: 16px;
  background-color: #fff; /* 白底 */
  border-top: 1px solid grey; /* 上框線 */
  border-left: none; /* 左邊不顯示框線 */
  border-right: none; /* 右邊不顯示框線 */
  border-bottom: none; /* 下邊不顯示框線 */
  max-width: 6000px; /* 或者使用你產品 card 的最大寬度 */
}

.product-item:last-child {
  border-bottom: 1px solid grey; /* 最後一個產品的下框線 */
}



.product-image {
  flex: 0 0 80px; /* 固定圖片寬度 */
}

.product-image img {
  width: 100%; /* 使圖片充滿容器 */
  border-radius: 4px;
}

.product-info {
  flex: 1; /* 產品名稱部分佔用剩餘空間 */
  margin-left: 16px;
  font-weight: bold; /* 設定產品名稱為粗體 */

}

.product-details {
  display: flex;
  align-items: center;
  justify-content: space-between; /* 使價格和數量按鈕分開 */
  flex: 1; /* 使 details 部分佔用剩餘空間 */
}

.product-price {
  margin-right: 30px; /* 與數量和刪除按鈕之間的距離 */
}

.product-actions {
  display: flex;
  align-items: center;
  gap: 20px; /* 調整按鈕之間的間距 */
}

.quantity-btn {
  background-color: white;
  color: black;
  border: 2px solid #007bff; /* 藍色外框線 */
  border-radius: 4px;
  padding: 5px 10px;
  cursor: pointer;
  transition: background-color 0.3s, border-color 0.3s; /* 加入邊框顏色的變化 */
}

.quantity-btn:hover {
  background-color: #007bff; /* 滑鼠懸停時改變背景顏色 */
  color: white; /* 滑鼠懸停時改變文字顏色 */
  border-color: #0056b3; /* 滑鼠懸停時改變邊框顏色 */
}


.delete-btn {
  background-color: transparent; /* 透明背景 */
  border: none; /* 去掉邊框 */
  cursor: pointer; /* 鼠標指針 */
  padding: 0; /* 去掉內邊距 */
}

.delete-btn i {
  color: #007bff; 
  font-size: 1.5em; /* 調整圖標大小 */
  
}

.v-chip {
  background-color: #1976d2; /* 你可以根據需要調整顏色 */
  color: white;
}

.service-summary {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
}

.service-card,
.summary-card {
  background-color: #fff; /* 白底 */
  border: 2px solid grey;
  border-radius: 8px;
  padding: 16px;
  flex: 1; /* 使卡片等寬 */
  margin: 0 10px; /* 卡片之間的間距 */
}

.cart-footer {
  background: white;
  padding: 10px 0;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.footer-buttons {
  display: flex;
  justify-content: center;
  gap: 10px;
  margin-top: 10px;
  flex-direction: column;
  width: 100%;
  
}

.footer-buttons v-btn:hover {
  background-color: #a8c1e0; /* 懸停時稍微變深的顏色 */
}



.empty-cart-message {
  color: red;
  font-weight: bold;
  text-align: center;
}
</style>



