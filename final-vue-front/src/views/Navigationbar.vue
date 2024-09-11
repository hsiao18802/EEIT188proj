<template>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <span class="navbar-brand">帳篷租借網站</span>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <RouterLink class="nav-link active" aria-current="page" to="/">首頁</RouterLink>
                    </li>
                    <li class="nav-item">
                        <RouterLink class="nav-link active" aria-current="page" to="/secure/login">登入</RouterLink>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="#" @click="logout" v-show="userStore.isLoggedIn">登出</a>
                    </li>

             

                    <li class="nav-item">
                        <RouterLink class="nav-link active" aria-current="page" to="/pages/Cart">購物車</RouterLink>
                    </li>

                    <li class="nav-item">
                        <RouterLink class="nav-link active" aria-current="page" to="/pages/Order">訂單詳情</RouterLink>
                    </li>



                    <li class="nav-item dropdown">
                        <span class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">功能</span>
                        <ul class="dropdown-menu">

                            <li><RouterLink class="dropdown-item" to="/pages/products">產品</RouterLink></li>
                            <li><RouterLink class="dropdown-item" to="/cart">購物車</RouterLink></li>
                            <li><RouterLink class="dropdown-item" to="/pages/Card">訂單管理</RouterLink></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>

<script setup>
import useUserStore from '@/stores/user';
const userStore = useUserStore();

function logout() {
    userStore.setEmail("");
    userStore.setLogin(false);
}
</script>

<style scoped>
.navbar-brand {
    font-weight: bold;
}
</style>
