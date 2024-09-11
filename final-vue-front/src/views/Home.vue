<template>
  <h1 style="font-family: '微軟正黑體', sans-serif; font-size: xx-large; font-weight: bold;">首頁 {{ userStore.realname }}</h1>
</template>

<script setup>
import useUserStore from '@/stores/user';
const userStore = useUserStore();
</script>
<style></style>
