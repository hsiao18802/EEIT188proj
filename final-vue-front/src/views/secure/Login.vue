<template>
    <h3>登入</h3>
    <table>
        <tr>
            <td>帳號：</td>
            <td><input type="text" name="username" v-model="username"></td>
            <td><span class="error">{{ message }}</span></td>
        </tr>
        <tr>
            <td>密碼：</td>
            <td><input type="text" name="password" v-model="password"></td>
            <td><span class="error"></span></td>
        </tr>
        <tr>
            <td></td>
            <td colspan="2">
                <button type="button" @click="login">登入</button>
            </td>
        </tr>

    </table>
</template>
    
<script setup>
    import Swal from 'sweetalert2';
    import axiosapi from '@/plugins/axios.js'
    import { ref } from 'vue';
    import { useRouter } from 'vue-router';
    import useUserStore from '@/stores/user.js';

    const userStore = useUserStore();
    const router = useRouter();
    const username = ref("");
    const password = ref("");
    const message = ref("");
    function login() {
        Swal.fire({
            text: "Loading......",
            showConfirmButton: false,
            allowOutsideClick: false,
        });

        if(username.value==="") {
            username.value = null;
        }
        if(password.value==="") {
            password.value = null;
        }
        
        let body = {
            "username": username.value,
            "password": password.value,
        }

        axiosapi.defaults.headers.authorization = "";
        userStore.setEmail("");
        userStore.setLogin(false);

        axiosapi.post("/ajax/secure/login", body).then(function(response) {
            console.log("response", response);
            message.value = response.data.message;

            if(response.data.success) {
                Swal.fire({
                    text: response.data.message,
                    icon: "success",
                }).then(function(result) {
                    axiosapi.defaults.headers.authorization = `Bearer ${response.data.token}`;
                    userStore.setEmail(response.data.email);
                    userStore.setLogin(true);

                    router.push({ name: "home-link" });
                });
            } else {
                Swal.fire({
                    text: response.data.message,
                    icon: "error",
                });
            }
        }).catch(function(error) {
            console.log("error", error);
            Swal.fire({
                text: "錯誤："+error.message,
                icon: "error",
            });
        }).finally(function() {
            console.log("finally");

        });
    }
</script>
    
<style scoped>
    .error {
        color: red;
    }
</style>