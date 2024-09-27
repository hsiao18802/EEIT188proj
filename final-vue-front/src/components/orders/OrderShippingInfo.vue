<template>
    <div>
      <h3>送貨資訊</h3>
      <p>收件人電話: {{ order.shippingPhoneNum }}</p>
      <p>收件地址: {{ order.shippingAddress }}</p>
      <p>運送方式: {{ order.shippingMethod }}</p>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      order: Object,
    },
  };
  </script>
  
  <style scoped>
  /* 添加需要的樣式 */
  </style>
  