<template>
  <div class="row">
    <!-- 左側分類區塊 -->
    <div class="col-md-2">
      <tr>
          <td>租用日期</td>
          <td><input type="date" name="rentalStartDate" :max="rentalEndDate" @input="doInput('rentalStartDate', $event)"></td>
      </tr>
      <tr>
          <td>歸還日期</td>
          <td><input type="date" name="rentalEndDate" :min="rentalStartDate" @input="doInput('rentalEndDate', $event)"></td>
          <!-- <td><button @click="checkAvailability">送出查詢</button></td> -->
      </tr>
      <h4>商品分類</h4>
      <table>
        <tr v-for="category in categories" :key="category.categoryId" @click="fetchProductsByCategory(category.categoryId)">
        <td>{{ category.categoryName }} ({{ category.productCount }})</td>
      </tr>
      </table>
    </div>

    <!-- 右側產品區塊 -->
    <div class="col-md-10">

      <!-- 插入分頁組件（詳最後面） -->

      <!-- 產品列表 -->
      <div class="row">
        <ProductCard v-for="product in products" :key="product.id" :item="product" :isDateSelected="isDateSelected"
        :available-quantity="availableQuantities[product.productId]" @open-rent="openModal"></ProductCard>
      </div>
    </div>
  </div>

  <!-- Modals -->
  <ProductModal ref="productModal" v-model:product="product" @rent="insertTheNameOfTheFunction"></ProductModal>
  <CartModal ref="cartModal"></CartModal>

</template>

<script setup>
// import ProductSelect from '@/components/ProductSelect.vue';

import ProductCard from '@/components/product_and_emp/customer_product/ProductCard.vue';
import Swal from 'sweetalert2';
import axiosapi from '@/plugins/axios';
import { onMounted, ref ,watch} from 'vue';

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
// import Paginate from "vuejs-paginate-next";
const start = ref(0);
const max = ref(3);
const current = ref(1);
const pages = ref(0);
const total = ref(0);
const lastPageRows = ref(0);
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

// 查詢全部 for whole page
function callFind(page) {
  console.log("callFind triggered, page:", page);

  if (page) {
    current.value = page;
    start.value = (page - 1) * max.value;
  } else {
    current.value = 1;
    start.value = 0;
  }

  console.log("Pagination values - start:", start.value, "max:", max.value, "current:", current.value);

  if (findName.value === "") {
    findName.value = null;
  }

  console.log("Search name value:", findName.value);

  let body = {
    "start": start.value,
    "max": max.value,
    "dir": false,
    "order": "id",
    "name": findName.value
  };

  console.log("Request body:", body);

  axiosapi.get("/rent/product/find", body)
    .then(function (response) {
      console.log("callFind response received:", response);

      // Check if response structure is as expected
      if (response.data && response.data) {
        products.value = response.data;
        total.value = response.data.count;
        pages.value = Math.ceil(total.value / max.value);
        lastPageRows.value = total.value % max.value;

        console.log("Updated products:", products.value);
        console.log("Total count:", total.value, "Pages:", pages.value, "Last page rows:", lastPageRows.value);
      } else {
        console.warn("Unexpected response structure:", response);
      }

      setTimeout(function () {
        Swal.close();
      }, 500);
    })
    .catch(function (error) {
      console.log("callFind error:", error);
      console.log("Error details - message:", error.message, "code:", error.code);

      Swal.fire({
        text: "錯誤：請先登錄會員!!!",
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

// 分類查詢 start
const fetchProductsByCategory = async (categoryId) => {
  try {
    const response = await axiosapi.get(`/rent/product/findByCategory/${categoryId}`);
    products.value = response.data; // 更新右側顯示的商品列表
  } catch (error) {
    console.error(`獲取分類 ${categoryId} 的商品失敗：`, error);
  }
};
// 分類查詢 end
// 分類 end



// 日期功能 start
function doInput(field, event) {
  const value = event.target.value;
  if (field === 'rentalStartDate') {
    rentalStartDate.value = value; // 確保 rentalStartDate 更新
    cartStore.setRentalDates(value, cartStore.rentalEndDate);

    // 如果歸還日期早於租用日期，自動清空歸還日期
    if (rentalEndDate.value && rentalEndDate.value <= rentalStartDate.value) {
      rentalEndDate.value = null; // 清空歸還日期
      cartStore.setRentalDates(rentalStartDate.value, null);
    }
  } else if (field === 'rentalEndDate') {
    rentalEndDate.value = value; // 確保 rentalEndDate 更新
    cartStore.setRentalDates(cartStore.rentalStartDate, value);

    // 如果歸還日期早於租用日期，自動清空歸還日期
    if (rentalEndDate.value && rentalEndDate.value <= rentalStartDate.value) {
      rentalEndDate.value = null; // 清空歸還日期
      cartStore.setRentalDates(cartStore.rentalStartDate, null);
    }
  }
}
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

// 手動查詢可用庫存的功能
const checkAvailability = async () => {
  // 確保日期已經正確更新，並打印出來檢查
  console.log("傳送的租用日期: ", rentalStartDate.value, rentalEndDate.value); // 除錯：打印日期
  isDateSelected.value = true;
  for (let product of products.value) {
    try {
      // 傳送API請求並附帶日期和產品ID
      const response = await axiosapi.post('/rent/product/check-availability', {
        dateA: rentalStartDate.value, // 傳送的租用開始日期
        dateB: rentalEndDate.value,   // 傳送的租用結束日期
        productId: product.productId
      });

      // 記錄回傳的可租用數量
      availableQuantities.value[product.productId] = response.data;

      // 確認API回傳內容
      console.log('可用數量 for productId ' + product.productId + ': ' + response.data);

    } catch (error) {
      console.error('獲取可用數量失敗:', error); // 如果請求失敗，打印錯誤訊息
    }
  }
};
// 個數計算 start

</script>

<style></style>


  <!-- <div class="row">
    <div class="col-2">
            <button type="button" class="btn btn-primary" @click="openModal('insert')">開啟新增</button>
        </div>
    <div class="col-6">å
            <input type="text" placeholder="請輸入查詢條件" v-model="findName" @input="callFind">
        </div>
    <div class="col-4">
      <ProductSelect v-model="max" :total="total" :options="[2, 3, 4, 5, 7, 10]" @max-change="callFind">
      </ProductSelect>
    </div>
  </div>
  <br> -->

  <!-- <div class="row">
    <Paginate v-show="total > 0" :first-last-button="true" first-button-text="&lt;&lt;" last-button-text="&gt;&gt;"
      prev-text="&lt;" next-text="&gt;" :page-count="pages" :initial-page="current" v-model="current"
      :click-handler="callFind">
    </Paginate>
  </div>
  <br> -->

<!-- 日期 doInput 舊程式碼備用 -->
  <!-- function doInput(field, event) {
    const value = event.target.value;
    if (field === 'rentalStartDate') {
      rentalStartDate.value = value; // 確保 rentalStartDate 更新
      cartStore.setRentalDates(value, cartStore.rentalEndDate);
    } else if (field === 'rentalEndDate') {
      rentalEndDate.value = value; // 確保 rentalEndDate 更新
      cartStore.setRentalDates(cartStore.rentalStartDate, value);
    }
  } -->

<!-- 日期 doInput Sweetalert2 備用 -->
  <!-- function doInput(field, event) {
    const value = event.target.value;
    if (field === 'rentalStartDate') {
      rentalStartDate.value = value; // 確保 rentalStartDate 更新
      cartStore.setRentalDates(value, cartStore.rentalEndDate);
  
      // 如果歸還日期早於租用日期，彈出提示
      if (rentalEndDate.value && rentalEndDate.value <= rentalStartDate.value) {
        Swal.fire({
          icon: 'error',
          title: '日期錯誤',
          text: '請輸入正確的日期，歸還日期必須晚於租用日期。',
        }).then(() => {
          // 點擊OK後才清空歸還日期
          rentalEndDate.value = null; 
          cartStore.setRentalDates(rentalStartDate.value, null);
        });
      }
    } else if (field === 'rentalEndDate') {
      rentalEndDate.value = value; // 確保 rentalEndDate 更新
      cartStore.setRentalDates(cartStore.rentalStartDate, value);
  
      // 如果歸還日期早於租用日期，彈出提示
      if (rentalEndDate.value && rentalEndDate.value <= rentalStartDate.value) {
        Swal.fire({
          icon: 'error',
          title: '日期錯誤',
          text: '請輸入正確的日期，歸還日期必須晚於租用日期。',
        }).then(() => {
          // 點擊OK後才清空歸還日期
          rentalEndDate.value = null;
          cartStore.setRentalDates(cartStore.rentalStartDate, null);
        });
      }
    }
  } -->