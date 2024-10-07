<template>
    <div ref="modalRef" class="modal fade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5">{{ isShowInsert ? '新增員工' : '修改員工資料' }}</h1>
                    <button type="button" class="btn-close" @click="hideModal"></button>
                </div>
                <div class="modal-body">
                    <form @submit.prevent="submitForm">
                        <div class="mb-3">
                            <label for="employeeAccount" class="form-label">員工帳號</label>
                            <input v-model="employee.employeeAccount" type="text" class="form-control"
                                id="employeeAccount" required />
                        </div>
                        <div class="mb-3">
                            <label for="employeeEmail" class="form-label">電子郵件</label>
                            <input v-model="employee.employeeEmail" type="email" class="form-control" id="employeeEmail"
                                required />
                        </div>
                        <div class="mb-3">
                            <label for="accessLevel" class="form-label">員工權限</label>
                            <select v-model="employee.accessLevel" class="form-control" id="accessLevel">
                                <option value="1">管理員</option>
                                <option value="2">正職員工</option>
                                <option value="3">工讀生</option>
                                <!-- 只有修改時才顯示離職選項 -->
                                <option v-if="isShowUpdate" value="99">已離職</option>
                            </select>
                        </div>
                        <div class="mb-3" v-if="isShowInsert">
                            <label for="password" class="form-label">密碼</label>
                            <input v-model="employee.password" type="password" class="form-control" id="password"
                                required />
                        </div>
                        <div class="mb-3" v-if="isShowInsert">
                            <label for="confirmPassword" class="form-label">確認密碼</label>
                            <input v-model="employee.confirmPassword" type="password" class="form-control"
                                id="confirmPassword" required />
                        </div>
                        <button type="submit" class="btn btn-primary">{{ isShowInsert ? '新增' : '修改' }}</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, defineProps, defineEmits, onMounted } from 'vue';
import bootstrap from 'bootstrap/dist/js/bootstrap.bundle.min.js';

const props = defineProps({
    isShowInsert: Boolean,
    isShowUpdate: Boolean,
    employee: {
        type: Object,
        default: () => ({ employeeAccount: '', employeeEmail: '', accessLevel: 2, password: '', confirmPassword: '' })
    }
});

const emits = defineEmits(['insert', 'update']);
const modalRef = ref(null);
let modalInstance = null;

// 初始化模態框
onMounted(() => {
    modalInstance = new bootstrap.Modal(modalRef.value);
});

// 顯示模態框
function showModal() {
    modalInstance.show();
}

// 隱藏模態框
function hideModal() {
    modalInstance.hide();
}

// 提交表單
function submitForm() {
    if (props.isShowInsert) {
        emits('insert');
    } else {
        emits('update');
    }
    hideModal();
}

defineExpose({
    showModal,
    hideModal
});
</script>

<style scoped></style>
