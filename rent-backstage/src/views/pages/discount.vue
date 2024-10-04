<template>
    <div>
      <h2>所有折扣碼</h2>
      <table>
        <thead>
          <tr>
            <th>折扣碼</th>
            <th>描述</th>
            <th>折扣類型</th>
            <th>折扣值</th>
            <th>開始日期</th>
            <th>結束日期</th>
            <th>使用限制</th>
            <th>已使用次數</th>
            <th>是否可用</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="discount in discounts" :key="discount.discountId">
            <td>{{ discount.code }}</td>
            <td>{{ discount.description }}</td>
            <td>{{ discount.discountType }}</td>
            <td>{{ discount.discountValue }}</td>
            <td>{{ formatDate(discount.startDate) }}</td>
            <td>{{ formatDate(discount.endDate) }}</td>
            <td>{{ discount.usageLimit }}</td>
            <td>{{ discount.usageCount }}</td>
            <td>{{ discount.isActive ? '是' : '否' }}</td>
            <td>
              <button @click="editDiscount(discount)">編輯</button>
              <button @click="deleteDiscount(discount.discountId)">刪除</button>
            </td>
          </tr>
        </tbody>
      </table>
      <button @click="addDiscount">新增折扣碼</button>
  
      <!-- 新增/編輯模態框 -->
      <div v-if="showModal">
        <h3>{{ isEditMode ? '編輯' : '新增' }}折扣碼</h3>
        <label>折扣碼：</label>
        <input v-model="currentDiscount.code" />
        <label>描述：</label>
        <input v-model="currentDiscount.description" />
        <label>折扣類型：</label>
        <input v-model="currentDiscount.discountType" />
        <label>折扣值：</label>
        <input v-model="currentDiscount.discountValue" type="number" />
        <label>開始日期：</label>
        <input v-model="currentDiscount.startDate" type="date" />
        <label>結束日期：</label>
        <input v-model="currentDiscount.endDate" type="date" />
        <label>使用限制：</label>
        <input v-model="currentDiscount.usageLimit" type="number" />
        <label>已使用次數：</label>
        <input v-model="currentDiscount.usageCount" type="number" />
        <label>是否可用：</label>
        <input v-model="currentDiscount.isActive" type="checkbox" />
        <button @click="saveDiscount">儲存</button>
        <button @click="closeModal">取消</button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import axiosapi from '@/plugins/axios'; // 使用 axiosapi
  
  const discounts = ref([]);
  const showModal = ref(false);
  const isEditMode = ref(false);
  const currentDiscount = ref({
    code: '',
    description: '',
    discountType: '',
    discountValue: 0,
    startDate: '',
    endDate: '',
    usageLimit: 0,
    usageCount: 0,
    isActive: false,
  });
  
  // 獲取所有折扣碼
  const fetchDiscounts = async () => {
    try {
      const response = await axiosapi.get('/rent/discount/all');
      discounts.value = response.data;
    } catch (error) {
      console.error('無法獲取折扣碼:', error);
    }
  };
  
  // 編輯折扣碼
  const editDiscount = (discount) => {
    currentDiscount.value = { ...discount }; // 將要編輯的折扣碼資料賦值給 currentDiscount
    isEditMode.value = true;
    showModal.value = true; // 顯示模態框
  };
  
  // 刪除折扣碼
  const deleteDiscount = async (id) => {
    if (confirm('確定要刪除這個折扣碼嗎？')) {
      try {
        await axiosapi.delete(`/rent/discount/delete/${id}`);
        fetchDiscounts(); // 刪除後重新獲取折扣碼
      } catch (error) {
        console.error('刪除折扣碼失敗:', error);
      }
    }
  };
  
  // 新增折扣碼
  const addDiscount = () => {
    currentDiscount.value = {
      code: '',
      description: '',
      discountType: '',
      discountValue: 0,
      startDate: '',
      endDate: '',
      usageLimit: 0,
      usageCount: 0,
      isActive: false,
    };
    isEditMode.value = false;
    showModal.value = true; // 顯示模態框
  };
  
  // 儲存折扣碼
  const saveDiscount = async () => {
    try {
      if (isEditMode.value) {
        // 編輯模式
        await axiosapi.put(`/rent/discount/update/${currentDiscount.value.discountId}`, currentDiscount.value);
      } else {
        // 新增模式
        await axiosapi.post('/rent/discount/add', currentDiscount.value);
      }
      fetchDiscounts(); // 更新折扣碼列表
      closeModal(); // 關閉模態框
    } catch (error) {
      console.error('儲存折扣碼失敗:', error);
    }
  };
  
  // 關閉模態框
  const closeModal = () => {
    showModal.value = false;
  };
  
  // 格式化日期
  const formatDate = (date) => {
    if (!date) return '';
    return new Date(date).toLocaleDateString('zh-TW');
  };
  
  // 在組件掛載後獲取折扣碼
  onMounted(() => {
    fetchDiscounts();
  });
  </script>
  
  <style scoped>
  table {
    width: 100%;
    border-collapse: collapse;
  }
  
  th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
  }
  
  th {
    background-color: #f2f2f2;
  }
  
  button {
    margin: 5px;
  }
  
  /* 模態框樣式 */
  div {
    margin-top: 20px;
    padding: 10px;
    border: 1px solid #ddd;
  }
  </style>
  