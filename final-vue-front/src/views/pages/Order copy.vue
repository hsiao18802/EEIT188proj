<template>
    <div class="order-container">
      <h1>結帳</h1>
      <div v-if="orderData">
        <h2>訂單摘要</h2>
        <ul>
          <li v-for="item in orderData.items" :key="item.product_cart_id">
            {{ item.product_name }} - {{ item.count }} 件
          </li>
        </ul>
        <h3>產品總計: {{ formatCurrency(orderData.totalAmount) }}</h3>
        <h3>運輸費用: {{ formatCurrency(orderData.shippingFee) }}</h3>
        <h3>折扣金額: {{ formatCurrency(orderData.discountAmount) }}</h3>
        <h3>總計: {{ formatCurrency(orderData.totalAmount + orderData.shippingFee - orderData.discountAmount) }}</h3>
        <button @click="submitOrder">提交訂單</button>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  import Swal from 'sweetalert2';
  
  export default {
    data() {
      return {
        orderData: null
      };
    },
    created() {



      
      const { cartItems, totalPrice, shippingMethod, shippingFee, discountAmount } = this.$route.params;
      this.orderData = {
        items: JSON.parse(cartItems),
        totalAmount: Number(totalPrice),
        shippingMethod,
        shippingFee: Number(shippingFee),
        discountAmount: Number(discountAmount)
      };
    },
    methods: {
      formatCurrency(value) {
        return `$${value.toFixed(2)}`;
      },
      async submitOrder() {
        try {
          const response = await axios.post('/api/checkout', {
            items: this.orderData.items,
            totalAmount: this.orderData.totalAmount,
            shippingMethod: this.orderData.shippingMethod,
            shippingFee: this.orderData.shippingFee,
            discountAmount: this.orderData.discountAmount,
            userId: 123 // 假設有一個用戶 ID
          });
  
          if (response.status === 200) {
            Swal.fire({
              icon: 'success',
              title: '訂單提交成功！',
              showConfirmButton: false,
              timer: 2000
            });
            this.$router.push('/'); // 跳轉到首頁或其他頁面
          }
        } catch (error) {
          console.error('結帳失敗:', error);
          Swal.fire({
            icon: 'error',
            title: '結帳失敗',
            text: '請稍後再試。',
          });
        }
      }
    }
  };
  </script>
  
  <style scoped>

  </style>
  