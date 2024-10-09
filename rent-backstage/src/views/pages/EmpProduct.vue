<template>
    <h1 style="font-family: '微軟正黑體', sans-serif; font-size: xx-large; font-weight: bold;">商品管理</h1>
    <div class="row">
      <div v-if="selfAdmin === 99"></div>
        <div v-else class="col-2 btn-group">
            <button type="button" class="btn btn-primary" @click="openModal('insert')">開啟新增</button>
            <button type="button" class="btn btn-outline-primary" @click="openCategory">分類管理</button>
        </div>
        <div class="col-4">
            <ProductSelect v-model="max" :total="total" :options="[4, 8, 12, 16]" :categories="categories"
                @max-change="callFind" @categoryChange="onCategoryChange" @statusChange="onStatusChange">
            </ProductSelect>
        </div>
    </div>
    <br>
    <table class="table">
        <thead>
            <tr>
                <th scope="col" style="text-align: left;">點圖放大</th>
                <th scope="col" style="text-align: left;">產品名稱</th>
                <th scope="col" style="text-align: right;">產品狀態</th>
                <th scope="col" style="text-align: right;">產品分類</th>
                <th scope="col" style="text-align: right;">庫存數量</th>
                <th scope="col" style="text-align: right;">每日租金</th>
                <th scope="col" style="text-align: right;">產品描述</th>
                <th scope="col" style="text-align: right;">修改刪除</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="product in products" :key="product.id" style="vertical-align: middle;">
                <td style="text-align: left;">
                    <img v-if="product.mainPhoto" :alt="product.productName" v-default-img="product.mainPhoto"
                        :key="product.productId" style="width: 100px; height: 100px;"
                        @click="showFullImage(product.mainPhoto)">

                    <span v-else><a class="btn btn-primary"
                            @click="openModal('changepic', product.productId)">新增圖片</a></span>
                </td>
                <th scope="row" style="text-align: left;">{{ product.productName }}</th>
                <td style="text-align: right;">
                    <span v-if="product.statusId === 1">未上架</span>
                    <span v-else-if="product.statusId === 2">販售中</span>
                    <span v-else-if="product.statusId === 3">已下架</span>
                </td>
                <td style="text-align: right;">{{ product.categoryName }}</td>
                <td style="text-align: right;">{{ product.maxAvailableQuantity }}</td>
                <td style="text-align: right;">{{ formatCurrency(product.dailyFeeOriginal) }}</td>
                <td style="text-align: right;" v-html="truncateTextWithLineBreak(product.description, 15)"></td>
                <td style="text-align: right;">
                  <div v-if="selfAdmin === 99">請洽系統管理員</div>
                    <div v-else class="btn-group col text-end">
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
        @update:categories="categories = $event" @add-category="addCategory" @callFetchRearrange="callChildAMethod">
    </CategoryModal>

    <!-- 分頁元件 -->
    <div class="row mt-3">
        <div class="d-flex justify-content-between align-items-center w-100">
            <!-- 左側空白 -->
            <div></div>

            <!-- 置中的分頁 -->
            <div class="d-flex justify-content-center flex-grow-1">
                <Paginate v-if="total > 0" :page-count="pages" :click-handler="callFind" :prev-text="'上一頁'"
                    :next-text="'下一頁'" :container-class="'pagination'">
                </Paginate>
                <h2 v-else-if="!loading">查無資料</h2>
            </div>
        </div>
    </div>

</template>

<script setup>
import ProductCard from '@/components/product/EmpProductCard.vue';
import Swal from 'sweetalert2';
import axiosapi from '@/plugins/axios';
import { onMounted, ref } from 'vue';
import Paginate from 'vuejs-paginate-next';
import ProductModal from '@/components/product/EmpProductModal.vue';
import CategoryModal from '@/components/product/CategoryModal.vue';
import ProductSelect from '@/components/product/ProductSelect.vue'

const start = ref(0);
const max = ref(16);
const current = ref(1);
const total = ref(0);
const pages = ref(0);
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
const selectedCategoryId = ref(null);  // 儲存當前選中的分類
const selectedStatusId = ref(null);    // 儲存當前選中的狀態

function callFind(page = 1) {
    current.value = page;
    start.value = (page - 1) * max.value;

    let body = {
        start: start.value,
        max: max.value,
        order: "productId",
        categoryId: selectedCategoryId.value || null,  // 傳入分類 ID
        statusId: selectedStatusId.value || null       // 傳入狀態 ID
    };

    Swal.fire({
        text: "Loading...",
        showConfirmButton: false,
        allowOutsideClick: false,
    });

    axiosapi.post("/rent/product/find-advanced", body)
        .then(async function (response) {
            products.value.forEach(product => {
                product.mainPhoto = null; // 清除舊圖片
            });

            products.value = response.data.list;
            total.value = response.data.count;
            pages.value = Math.ceil(total.value / max.value);
            Swal.close();

            // 遍歷每個產品並通過 categoryId 呼叫 /rent/category/{id} 來獲取分類名稱
            for (const product of products.value) {
                console.log('Product ID:', product.productId);
                console.log('Category ID:', product.categoryId);

                if (product.categoryId) {
                    try {
                        // 呼叫後端 API 根據 categoryId 獲取分類信息
                        const categoryResponse = await axiosapi.get(`/rent/category/${product.categoryId}`);
                        console.log(`Category Response for Product ID ${product.productId}:`, categoryResponse);

                        if (categoryResponse.data) {
                            const categoryName = categoryResponse.data.name || categoryResponse.data.categoryName;
                            console.log(`Category Name for Product ID ${product.productId}:`, categoryName);
                            // 可以在這裡將 categoryName 賦值到產品對象中
                            product.categoryName = categoryName;
                        } else {
                            console.log(`No category data received for Product ID ${product.productId}`);
                        }
                    } catch (error) {
                        console.error(`Error fetching category for Product ID ${product.productId}:`, error);
                    }
                } else {
                    console.log(`No category ID found for Product ID ${product.productId}`);
                }
            }

            // 這裡可以在模板中渲染帶有分類名稱的產品
        })
        .catch(function (error) {
            Swal.fire({ text: "錯誤：" + error.message, icon: "error" });
        });
}









function onCategoryChange(categoryId) {
    selectedCategoryId.value = categoryId;  // 更新選擇的分類 ID
    callFind(1, categoryId);  // 重新查詢，並傳遞選中的分類 ID
}

// 當狀態變更時重新查詢
function onStatusChange(statusId) {
    selectedStatusId.value = statusId;  // 更新選擇的狀態 ID
    callFind(1);  // 重新查詢
}

function openModal(action, id) {
    console.log("openModal called with action:", action, "and id:", id);  // 檢查 action 和 id

    if (action === 'insert') {
        console.log("Action is 'insert'");
        isShowInsert.value = true;
        isShowUpdate.value = false;
        isShowChangepic.value = false;
        product.value = {};
        product.value.statusId = 1;
        console.log("Product after insert action:", product.value);  // 檢查 product 的值
    } else {
        isShowInsert.value = false;
        if (action === 'changepic') {
            console.log("Action is 'changepic'");
            isShowUpdate.value = false;
            isShowChangepic.value = true;
        } else {
            console.log("Action is not 'changepic', setting update to true");
            isShowUpdate.value = true;
            isShowChangepic.value = false;
        }
        console.log("Calling callFindById with id:", id);  // 檢查傳遞給 callFindById 的 id
        callFindById(id);  // 檢查 callFindById 函數內部
    }

    console.log("Displaying modal, productModal reference:", productModal);  // 檢查 modal 引用
    productModal.value.showModal();  // 顯示模態窗口
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
                productModal.value.fetchCategories();
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
                        callChildAMethod();
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

const hasSalesRecord = ref(false);  // 儲存是否有售出紀錄
const dailyFeeOriginalBackup = ref(null);  // 儲存 dailyFeeOriginal 的副本

function callFindById(id) {
    console.log("開始檢查商品是否有售出紀錄，商品ID:", id);

    // 檢查是否有售出紀錄
    axiosapi.get(`/rent/product/order-product/exist/${id}`).then(function (existResponse) {
        hasSalesRecord.value = existResponse.data;
        console.log("是否有售出紀錄:", hasSalesRecord.value);

        // 無論結果為 true 或 false，繼續查詢商品詳細資料
        return axiosapi.get(`/rent/product/${id}`);
    }).then(function (response) {
        if (response.data) {
            product.value = response.data;
            console.log("成功取得商品資料:", product.value);
            findEmployeeAccounts(product.value);  // 這裡傳入單一產品
            // 存儲 dailyFeeOriginal 的副本
            dailyFeeOriginalBackup.value = product.value.dailyFeeOriginal;
            console.log("dailyFeeOriginal 的副本:", dailyFeeOriginalBackup.value);
        } else {
            console.log("找不到產品資料，ID:", id);
        }
    }).catch(function (error) {
        console.error("發生錯誤:", error);
    });
}



// function callFind(page = 1) {
//     current.value = page;
//     start.value = (page - 1) * max.value;

//     let body = {
//         start: start.value,
//         max: max.value,
//         order: "productId"
//     };

//     Swal.fire({
//         text: "Loading...",
//         showConfirmButton: false,
//         allowOutsideClick: false,
//     });

//     axiosapi.post("/rent/product/find-advanced", body)
//         .then(async function (response) {
//             products.value = response.data.list;
//             total.value = response.data.count;
//             pages.value = Math.ceil(total.value / max.value);

//             // 查詢每個產品的 categoryName 和 employeeAccount
//             await fetchCategoryNames();
//             await fetchEmployeeAccounts();

//             Swal.close();
//         })
//         .catch(function (error) {
//             Swal.fire({ text: "錯誤：" + error.message, icon: "error" });
//         });
// }


// 新增查詢 categoryName 的函數
const fetchCategoryNames = async () => {
    const promises = products.value.map(async (product) => {
        if (product.categoryId) {
            try {
                const response = await axiosapi.get(`/rent/category/${product.categoryId}`);
                product.categoryName = response.data.categoryName;  // 假設回傳值有 categoryName
            } catch (error) {
                console.error('無法查詢 categoryName', error);
                product.categoryName = 'N/A';  // 若查詢失敗，設為 'N/A'
            }
        } else {
            product.categoryName = 'N/A';
        }
    });
    await Promise.all(promises);  // 等待所有查詢完成
};


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

    const employeeId = localStorage.getItem('employee_id');

    // 檢查是否有售出紀錄且價格是否有變動
    if (hasSalesRecord.value && dailyFeeOriginalBackup.value !== product.value.dailyFeeOriginal) {
        // 如果商品有售出紀錄且價格不同，顯示警告並阻止修改
        Swal.fire({
            title: "價格無法修改",
            html: "本商品已有售出的紀錄，無法直接修改價格。<br>是否下架原商品、以新價目重新上架？",
            icon: "warning",
            showCancelButton: true,
            confirmButtonText: "下架並重新上架",
            cancelButtonText: "取消"
        }).then((result) => {
            if (result.isDismissed) {
                // 取消按鈕的行為：恢復原始價格
                product.value.dailyFeeOriginal = dailyFeeOriginalBackup.value;
                console.log("已恢復原始價格:", dailyFeeOriginalBackup.value);
            } else if (result.isConfirmed) {
                // 下架
                let bodyM = {
                    productId: product.value.productId,
                    productName: product.value.productName || null,
                    dailyFeeOriginal: dailyFeeOriginalBackup.value,
                    maxAvailableQuantity: product.value.maxAvailableQuantity || null,
                    description: product.value.description || null,
                    categoryId: product.value.categoryId || null,
                    statusId: 3,
                    lastUpdateEmployeeId: employeeId || null, // 將 employee_id 塞進 body
                };
                let bodyA = {

                    productName: product.value.productName || null,
                    mainPhoto: product.value.mainPhoto || null,
                    dailyFeeOriginal: product.value.dailyFeeOriginal || null,
                    maxAvailableQuantity: product.value.maxAvailableQuantity || null,
                    description: product.value.description || null,
                    categoryId: product.value.categoryId || null,
                    statusId: product.value.statusId || null,
                    lastUpdateEmployeeId: employeeId || null, // 將 employee_id 塞進 body
                    addEmployeeId: employeeId || null, // 將 employee_id 塞進 body
                };
                console.log("用戶選擇了下架並重新上架");
                axiosapi.put(`/rent/product/${bodyM.productId}`, bodyM).then(function (responseM) {
                    console.log("商品已下架", responseM.data);

                    // 下架成功後，進行重新上架操作
                    axiosapi.post("/rent/product/add", bodyA).then(function (responseA) {
                        console.log("商品已重新上架", responseA.data);
                        handleSuccess("商品已成功下架並重新上架", productModal.value);  // 使用 handleSuccess 函數
                    }).catch(function (errorA) {
                        console.error("重新上架時發生錯誤", errorA);
                        Swal.fire({
                            text: "重新上架時發生錯誤",
                            icon: "error",
                            confirmButtonText: "確定"
                        });
                    });
                }).catch(function (errorM) {
                    console.error("下架時發生錯誤", errorM);
                    Swal.fire({
                        text: "下架時發生錯誤",
                        icon: "error",
                        confirmButtonText: "確定"
                    });
                });
            }
        });
        return;  // 阻止後續的修改操作
    }

    // 顯示 Loading 提示
    Swal.fire({
        text: "Loading......",
        showConfirmButton: false,
        allowOutsideClick: false,
    });

    console.log(product.value.statusId);

    // 從 localStorage 取得 employee_id，並設為 lastUpdateEmployeeId
    // const employeeId = localStorage.getItem('employee_id');

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
            productModal.value.fetchCategories();

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
    if (!imageData) {
        console.error('No image data provided.');
        return;
    }

    // 假設圖片是 Base64 編碼的
    const imageUrl = `data:image/jpeg;base64,${imageData}`;
    console.log('Generated Image URL (Base64):', imageUrl);

    Swal.fire({
        imageUrl: imageUrl,
        imageAlt: '產品圖片',
        imageWidth: 'auto',
        imageHeight: 'auto',
        showConfirmButton: false
    });
}



onMounted(async () => {
    callFind();

    // 查詢本地存儲中的 employeeId
    const employeeId = localStorage.getItem('employee_id');

    if (employeeId) {
        try {
            // 使用 employeeId 查詢對應的員工資料
            const response = await axiosapi.get(`/api/employee/${employeeId}`);
            const employeeData = response.data.employee; // 從 API 回應中提取員工資料

            // 設置查詢結果到 selfAccount 和 selfAdmin
            selfAdmin.value = employeeData.accessLevel; // 直接顯示 accessLevel 數字
            console.log(selfAdmin.value);
        } catch (error) {
            console.error('無法查詢員工帳號', error);
        }
    }
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



const findEmployeeAccounts = async (product) => {
    if (product.lastUpdateEmployeeId) {
        try {
            const lastUpdateResponse = await axiosapi.get(`/api/employee/account/${product.lastUpdateEmployeeId}`);
            product.lastUpdateEmployeeAccount = lastUpdateResponse.data;
        } catch (error) {
            console.error('無法查詢 lastUpdateEmployeeAccount', error);
            product.lastUpdateEmployeeAccount = 'N/A';
        }
    } else {
        product.lastUpdateEmployeeAccount = 'N/A';
    }

    if (product.addEmployeeId) {
        try {
            const addEmployeeResponse = await axiosapi.get(`/api/employee/account/${product.addEmployeeId}`);
            product.addEmployeeAccount = addEmployeeResponse.data;
        } catch (error) {
            console.error('無法查詢 addEmployeeAccount', error);
            product.addEmployeeAccount = 'N/A';
        }
    } else {
        product.addEmployeeAccount = 'N/A';
    }
};
function callChildAMethod() {
    productModal.value.fetchCategories();
}

function truncateTextWithLineBreak(text, length) {
    if (!text) return '';
    const regex = new RegExp(`(.{${length}})`, 'g');
    return text.replace(regex, '$1<br>');
}

function formatCurrency(amount) {
    if (amount === null || amount === undefined) return '';
    return '$' + amount.toLocaleString();
}

const selfAdmin = ref(null); // 判斷當前使用者是否是管理員
</script>

<style></style>