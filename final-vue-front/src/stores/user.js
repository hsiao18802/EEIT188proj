import { defineStore } from 'pinia';
import { ref, computed } from 'vue';

const useUserStore = defineStore('user', () => {
  const login = ref(false); // 登录状态
  const realname = ref(""); // 真实姓名
  const token = ref(""); // JWT token
  const membersId = ref(); // 新增 membersId


  const isLogin = computed(() => login.value);


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

  // 更新 membersId
  function setMembersId(id) {
    membersId.value = id;
    console.log("MembersId stored in Pinia: ", membersId.value);
  }

  return {
    login, realname, setRealname, isLogin, setLogin, token, setToken, membersId, setMembersId
  };
}, {
  persist: {
    enabled: true,
    storage: localStorage,
    paths: ["realname", "login", "token", "membersId"]
  }
});

export default useUserStore;
