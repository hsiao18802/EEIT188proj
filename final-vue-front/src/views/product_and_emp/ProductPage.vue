<template>
  <!-- <ProductNavbar></ProductNavbar> -->
  <h3>Products</h3>
  <tr>
                            <td>租用日期</td>
                            <td><input type="date" name="rentalStartDate" @input="doInput('rentalStartDate', $event)"></td>
                        </tr>
                        <tr>
                            <td>歸還日期</td>
                            <td><input type="date" name="rentalEndDate" @input="doInput('rentalEndDate', $event)"></td>
                        </tr>
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

  <div class="row">
    <ProductCard v-for="product in products" :key="product.id" :item="product" @open-rent="openModal">
    </ProductCard>
  </div>

  <ProductModal ref="productModal" v-model:product="product" @rent="insertTheNameOfTheFunction">
  </ProductModal>

   <!-- 購物車 Modal -->
   <CartModal ref="cartModal"></CartModal>

</template>

<script setup>
// import ProductNavbar from './ProductNavbar.vue';
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


//分頁 start
// import Paginate from "vuejs-paginate-next";
const start = ref(0);
const max = ref(3);
const current = ref(1);
const pages = ref(0);
const total = ref(0);
const lastPageRows = ref(0);
//分頁 end

//modal start
import ProductModal from '@/components/product_and_emp/customer_product/ProductModal.vue';
const productModal = ref(null);
const product = ref({});
function openModal(action, id) {
    callFindById(id);
  productModal.value.showModal();
}
//modal end

const findName = ref("");
const products = ref([]);


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

onMounted(function () {
  callFind();
});





function doInput(field, event) {
  const value = event.target.value;
  if (field === 'rentalStartDate') {
    cartStore.setRentalDates(value, cartStore.rentalEndDate);
  } else if (field === 'rentalEndDate') {
    cartStore.setRentalDates(cartStore.rentalStartDate, value);
  }
}


</script>

<style></style>