<template>
    <v-navigation-drawer
      v-model="drawer"
      app
      right
      :clipped="$vuetify.breakpoint.mdAndDown"
      class="cart-drawer"
    >
      <v-list dense>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title>租借開始時間: {{ rentalStartDate }}</v-list-item-title>
            <v-list-item-title>租借結束時間: {{ rentalEndDate }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-divider></v-divider>
        <v-list-item-group v-if="cartItems.length > 0">
          <v-list-item v-for="item in cartItems" :key="item.productId">
            <v-list-item-content>
              <v-list-item-title>{{ item.productName }}</v-list-item-title>
              <v-list-item-subtitle>
                數量: <v-text-field v-model="item.count" type="number" min="1" class="ml-2"></v-text-field><br>
                單價: {{ item.dailyFeeOriginal }}<br>
                Subtotal: {{ item.count * item.dailyFeeOriginal }}
              </v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-action>
              <v-btn @click="viewCart">View Cart</v-btn>
            </v-list-item-action>
            <v-list-item-action>
              <v-btn @click="checkout">Checkout</v-btn>
            </v-list-item-action>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </template>
  
  <script>
  export default {
    data() {
      return {
        drawer: false,
        rentalStartDate: '',
        rentalEndDate: '',
        cartItems: [] // 這裡應該由狀態管理獲取
      }
    },
    methods: {
      viewCart() {
        this.$router.push('/cart')
      },
      checkout() {
        this.$router.push('/checkout')
      }
    }
  }
  </script>
  
  <style scoped>
  .cart-drawer {
    width: 350px;
  }
  </style>
  