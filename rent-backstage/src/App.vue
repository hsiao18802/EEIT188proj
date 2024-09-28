<template>
  <div :class="layoutClass">
    <!-- 動態導航列  :style="maxwidth" -->

    <component :is="currentNavbar"></component>





    <!-- 右側內容區 -->
    <div v-if="isEmpNavbar" class="flex-grow-1 p-3">
      <router-view></router-view>
    </div>

    <div v-else>
      <router-view></router-view>
    </div>


     
  </div>
</template>

<script setup>
import { useRoute } from 'vue-router';
import { computed, onMounted } from 'vue';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import EmpNavbar from './views/EmpNavbar.vue';


const route = useRoute();

// 檢查當前的導航列是否為 EmpNavbar
const isEmpNavbar = computed(() => {
  return route.meta.navbar === 'EmpNavbar';
});

// 根據導航列決定佈局類別：EmpNavbar 時左右佈局，PublicNavbar 時上下佈局
const layoutClass = computed(() => {
  return isEmpNavbar.value ? 'container-fluid d-flex flex-row' : 'container-xxl d-flex flex-column';
});



// 動態設置當前導航列
const currentNavbar = computed(() => {
  return isEmpNavbar.value ? EmpNavbar : PublicNavbar;
});



</script>

<style scoped>
#app {
  height: 100vh;
}



.messages {
  max-height: 300px;
  overflow-y: auto;
  margin-bottom: 20px;
}

.user {
  text-align: right;
  color: blue;
}

.bot {
  text-align: left;
  color: green;
}

input {
  width: calc(100% - 60px);
  padding: 10px;
  margin-right: 10px;
}

button {
  padding: 10px;
}
</style>
