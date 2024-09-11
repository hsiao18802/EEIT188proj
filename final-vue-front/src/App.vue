<template>
  <div id="app">
    <component :is="currentNavbar"></component>
    <router-view></router-view>
  </div>
</template>

<script setup>
import useUserStore from '@/stores/user'; // �ޥ� Pinia �� store
import { onMounted } from 'vue'; // Vue ���ͩR�P���_�l
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
import EmpNavbar from './views/product_and_emp/EmpNavbar.vue'
import PublicNavbar from './views/Navbar.vue'
import { computed } from 'vue';
import { useRoute } from 'vue-router';

// �ϥ� `useRoute` ������e����
const route = useRoute();
const userStore = useUserStore();


onMounted(() => {
  // ���αҰʮɡA�q localStorage ����_ token �M�n�J���A
  const token = localStorage.getItem('token');
  if (token) {
    userStore.setToken(token);  // ��_ token
    userStore.setLogin(true);   // ��_�n�J���A
    console.log("Login state restored"); // �ոե�
  } else {
    console.log("No token found in sessionStorage");
  }
});


// �w�q currentNavbar �p���ݩ�
const currentNavbar = computed(() => {
  return route.meta.navbar === 'EmpNavbar' ? EmpNavbar : PublicNavbar;
});

</script>

<style></style>