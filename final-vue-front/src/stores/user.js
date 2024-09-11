import { defineStore } from "pinia";
import { ref, computed } from "vue";

const useUserStore = defineStore("user", () => {
  const login = ref(false);
  const realname = ref(""); // 使用 realname 替代 email
  const token = ref(""); // 存儲 JWT token

  // 計算屬性來判斷是否登入
  const isLogin = computed(() => login.value);

  // 設置登入狀態
  function setLogin(data) {
    login.value = data;
  }

  // 設置 realname
  function setRealname(data) {
    realname.value = data;
    console.log("Realname stored in Pinia: ", realname.value); // 檢查是否正確存儲
  }

  // 設置 token
  function setToken(data) {
    token.value = data;
  }

  return {
    realname, setRealname, isLogin, setLogin, token, setToken
  };
}, {
  persist: {
    storage: localStorage,
    paths: ["realname", "login", "token"] // 同步持久化 realname, login 和 token
  }
});

export default useUserStore;
