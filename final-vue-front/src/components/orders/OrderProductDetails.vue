<template>
    <div>
      <h3>產品詳情</h3>
      <el-table :data="order.orderProducts">
        <el-table-column prop="productName" label="產品名稱" />
        <el-table-column prop="quantity" label="數量" />
        <el-table-column prop="price" label="單價" />
        <el-table-column prop="subtotal" label="小計" />
      </el-table>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      order: Object,
    }
}
    
    
  
  </script>
  
  <style scoped>
  /* 添加需要的樣式 */
  </style>
  