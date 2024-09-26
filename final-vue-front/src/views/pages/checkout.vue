<template>
    <div class="checkout-container">
      <div class="address-section">
        <h2>填寫地址資訊</h2>
        <form @submit.prevent="submitOrder">
          <div class="form-group">
            <label for="address">地址</label>
            <input v-model="address" id="address" placeholder="輸入地址" required />
          </div>
          <div class="form-group">
            <label for="phone">手機</label>
            <input v-model="phone" id="phone" placeholder="輸入手機號碼" required />
          </div>
          <div class="form-group">
            <label for="contact">聯絡電話</label>
            <input v-model="contact" id="contact" placeholder="輸入聯絡電話" required />
          </div>
          <button type="submit" class="submit-button">確定訂單</button>
        </form>
      </div>
  
   
      <div class="order-info-section" v-if="orderData">
        <div>我的預約</div>
        <header class="order-header">
            <p>租借日期: {{ orderData.rentalStartDate }} - {{ orderData.rentalEndDate }}</p>
            <p>租借天數: {{ orderData.rentalDays }}</p>

        </header>
  
        <div class="order-details">

          <ul>
            <li v-for="(product, index) in orderData.orderProducts" :key="index">
                 <!-- 從 cartStore.cartList 匹配圖片 -->
    <img
      :src="getProductImage(product.productId)"
      class="product-image"
    />
              {{ product.count }} x {{ product.productName }}
            </li>
          </ul>
          <p>運送方式: {{ orderData.shippingMethod }}</p>
        </div>
  
        <footer class="order-footer">
        <div>
          <p :style="{ textDecoration: hasAppliedCoupon ? 'line-through' : 'none' }">總共價格: {{ originalPrice }} 元</p>
          <p v-if="hasAppliedCoupon">折扣金額: {{ discountValue }} 元</p>
          <p v-if="hasAppliedCoupon">折扣後價格: {{ finalPrice }} 元</p>
          <button v-if="!hasAppliedCoupon" @click="showCouponPrompt">輸入優惠碼</button>
        </div>
      </footer>

      <div v-if="discountMessage">{{ discountMessage }}</div>
    </div>
  </div>
  </template>
  
  <script setup>
  import { computed, ref } from 'vue';
  import { useCartStore } from '@/stores/cartStore';
  import { useOrderStore } from '@/stores/orderStore';
  import { useRouter } from 'vue-router';
  import Swal from 'sweetalert2';
  
  const hasAppliedCoupon = ref(false); // 新增變數以追蹤是否已輸入折扣碼
  const discountMessage = ref('');
  const discountValue = ref(0); // 儲存折扣金額
  const cartStore = useCartStore();
  const router = useRouter();
  const orderStore = useOrderStore();
  const address = ref("");
  const phone = ref(""); // 新增手機號碼響應式變數
  const contact = ref(""); // 新增聯絡電話響應式變數
  
  // 確保從 orderStore 取得暫存的訂單資料
  const orderData = computed(() => orderStore.orderData);
  
  // 顯示優惠碼提示框
const showCouponPrompt = async () => {
  const { value: couponCode } = await Swal.fire({
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
      const code = document.getElementById('swal-input1').value; // 取得輸入的優惠碼
      if (!code) {
        document.getElementById('discount-message').innerText = '請輸入優惠碼';
        return false;
      }
      const isValid = await validateCoupon(code);
      if (!isValid) {
        document.getElementById('discount-message').innerText = discountMessage.value; // 更新顯示的錯誤訊息
        return false;
      }
      return code; // 返回有效的優惠碼
    },
  });

  if (couponCode) {
    hasAppliedCoupon.value = true; // 成功輸入折扣碼後更新狀態
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





  // 提交訂單
  const submitOrder = async () => {
    try {
      const newOrderData = { 
        ...orderData.value, 
        shippingAddress: address.value,
        phone: phone.value,
        contact: contact.value 
      };
  
      const newOrder = await orderStore.createOrder(newOrderData);
      console.log("訂單創建成功:", newOrder);
  
      // 更新本地 orderStore 的 orderProducts
      const updatedOrderProducts = newOrder.orderProducts.map((product, index) => ({
        ...orderData.value.orderProducts[index],
        orderProductId: product.orderProductId
      }));
  
      orderStore.setOrderData({
        ...orderData.value,
        orderProducts: updatedOrderProducts
      });
      
      cartStore.clearCart();
      router.push('/'); // 跳轉到訂單成功頁面
    } catch (error) {
      console.error("訂單創建失敗:", error);
    }
  };
  </script>
  
  <style scoped>
  .checkout-container {
    display: flex;
    justify-content: space-between;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  }
  
  .address-section {
    flex: 1;
    margin-right: 20px;
  }
  
  .order-info-section {
    flex: 1;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 8px;
    background-color: #f9f9f9;
  }
  
  .order-header {
    background-color: #004d00;
    color: white;
    padding: 10px;
    text-align: center;
    border-radius: 8px 8px 0 0;
  }
  
  .order-details {
    margin: 20px 0;
  }
  
  .order-footer {
    text-align: center;
    padding: 10px;
    background-color: #e9ecef;
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
  
  .submit-button {
    padding: 10px 15px;
    background-color: #28a745;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  
  .submit-button:hover {
    background-color: #218838;
  }
  </style>
  