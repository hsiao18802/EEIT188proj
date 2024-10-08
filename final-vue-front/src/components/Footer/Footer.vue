<template>
  <footer class="footer">
    <div class="footer-content">
      <p>© 2024 趣露營. All Rights Reserved.</p>
      <div class="footer-links">
        <RouterLink to="/contact" class="footer-link">聯繫我們</RouterLink>
        <a href="https://www.facebook.com/yourpage" target="_blank" class="footer-icon">
          <img src="https://instagearoutdoors.com/wp-content/plugins/wp-social-reviews/assets/images/icon/icon-facebook-small.png" alt="Facebook" class="social-icon">
        </a>
        <a href="https://plus.google.com/yourpage" target="_blank" class="footer-icon">
          <img src="https://instagearoutdoors.com/wp-content/plugins/wp-social-reviews/assets/images/icon/icon-google-small.png" alt="Google" class="social-icon">
        </a>
      </div>
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
  position: relative;
  margin-top: auto;
}

.footer-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  max-width: 1200px;
  margin: 0 auto;
  padding: 10px 20px;
}

.footer-links {
  display: flex;
  align-items: center;
}

.footer-link {
  color: #007bff;
  text-decoration: none;
  margin-right: 20px;
  font-weight: bold;
}

.footer-link:hover {
  text-decoration: underline;
}

.footer-icon {
  display: inline-block;
  margin-left: 10px;
}

.social-icon {
  width: 24px;
  height: 24px;
  transition: transform 0.3s ease;
}

.social-icon:hover {
  transform: scale(1.2);
}
</style>
