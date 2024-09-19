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
  background-color: #ff5722; /* 按鈕顏色 */
  color: white; /* 圖標顏色 */
  width: 60px; /* 按鈕寬度 */
  height: 60px; /* 按鈕高度 */
  border-radius: 50%; /* 按鈕圓角 */
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3); /* 按鈕陰影 */
  transition: background-color 0.3s, transform 0.3s; /* 過渡效果 */
}

.cart-icon:hover {
  background-color: #e64a19; /* 懸停時的顏色 */
  transform: scale(1.1); /* 懸停時的放大效果 */
}

.cart-icon .v-icon {
  font-size: 100px; /* 圖標大小 */
}
</style>
