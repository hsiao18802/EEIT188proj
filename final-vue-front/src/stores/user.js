import { defineStore } from "pinia";
import { ref, computed } from "vue";

const useUserStore = defineStore("user", () => {
  const login = ref(false);
  const realname = ref("");
  const token = ref("");


  const isLogin = computed(() => login.value);


  function setLogin(data) {
    login.value = data;
  }


  function setRealname(data) {
    realname.value = data;
    console.log("Realname stored in Pinia: ", realname.value);
  }


  function setToken(data) {
    token.value = data;
  }

  return {
    realname, setRealname, isLogin, setLogin, token, setToken
  };
}, {
  persist: {
    storage: localStorage,
    paths: ["realname", "login"]
  }
});

export default useUserStore;
