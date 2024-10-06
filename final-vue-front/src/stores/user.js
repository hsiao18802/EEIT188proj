import { defineStore } from 'pinia';
import { ref, computed } from 'vue';

const useUserStore = defineStore('user', () => {
  const login = ref(false); // 登录状态
  const realname = ref(""); // 真实姓名
  const token = ref(""); // JWT token
  const membersId = ref(); // 會員 ID
  const memberPhoto = ref(""); // 會員大頭貼

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

  // 更新 membersId
  function setMembersId(id) {
    membersId.value = id;
    console.log("MembersId stored in Pinia: ", membersId.value);
  }

  // 设置会员大头贴
  function setMemberPhoto(photoUrl) {
    memberPhoto.value = photoUrl;
    console.log("MemberPhoto stored in Pinia: ", memberPhoto.value);
  }

  return {
    login, realname, setRealname, isLogin, setLogin, token, setToken, membersId, setMembersId, memberPhoto, setMemberPhoto
  };
}, {
  persist: {
    enabled: true,
    storage: localStorage,
    paths: ["realname", "login", "token", "membersId", "memberPhoto"]
  }
});

export default useUserStore;
