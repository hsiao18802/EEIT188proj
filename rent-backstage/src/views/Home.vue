<template>
    <div class="home">
      <h1>後台管理系統</h1>
      <button @click="goToLogin">登入</button>
    </div>
  </template>
  
  <script>
  export default {
    name: 'Home',
    methods: {
      goToLogin() {
        this.$router.push('/emp/login'); // 跳轉到登入頁面
      }
    }
  }
  </script>
  
  <style scoped>
  .home {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    flex-direction: column;
  }
  
  button {
    padding: 10px 20px;
    font-size: 16px;
    cursor: pointer;
    background-color: #42b983;
    color: white;
    border: none;
    border-radius: 5px;
  }
  </style>
  