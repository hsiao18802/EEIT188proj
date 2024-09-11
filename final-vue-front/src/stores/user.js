import { defineStore } from "pinia";
import { ref, computed } from "vue";

const useUserStore = defineStore("user", () => {
  const login = ref(false);
  const realname = ref(""); // �ϥ� realname ���N email
  const token = ref(""); // �s�x JWT token

  // �p���ݩʨӧP�_�O�_�n�J
  const isLogin = computed(() => login.value);

  // �]�m�n�J���A
  function setLogin(data) {
    login.value = data;
  }

  // �]�m realname
  function setRealname(data) {
    realname.value = data;
    console.log("Realname stored in Pinia: ", realname.value); // �ˬd�O�_���T�s�x
  }

  // �]�m token
  function setToken(data) {
    token.value = data;
  }

  return {
    realname, setRealname, isLogin, setLogin, token, setToken
  };
}, {
  persist: {
    storage: localStorage,
    paths: ["realname", "login", "token"] // �P�B���[�� realname, login �M token
  }
});

export default useUserStore;
