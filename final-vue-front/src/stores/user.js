import { defineStore } from 'pinia';
import { ref, computed } from 'vue';

const useUserStore = defineStore('user', () => {
  const login = ref(false); // 登录状态
  const realname = ref(""); // 真实姓名
  const token = ref(""); // JWT token

  // 计算属性：判断用户是否已登录
  const isLogin = computed(() => login.value);

  // 设置登录状态
  function setLogin(data) {
    login.value = data;
    console.log("Login status stored in Pinia: ", login.value);
  }

  // 设置真实姓名
  function setRealname(data) {
    realname.value = data;
    console.log("Realname stored in Pinia: ", realname.value);
  }

  // 设置 token
  function setToken(data) {
    token.value = data;
    console.log("Token stored in Pinia: ", token.value);
  }

  return {
    login,
    realname,
    setRealname,
    isLogin,
    setLogin,
    token,
    setToken,
  };
}, {
  persist: {
    enabled: true,  // 确保启用持久化
    storage: localStorage, // 使用 localStorage 进行存储
    paths: ["login", "realname","token"],  // 持久化 login 和 token 状态
  }
});

export default useUserStore;
