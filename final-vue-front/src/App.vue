<template>
  <div id="app">
    <component :is="currentNavbar"></component>
    <router-view></router-view>





  </div>
</template>

<script setup>
import useUserStore from '@/stores/user'; 
import { onMounted } from 'vue';  
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
import EmpNavbar from './views/product_and_emp/EmpNavbar.vue'
import PublicNavbar from './views/Navbar.vue'
import { computed } from 'vue';
import { useRoute } from 'vue-router';


const route = useRoute();
const userStore = useUserStore();


onMounted(() => {

  const token = localStorage.getItem('token');
  if (token) {
    userStore.setToken(token);  
    userStore.setLogin(true);   
    console.log("Login state restored"); 
  } else {
    console.log("No token found in sessionStorage");
  }
});



const currentNavbar = computed(() => {
  return route.meta.navbar === 'EmpNavbar' ? EmpNavbar : PublicNavbar;
});





</script>

<style></style>