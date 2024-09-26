<template>
    <div class="d-flex flex-column flex-shrink-0 p-3 bg-dark text-white" style="width: 280px;">
      <!-- 管理系統變成超連結，指向系統首頁 -->
      <RouterLink to="/employee/emphome" class="fs-4 mb-3 link-body-emphasis text-white d-inline-flex text-decoration-none rounded">管理系統</RouterLink>
      <hr>
      <ul class="list-unstyled ps-0">
        <!-- 系統首頁按鈕註解掉 -->
        <!--
        <li class="mb-1">
          <RouterLink to="/employee/emphome" class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">系統首頁</RouterLink>
        </li>
        -->
        <li class="mb-1">
          <RouterLink to="/employee/order" class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">會員訂單</RouterLink>
        </li>
        <li class="mb-1">
          <RouterLink to="/employee/empproduct" class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">商品管理</RouterLink>
        </li>
        <li class="mb-1">
          <RouterLink to="/employee/member" class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">會員一覽</RouterLink>
        </li>
        <li class="mb-1">
          <RouterLink to="/plceholder/forphoto/remembertodelete" class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">員工管理</RouterLink>
        </li>
        <li class="mb-1">
          <RouterLink to="/customerservice" class="link-body-emphasis btn-toggle-nav text-white d-inline-flex text-decoration-none rounded">客服頁面</RouterLink>
        </li>
    
        <!-- 員工管理 -->
        <!-- <li class="mb-1">
          <button
            class="btn btn-toggle text-white d-inline-flex align-items-center rounded border-0"
            data-bs-toggle="collapse"
            data-bs-target="#emp-collapse"
            aria-expanded="false"
          >
            員工管理
          </button>
          <div class="collapse" id="emp-collapse">
            <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
              <li><RouterLink to="/employee/empadd" class="link-body-emphasis text-white d-inline-flex text-decoration-none rounded">新增員工</RouterLink></li>
              <li><RouterLink to="/employee/emplist" class="link-body-emphasis text-white d-inline-flex text-decoration-none rounded">員工一覽</RouterLink></li>
            </ul>
          </div>
        </li> -->
    
        <!-- 錯誤訊息 -->
        <!-- <li class="mb-1">
          <button
            class="btn btn-toggle text-white d-inline-flex align-items-center rounded border-0"
            data-bs-toggle="collapse"
            data-bs-target="#error-collapse"
            aria-expanded="false"
          >
            錯誤訊息（之後會刪掉）
          </button>
          <div class="collapse" id="error-collapse">
            <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
              <li><RouterLink to="/401" class="link-body-emphasis text-white d-inline-flex text-decoration-none rounded">401</RouterLink></li>
              <li><RouterLink to="/403" class="link-body-emphasis text-white d-inline-flex text-decoration-none rounded">403</RouterLink></li>
              <li><RouterLink to="/xxx/ooo" class="link-body-emphasis text-white d-inline-flex text-decoration-none rounded">404</RouterLink></li>
            </ul>
          </div>
        </li> -->
      </ul>
    
      <hr>
    
      <!-- 登出按鈕 -->
      <RouterLink to="/reserved" class="link-body-emphasis text-white d-inline-flex text-decoration-none rounded mb-2">登出</RouterLink>
  
      <!-- 回到顧客頁面 -->
      <RouterLink to="/" class="link-body-emphasis text-white d-inline-flex text-decoration-none rounded">回到顧客頁面</RouterLink>
    </div>
  </template>
  
  <script setup>
  import { RouterLink } from 'vue-router';
  </script>
  
  <style scoped>
  /* .btn-toggle {
    font-weight: 600;
    color: #fff;
    background-color: transparent;
  } */
  

  
  .btn-toggle-nav a {
    padding: 0.1875rem 0.5rem;
    margin-top: 0.125rem;
    margin-bottom: 0.125rem;
    color: #fff; /* 確保鏈接文字為白色 */
  }
  
  /* 外部連結與下拉選單按鈕的共同樣式 */
  .link-body-emphasis {
    padding: 0.1875rem 0.5rem;
    margin-top: 0.125rem;
    margin-bottom: 0.125rem;
    font-weight: 600;
    color: #fff;
    border-radius: 0.375rem;
  }
  
  /* 懸停時的背景色 */
  .link-body-emphasis:hover,
  .btn-toggle-nav:hover {
    /* color: #fff !important; */
    background-color: LightSlateGray;
  }

  /* 當按鈕被選中或點擊時增加白色邊框和圓角 */
  .link-body-emphasis:focus, .link-body-emphasis:active,
  .btn-toggle-nav a:focus, .btn-toggle-nav a:active {
    background-color: white; /* 背景填滿白色 */
    color: #000; /* 文字變為黑色 */
    border: 2px solid white; /* 白色外框 */
    border-radius: 0.375rem; /* 圓角 */
    outline: none; /* 去除默認的邊框 */
  }
  
  .flex-shrink-0 {
    min-height: 100vh; /* 保持側邊欄全高 */
  }
  
  .bg-dark {
    background-color: #343a40 !important; /* 深色背景 */
  }
  </style>
  