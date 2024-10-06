<template>
  <div class="container">
    <h2 class="text-primary my-4">所有折扣碼</h2>

    <!-- 搜尋欄 -->
    <div class="input-group mb-3">
      <input
        type="text"
        class="form-control"
        placeholder="搜尋折扣碼"
        v-model="searchQuery"
      />
      <button class="btn btn-outline-secondary" type="button" @click="clearSearch">
        清除搜尋
      </button>
    </div>

    <!-- 顯示過期折扣碼的切換 -->
    <div class="form-check mb-3">
      <input
        class="form-check-input"
        type="checkbox"
        v-model="showOnlyExpired"
        id="showOnlyExpired"
      />
      <label class="form-check-label" for="showOnlyExpired">
        顯示過期折扣碼
      </label>
    </div>


    <table class="table table-striped table-hover">
      <thead class="table-light">
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
        <tr v-for="discount in filteredDiscounts" :key="discount.discountId">
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
            <button
              class="btn btn-outline-primary btn-sm me-2"
              @click="editDiscount(discount)"
            >
              編輯
            </button>
            <button
              class="btn btn-outline-danger btn-sm"
              @click="deleteDiscount(discount.discountId)"
            >
              刪除
            </button>
          </td>
        </tr>
      </tbody>
    </table>
    <button class="btn btn-success my-3" @click="addDiscount">新增折扣碼</button>


    <!-- 新增/編輯模態框 -->
    <div v-if="showModal" class="modal fade show" tabindex="-1" style="display:block;">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">{{ isEditMode ? '編輯' : '新增' }} 折扣碼</h5>
            <button type="button" class="btn-close" @click="closeModal"></button>
          </div>
          <div class="modal-body">
            <label>折扣碼：</label>
            <input class="form-control mb-2" v-model="currentDiscount.code" />
            <label>描述：</label>
            <input class="form-control mb-2" v-model="currentDiscount.description" />
            <label>折扣類型：</label>
            <input class="form-control mb-2" v-model="currentDiscount.discountType" />
            <label>折扣值：</label>
            <input class="form-control mb-2" v-model="currentDiscount.discountValue" type="number" />
            <label>開始日期：</label>
            <input class="form-control mb-2" v-model="currentDiscount.startDate" type="date" />
            <label>結束日期：</label>
            <input class="form-control mb-2" v-model="currentDiscount.endDate" type="date" />
            <label>使用限制：</label>
            <input class="form-control mb-2" v-model="currentDiscount.usageLimit" type="number" />
            <label>已使用次數：</label>
            <input class="form-control mb-2" v-model="currentDiscount.usageCount" type="number" />
            <label>是否可用：</label>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" v-model="currentDiscount.isActive" />
              <label class="form-check-label">是否可用</label>
            </div>
          </div>
          <div class="modal-footer">
            <button class="btn btn-primary" @click="saveDiscount">儲存</button>
            <button class="btn btn-secondary" @click="closeModal">取消</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue';
import axiosapi from '@/plugins/axios';

const discounts = ref([]);
const showModal = ref(false);
const isEditMode = ref(false);
const searchQuery = ref('');
const showOnlyExpired = ref(false); // 用來控制只顯示過期折扣碼
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

// 計算屬性：根據搜尋條件與是否只顯示過期折扣碼進行過濾
const filteredDiscounts = computed(() => {
  let filtered = discounts.value;
  
  // 根據搜尋條件過濾
  if (searchQuery.value) {
    filtered = filtered.filter(discount =>
      discount.code.toLowerCase().includes(searchQuery.value.toLowerCase())
    );
  }
  
  // 根據過期狀態過濾
  const currentDate = new Date();
  if (showOnlyExpired.value) {
    // 只顯示過期的折扣碼
    filtered = filtered.filter(discount => new Date(discount.endDate) < currentDate);
  }
  
  return filtered;
});

// 編輯折扣碼
const editDiscount = (discount) => {
  currentDiscount.value = { ...discount };
  isEditMode.value = true;
  showModal.value = true;
};

// 刪除折扣碼
const deleteDiscount = async (id) => {
  if (confirm('確定要刪除這個折扣碼嗎？')) {
    try {
      await axiosapi.delete(`/rent/discount/delete/${id}`);
      fetchDiscounts();
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
  showModal.value = true;
};

// 儲存折扣碼
const saveDiscount = async () => {
  try {
    if (isEditMode.value) {
      await axiosapi.put(`/rent/discount/update/${currentDiscount.value.discountId}`, currentDiscount.value);
    } else {
      await axiosapi.post('/rent/discount/add', currentDiscount.value);
    }
    fetchDiscounts();
    closeModal();
  } catch (error) {
    console.error('儲存折扣碼失敗:', error);
  }
};

// 關閉模態框
const closeModal = () => {
  showModal.value = false;
};

// 清除搜尋
const clearSearch = () => {
  searchQuery.value = '';
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
.table-hover tbody tr:hover {
  background-color: #f1f1f1;
}

.modal-content {
  border-radius: 10px;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
}

.btn {
  transition: all 0.3s ease;
}

.btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.15);
}
</style>
