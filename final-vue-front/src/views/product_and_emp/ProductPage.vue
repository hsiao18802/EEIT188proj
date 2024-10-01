<template>
  <div class="row mt-5">
    <!-- 左側分類區塊 -->
    <div class="col-md-2">
      <v-card class="mb-4">
        <v-card-title>租用日期</v-card-title>
        <v-card-text>
          <flat-pickr v-model="rentalStartDate" @input="doInput('rentalStartDate', $event)" placeholder="請選擇日期"
            :config="{ maxDate: rentalEndDate ? new Date(new Date(rentalEndDate).setDate(new Date(rentalEndDate).getDate() - 1)) : null, }" />
        </v-card-text>
      </v-card>
      <v-card class="mb-4">
        <v-card-title>歸還日期</v-card-title>
        <v-card-text>
          <flat-pickr v-model="rentalEndDate" @input="doInput('rentalEndDate', $event)" placeholder="請選擇日期"
            :config="{ minDate: rentalStartDate ? new Date(new Date(rentalStartDate).setDate(new Date(rentalStartDate).getDate() + 1)) : null, }" />
        </v-card-text>
      </v-card>
      <div class="d-flex">
        <button class="btn btn-danger" @click="clearDates">重新選擇</button>
      </div>
      <div>
        <input type="text" placeholder="請輸入產品名稱" v-model="findName" class="form-control" />
        <button type="button" class="btn btn-primary" @click="callFind">確認搜尋</button>
      </div>
      <br>
      <h4>商品分類</h4>
      <table>
        <tr v-for="category in categories" :key="category.categoryId" @click="callFind(1, category.categoryId)">
          <td>{{ category.categoryName }} ({{ category.productCount }})</td>
        </tr>
      </table>
      <!-- 產品搜尋欄位 -->
    </div>


    <!-- 右側產品區塊 -->
    <div class="col-md-10">
      <!-- 產品列表 -->
      <div class="row">
        <ProductCard v-for="product in products" :key="product.productId" :item="product" :isDateSelected="isDateSelected"
        :available-quantity="availableQuantities[product.productId]" @open-rent="openModal"></ProductCard>
      </div>
      
      <!-- 分頁與選擇欄 -->
      <div class="row mt-3">
        <div class="d-flex justify-content-center align-items-center">
          <Paginate v-show="total>0"
              :first-last-button="true"
              first-button-text="&lt;&lt;" last-button-text="&gt;&gt;"
              prev-text="&lt;" next-text="&gt;"
              :page-count="pages" :initial-page="current" v-model="current"
              :click-handler="callFind">
          </Paginate>
          <!-- 分頁選擇欄 -->
          <ProductSelect v-model="max" :total="total" :options="[16, 20]" @max-change="callFind" class="ms-3">
          </ProductSelect>
        </div>
      </div>
    </div>
  </div>
  
  <!-- 插入分頁組件 -->


  <!-- Modals -->
  <ProductModal ref="productModal" v-model:product="product" @rent="insertTheNameOfTheFunction"></ProductModal>
  <CartModal ref="cartModal"></CartModal>

</template>

<script setup>
// import ProductSelect from '@/components/ProductSelect.vue';

import ProductCard from '@/components/product_and_emp/customer_product/ProductCard.vue';
import Swal from 'sweetalert2';
import axiosapi from '@/plugins/axios';
import { onMounted, ref, watch } from 'vue';

//hsiao
import CartModal from '@/components/cart/CartModal.vue';
import { useCartStore } from '@/stores/cartStore';
const cartStore = useCartStore();
const rentalStartDate = ref(null);
const rentalEndDate = ref(null);

// 更新日期的方法
const updateDate = (type, event) => {
  const value = event.target.value;
  if (type === 'rentalStartDate') {
    rentalStartDate.value = value;
  } else if (type === 'rentalEndDate') {
    rentalEndDate.value = value;
  }

  // 自動加入購物車
  if (rentalStartDate.value && rentalEndDate.value) {
    addToCart();
  }
};

// 添加到購物車的方法
const addToCart = () => {
  // 將日期添加到購物車
  cartStore.addCart({
    rentalStartDate: rentalStartDate.value,
    rentalEndDate: rentalEndDate.value,
  });
};

// （還沒有用到的）分頁 start
import Paginate from "vuejs-paginate-next";
const start = ref(0);
const max = ref(3);
const current = ref(1);
const pages = ref(0);
const total = ref(0);
const lastPageRows = ref(0);
import ProductSelect from '@/components/product_and_emp/customer_product/ProductSelect.vue';
// （還沒有用到的）分頁 end

// modal start
import ProductModal from '@/components/product_and_emp/customer_product/ProductModal.vue';
const productModal = ref(null);
const product = ref({});
function openModal(action, id) {
    callFindById(id);
  productModal.value.showModal();
}
// modal end

// 查詢 start
const findName = ref("");
const products = ref([]);

// 查詢單筆 for modal
function callFindById(id) {
  Swal.fire({
    text: "Loading......",
    showConfirmButton: false,
    allowOutsideClick: false,
  });

  axiosapi.get(`/rent/product/${id}`).then(function (response) {
    console.log("callFindById response", response);

    // 如果 response.data 是物件而非 list，直接賦值給 product
    if (response.data) {
      product.value = response.data; // 直接使用 response.data
    } else {
      Swal.fire({
        text: "找不到產品資料",
        icon: "error",
      });
    }

    setTimeout(function () {
      Swal.close();
    }, 500);
  }).catch(function (error) {
    console.log("callFindById error", error);
    Swal.fire({
      text: "錯誤：" + error.message,
      icon: "error",
    });
  });
}

function callFind(page, categoryId = null) {
    console.log("callFind", page, "categoryId", categoryId);

    if (page) {
        current.value = page;
        start.value = (page - 1) * max.value;
    } else {
        current.value = 1;
        start.value = 0;
    }

    if (findName.value === "") {
        findName.value = null;
    }

    let body = {
        "start": start.value,
        "max": max.value,
        "dir": false,  // 這裡是排序方向，視需要修改為 true（desc）
        "order": "productId",  // 假設你要按產品 ID 排序，根據需求更改
        "name": findName.value,
        "categoryId": categoryId  // 新增 categoryId 條件
    };

    axiosapi.post("/rent/product/find-advanced", body).then(function(response) {
        console.log("callFind response", response);
        products.value = response.data.list;
        total.value = response.data.count;
        pages.value = Math.ceil(total.value / max.value);
        lastPageRows.value = total.value % max.value;

        setTimeout(function() {
            Swal.close();
        }, 500);
    }).catch(function(error) {
        console.log("callFind error", error);
        Swal.fire({
            text: "錯誤：" + error.message,
            icon: "error",
        });
    });
}

// 初始渲染
onMounted(function () {
  callFind();
  fetchCategories();
});

// 分類 start
// 分類渲染 start
const categories = ref([]); // 用來存放後端返回的分類資料

// 從後端查詢所有分類
const fetchCategories = async () => {
  try {
    const response = await axiosapi.get('/rent/category/find');
    const categoryList = response.data; // 取得分類資料
    const filteredCategories = [];

    // 遍歷每個分類，並獲取對應的產品數量
    for (const category of categoryList) {
      try {
        const countResponse = await axiosapi.get(`/rent/product/countByCategory/${category.categoryId}`);
        const productCount = countResponse.data;

        // 只保留產品數量大於 0 的分類
        if (productCount > 0) {
          // 將分類與對應的產品數量一起存儲
          filteredCategories.push({
            ...category,
            productCount: productCount
          });
        }
      } catch (countError) {
        console.error(`獲取分類 ${category.categoryName} 的產品數量失敗：`, countError);
      }
    }

    categories.value = filteredCategories; // 更新有產品的分類列表

  } catch (error) {
    console.error('獲取分類失敗：', error);
  }
};
// 分類渲染 end
// 分類查詢（已合併）
// 分類 end

// 日期功能 start
import FlatPickr from 'vue-flatpickr-component';
import 'flatpickr/dist/flatpickr.css';
function doInput(field) {
  if (field === 'rentalStartDate') {
    // rentalStartDate 會由 v-model 自動更新
    cartStore.setRentalDates(rentalStartDate.value, rentalEndDate.value);

    // 檢查歸還日期是否早於租用日期
    if (rentalEndDate.value && rentalEndDate.value <= rentalStartDate.value) {
      Swal.fire({
        icon: 'error',
        title: '日期錯誤',
        text: '請輸入正確的日期，歸還日期必須晚於租用日期。',
      }).then(() => {
        rentalEndDate.value = null;
        cartStore.setRentalDates(rentalStartDate.value, null);
      });
    }
  } else if (field === 'rentalEndDate') {
    // rentalEndDate 會由 v-model 自動更新
    cartStore.setRentalDates(rentalStartDate.value, rentalEndDate.value);

    // 檢查歸還日期是否早於租用日期
    if (rentalEndDate.value && rentalEndDate.value <= rentalStartDate.value) {
      Swal.fire({
        icon: 'error',
        title: '日期錯誤',
        text: '請輸入正確的日期，歸還日期必須晚於租用日期。',
      }).then(() => {
        rentalEndDate.value = null;
        cartStore.setRentalDates(rentalStartDate.value, null);
      });
    }
  }
}

// 清除兩個日期的方法
const clearDates = () => {
  rentalStartDate.value = null;
  rentalEndDate.value = null;
  cartStore.setRentalDates(null, null); // 同步清除購物車中的日期
};
// 日期功能 end

// 個數計算 start
// 儲存每個產品的可租用數量
const availableQuantities = ref({});
const isDateSelected = ref(false);

// 當日期或產品資料改變時，發送請求取得可用庫存
watch([rentalStartDate, rentalEndDate], async () => {
  if (rentalStartDate.value && rentalEndDate.value) {
    isDateSelected.value = true;
    for (let product of products.value) {
      try {
        const response = await axiosapi.post('/rent/product/check-availability', {
          dateA: rentalStartDate.value,
          dateB: rentalEndDate.value,
          productId: product.productId
        });
        availableQuantities.value[product.productId] = response.data;
      } catch (error) {
        console.error('Failed to get available quantity:', error);
      }
    }
  } else {
    isDateSelected.value = false;
  }
});
// 個數計算 end

</script>

<style></style>