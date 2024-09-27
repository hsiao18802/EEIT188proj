<template>
    <div>
      <el-table :data="orders">
        <el-table-column prop="orderId" label="訂單編號" />
        <el-table-column prop="status" label="訂單狀態" />
        <el-table-column prop="createdAt" label="創建時間" />
        <el-table-column label="操作">
          <template #default="{ row }">
            <el-button @click="handleViewOrder(row.orderId)">查看</el-button>
            <el-button @click="handleDeleteOrder(row.orderId)" type="danger">刪除</el-button>
            <el-button @click="handleUpdateStatus(row.orderId, 'completed')">更改為已完成</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      orders: Array,
    },
    emits: ['view-order', 'delete-order', 'update-status'],
    setup(props, { emit }) {
      const handleViewOrder = (orderId) => {
        emit('view-order', orderId);
      };
  
      const handleDeleteOrder = (orderId) => {
        emit('delete-order', orderId);
      };
  
      const handleUpdateStatus = (orderId, status) => {
        emit('update-status', orderId, status);
      };
  
      return {
        handleViewOrder,
        handleDeleteOrder,
        handleUpdateStatus,
      };
    },
  };
  </script>
  
  <style scoped>
  /* 添加需要的樣式 */
  </style>
  