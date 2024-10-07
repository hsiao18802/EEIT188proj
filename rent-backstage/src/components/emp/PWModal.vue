<template>
    <div ref="passwordModalRef" class="modal fade" tabindex="-1" aria-labelledby="passwordModalLabel"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="passwordModalLabel">修改密碼</h1>
                    <button type="button" class="btn-close" @click="hideModal"></button>
                </div>
                <div class="modal-body">
                    <form @submit.prevent="submitPasswordForm">
                        <div class="mb-3">
                            <label for="oldPassword" class="form-label">舊密碼</label>
                            <input v-model="oldPassword" type="password" class="form-control" id="oldPassword"
                                required />
                        </div>
                        <div class="mb-3">
                            <label for="newPassword" class="form-label">新密碼</label>
                            <input v-model="newPassword" type="password" class="form-control" id="newPassword"
                                required />
                        </div>
                        <div class="mb-3">
                            <label for="confirmPassword" class="form-label">確認新密碼</label>
                            <input v-model="confirmPassword" type="password" class="form-control" id="confirmPassword"
                                required />
                        </div>
                        <button type="submit" class="btn btn-primary">修改密碼</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import bootstrap from 'bootstrap/dist/js/bootstrap.bundle.min.js';
import Swal from 'sweetalert2';

const emits = defineEmits(['passwordUpdate', 'closeModal']);

const oldPassword = ref('');
const newPassword = ref('');
const confirmPassword = ref('');

const passwordModalRef = ref(null);
let passwordModalInstance = null;

// 顯示模態框
function showModal() {
    passwordModalInstance.show();
}

// 隱藏模態框
function hideModal() {
    passwordModalInstance.hide();
}

// 提交修改密碼表單
function submitPasswordForm() {
    if (newPassword.value !== confirmPassword.value) {
        Swal.fire({
            text: "新密碼和確認密碼不一致",
            icon: "error"
        });
        return;
    }

    // 通知父組件進行密碼更新
    emits('passwordUpdate', { oldPassword: oldPassword.value, newPassword: newPassword.value });
    hideModal();
}

onMounted(() => {
    passwordModalInstance = new bootstrap.Modal(passwordModalRef.value);
});

defineExpose({
    showModal,
    hideModal
});
</script>

<style scoped></style>
