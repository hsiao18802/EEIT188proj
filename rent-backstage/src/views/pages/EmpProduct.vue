<template>
    <h1 style="font-family: '微軟正黑體', sans-serif; font-size: xx-large; font-weight: bold;">商品管理</h1>
    <div class="row">
        <div class="col-2 btn-group">
            <button type="button" class="btn btn-primary" @click="openModal('insert')">開啟新增</button>
            <button type="button" class="btn btn-outline-primary" @click="openCategory">分類管理</button>
        </div>
        <div class="col-4">
            <ProductSelect v-model="max" :total="total" :options="[2, 3, 4, 5, 7, 10]" @max-change="callFind">
            </ProductSelect>
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
                <td>
                    <img v-if="product.mainPhoto" :alt="product.productName" v-default-img="product.mainPhoto"
                        style="width: 100px; height: 100px;" @click="showFullImage(product.mainPhoto)">
                    <span v-else><a class="btn btn-primary"
                            @click="openModal('changepic', product.productId)">新增圖片</a></span>
                </td>
                <th scope="row">{{ product.productName }}</th>
                <td>{{ product.categoryId }}</td>
                <td>{{ product.dailyFeeOriginal }}</td>
                <td>{{ product.maxAvailableQuantity }}</td>
                <td>{{ truncateText(product.description, 20) }}</td>
                <td v-if="product.employeeAccount !== 'N/A'">{{ product.employeeAccount }}</td>
                <td v-else></td>
                <td>{{ formatDate(product.lastUpdateDatetime) }}</td>
                <td>
                    <div class="btn-group col text-end">
                        <a class="btn btn-primary" @click="openModal('update', product.productId)">修改</a>
                        <a class="btn btn-outline-danger" @click="callDiscontinue(product.productId)">下架</a>
                        <a class="btn btn-danger" @click="callRemove(product.productId)">刪除</a>
                    </div>
                </td>
            </tr>
        </tbody>
    </table>

    <!-- <div class="row">
        <ProductCard v-for="product in products" :key="product.id" :item="product" @delete="callRemove"
            @open-update="openModal"></ProductCard>
    </div> -->

    <ProductModal ref="productModal" v-model:product="product" :is-show-insert="isShowInsert"
        :is-show-changepic="isShowChangepic" :is-show-update="isShowUpdate" @insert="callCreate" @update="callModify"
        @changepic="callChangePic" @imageSelected="handleImageSelected" @clearImage="clearImage">
    </ProductModal>
    <!-- <CategoryModal ref="categoryModal" :categories="categories" @catDelete="callCatRemove" @catUpdate="callCatModify"></CategoryModal> -->
    <CategoryModal ref="categoryModal" :categories="categories" @cat-delete="callCatRemove" @catUpdate="callCatModify"
        @update:categories="categories = $event" @add-category="addCategory"></CategoryModal>


</template>

<script setup>
import ProductCard from '@/components/product/EmpProductCard.vue';
import Swal from 'sweetalert2';
import axiosapi from '@/plugins/axios';
import { onMounted, ref } from 'vue';

import ProductModal from '@/components/product/EmpProductModal.vue';
import CategoryModal from '@/components/product/CategoryModal.vue';

const start = ref(0);
const max = ref(3);
const current = ref(1);
const total = ref(0);
const lastPageRows = ref(0);
const productModal = ref(null);
const categoryModal = ref(null);
const picModal = ref(null);
const product = ref({});
const category = ref({});
const isShowInsert = ref(true);
const isShowUpdate = ref(true);
const isShowChangepic = ref(true);
const findName = ref("");
const products = ref([]);
const categories = ref([]);
const emits = defineEmits(["delete", "openUpdate"]);

function openModal(action, id) {
    if (action === 'insert') {
        isShowInsert.value = true;
        isShowUpdate.value = false;
        isShowChangepic.value = false;
        product.value = {};
        product.value.statusId = 1;
    } else {
        isShowInsert.value = false;
        if (action === 'changepic') {
            console.log("changepic = true");
            isShowUpdate.value = false;
            isShowChangepic.value = true;
        } else {
            console.log("changepic = false");
            isShowUpdate.value = true;
            isShowChangepic.value = false;
        }
        callFindById(id);
    }
    productModal.value.showModal();
}

async function openCategory() {
    await callFindCategory(); // 等待資料加載完成
    console.log("(1)category : " + JSON.stringify(categories.value)); // 資料加載完成後再檢查
    if (categories.value && categories.value.length > 0) {
        categoryModal.value.showModal();  // 確保 modal 打開時 category 已經有資料
    } else {
        console.error('No category data available');
    }
}

// 父組件中的新增分類方法
function addCategory() {
    const categoryName = prompt("請輸入分類名稱:");

    if (categoryName) {
        // 發送新增請求到後端
        axiosapi.post('/rent/category/add', { categoryName })
            .then(response => {
                alert('分類已成功新增');
                callFindCategory(); // 重新獲取分類數據
            })
            .catch(error => {
                alert('新增失敗，請重試');
            });
    } else if (categoryName === "") {
        alert('分類名稱不能為空！');
    } else {
        alert('您已取消新增分類');
    }
}

async function callFindCategory() {
    const response = await axiosapi.get('/rent/category/find');
    if (response.data) {
        categories.value = response.data; // 確保資料被賦值到 category
        console.log("成功獲取資料:", categories.value);
    }
    console.log("(2)categories : " + JSON.stringify(categories.value));
}

function reloadCategories() {
    console.log("重刷 啟動");
    axiosapi.get('/rent/category/find')
        .then(response => {
            console.log("API 回應：", response.data);  // 打印回應資料

            // 假設返回的是一個分類的陣列，直接更新 categories
            if (Array.isArray(response.data)) {
                categories.value = response.data;
                console.log("更新後的 categories：", categories.value);
            } else {
                console.error("API 回應格式不正確");
            }
        })
        .catch(error => {
            console.error("載入分類資料失敗", error);
        });
}



function callDiscontinue(id) {
    Swal.fire({
        title: "確定下架？",
        icon: "question",
        showCancelButton: true,
        allowOutsideClick: false,
    }).then(function (result) {
        if (result.isConfirmed) {
            Swal.fire({
                text: "Loading......",
                showConfirmButton: false,
                allowOutsideClick: false,
            });
            axiosapi.put(`/rent/product/${id}/discontinue`)
                .then(function (response) {
                    if (response.data && response.data.success) {
                        handleSuccess(response.data.message, productModal.value);
                    } else {
                        handleError(new Error(response.data.message || "下架失敗，請稍後再試"));
                    }
                })
                .catch(handleError);
        }
    });
}

function callRemove(id) {
    Swal.fire({
        title: "確認刪除？",
        text: "請注意，刪除以後將無法復原資料",
        icon: "question",
        showCancelButton: true,
        allowOutsideClick: false,
        footer: '<a href="#" id="discontinueLink">或使用下架，停止販售但保留商品資料</a>',
        didOpen: () => {
            const discontinueLink = document.getElementById('discontinueLink');
            discontinueLink.addEventListener('click', (event) => {
                event.preventDefault(); // 防止預設的跳轉行為
                callDiscontinue(id);    // 呼叫下架方法
            });
        }
    }).then(function (result) {
        if (result.isConfirmed) {
            Swal.fire({
                text: "Loading......",
                showConfirmButton: false,
                allowOutsideClick: false,
            });
            axiosapi.delete(`/rent/product/${id}`)
                .then(function (response) {
                    if (response.data && response.data.success) {
                        handleSuccess(response.data.message, productModal.value);
                    } else {
                        handleError(new Error(response.data.message || "刪除失敗，請稍後再試"));
                    }
                })
                .catch(function (error) {
                    // 檢查錯誤訊息是否包含資料表衝突相關字詞
                    if (error.response && error.response.data && error.response.data.message) {
                        const errorMessage = error.response.data.message;
                        if (errorMessage.includes("REFERENCE") || errorMessage.includes("衝突發生在資料庫")) {
                            Swal.fire({
                                icon: 'error',
                                title: '刪除失敗',
                                html: '商品已有客戶下單，無法刪除<br>使用下架功能，讓商品不再顯示與販售？',
                                showCancelButton: true,
                                allowOutsideClick: false,
                            }).then(function (result) {
                                if (result.isConfirmed) {
                                    Swal.fire({
                                        text: "Loading......",
                                        showConfirmButton: false,
                                        allowOutsideClick: false,
                                    });
                                    axiosapi.put(`/rent/product/${id}/discontinue`)
                                        .then(function (response) {
                                            if (response.data && response.data.success) {
                                                handleSuccess(response.data.message, productModal.value);
                                            } else {
                                                handleError(new Error(response.data.message || "下架失敗，請稍後再試"));
                                            }
                                        })
                                        .catch(handleError);
                                }
                            });
                        } else {
                            handleError(error); // 其他錯誤仍用原來的處理
                        }
                    } else {
                        handleError(error); // 處理未知錯誤
                    }
                });
        }
    });
}

function callCatRemove(id) {
    console.log("Category ID to remove:", id); // 檢查 id 是否為有效數字
    Swal.fire({
        title: "確認刪除？",
        text: "請注意，刪除以後將無法復原資料",
        icon: "question",
        showCancelButton: true,
        allowOutsideClick: false,
    }).then(function (result) {
        if (result.isConfirmed) {
            Swal.fire({
                text: "Loading......",
                showConfirmButton: false,
                allowOutsideClick: false,
            });
            axiosapi.delete(`/rent/category/${id}`)
                .then(function (response) {
                    if (response.data && response.data.success) {
                        handleSuccess(response.data.message);
                    } else {
                        handleError(new Error(response.data.message || "刪除失敗，請稍後再試"));
                    }
                })
                .catch(function (error) {
                    // 檢查錯誤訊息是否包含資料表衝突相關字詞
                    if (error.response && error.response.data && error.response.data.message) {
                        const errorMessage = error.response.data.message;
                        if (errorMessage.includes("REFERENCE") || errorMessage.includes("衝突發生在資料庫")) {
                            Swal.fire({
                                icon: 'error',
                                title: '刪除失敗',
                                html: '此分類已有商品，無法刪除',
                                showConfirmButton: false,
                                showCancelButton: true,
                                allowOutsideClick: false,
                            });
                        } else {
                            handleError(error); // 其他錯誤仍用原來的處理
                        }
                    } else {
                        handleError(error); // 處理未知錯誤
                    }
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

    axiosapi.get(`/rent/product/${id}`).then(function (response) {
        if (response.data) {
            product.value = response.data;
        } else {
            Swal.fire({
                text: "找不到產品資料",
                icon: "error",
            });
        }
        setTimeout(function () {
            Swal.close();
        }, 500);
    }).catch(handleError);
}

function callFind(page) {
    current.value = page || 1;
    start.value = (current.value - 1) * max.value;
    findName.value = findName.value || null;

    let body = { start: start.value, max: max.value, dir: false, order: "id", name: findName.value };

    Swal.fire({
        text: "Loading...",
        showConfirmButton: false,
        allowOutsideClick: false,
    });

    axiosapi.get("/rent/product/find", { params: body })
        .then(async function (response) {
            if (response.data && Array.isArray(response.data)) {
                // 直接將 response.data 賦值給 products
                products.value = response.data;
                total.value = response.data.length;

                // 查詢所有產品的 employeeAccount
                await fetchEmployeeAccounts();
            } else {
                console.error("產品數據格式不正確", response.data);
            }
            setTimeout(function () {
                Swal.close();
            }, 500);
        })
        .catch(function (error) {
            Swal.close();
            console.error('查詢失敗', error);
        });
}

async function callCreate() {
    Swal.fire({
        text: "Loading......",
        showConfirmButton: false,
        allowOutsideClick: false,
    });

    // 從 localStorage 取得 employee_id，並設為 addEmployeeId
    const employeeId = localStorage.getItem('employee_id');

    let body = {
        ...product.value,
        addEmployeeId: employeeId || null,  // 將 employee_id 設為 addEmployeeId
        lastUpdateEmployeeId: employeeId || null,  // 將 employee_id 設為 addEmployeeId
    };

    try {
        if (selectedImage.value) {
            const reader = new FileReader();
            reader.onloadend = async function () {
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
    console.log(product.value.statusId);

    // 從 localStorage 取得 employee_id，並設為 lastUpdateEmployeeId
    const employeeId = localStorage.getItem('employee_id');

    let body = {
        productId: product.value.productId,
        productName: product.value.productName || null,
        dailyFeeOriginal: product.value.dailyFeeOriginal || null,
        maxAvailableQuantity: product.value.maxAvailableQuantity || null,
        description: product.value.description || null,
        categoryId: product.value.categoryId || null,
        statusId: product.value.statusId || null,
        lastUpdateEmployeeId: employeeId || null, // 將 employee_id 塞進 body
    };

    axiosapi.put(`/rent/product/${body.productId}`, body).then(function (response) {
        console.log(product.value.statusId);

        if (selectedImage.value) {
            const reader = new FileReader();
            reader.onloadend = function () {
                const base64String = reader.result.split(",")[1];
                let photoBody = { mainPhoto: base64String };
                axiosapi.put(`/rent/product/${product.value.productId}/photo`, photoBody).then(function (response) {
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


function callCatModify(updatedCategory) {
    console.log("修改 啟動");
    console.log("接收到的更新內容: ", updatedCategory);
    console.log("category.value.categoryId: ", updatedCategory.categoryId);
    console.log("category.value.categoryName: ", updatedCategory.categoryName);
    Swal.fire({
        text: "Loading......",
        showConfirmButton: false,
        allowOutsideClick: false,
    });
    let body = {
        categoryId: updatedCategory.categoryId,
        categoryName: updatedCategory.categoryName,
    };

    axiosapi.put(`/rent/category/${body.categoryId}`, body).then(function (response) {
        console.log(product.value.statusId);

        if (response.data.success) {
            handleSuccess(response.data.message, productModal.value);
        } else {
            handleError(new Error(response.data.message));
        }

    }).catch(handleError);
}

let selectedImage = ref(null);

function handleImageSelected(image) {
    selectedImage.value = image;
}

function clearImage() {
    console.log("清除檔案");
    selectedImage.value = null;
}

function callChangePic() {
    if (!selectedImage.value) {
        Swal.fire({ text: "請選擇一張圖片", icon: "error" });
        return;
    }

    const reader = new FileReader();
    reader.onloadend = function () {
        let body = { mainPhoto: reader.result.split(",")[1] };
        axiosapi.put(`/rent/product/${product.value.productId}/photo`, body).then(function (response) {
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
    Swal.fire({ text: message || '操作成功', icon: "success" }).then(function () {
        window.location.reload();
    });
}

// 共用的成功提示函數 (無頁面刷新)
function handleSuccess(message, modalToHide = null) {
    Swal.fire({ text: message || '操作成功', icon: "success" }).then(function () {
        if (modalToHide) modalToHide.hideModal();
        reloadCategories(); // 呼叫重新載入方法
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

function showFullImage(imageData) {
    // 將二進制的圖片資料轉換成 URL
    const blob = new Blob([new Uint8Array(imageData)], { type: 'image/jpeg' }); // 假設是 JPEG 格式
    const imageUrl = URL.createObjectURL(blob);

    Swal.fire({
        imageUrl: product.mainPhoto,   // 使用圖片 URL
        imageAlt: '產品圖片',
        imageWidth: 'auto',   // 你可以根據需要調整
        imageHeight: 'auto',
        showConfirmButton: false
    });
}

onMounted(function () {
    callFind();
});

function truncateText(text, length) {
    if (!text) return '';
    return text.length > length ? text.substring(0, length) + '...' : text;
}

// 查詢員工帳號
// 查詢員工帳號
const fetchEmployeeAccounts = async () => {
    // 確保 products.value 是一個數組
    if (Array.isArray(products.value)) {
        const promises = products.value.map(async (product) => {
            if (product.lastUpdateEmployeeId) {
                try {
                    const response = await axiosapi.get(`/api/employee/account/${product.lastUpdateEmployeeId}`);
                    // 將查詢到的 employeeAccount 存入產品數據
                    product.employeeAccount = response.data;
                } catch (error) {
                    console.error('無法查詢 employeeAccount', error);
                }
            } else {
                product.employeeAccount = 'N/A'; // 如果 lastUpdateEmployeeId 為空，設為 'N/A'
            }
        });

        // 等待所有查詢完成
        await Promise.all(promises);
    }
};
</script>

<style></style>