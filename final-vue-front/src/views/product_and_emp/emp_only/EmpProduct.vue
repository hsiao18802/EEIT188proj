<template>
    <h1 style="font-family: '微軟正黑體', sans-serif; font-size: xx-large; font-weight: bold;">商品管理</h1>
    <div class="row">
        <div class="col-2">
            <button type="button" class="btn btn-primary" @click="openModal('insert')">開啟新增</button>
        </div>
        <!-- <div class="col-6">
            <input type="text" placeholder="請輸入查詢條件" v-model="findName" @input="callFind">
        </div> -->
        <div class="col-4">
            <ProductSelect v-model="max" :total="total" :options="[2, 3, 4, 5, 7, 10]" @max-change="callFind">
            </ProductSelect>
        </div>
    </div>
    <br>

    <div class="row">
        <Paginate v-show="total>0"
            :first-last-button="true"
            first-button-text="&lt;&lt;" last-button-text="&gt;&gt;"
            prev-text="&lt;" next-text="&gt;"
            :page-count="pages" :initial-page="current" v-model="current"
            :click-handler="callFind">
        </Paginate>
    </div>
    <br>
    
    <div class="row">
        <ProductCard v-for="product in products" :key="product.id"
                    :item="product" @delete="callRemove" @open-update="openModal">
        </ProductCard>
    </div>

    <ProductModal ref="productModal" v-model:product="product"
            :is-show-insert-button="isShowInsertButton"
            @insert="callCreate" @update="callModify">
    </ProductModal>

    <!-- <ProductModal ref="productModal" v-model:product="product"
            :is-show-insert-button="isShowInsertButton"
            @insert="callCreate" @update="callModify" v-if="!isChangePicModal">
    </ProductModal> -->

    <!-- <ProductModal ref="changePicModal" v-model:product="product"
    :is-show-insert-button="isShowInsertButton"
    @update="uploadImage" v-if="isChangePicModal">
</ProductModal> -->
</template>

<script setup>
import ProductCard from '@/components/product_and_emp/emp_product/EmpProductCard.vue';
    // import ProductSelect from '@/components/ProductSelect.vue';
    import Swal from 'sweetalert2';
    import axiosapi from '@/plugins/axios';
    import { onMounted, ref } from 'vue';

    //分頁 start
    import Paginate from "vuejs-paginate-next";
    const start = ref(0);
    const max = ref(3);
    const current = ref(1);
    const pages = ref(0);
    const total = ref(0);
    const lastPageRows = ref(0);
    //分頁 end
    //modal start
    import ProductModal from '@/components/product_and_emp/emp_product/EmpProductModal.vue';
    const productModal = ref(null);
    const changePicModal = ref(null);  // 新增這個參考來控制換圖的Modal
    const product = ref({ });
    const isShowInsertButton = ref(true);
    const isChangePicModal = ref(false);  // 新增一個變數來區分是修改產品還是換圖
    // function openModal(action, id) {
    //     if(action==='changePic'){
    //         changePicModal.value.showModal();
    //     } else{

    //         if(action==='insert') {
    //             isShowInsertButton.value = true;
    //             product.value = {};
    //         } else {
    //             isShowInsertButton.value = false;
    //             callFindById(id);
    //         }
    //         productModal.value.showModal();
    //     }
    // }
    function openModal(action, id) {
    if (action === 'changePic') {
        isChangePicModal.value = true;  // 設定換圖模式
        callFindById(id);  // 查詢產品的資料，讓 Modal 顯示產品編號和名稱
        changePicModal.value.showModal();
    } else {
        isChangePicModal.value = false;  // 設定為一般修改模式
        if (action === 'insert') {
            isShowInsertButton.value = true;
            product.value = {};
        } else {
            isShowInsertButton.value = false;
            callFindById(id);
        }
        productModal.value.showModal();
    }
}
    //modal end

    const findName = ref("");
    const products = ref([]);

    async function callCreate() {
        Swal.fire({
            text: "Loading......",
            showConfirmButton: false,
            allowOutsideClick: false,
        });

        if(product.value.id==="") {
            product.value.id = null;
        }
        if(product.value.name==="") {
            product.value.name = null;
        }
        if(product.value.price==="") {
            product.value.price = null;
        }
        if(product.value.make==="") {
            product.value.make = null;
        }
        if(product.value.expire==="") {
            product.value.expire = null;
        }
        let body = product.value;
        console.log("body", body);

        try {
            const response = await axiosapi.post("/rent/product/add", body);
            console.log("callCreate response", response);
            if(response.data.success) {
                Swal.fire({
                    text: response.data.message,
                    icon: "success",
                }).then(function(result) {
                    productModal.value.hideModal();
                    callFind(current.value);
                });
            } else {
                Swal.fire({
                    text: response.data.message,
                    icon: "error",
                });
            }
        } catch(error) {
            console.log("callCreate error", error);
            Swal.fire({
                text: "錯誤："+error.message,
                icon: "error",
            });
        }
    }
    function callRemove(id) {
    console.log("開始刪除，ID:", id);
    Swal.fire({
        text: "確定刪除？",
        icon: "question",
        showCancelButton: true,
        allowOutsideClick: false,
    }).then(function(result) {
        if (result.isConfirmed) {
            console.log("使用者確認刪除，ID:", id);
            Swal.fire({
                text: "Loading......",
                showConfirmButton: false,
                allowOutsideClick: false,
            });

            // 進行刪除請求
            axiosapi.delete(`/rent/product/${id}`)
                .then(function(response) {
                    console.log("callRemove response", response); // 查看完整回應
                    if (response.data && response.data.success) {
                        Swal.fire({
                            text: response.data.message,
                            icon: "success",
                        }).then(function(result) {
                            if (current.value > 1 && lastPageRows.value === 1) {
                                current.value = current.value - 1;
                            }
                            callFind(current.value);
                            productModal.value.hideModal();
                        });
                    } else {
                        console.log("callRemove response data 無 success 屬性", response.data);
                        Swal.fire({
                            text: response.data.message || "刪除失敗，請稍後再試",
                            icon: "error",
                        });
                    }
                })
                .catch(function(error) {
                    console.log("callRemove error", error);
                    Swal.fire({
                        text: "錯誤：" + (error.response ? error.response.data.message : error.message),
                        icon: "error",
                    });
                });
        }
    });
}
    function callFindById(id) {
    Swal.fire({
        text: "Loading......",
        showConfirmButton: false,
        allowOutsideClick: false,
    });
    
    axiosapi.get(`/rent/product/${id}`).then(function(response) {
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

        setTimeout(function() {
            Swal.close();
        }, 500);
    }).catch(function(error) {
        console.log("callFindById error", error);
        Swal.fire({
            text: "錯誤：" + error.message,
            icon: "error",
        });
    });
}

    function callModify() {


    axiosapi.put(`/rent/product/${body.productId}`, body).then(function(response) {
        console.log("callModify 成功 response:", response);
        console.log("response.data:", response.data);

        if (response.data && response.data.success) {
            Swal.fire({
                text: response.data.message || '修改成功',
                icon: "success",
            }).then(function(result) {
                callFind(current.value);
                productModal.value.hideModal();
            });
        } else {
            Swal.fire({
                text: response.data.message || '發生錯誤，請稍後再試',
                icon: "error",
            });
        }
    }).catch(function(error) {
        console.log("callModify 發生錯誤:", error);
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
        .then(function(response) {
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

            setTimeout(function() {
                Swal.close();
            }, 500);
        })
        .catch(function(error) {
            console.log("callFind error:", error);
            console.log("Error details - message:", error.message, "code:", error.code);

            Swal.fire({
                text: "錯誤：" + error.message,
                icon: "error",
            });
        });
}

    onMounted(function() {
        callFind();
    });

    function handleBase64Image(imageFile) {
        return new Promise((resolve, reject) => {
    console.log("handleBase64Image called with file:", imageFile);

    const reader = new FileReader();

    // 當讀取成功時，將圖片轉換為 Base64 格式
    reader.onload = function (event) {
        console.log("FileReader onload event:", event);
      const base64String = event.target.result.split(",")[1]; // 去掉 "data:image/jpeg;base64," 這段
        console.log("Base64 string generated:", base64String);
        resolve(base64String);
    };

    // 當讀取失敗時，返回錯誤
    reader.onerror = function (error) {
        console.log("FileReader onerror, failed to read file:", error);
        reject(error);
    };

    // 開始讀取圖片，格式為 Data URL
    console.log("Starting to read the image file...");
    reader.readAsDataURL(imageFile);
        });
}
</script>

<style>

</style>