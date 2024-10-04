<template>
  <div class="checkout-container">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <div class="address-section">
      <h2>填寫聯絡資訊</h2>
      <form @submit.prevent="submitOrder">
        <div v-if="shippingMethod !== '自取($0)大安區店'" class="form-group">
          <label for="address">收貨地址</label>
          <input v-model="address" id="address" placeholder="輸入地址" required />
        </div>
        <div class="form-group">
          <label for="name">姓名</label>
          <input v-model="name" id="name" placeholder="輸入聯絡人姓名" required />
        </div>
        <div class="form-group">
          <label for="contact">聯絡電話</label>
          <input v-model="contact" id="contact" placeholder="輸入聯絡電話" required />
        </div>
        <div class="form-group">
          <label for="remarks">備註</label>
          <input v-model="remarks" id="remarks" placeholder="輸入方便交貨時間等資訊" />
        </div>
      </form>
    </div>

    <div class="order-info-section" v-if="orderData">
      <header class="order-header">
        <p>
          <span class="rental-date">{{ formatDate(orderData.rentalStartDate) }}</span>
          <i class="fas fa-arrow-right arrow-icon"></i>
          <span class="rental-date">{{ formatDate(orderData.rentalEndDate) }}</span>
        </p>
      </header>

      <div class="order-details">
        <ul>
          <li v-for="(product, index) in orderData.orderProducts" :key="index"
            style="display: flex; justify-content: space-between; align-items: center;">
            <div style="display: flex; align-items: center;">
              <img :src="`data:image/jpeg;base64,${product.mainPhoto}`" alt="product image"
                style="width: 50px; height: auto; margin-right: 10px;" />
              {{ product.count }} x {{ product.productName }}
            </div>
            <span>{{ formatPrice(product.dailyFeeOriginal) }}</span>
          </li>
        </ul>
        <p>運送方式: {{ orderData.shippingMethod }}</p>
      </div>

      <footer class="order-footer">
        <div>
          <p :style="{ textDecoration: hasAppliedCoupon ? 'line-through' : 'none' }">
            總計: {{ formatPrice(originalPrice) }} <!-- 使用 formatPrice 格式化總計 -->
          </p>
          <p v-if="hasAppliedCoupon">折扣金額: {{ formatPrice(discountValue) }} 元</p>
          <p v-if="hasAppliedCoupon">折扣後優惠價: {{ formatPrice(finalPrice) }} 元</p>
          <div class="coupon-container" v-if="!hasAppliedCoupon">
            <button class="coupon-button" @click="showCouponPrompt">
              <i class="fas fa-tag"></i> 輸入優惠碼
            </button>
          </div>
        </div>
      </footer>

      <div class="agreement-section">
        <input type="checkbox" id="terms-checkbox" v-model="termsAccepted" />
        <label for="terms-checkbox">我接受上述條款與條件</label>
        <button type="button" @click="showTerms">了解更多</button>
      </div>

      <button @click="submitOrder" type="submit" class="checkout-button" :disabled="!termsAccepted">繼續付款</button>

    </div>


  </div>




</template>

<script setup>
import { computed, ref, onMounted } from 'vue';
import { useCartStore } from '@/stores/cartStore';
import { useOrderStore } from '@/stores/orderStore';
import { useRouter } from 'vue-router';
import Swal from 'sweetalert2';
import { ecpayAPI } from '@/apis/order';

const hasAppliedCoupon = ref(false); // 新增變數以追蹤是否已輸入折扣碼
const discountMessage = ref('');
const discountValue = ref(0); // 儲存折扣金額
const cartStore = useCartStore();
const router = useRouter();
const orderStore = useOrderStore();
const address = ref("");
const name = ref(""); // 新增手機號碼響應式變數
const contact = ref(""); // 新增聯絡電話響應式變數
const termsAccepted = ref(false); // 新增變數以追蹤是否接受條款
const remarks = ref("");
const couponCode = ref(""); // 儲存當前的折扣碼




// 格式化價格，確保是有效的整數
const formatPrice = (price) => {
  return new Intl.NumberFormat('zh-TW', {
    style: 'currency',
    currency: 'TWD',
    minimumFractionDigits: 0,
    maximumFractionDigits: 0,
  }).format(Math.round(price)); // 確保傳入的是有效的整數
};



// 取得運送方式的計算屬性
const shippingMethod = computed(() => {
  return orderData.value.shippingMethod; // 假設 shippingMethod 在 orderData 中
});

// 確保從 orderStore 取得暫存的訂單資料
const orderData = computed(() => orderStore.orderData);

const showCouponPrompt = async () => {
  const { value: code } = await Swal.fire({
    title: '輸入優惠碼',
    html: `
      <input id="swal-input1" class="swal2-input" placeholder="請輸入優惠碼">
      <div id="discount-message" style="color: red;"></div>
    `,
    showCancelButton: true,
    confirmButtonText: '確認',
    cancelButtonText: '取消',
    focusConfirm: false,
    preConfirm: async () => {
      const inputCode = document.getElementById('swal-input1').value; // 取得輸入的優惠碼
      if (!inputCode) {
        document.getElementById('discount-message').innerText = '請輸入優惠碼';
        return false;
      }
      const isValid = await validateCoupon(inputCode);
      if (!isValid) {
        document.getElementById('discount-message').innerText = discountMessage.value; // 更新顯示的錯誤訊息
        return false;
      }
      return inputCode; // 返回有效的優惠碼
    },
  });

  if (code) { // 使用 `code` 而不是 `couponCode`
    hasAppliedCoupon.value = true; // 成功輸入折扣碼後更新狀態
    couponCode.value = code; // 將有效的折扣碼存儲
  }
};


// 驗證優惠碼
const validateCoupon = async (code) => {
  try {
    const response = await fetch(`http://localhost:8080/rent/discount/validate?code=${code}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    });

    // 檢查回應的狀態
    console.log(response.status); // 紀錄狀態碼

    if (!response.ok) {
      // 如果不是 200 OK，獲取文本回應
      const text = await response.text();
      console.error('錯誤回應:', text); // 紀錄錯誤回應
      discountMessage.value = '沒有這個折扣碼。';
      return false; // 回傳 false 表示驗證失敗
    }

    // 確保在這裡成功解析 JSON
    const message = await response.json(); // 假設成功時返回 JSON 格式
    discountValue.value = parseFloat(message.message.match(/(\d+(\.\d+)?)/)[0]); // 擷取折扣金額
    discountMessage.value = message.message; // 更新消息內容
    return true; // 回傳 true 表示驗證成功
  } catch (error) {
    discountMessage.value = '驗證過程中發生錯誤。';
    console.error(error);
    return false; // 回傳 false 表示驗證失敗
  }
};

// 使用計算屬性來獲取原始價格
const originalPrice = computed(() => {
  return orderData.value.totalPrice; // 確保使用 value 來獲取計算屬性
});

// 計算最終價格
const finalPrice = computed(() => {
  return originalPrice.value - discountValue.value >= 0 ? originalPrice.value - discountValue.value : 0; // 確保價格不會為負
});




// 根據 productId 從 cartStore 中取得圖片
const getProductImage = (productId) => {
  const product = cartStore.cartList.find((item) => item.productId === productId);
  return product ? product.mainPhoto : 'public/NoPic256.jpg'; // 預設圖片路徑
};


// 顯示租借規則視窗
const showTerms = async () => {
  await Swal.fire({
    title: '租借規則',
    text: '搞破壞會罰錢',
    icon: 'info',
    confirmButtonText: '了解'
  });
};




// 提交訂單
const submitOrder = async () => {
  try {
    const newOrderData = {
      ...orderData.value,
      shippingAddress: shippingMethod.value !== '自取($0)大安區店' ? address.value : "",
      shippingName: name.value || "",  // 如果未填則設為空字串
      shippingPhoneNum: contact.value || "", // 如果未填則設為空字串
      remarks: remarks.value || "", // 傳送備註，如果未填則設為空字串
      payMethod: null ,// 可以根據需求設定
      totalPrice: finalPrice.value, // 將折扣後的價格傳入
      discountCode: couponCode.value && couponCode.value.trim() !== "" ? couponCode.value : null, // 如果沒有折扣碼則設為 null
      discountValue: discountValue.value || 0


    };

    console.log("訂單數據:", newOrderData);

    // 提交訂單
    const newOrder = await orderStore.createOrder(newOrderData);
    console.log("訂單創建成功:", newOrder);

    // 更新本地 orderStore 的 orderProducts
    const updatedOrderProducts = newOrder.orderProducts.map((product, index) => ({
      ...orderData.value.orderProducts[index],
      orderProductId: product.orderProductId
    }));

    orderStore.setOrderData({
      ...orderData.value,
      orderProducts: updatedOrderProducts,
      totalPrice: finalPrice.value, // 將折扣後的價格傳入

    });

    // 清空購物車
    cartStore.clearCart();
    // 清空 shippingMethod
    shippingMethod.value = "";
    await router.push('/pages/readyToPay');


  } catch (error) {
    console.error("訂單創建失敗:", error);
    await Swal.fire({
      title: '提交失敗',
      text: '抱歉，您的訂單未能提交。請重試。',
      icon: 'error',
      confirmButtonText: '確定'
    });
  }
}


// 日期格式化函數
const formatDate = (dateString) => {
  const date = new Date(dateString);
  const year = date.getFullYear();
  const month = String(date.getMonth() + 1).padStart(2, '0'); // 月份從0開始，所以加1
  const day = String(date.getDate()).padStart(2, '0');
  return `${year}-${month}-${day}`;
};



</script>

<style scoped>
.checkout-container {
  display: flex;
  justify-content: space-between;
  padding: 20px;
  border: 1px solid white;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  position: relative;
  /* 確保按鈕相對於這個容器定位 */
  padding-bottom: 60px;
  /* 留出空間給固定按鈕 */
  margin-top: 60px;
}

.coupon-container {
  margin-top: 10px;
}

.coupon-button {
  background-color: white;
  /* 綠色背景 */
  color: grey;
  /* 白色文字 */
  border: 1px solid #A9A9A9;
  /* 無邊框 */
  padding: 10px 20px;
  /* 內邊距 */
  text-align: center;
  /* 文字居中 */
  text-decoration: none;
  /* 無底線 */
  display: inline-flex;
  /* 使按鈕與圖示在同一行 */
  align-items: center;
  /* 垂直置中 */
  border-radius: 5px;
  /* 邊角圓滑 */
  transition: background-color 0.3s;
  /* 漸變效果 */
}



.coupon-button i {
  margin-right: 8px;
  /* 圖示與文字之間的間距 */
}

.address-section {
  flex: 1;
  margin-right: 20px;
}

.order-info-section {
  padding: 20px;
  border: 1px solid #e0e0e0;
  /* 增加邊框 */
  border-radius: 8px;
  /* 增加圓角 */
  background-color: white;
  /* 背景顏色 */
  margin: 20px 0;
  /* 增加外邊距 */
  display: flex;
  /* 使用 Flexbox */
  flex-direction: column;
  /* 垂直方向排列 */
  align-items: center;
  /* 水平方向居中 */
}

.order-header {
  display: flex;
  /* 使用 Flexbox */
  align-items: center;
  /* 垂直居中 */
  justify-content: space-between;
  /* 兩側對齊 */
  background-color: #218838;
  /* 背景顏色 */
  padding: 15px 20px;
  /* 增加內邊距，上下15px，左右20px */
  border-radius: 10px 10px 0 0;
  /* 只有上邊圓角 */
  margin: 0;
  /* 確保沒有上邊距 */
  width: 100%;
  /* 確保寬度為100% */
}




.order-header::after {
  content: '';
  display: block;
  height: 1px;
  /* 邊框高度 */
  background-color: #e0e0e0;
  /* 邊框顏色 */
  margin-top: -1px;
  /* 確保邊框在上方 */
}




.rental-date {
  color: white;
  /* 設置文字顏色為白色 */
  margin: 10px;
  /* 增加左右邊距 */
  font-size: 18px;
  /* 字體大小 */
}

.arrow-icon {
  font-size: 18px;
  /* 字體大小 */
  color: white;
  /* 箭頭顏色 */
  margin: 0 10px;
  /* 增加邊距 */
}



.order-details {
  margin: 20px 0;
}

.order-footer {
  text-align: center;
  padding: 10px;
  background-color: white;
  border-radius: 0 0 8px 8px;
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
}

.form-group input {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.agreement-section {
  position: fixed;
  /* 固定在畫面底部 */
  bottom: 200px;
  /* 距離底部 60px（留出空間給付款按鈕） */
  left: 63%;
  /* 居中 */
  transform: translateX(-50%);
  /* 確保水平居中 */
  background-color: rgba(255, 255, 255, 0.9);
  /* 背景顏色 */
  padding: 10px;
  /* 內邊距 */
  border-radius: 8px;
  /* 圓角邊框 */
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
  /* 陰影效果 */
  text-align: center;
  /* 文字置中 */
  width: 90%;
  /* 寬度 90%（可根據需求調整） */
  max-width: 400px;
  /* 最大寬度 */
}

.checkout-button {
  position: fixed;
  /* 固定在畫面底部 */
  bottom: 200Px;
  /* 距離底部 px */
  left: 50%;
  /* 居中 */
  transform: translateX(-50%);
  /* 確保水平居中 */
  padding: 10px 20px;
  /* 按鈕內邊距 */
  border: none;
  /* 無邊框 */
  border-radius: 5px;
  /* 圓角 */
  background-color: #007BFF;
  /* 按鈕顏色 */
  color: white;
  /* 字體顏色 */
  cursor: pointer;
  /* 游標變為手形 */
}

.checkout-button:disabled {
  background-color: #A9A9A9;
  /* 禁用狀態的顏色 */
  cursor: not-allowed;
  /* 游標變為禁止 */
}


.form-group {
  margin-bottom: 15px;
  /* 增加間距 */
}

.agreement-section {
  display: flex;
  align-items: center;
  margin-top: 20px;
}

.agreement-section button {
  margin-left: 10px;
}
</style>