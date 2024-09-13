<template>
  <v-container class="order-container" max-width="600px">
    <v-card elevation="3" class="pa-4">
      <v-card-title class="text-center">
        <h1>結帳</h1>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-subtitle v-if="orderData" class="text-center mt-4">
        <h2>訂單摘要</h2>
      </v-card-subtitle>
      <v-divider></v-divider>
      <v-card-text v-if="orderData">
        <v-list dense class="mt-4">
          <v-list-item v-for="item in orderData.items" :key="item.product_cart_id" class="my-2">
            <v-list-item-content>
              <v-list-item-title>{{ item.product_name }}</v-list-item-title>
              <v-list-item-subtitle>{{ item.count }} 件</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </v-list>
        <v-divider class="my-4"></v-divider>
        <v-row class="mt-2" justify="space-between">
          <v-col cols="6"><strong>產品總計:</strong></v-col>
          <v-col cols="6" class="text-right">{{ formatCurrency(orderData.totalAmount) }}</v-col>
        </v-row>
        <v-row class="mt-2" justify="space-between">
          <v-col cols="6"><strong>運輸費用:</strong></v-col>
          <v-col cols="6" class="text-right">{{ formatCurrency(orderData.shippingFee) }}</v-col>
        </v-row>
        <v-row class="mt-2" justify="space-between">
          <v-col cols="6"><strong>折扣金額:</strong></v-col>
          <v-col cols="6" class="text-right">{{ formatCurrency(orderData.discountAmount) }}</v-col>
        </v-row>
        <v-divider class="my-4"></v-divider>
        <v-row class="mt-2" justify="space-between">
          <v-col cols="6"><strong>總計:</strong></v-col>
          <v-col cols="6" class="text-right">{{ formatCurrency(orderData.totalAmount + orderData.shippingFee - orderData.discountAmount) }}</v-col>
        </v-row>
        <v-btn class="mt-4" block color="primary" @click="submitOrder">提交訂單</v-btn>
      </v-card-text>
    </v-card>
  </v-container>
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
    this.orderData = {
      items: [
        {
          product_cart_id: 1,
          product_name: '帳篷 A',
          count: 2
        },
        {
          product_cart_id: 2,
          product_name: '睡袋 B',
          count: 1
        },
        {
          product_cart_id: 3,
          product_name: '露營燈 C',
          count: 3
        }
      ],
      totalAmount: 5000,
      shippingMethod: '快遞',
      shippingFee: 150,
      discountAmount: 300
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
          userId: 123
        });

        if (response.status === 200) {
          Swal.fire({
            icon: 'success',
            title: '訂單提交成功！',
            showConfirmButton: false,
            timer: 2000
          });
          this.$router.push('/');
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
.order-container {
  margin-top: 30px;
}

.text-center {
  text-align: center;
}

.text-right {
  text-align: right;
}

.my-2 {
  margin-top: 8px;
  margin-bottom: 8px;
}

.my-4 {
  margin-top: 16px;
  margin-bottom: 16px;
}

.mt-2 {
  margin-top: 8px;
}

.mt-4 {
  margin-top: 16px;
}

.pa-4 {
  padding: 16px;
}
</style>
