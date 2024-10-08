<template>
  <div class="row mt-5">
    <!-- 左側分類區塊 -->
    <div class="col-md-2">
      <v-card class="mb-3">
        <v-card-title>租用日期</v-card-title>
        <v-card-text>
          <flat-pickr v-model="rentalStartDate" @input="doInput('rentalStartDate', $event)" placeholder="請選擇日期" :config="{
        minDate: new Date(new Date().setDate(new Date().getDate() + 1)), // 當天的隔一天
        maxDate: rentalEndDate ? new Date(new Date(rentalEndDate).setDate(new Date(rentalEndDate).getDate() - 1)) : null,
      }" />
        </v-card-text>
      </v-card>

      <v-card class="mb-3">
        <v-card-title>歸還日期</v-card-title>
        <v-card-text>
          <flat-pickr v-model="rentalEndDate" @input="doInput('rentalEndDate', $event)" placeholder="請選擇日期"
            :config="{ minDate: rentalStartDate ? new Date(new Date(rentalStartDate).setDate(new Date(rentalStartDate).getDate() + 1)) : null, }" />
        </v-card-text>
      </v-card>


      <!-- 陰影效果添加 -->
      <div class="mb-3 mt-3">
        <div class="btn-group" role="group">
          <button class="btn btn-primary shadow1" @click="updateSelectedDates">選擇日期</button>
          <button class="btn btn-danger shadow1" @click="clearDates">重新選擇</button>
        </div>
      </div>

      <!-- 搜尋輸入欄和按鈕組 -->
      <div class="mb-3 mt-6">
        <input type="text" placeholder="請輸入產品名稱" v-model="findName" class="form-control mb-3 mt-3 shadow1"
          @keyup.enter="handleSearch" /> <!-- 監聽 Enter 鍵事件 -->
        <div class="btn-group" role="group">
          <button type="button" class="btn btn-primary shadow1" @click="handleSearch">確認搜尋</button>
          <button type="button" class="btn btn-secondary shadow1" @click="handleClearSearch">清除搜尋</button>
        </div>
      </div>

      <br>
      <h4>商品分類</h4>
      <table>
        <tr v-for="category in categories" :key="category.categoryId" @click="callFind(1, category.categoryId)"
          class="category-link">
          <td>{{ category.categoryName }} ({{ category.productCount }})</td>
        </tr>
        <br>
        <tr @click="callFind(1, null)" class="category-link">
          <td>所有分類 ({{ categoryTotal }})</td>
        </tr>
      </table>
    </div>

    <!-- 右側產品區塊 -->
    <div class="col-md-10">
      <!-- 產品列表 -->
      <div class="row">
        <ProductCard v-for="product in products" :key="product.productId" :item="product"
          :isDateSelected="isDateSelected" :available-quantity="availableQuantities[product.productId]"
          @open-rent="openModal"></ProductCard>
      </div>

      <!-- 分頁與選擇欄 -->
      <div class="row mt-3">
        <div class="d-flex justify-content-between align-items-center w-100">

          <!-- 置中 Paginate -->
          <div class="d-flex justify-content-center flex-grow-1">
            <Paginate v-if="total > 0" :first-last-button="true" first-button-text="&lt;&lt;"
              last-button-text="&gt;&gt;" prev-text="&lt;" next-text="&gt;" :page-count="pages" :initial-page="current"
              v-model="current" :click-handler="callFind" class="shadow-p">
            </Paginate>
            <h2 v-else-if="!loading">查無資料😭</h2>
          </div>

          <!-- 右側的 ProductSelect -->
          <div v-show="total>0" class="ms-auto">
            <ProductSelect v-model="max" :total="total" :options="[4, 8, 12, 16]" @max-change="callFind">
            </ProductSelect>
          </div>
        </div>
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

// 分頁 start
import Paginate from "vuejs-paginate-next";
const start = ref(0);
const max = ref(8);
const current = ref(1);
const pages = ref(0);
const total = ref(0); const categoryTotal = ref(0);  // 「所有分類」的總數
const lastPageRows = ref(0);
import ProductSelect from '@/components/product_and_emp/customer_product/ProductSelect.vue';
// 分頁 end

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

// 複雜查詢
const selectedCategoryId = ref(null);  // 用來保存當前選擇的分類 ID
const loading = ref(true);  // 初始化為 true

function callFind(page, categoryId = null, clear = false) {
    console.log("callFind", page, "categoryId", categoryId, "clear", clear);

    loading.value = true;  // 開始查詢，顯示 loading 狀態

    if (clear) {
        findName.value = "";  // 清空搜尋名稱
        categoryId = null;    // 清空分類
    }

    if (page) {
        current.value = page;
        start.value = (page - 1) * max.value;
    } else {
        current.value = 1;
        start.value = 0;
    }

    let body = {
        "start": start.value,
        "max": max.value,
        "dir": false,
        "order": "productId",
        "name": findName.value || null,
        "categoryId": categoryId,
        "statusId": 2  // 添加 status_id = 2 的條件
    };

    axiosapi.post("/rent/product/find-advanced", body).then(function(response) {
        console.log("callFind response", response);
        products.value = response.data.list;
        pages.value = Math.ceil(response.data.count / max.value);
        lastPageRows.value = response.data.count % max.value;

        // 只在點擊所有分類或清除搜尋時更新 categoryTotal
        if (categoryId === null || clear) {
            categoryTotal.value = response.data.count;  // 更新「所有分類」的總數
        }

        total.value = response.data.count;  // 更新頁面上的總數（會因為分類或其他條件變動）

        loading.value = false;  // 查詢完成，隱藏 loading 狀態
      triggerAvailabilityCheck();
        
        setTimeout(function() {
            Swal.close();
        }, 500);
    }).catch(function(error) {
        console.log("callFind error", error);
        loading.value = false;  // 即使出錯也要隱藏 loading 狀態
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
  fetchCartDates();
});

// 分類 start
// 分類渲染 start
const categories = ref([]); // 用來存放後端返回的分類資料
const filteredCategories = ref([]);  // 用來存放有產品的分類

// 從後端查詢所有分類
const fetchCategories = async () => {
  try {
    const response = await axiosapi.get('/rent/category/find');
    const categoryList = response.data; // 取得分類資料

    // 清空 filteredCategories 以確保新數據進入
    filteredCategories.value = [];

    // 遍歷每個分類，並獲取對應的產品數量
    for (const category of categoryList) {
      try {
        const countResponse = await axiosapi.get(`/rent/product/countAvailableByCategory/${category.categoryId}`);
        const productCount = countResponse.data;

        // 只保留產品數量大於 0 的分類
        if (productCount > 0) {
          // 將分類與對應的產品數量一起存儲
          filteredCategories.value.push({
            ...category,
            productCount: productCount
          });
        }
      } catch (countError) {
        console.error(`獲取分類 ${category.categoryName} 的產品數量失敗：`, countError);
      }
    }

    // 按照 displaySequence 排序
    filteredCategories.value.sort((a, b) => a.displaySequence - b.displaySequence);

    categories.value = filteredCategories.value; // 更新有產品的分類列表

  } catch (error) {
    console.error('獲取分類失敗：', error);
  }
};

// 更新分類之產品數量的函數，根據文字搜尋結果更新數量
function fetchAndUpdateCategoryCounts(searchTerm) {
    console.log("Starting fetchAndUpdateCategoryCounts...");

    // 遍歷 filteredCategories 以針對每個分類進行交集查詢
    filteredCategories.value.forEach(async (category) => {
        try {
            // 查詢分類和文字搜尋的交集數量
            let body = {
                "start": 0,  // 不需要分頁，只需要統計
                "max": 1000,  // 設置一個很大的值，確保能抓取所有產品
                "dir": false, 
                "order": "productId",
                "name": searchTerm || null,  // 傳遞當前的搜尋條件
                "categoryId": category.categoryId  // 傳遞分類 ID
            };

            console.log("Body for find-advanced API:", body);

            // 發送請求到 find-advanced，查詢分類與搜尋條件的交集
            const response = await axiosapi.post("/rent/product/find-advanced", body);

            // 獲取該分類的產品數量
            const categoryCount = response.data.count;

            console.log(`分類 ${category.categoryName} 的產品數量: ${categoryCount}`);

            // 更新分類的產品數量
            category.productCount = categoryCount;

        } catch (error) {
            console.log(`fetchAndUpdateCategoryCounts encountered an error for category ${category.categoryName}:`, error);
            Swal.fire({
                text: "錯誤：" + error.message,
                icon: "error",
            });
        }
    });
    console.log("fetchAndUpdateCategoryCounts function completed.");
}

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
  isDateSelected.value = false;
};
// 日期功能 end

// 個數計算 start
// 儲存每個產品的可租用數量
const availableQuantities = ref({});
const isDateSelected = ref(false);

// 當日期或產品資料改變時，發送請求取得可用庫存
watch([rentalStartDate, rentalEndDate], () => {
  if (rentalStartDate.value && rentalEndDate.value) {
    triggerAvailabilityCheck();  // 手動觸發計算
  }
});

function triggerAvailabilityCheck() {
    if (rentalStartDate.value && rentalEndDate.value) {
        isDateSelected.value = true;
        for (let product of products.value) {
            axiosapi.post('/rent/product/check-availability', {
                dateA: rentalStartDate.value,
                dateB: rentalEndDate.value,
                productId: product.productId
            }).then(response => {
                availableQuantities.value[product.productId] = response.data;
            }).catch(error => {
                console.error('Failed to get available quantity:', error);
            });
        }
    } else {
        isDateSelected.value = false;
    }
}
// 個數計算 end

function handleSearch() {
    callFind(1, null);
    fetchAndUpdateCategoryCounts(findName.value);  // 傳入搜尋條件以更新分類數量
}

function handleClearSearch() {
    callFind(1, null, true); 
    fetchAndUpdateCategoryCounts("");  // 傳入空值表示清除搜尋條件
}

function fetchCartDates() {
    const storedData = localStorage.getItem('user');
    if (storedData) {
        const userData = JSON.parse(storedData);
        const membersId = userData.membersId;

        if (membersId) {
            axiosapi.get(`/rent/cart/members/${membersId}/cart`).then(response => {
                console.log("API Response: ", response.data);

                if (response.data.length > 0) {
                    // 找出 cartId 最大的項目
                    const cartItem = response.data.reduce((maxItem, currentItem) => {
                        return currentItem.cartId > maxItem.cartId ? currentItem : maxItem;
                    });

                    // 設置日期到日曆
                    rentalStartDate.value = new Date(cartItem.rentalStartDate);
                    rentalEndDate.value = new Date(cartItem.rentalEndDate);

                    console.log("租用日期: ", rentalStartDate.value);
                    console.log("歸還日期: ", rentalEndDate.value);

                    // 延遲庫存檢查，確保日期已正確設置
                    setTimeout(() => {
                        triggerAvailabilityCheck();
                    }, 100);  // 延遲100毫秒確保日期已設置
                }
            }).catch(error => {
                console.error("Error fetching cart dates:", error);
            });
        }
    }
}

const updateSelectedDates = () => {
  if (!rentalStartDate.value || !rentalEndDate.value) {
    Swal.fire({
      icon: 'error',
      title: '錯誤',
      text: '請選擇租用日期和歸還日期。',
    });
    return;
  }

  // 更新日期並刷新可用庫存
  triggerAvailabilityCheck();

  // 提示用戶日期已選擇成功
  Swal.fire({
    icon: 'success',
    title: '成功',
    text: '日期已選擇！',
  });
};

</script>

<style scoped>

  /* 調整陰影 */
  .shadow1 {
    box-shadow: 0 1px 1.5px rgba(0, 0, 0, 0.5); /* 給輸入框和按鈕加上陰影 */
  }
  .shadow-p {
    box-shadow: 0 1px 1.5px rgba(0, 0, 0, 0.5); /* 給輸入框和按鈕加上陰影 */
    border-radius: 6px; /* 這是圓角 */
  }

  /* Button group 裡的文字顏色設定為白色，並用 !important 防止干擾 */
  .btn {
    color: white !important; /* 強制設置文字為白色 */
  }

  /* 設置分類為手型游標 */
  .category-link:hover {
    cursor: pointer; /* 游標變成手型 */
  }

</style>