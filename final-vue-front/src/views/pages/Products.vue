<template>
    <h3>Products</h3>
    <div class="row">
        <div class="col-2">
            <button type="button" class="btn btn-primary" @click="openModal('insert')">開啟新增</button>
        </div>
        <div class="col-6">
            <input type="text" placeholder="請輸入查詢條件" v-model="findName" @input="callFind">
        </div>
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
</template>
    
<script setup>
    import ProductCard from '@/components/product_and_emp/customer_product/ProductCard.vue';
    import ProductSelect from '@/components/product_and_emp/customer_product/ProductSelect.vue';
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
    import ProductModal from '@/components/product_and_emp/customer_product/ProductModal.vue';
    const productModal = ref(null);
    const product = ref({ });
    const isShowInsertButton = ref(true);
    function openModal(action, id) {
        if(action==='insert') {
            isShowInsertButton.value = true;
            product.value = {};
        } else {
            isShowInsertButton.value = false;
            callFindById(id);
        }
        productModal.value.showModal();
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
            const response = await axiosapi.post("/ajax/pages/products", body);
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
        Swal.fire({
            text: "確定刪除？",
            icon: "question",
            showCancelButton: true,
            allowOutsideClick: false,
        }).then(function(result) {
            if(result.isConfirmed) {
                Swal.fire({
                    text: "Loading......",
                    showConfirmButton: false,
                    allowOutsideClick: false,
                });
                axiosapi.delete(`/ajax/pages/products/${id}`).then(function(response) {
                    console.log("callRemove response", response);
                    if(response.data.success) {
                        Swal.fire({
                            text: response.data.message,
                            icon: "success",
                        }).then(function(result) {
                            if(current.value > 1 && lastPageRows.value===1) {
                                current.value = current.value - 1 ;
                            }
                            callFind(current.value);
                            productModal.value.hideModal();
                        });
                    } else {
                        Swal.fire({
                            text: response.data.message,
                            icon: "error",
                        });
                    }
                }).catch(function(error) {
                    console.log("callRemove error", error);
                    Swal.fire({
                        text: "錯誤："+error.message,
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
        axiosapi.get(`/ajax/pages/products/${id}`).then(function(response) {
            console.log("callFindById response", response);
            product.value = response.data.list[0];
            setTimeout(function() {
                Swal.close();
            }, 500);
        }).catch(function(error) {
            console.log("callFindById error", error);
            Swal.fire({
                text: "錯誤："+error.message,
                icon: "error",
            });
        });
    }
    function callModify() {
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

        axiosapi.put(`/ajax/pages/products/${body.id}`, body).then(function(response) {
            console.log("callModify response", response);
            if(response.data.success) {
                Swal.fire({
                    text: response.data.message,
                    icon: "success",
                }).then(function(result) {
                    callFind(current.value);
                    productModal.value.hideModal();
                });
            } else {
                Swal.fire({
                    text: response.data.message,
                    icon: "error",
                });
            }
        }).catch(function(error) {
            console.log("callModify error", error);
            Swal.fire({
                text: "錯誤："+error.message,
                icon: "error",
            });
        });
    }
    function callFind(page) {
        console.log("callFind", page);

        if(page) {
            current.value = page;
            start.value = (page - 1) * max.value;
        } else {
            current.value = 1;
            start.value = 0;
        }

        if(findName.value==="") {
            findName.value = null;
        }

        let body = {
            "start": start.value,
            "max": max.value,
            "dir": false,
            "order": "id",
            "name": findName.value
        };

        axiosapi.post("/ajax/pages/products/find", body).then(function(response) {
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
                text: "錯誤："+error.message,
                icon: "error",
            });
        });
    }
    onMounted(function() {
        callFind();
    });
</script>
    
<style>
    
</style>