<template>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <span class="navbar-brand">管理系統</span>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <RouterLink class="nav-link active" aria-current="page" to="/employee/employeehome">系統首頁</RouterLink>
                    </li>
                    <li class="nav-item">
                        <RouterLink class="nav-link active" aria-current="page" to="/employee/order">會員訂單</RouterLink>
                    </li>
                    <!-- <li class="nav-item dropdown">
                        <span class="nav-link dropdown-toggle"  role="button" data-bs-toggle="dropdown" aria-expanded="false">商品管理</span>
                        <ul class="dropdown-menu">
                            <li><RouterLink class="dropdown-item" to="/employee/productadd">商品上架</RouterLink></li>
                            <li><RouterLink class="dropdown-item" to="/employee/productlist">商品一覽</RouterLink></li>
                        </ul>
                    </li> -->
                    <li class="nav-item">
                        <RouterLink class="nav-link active" aria-current="page" to="/employee/empproduct">商品管理</RouterLink>
                    </li>
                    <!-- <li class="nav-item">
                        <RouterLink class="nav-link active" aria-current="page" to="/employee/member">會員管理</RouterLink>
                    </li> -->
                    <li class="nav-item dropdown">
                        <span class="nav-link dropdown-toggle"  role="button" data-bs-toggle="dropdown" aria-expanded="false">員工管理</span>
                        <ul class="dropdown-menu">
                            <li><RouterLink class="dropdown-item" to="/employee/empadd">新增員工</RouterLink></li>
                            <li><RouterLink class="dropdown-item" to="/employee/emplist">員工一覽</RouterLink></li>
                        </ul>
                    </li>

                    
                </ul>
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item dropdown">
                        <span class="nav-link dropdown-toggle"  role="button" data-bs-toggle="dropdown" aria-expanded="false">錯誤訊息（之後會刪掉）</span>
                        <ul class="dropdown-menu">
                            <li><RouterLink class="dropdown-item" to="/401">401</RouterLink></li>
                            <li><RouterLink class="dropdown-item" to="/403">403</RouterLink></li>
                            <li><RouterLink class="dropdown-item" to="/xxx/ooo">404</RouterLink></li>
                        </ul>
                    </li>
            <li class="nav-item">
                <RouterLink class="nav-link active" aria-current="page" to="/">回到顧客頁面</RouterLink>
            </li>
        </ul>
            </div>
        </div>
    </nav>
</template>
    

<script setup>

</script>
    
<style>
    
</style>