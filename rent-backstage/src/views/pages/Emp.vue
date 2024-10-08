<template>
  <!-- 顯示當前登入的員工帳號和權限等級 -->
  <h1>員工管理：{{ selfAccount }}</h1>

  <div class="row">
    <div class="col-2 btn-group" v-if="selfAdmin === 1">
      <!-- 當前使用者是管理員時顯示新增按鈕 -->
      <button type="button" class="btn btn-primary" @click="openModal('insert')">開啟新增</button>
      <button type="button" class="btn btn-outline-primary" @click="openPasswordModal">修改密碼</button>
    </div>
    <div v-else>
      <button type="button" class="btn btn-outline-primary" @click="openPasswordModal">修改密碼</button>
    </div>
  </div>

  <br>

  <table class="table">
    <thead>
      <tr>
        <th scope="col">員工帳號</th>
        <th scope="col">電子郵件</th>
        <th scope="col">員工身分</th>
        <th scope="col">權限調整</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="employee in employees" :key="employee.employeeId">
        <th scope="row" style="vertical-align: middle;">{{ employee.employeeAccount }}</th>
        <td style="vertical-align: middle;">{{ employee.employeeEmail }}</td>
        <td style="vertical-align: middle;">{{ formatAccessLevel(employee.accessLevel) }}</td>
        <td style="vertical-align: middle;">
          <div class="btn-group col text-end" v-if="selfAdmin === 1">
            <!-- 當前使用者是管理員時顯示操作按鈕 -->
            <a class="btn btn-primary" @click="openModal('update', employee.employeeId)">修改</a>
            <a class="btn btn-outline-danger" @click="callDiscontinue(employee.employeeId)">離職</a>
            <a class="btn btn-danger" @click="callRemove(employee.employeeId)">刪除</a>
          </div>
          <div v-else>
            <!-- 當前使用者不是管理員時顯示「請洽系統管理員」 -->
            請洽系統管理員
          </div>
        </td>
      </tr>
    </tbody>

  </table>

  <!-- 綁定子組件的模態框 -->
  <EmployeeModal ref="employeeModal" :employee="currentEmployee" :is-show-insert="isShowInsert"
    :is-show-update="isShowUpdate" @insert="callInsert" @update="callUpdate" />
  <PasswordModal ref="passwordModal" @password-update="callUpdatePassword" />
</template>


<script setup>
import { ref, onMounted } from 'vue';
import Swal from 'sweetalert2';
import axiosapi from '@/plugins/axios';
import EmployeeModal from '@/components/emp/EmpModal.vue'; // 子組件的模態框
import PasswordModal from '@/components/emp/PWModal.vue'; // 引入修改密碼的模態框

const employees = ref([]);
const currentEmployee = ref({
  employeeAccount: '',
  employeeEmail: '',
  accessLevel: 2,
  password: '',
  confirmPassword: ''
}); // 儲存當前選中的員工資料
const isShowInsert = ref(false); // 控制是否顯示新增模式
const isShowUpdate = ref(false); // 控制是否顯示修改模式


const employeeModal = ref(null); // 引用子組件

// 格式化 accessLevel 顯示員工身分
function formatAccessLevel(accessLevel) {
  switch (accessLevel) {
    case 1:
      return '管理員';
    case 2:
      return '正職員工';
    case 3:
      return '工讀生';
    case 99:
      return '已離職';
    default:
      return '未知';
  }
}

// 開啟模態框
function openModal(action, employeeId = null) {
  if (action === 'insert') {
    isShowInsert.value = true;
    isShowUpdate.value = false;
    currentEmployee.value = {
      employeeAccount: '',
      employeeEmail: '',
      accessLevel: 2,
      password: '',
      confirmPassword: ''
    };
  } else if (action === 'update' && employeeId) {
    isShowInsert.value = false;
    isShowUpdate.value = true;
    currentEmployee.value = employees.value.find(emp => emp.employeeId === employeeId) || {};
    currentEmployee.value.password = '';  // 更新模式不修改密碼
    currentEmployee.value.confirmPassword = ''; // 確認密碼也清空
  }

  // 顯示模態框
  if (employeeModal.value && typeof employeeModal.value.showModal === 'function') {
    employeeModal.value.showModal();
  } else {
    console.error('employeeModal is not correctly initialized or showModal is not a function.');
  }
}

// 加載員工資料
function loadEmployees() {
  axiosapi.get('/api/employee/all')
    .then((response) => {
      employees.value = response.data.employees;
    })
    .catch((error) => {
      console.log("Error loading employees:", error);
    });
}

// 新增員工
function callInsert() {
  if (!currentEmployee.value.password || !currentEmployee.value.confirmPassword) {
    Swal.fire({
      text: "請輸入密碼和確認密碼",
      icon: "error"
    });
    return;
  }

  if (currentEmployee.value.password !== currentEmployee.value.confirmPassword) {
    Swal.fire({
      text: "密碼與確認密碼不相符",
      icon: "error"
    });
    return;
  }

  axiosapi
    .post('/api/employee/add', {
      ...currentEmployee.value,
      employeePassword: currentEmployee.value.password
    })
    .then(() => {
      Swal.fire({
        text: "員工新增成功",
        icon: "success"
      }).then(() => {
        loadEmployees(); // 刷新員工列表
      });
    })
    .catch(() => {
      Swal.fire({
        text: "無法新增員工，請稍後再試",
        icon: "error"
      });
    });
}

// 修改員工
function callUpdate() {
  axiosapi
    .put(`/api/employee/update/${currentEmployee.value.employeeId}`, currentEmployee.value)
    .then(() => {
      Swal.fire({
        text: "員工資料更新成功",
        icon: "success"
      }).then(() => {
        loadEmployees(); // 刷新員工列表
      });
    })
    .catch(() => {
      Swal.fire({
        text: "無法更新員工，請稍後再試",
        icon: "error"
      });
    });
}

function callDiscontinue(employeeId) {
  Swal.fire({
    title: "確定修改權限？",
    text: "此動作會將員工設為離職狀態",
    icon: "question",
    showCancelButton: true,
    confirmButtonText: "確定",
    cancelButtonText: "取消",
    allowOutsideClick: false,
  }).then((result) => {
    if (result.isConfirmed) {
      axiosapi
        .put(`/api/employee/update/${employeeId}`, { accessLevel: 99 }) // 更新為離職狀態
        .then((response) => {
          if (response.status === 200 && response.data.employee) {
            Swal.fire({
              text: "已成功將員工設為離職狀態",
              icon: "success",
            }).then(() => {
              loadEmployees(); // 更新員工資料
            });
          } else {
            Swal.fire({
              text: "無法更新員工狀態，請稍後再試。",
              icon: "error",
            });
          }
        })
        .catch((error) => {
          Swal.fire({
            text: "無法更新員工狀態，請稍後再試。",
            icon: "error",
          });
        });
    }
  });
}

function callRemove(employeeId) {
  Swal.fire({
    title: "確認刪除？",
    text: "請注意，刪除以後將無法復原資料",
    icon: "question",
    showCancelButton: true,
    allowOutsideClick: false,
    footer: '<a href="#" id="discontinueLink">或將員工設為離職，保留員工資料</a>',
    didOpen: () => {
      const discontinueLink = document.getElementById('discontinueLink');
      discontinueLink.addEventListener('click', (event) => {
        event.preventDefault(); // 防止預設的跳轉行為
        callDiscontinue(employeeId);    // 呼叫設為離職的功能
      });
    }
  }).then(function (result) {
    if (result.isConfirmed) {
      Swal.fire({
        text: "Loading......",
        showConfirmButton: false,
        allowOutsideClick: false,
      });
      axiosapi.delete(`/api/employee/${employeeId}`)
        .then(function (response) {
          if (response.status === 204) {
            Swal.fire({
              text: "員工已成功刪除",
              icon: "success",
            }).then(() => {
              loadEmployees(); // 刪除後重刷頁面
            });
          } else {
            Swal.fire({
              text: "無法刪除員工，請稍後再試。",
              icon: "error",
            });
          }
        })
        .catch(function (error) {
          Swal.fire({
            text: "無法刪除員工，請稍後再試。",
            icon: "error",
          });
        });
    }
  });
}


// 當頁面初始化時加載員工資料並查詢 employeeId
onMounted(async () => {
  // 1. 加載員工資料
  loadEmployees();

  // 2. 查詢本地存儲中的 employeeId
  const employeeId = localStorage.getItem('employee_id');

  if (employeeId) {
    try {
      // 使用 employeeId 查詢對應的員工資料
      const response = await axiosapi.get(`/api/employee/${employeeId}`);
      const employeeData = response.data.employee; // 從 API 回應中提取員工資料

      // 設置查詢結果到 selfAccount 和 selfAdmin
      selfAccount.value = employeeData.employeeAccount; // 員工帳號
      selfAdmin.value = employeeData.accessLevel; // 直接顯示 accessLevel 數字
    } catch (error) {
      console.error('無法查詢員工帳號', error);
    }
  }
});

const selfAccount = ref(null); // 定義一個變數來存放員工帳號
const selfAdmin = ref(null); // 判斷當前使用者是否是管理員

const passwordModal = ref(null); // 引用修改密碼的模態框

// 開啟修改密碼的模態框
function openPasswordModal() {
  passwordModal.value.showModal();
}

// 更新密碼
function callUpdatePassword({ oldPassword, newPassword }) {
  const employeeId = localStorage.getItem('employee_id'); // 使用本地存儲的 ID
  axiosapi
    .put(`/api/employee/update-password/${employeeId}`, {
      oldPassword,
      newPassword
    })
    .then((response) => {
      Swal.fire({
        text: response.data.message,
        icon: response.status === 200 ? 'success' : 'error',
      });
    })
    .catch((error) => {
      Swal.fire({
        text: "密碼更新失敗，請稍後再試。",
        icon: 'error'
      });
    });
}

</script>

<style scoped>
/* 可添加需要的樣式 */
</style>
