<template>
  <div v-if="showCartDrawer">
    <div class="overlay" @click="toggleCart"></div>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <div class="cart-drawer">
      <div class="cart-header">
        <h3>My reservation</h3>
        <p>租借日期: {{ formattedRentalStartDate }} 到 {{ formattedRentalEndDate }} </p>
        <p>共 {{ rentalDays }} 天</p>
      </div>

      <div class="cart-content">
        <div v-for="product in cartStore.sortedCartList" :key="product.cartId + product.productId + product.membersId" class="product-item">
          <div class="product-image">
            <img :src="`data:image/jpeg;base64,${product.mainPhoto}`" alt="product image" />
          </div>
          <div class="product-info">
            <div class="product-title">{{ product.productName }}</div>
            <div class="product-details">
              單價: {{ formatPrice(product.dailyFeeOriginal) }} / 每日
              <br />
              <!-- <button @click="fetchAvailableQuantity(product.productId, rentalStartDate.value, rentalEndDate.value)">
                查詢可租借數量
              </button> -->
              <div v-if="availableQuantities[product.productId] !== undefined">
                可租借數量: {{ availableQuantities[product.productId] }}
              </div>
            </div>
            <div class="product-actions">
              <button class="quantity-btn" @click="minusOne(product.productId)">-</button>
              <span>{{ product.count }}</span>
              <button class="quantity-btn" @click="plusOne(product.productId)">+</button>
              <button class="quantity-btn delete-btn" @click="removeFromCart(product.productId)">
                <i class="fas fa-trash"></i> <!-- 垃圾桶圖案 -->
              </button>
            </div>
          </div>
        </div>
        <div v-if="isCartEmpty" class="empty-cart-message">
          購物車是空的
        </div>
      </div>

      <div>
        <h3>加價服務</h3>
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
        
      </div>

      <div class="cart-footer" v-if="cartList.length > 0">
        <span>🛒共 {{ totalItemCount }} 件商品</span>
        <div class="cart-summary">
          <p>小計: {{ formatPrice(totalPrice) }} 元</p>
        </div>
        <div class="footer-buttons">
          <v-btn @click="viewCart">查看購物車</v-btn>
          <v-btn @click="checkout">結帳</v-btn>
          <v-btn class="clear-cart-btn" @click="clearCart">清空購物車</v-btn>
        </div>
      </div>
    </div>
  </div>

  <div v-if="!showCartDrawer && shouldShowCartIcon" class="cart-icon" @click="toggleCart">
    <span>🛒</span>
  </div>
</template>



<script setup>
import { computed,ref,onMounted,watch  } from 'vue';
import { useCartStore } from '@/stores/cartStore';
import { useOrderStore } from '@/stores/orderStore';
import { useRouter } from 'vue-router';
import dayjs from 'dayjs'; // 引入 dayjs 函式庫 算天數
import Swal from 'sweetalert2'
import axiosapi from '@/plugins/axios';


const cartStore = useCartStore();
const cartList = computed(() => cartStore.cartList);
const router = useRouter();
const orderStore =  useOrderStore();
const showCartDrawer = computed(() => cartStore.showCartDrawer);
const rentalStartDate = computed(() => cartStore.rentalStartDate);
const rentalEndDate = computed(() => cartStore.rentalEndDate);






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

const selectedServices = ref({
  delivery1: false, // 自取
  delivery2: false, // 1-20 公里
  delivery3: false, // 20-40 公里
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





const handleServiceSelection = (selectedOption) => {
  if (selectedOption === 1) {
    selectedServices.value.delivery2 = false;
    selectedServices.value.delivery3 = false;
    cartStore.shippingMethod = '自取($0)大安區店'; // 更新為自取
  } else {
    selectedServices.value.delivery1 = false;
    if (selectedOption === 2) {
      selectedServices.value.delivery3 = false;
      cartStore.shippingMethod = '1-20公里內的送貨和取貨 ($300) 大安區店'; // 更新為1-20公里送貨
    } else if (selectedOption === 3) {
      selectedServices.value.delivery2 = false;
      cartStore.shippingMethod = '20-40公里內的送貨和取貨 ($500) 大安區店'; // 更新為20-40公里送貨
    }
  }
};

const formatPrice = (price) => {
  return new Intl.NumberFormat('zh-TW', {
    style: 'currency',
    currency: 'TWD',
    minimumFractionDigits: 0, // 不顯示小數點
    maximumFractionDigits: 0, // 不顯示小數點
  }).format(price);
};


const totalItemCount = computed(() =>
  cartList.value.reduce((total, item) => total + item.count, 0)
);

const isCartEmpty = computed(() => cartList.value.length === 0);
const shouldShowCartIcon = computed(() => cartList.value.length > 0);

const toggleCart = () => {
  cartStore.toggleCartDrawer();
};


const checkout = async()=>{

  // 檢查是否已經選擇日期
  if (!cartStore.rentalStartDate || !cartStore.rentalEndDate) {
    Swal.fire({
      icon: 'warning',
      title: '日期未選擇',
      text: '請選擇租借的開始日期和結束日期',
      confirmButtonText: '確定'
    });
    return; // 阻止繼續進行 checkout
  }

  // 檢查是否已經選擇加價服務
  if (!selectedServices.value.delivery1 && !selectedServices.value.delivery2 && !selectedServices.value.delivery3) {
    Swal.fire({
      icon: 'warning',
      title: '未選擇加價服務',
      text: '請選擇至少一個加價服務',
      confirmButtonText: '確定'
    });
    return; // 阻止繼續進行 checkout
  }

  // orderProducts 內容
  const orderProducts = cartList.value.map(product => {
        const subtotal = product.dailyFeeOriginal * product.count; // 計算小計
        return {
            productId: product.productId,
    subtotal: formatPrice(subtotal), // 使用 formatPrice 格式化小計
            count: product.count,
            productName:  product.productName,
            dailyFeeOriginal:product.dailyFeeOriginal,
            subtotal: formatPrice(subtotal), // 使用 formatPrice 格式化小計
            orderProductId: null ,// 如果需要，待後端生成
            mainPhoto: product.mainPhoto // 加入圖片資料

            
        };
    });

  orderStore.setOrderData({
  membersId: cartStore.membersId,
  rentalStartDate: cartStore.rentalStartDate,
  rentalEndDate: cartStore.rentalEndDate,
  rentalDays: rentalDays.value,
  totalPrice: totalPrice.value,
  shippingFee: selectedServicesPrice.value,
  shippingMethod: cartStore.shippingMethod,
  orderProducts: orderProducts,
  payMethod: null,
});

console.log("暫存的訂單資料:", JSON.stringify(orderStore.orderData));
 

  await router.push('/pages/checkout');
  cartStore.toggleCartDrawer(); // 隱藏抽屜

};


const viewCart = () => {
  cartStore.toggleCartDrawer(); // 隱藏抽屜
  router.push('/pages/Cart'); // 僅使用路徑進行跳轉
};


const minusOne = (productId) => cartStore.minusOne(productId);
const plusOne = (productId) => cartStore.plusOne(productId);
const removeFromCart = (productId) => cartStore.delCart(productId);

const clearCart = () => {
  Swal.fire({
    title: '確定要清空購物車嗎?',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: '是的，清空',
    cancelButtonText: '取消'
  }).then(async (result) => {
    if (result.isConfirmed) {
      try {
        await cartStore.clearCart(); // 這裡呼叫清空購物車的 API
      } catch (error) {
        console.error('清空購物車失敗:', error);
      }
    }
  });
};


const formattedRentalStartDate = computed(() => {
  return rentalStartDate.value ? dayjs(rentalStartDate.value).format('YYYY-MM-DD') : '';
});

const formattedRentalEndDate = computed(() => {
  return rentalEndDate.value ? dayjs(rentalEndDate.value).format('YYYY-MM-DD') : '';
});


const availableQuantities = ref({});
// 定義函數來調用後端 API，並在多處加入 console.log 幫助偵錯
// const fetchAvailableQuantity = async (productId, rentalStartDate, rentalEndDate) => {

//   if (!cartStore.rentalStartDate || !cartStore.rentalEndDate) {
//     console.error('租借日期未定義，無法查詢可租借數量');
//     return;
//   }

//   try {
//     const response = await axiosapi.post('/rent/product/check-availability', {
//       dateA: cartStore.rentalStartDate,
//       dateB: cartStore.rentalEndDate,
//       productId,
//     });

//     console.log('API 請求已完成，返回數據:', response.data);

//     if (response.data && response.data.availableQuantity !== undefined) {
//       console.log(`成功獲取 productId ${productId} 的可租借數量:`, response.data.availableQuantity);
//       availableQuantities.value[productId] = response.data.availableQuantity;
//     } else {
//       console.error('無法取得可租借數量，API 返回的數據異常');
//     }
//   } catch (error) {
//     console.error('API 請求失敗:', error);
//   }
// };

const fetchAvailableQuantity = async (productId, rentalStartDate, rentalEndDate) => {

if (!cartStore.rentalStartDate || !cartStore.rentalEndDate) {
  console.error('租借日期未定義，無法查詢可租借數量');
  return;
}

try {
  const response = await axiosapi.post('/rent/product/check-availability', {
    dateA: cartStore.rentalStartDate,
    dateB: cartStore.rentalEndDate,
    productId,
  });

  console.log('API 請求已完成，返回數據:', response.data);

  // 檢查是否直接返回數字
  if (typeof response.data === 'number') {
    console.log(`成功獲取 productId ${productId} 的可租借數量:`, response.data);
    availableQuantities.value[productId] = response.data; // 直接將數據分配給 productId 對應的可租借數量
  } else {
    console.error('無法取得可租借數量，API 返回的數據異常:', response.data);
  }
} catch (error) {
  console.error('API 請求失敗:', error);
}
};

onMounted(() => {
  cartStore.sortedCartList.forEach(product => {
    fetchAvailableQuantity(product.productId, rentalStartDate.value, rentalEndDate.value);
  });
});

// 當租借日期變化時重新獲取數據
watch([rentalStartDate, rentalEndDate], () => {
  cartStore.sortedCartList.forEach(product => {
    fetchAvailableQuantity(product.productId, rentalStartDate.value, rentalEndDate.value);
  });
});


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
  background-color: white;
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

.delete-btn:hover i {
  filter: grayscale(100%) contrast(200%); /* 懸停時提高對比度 */
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

