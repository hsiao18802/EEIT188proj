<template>
    <h1 style="font-family: '微軟正黑體', sans-serif; font-size: xx-large; font-weight: bold;">商品管理</h1>
    <div class="row">
        <div class="col-2">
            <button type="button" class="btn btn-primary" @click="openModal('insert')" style="color: white;">開啟新增</button>
        </div>
        <div class="col-4">
            <ProductSelect v-model="max" :total="total" :options="[2, 3, 4, 5, 7, 10]" @max-change="callFind"></ProductSelect>
        </div>
    </div>
    <br>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">圖片</th>
                <th scope="col">產品名稱</th>
                <th scope="col">產品分類</th>
                <th scope="col">每日租金</th>
                <th scope="col">庫存數量</th>
                <th scope="col">產品描述</th>
                <th scope="col">增修人員</th>
                <th scope="col">最後增修</th>
                <th scope="col">修改刪除</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="product in products" :key="product.id">
                <td></td>
                <th scope="row">{{ product.productName }}</th>
                <td>{{ product.categoryId }}</td>
                <td>{{ product.dailyFeeOriginal }}</td>
                <td>{{ product.maxAvailableQuantity }}</td>
                <td>{{ product.description }}</td>
                <td v-if="product.lastUpdateEmployeeId">{{ product.lastUpdateEmployeeId }}</td>
                <td v-else>{{ product.addEmployeeId }}</td>
                <td v-if="product.lastUpdateDatetime">{{ formatDate(product.lastUpdateDatetime) }}</td>
                <td v-else>{{ formatDate(product.addDatetime) }}</td>
                <td><div class="btn-group col text-end">
                        <a class="btn btn-primary"
                            @click="$emit('openUpdate', 'update', item.productId)">修改</a>
                        <a class="btn btn-danger"
                                @click="emits('delete', item.productId)">刪除</a>
                    </div></td>
            </tr>
        </tbody>
    </table>
    <div class="row">
        <ProductCard v-for="product in products" :key="product.id" :item="product" @delete="callRemove" @open-update="openModal" @open-change-pic="openChangePic"></ProductCard>
    </div>

    <ProductModal ref="productModal" v-model:product="product" :is-show-insert-button="isShowInsertButton" @insert="callCreate" @update="callModify" @imageSelected="handleImageSelected"></ProductModal>
    <EmpChangePic ref="picModal" v-model:product="product" @imageSelected="handleImageSelected" @changepic="callChangePic"></EmpChangePic>
</template>

<script setup>
import ProductCard from '@/components/product_and_emp/emp_product/EmpProductCard.vue';
import Swal from 'sweetalert2';
import axiosapi from '@/plugins/axios';
import { onMounted, ref } from 'vue';

import ProductModal from '@/components/product_and_emp/emp_product/EmpProductModal.vue';
import EmpChangePic from '@/components/product_and_emp/emp_product/EmpChangePic.vue';

const start = ref(0);
const max = ref(3);
const current = ref(1);
const total = ref(0);
const lastPageRows = ref(0);
const productModal = ref(null);
const picModal = ref(null);
const product = ref({});
const isShowInsertButton = ref(true);
const findName = ref("");
const products = ref([]);

function openModal(action, id) {
    if (action === 'insert') {
        isShowInsertButton.value = true;
        product.value = {};
    } else {
        isShowInsertButton.value = false;
        callFindById(id);
    }
    productModal.value.showModal();
}

function openChangePic(action, id) {
    product.value = {};
    callFindById(id);
    picModal.value.showModal();
}

function callRemove(id) {
    Swal.fire({
        text: "確定刪除？",
        icon: "question",
        showCancelButton: true,
        allowOutsideClick: false,
    }).then(function(result) {
        if (result.isConfirmed) {
            Swal.fire({
                text: "Loading......",
                showConfirmButton: false,
                allowOutsideClick: false,
            });
            axiosapi.delete(`/rent/product/${id}`)
                .then(function(response) {
                    if (response.data && response.data.success) {
                        handleSuccess(response.data.message, productModal.value);
                    } else {
                        handleError(new Error(response.data.message || "刪除失敗，請稍後再試"));
                    }
                })
                .catch(handleError);
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
        if (response.data) {
            product.value = response.data;
        } else {
            Swal.fire({
                text: "找不到產品資料",
                icon: "error",
            });
        }
        setTimeout(function() {
            Swal.close();
        }, 500);
    }).catch(handleError);
}

function callFind(page) {
    current.value = page || 1;
    start.value = (current.value - 1) * max.value;
    findName.value = findName.value || null;

    let body = { start: start.value, max: max.value, dir: false, order: "id", name: findName.value };
    axiosapi.get("/rent/product/find", body)
        .then(function(response) {
            if (response.data) {
                products.value = response.data;
                total.value = response.data.count;
            }
            setTimeout(function() {
                Swal.close();
            }, 500);
        })
        .catch(handleError);
}

async function callCreate() {
    Swal.fire({
        text: "Loading......",
        showConfirmButton: false,
        allowOutsideClick: false,
    });

    let body = product.value;

    try {
        if (selectedImage.value) {
            const reader = new FileReader();
            reader.onloadend = async function() {
                body.mainPhoto = reader.result.split(",")[1];
                await sendCreateRequest(body);
            };
            reader.onerror = handleError;
            reader.readAsDataURL(selectedImage.value);
        } else {
            await sendCreateRequest(body);
        }
    } catch (error) {
        handleError(error);
    }
}

async function sendCreateRequest(body) {
    try {
        const response = await axiosapi.post("/rent/product/add", body);
        if (response.data.success) {
            handleSuccess(response.data.message, productModal.value);
        } else {
            handleError(new Error(response.data.message));
        }
    } catch (error) {
        handleError(error);
    }
}

function callModify() {
    Swal.fire({
        text: "Loading......",
        showConfirmButton: false,
        allowOutsideClick: false,
    });

    let body = {
        productId: product.value.productId,
        productName: product.value.productName || null,
        dailyFeeOriginal: product.value.dailyFeeOriginal || null,
        maxAvailableQuantity: product.value.maxAvailableQuantity || null,
        description: product.value.description || null,
        categoryId: product.value.categoryId || null,
    };

    axiosapi.put(`/rent/product/${body.productId}`, body).then(function(response) {
        if (selectedImage.value) {
            const reader = new FileReader();
            reader.onloadend = function() {
                const base64String = reader.result.split(",")[1];
                let photoBody = { mainPhoto: base64String };
                axiosapi.put(`/rent/product/${product.value.productId}/photo`, photoBody).then(function(response) {
                    if (response.data.success) {
                        handleSuccessReload(response.data.message);
                    } else {
                        handleError(new Error(response.data.message));
                    }
                }).catch(handleError);
            };
            reader.onerror = handleError;
            reader.readAsDataURL(selectedImage.value);
        } else {
            if (response.data.success) {
                handleSuccess(response.data.message, productModal.value);
            } else {
                handleError(new Error(response.data.message));
            }
        }
    }).catch(handleError);
}

let selectedImage = ref(null);

function handleImageSelected(image) {
    selectedImage.value = image;
}

function callChangePic() {
    if (!selectedImage.value) {
        Swal.fire({ text: "請選擇一張圖片", icon: "error" });
        return;
    }

    const reader = new FileReader();
    reader.onloadend = function() {
        let body = { mainPhoto: reader.result.split(",")[1] };
        axiosapi.put(`/rent/product/${product.value.productId}/photo`, body).then(function(response) {
            if (response.data.success) {
                handleSuccessReload(response.data.message);
            } else {
                handleError(new Error(response.data.message));
            }
        }).catch(handleError);
    };
    reader.onerror = handleError;
    reader.readAsDataURL(selectedImage.value);
}

// 共用的錯誤提示函數
function handleError(error) {
    console.log("發生錯誤:", error);
    Swal.fire({ text: "錯誤：" + (error.response ? error.response.data.message : error.message), icon: "error" });
}

// 共用的成功提示函數 (頁面刷新)
function handleSuccessReload(message) {
    Swal.fire({ text: message || '操作成功', icon: "success" }).then(function() {
        window.location.reload();
    });
}

// 共用的成功提示函數 (無頁面刷新)
function handleSuccess(message, modalToHide = null) {
    Swal.fire({ text: message || '操作成功', icon: "success" }).then(function() {
        if (modalToHide) modalToHide.hideModal();
        callFind(current.value);
    });
}


// 定義一個函數來格式化日期並調整時區
function formatDate(utcDateString) {
        if (!utcDateString) return ""; // 防止空值報錯
        const date = new Date(utcDateString);
        // 調整時區+8
        // date.setHours(date.getHours() + 8);

        // 格式化為 yyyy-MM-dd HH:mm:ss
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, "0");
        const day = String(date.getDate()).padStart(2, "0");
        const hours = String(date.getHours()).padStart(2, "0");
        const minutes = String(date.getMinutes()).padStart(2, "0");
        // const seconds = String(date.getSeconds()).padStart(2, "0");

        return `${year}年${month}月${day}日 ${hours}時${minutes}分`;
    }


onMounted(function() {
    callFind();
});
</script>

<style></style>