import { defineStore } from "pinia";
import { ref, computed } from "vue";

const useUserStore = defineStore("user", () => {
  const login = ref(false);
  const realname = ref(""); // �ϥ� realname ���N email
  const token = ref(""); // �s�x JWT token
  const membersId = ref(); // 新增 membersId

  // �p���ݩʨӧP�_�O�_�n�J
  const isLogin = computed(() => login.value);

  // �]�m�n�J���A
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

  // 更新 membersId
  function setMembersId(id) {
    membersId.value = id;
    console.log("MembersId stored in Pinia: ", membersId.value);
  }

  return {
    realname, setRealname, isLogin, setLogin, token, setToken,
    membersId,
    setMembersId // 返回更新 membersId 的函數
  };
}, {
  persist: {
    storage: localStorage,
    paths: ["realname", "login", "token", "membersId"] // �P�B���[�� realname, login �M token
  }
});

export default useUserStore;
