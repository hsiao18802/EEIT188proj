<template>
    <v-fab-transition>
      <v-btn
        v-if="cartItems.length > 0"
        class="cart-icon"
        fab
        fixed
        bottom
        right
        @click="toggleDrawer"
      >
        <v-icon>mdi-cart</v-icon>
      </v-btn>
    </v-fab-transition>
  </template>
  
  <script>
  export default {
    data() {
      return {
        drawer: false,
        cartItems: [] // 這裡應該由狀態管理獲取
      }
    },
    methods: {
      toggleDrawer() {
        this.$refs.cartDrawer.drawer = !this.$refs.cartDrawer.drawer
      }
    }
  }
  </script>
  
  <style scoped>
  .cart-icon {
    background-color: #ff5722;
    color: white;
  }
  </style>
  