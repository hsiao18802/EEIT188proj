<template>
    <footer class="footer">
      <div class="footer-content">
        <p>© 2024 趣露營. All Rights Reserved.</p>
        <RouterLink to="/contact" class="footer-link">聯繫我們</RouterLink>
      </div>
    </footer>
  </template>
  
  <script>
  export default {
    name: 'Footer'
  };
  </script>
  
  <style scoped>
  .footer {
    background-color: #333;
    color: #fff;
    padding: 20px;
    text-align: center;
    width: 100%;
    position: relative; /* 修改為相對定位 */
    margin-top: auto; /* 保證頁面內容不足時，footer 仍然位於頁面底部 */
  }
  
  .footer-content {
    display: flex;
    justify-content: space-between;
    align-items: center;
    max-width: 1200px;
    margin: 0 auto;
  }
  
  .footer-link {
    color: #007bff;
    text-decoration: none;
    margin-left: 20px;
  }
  
  .footer-link:hover {
    text-decoration: underline;
  }
  </style>
  <!--  -->