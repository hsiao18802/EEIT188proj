<template>
  <v-container>
    <v-card>
      <v-card-title>
        <h2>訂單歷史</h2>
      </v-card-title>
      <v-data-table
        :headers="headers"
        :items="orders"
        item-key="order_id"
        class="elevation-1"
      >
        <template v-slot:item.order_creation_date="{ item }">
          {{ formatDate(item.order_creation_date) }}
        </template>
        <template v-slot:item.total_price_amount="{ item }">
          {{ formatCurrency(item.total_price_amount) }}
        </template>
        <template v-slot:item.shipping_fee="{ item }">
          {{ formatCurrency(item.shipping_fee) }}
        </template>
        <template v-slot:item.status="{ item }">
          <v-chip :color="getStatusColor(item.status)" dark>{{ item.status }}</v-chip>
        </template>
        <template v-slot:no-data>
          <v-alert type="info" icon="mdi-information">
            沒有訂單資料
          </v-alert>
        </template>
      </v-data-table>
    </v-card>
  </v-container>
</template>

<script setup>
import { ref } from 'vue';

const headers = [
  { text: '訂單 ID', value: 'order_id' },
  { text: '會員 ID', value: 'members_id' },
  { text: '創建日期', value: 'order_creation_date' },
  { text: '總金額', value: 'total_price_amount' },
  { text: '租借狀態', value: 'rent_retrun_status' },
  { text: '付款方式', value: 'pay_method' },
  { text: '備註', value: 'remarks' },
  { text: '訂單狀態', value: 'status' },
  { text: '運輸費用', value: 'shipping_fee' },
  { text: '運輸方式', value: 'shipping_method' },
];

const orders = ref([
  {
    order_id: 1,
    members_id: 1,
    order_creation_date: '2024-09-10 12:00:00',
    total_price_amount: 600,
    rent_retrun_status: '未歸還',
    pay_method: '信用卡',
    remarks: '第一次租借',
    status: '處理中',
    shipping_fee: 100,
    shipping_method: '標準運輸',
  },
  {
    order_id: 2,
    members_id: 2,
    order_creation_date: '2024-09-12 14:30:00',
    total_price_amount: 700,
    rent_retrun_status: '已歸還',
    pay_method: '現金',
    remarks: '急件',
    status: '已完成',
    shipping_fee: 150,
    shipping_method: '快遞',
  },
  {
    order_id: 3,
    members_id: 3,
    order_creation_date: '2024-09-15 09:45:00',
    total_price_amount: 800,
    rent_retrun_status: '未歸還',
    pay_method: '信用卡',
    remarks: '特殊要求',
    status: '處理中',
    shipping_fee: 200,
    shipping_method: '標準運輸',
  }
]);

const formatDate = (date) => {
  return new Date(date).toLocaleDateString();
};

const formatCurrency = (amount) => {
  return `$${amount}`;
};

const getStatusColor = (status) => {
  return status === '已完成' ? 'green' : 'orange';
};
</script>

<style scoped>
.v-data-table th {
  background-color: #f5f5f5;
}

.v-chip {
  font-size: 0.9rem;
}
</style>
