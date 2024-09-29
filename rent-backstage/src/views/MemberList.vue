<template>
    <div class="member-list">
      <h3>等待支援的會員</h3>
      <ul>
        <!-- 顯示會員名稱 -->
        <li v-for="member in members" :key="member.id" @click="selectMember(member)" class="clickable-member">
          {{ member.member.realName }} (ID: {{ member.member.membersId }})
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    props: ['members'],
    methods: {
      selectMember(member) {
        // 確保有 id (customerRequestId) 和 membersId
        if (!member.id || !member.member.membersId) {
          console.error('缺少 customerRequestId 或 membersId，無法選擇會員');
          return;
        }
  
        // 傳遞會員和請求 ID 給父組件
        this.$emit('member-selected', { 
          customerRequestId: member.id, // 使用請求的 id 作為 customerRequestId
          membersId: member.member.membersId, // 確保 membersId 正確傳遞
          realName: member.member.realName // 傳遞會員名稱
        });
      }
    }
  }
  </script>
  
  <style scoped>
  .member-list {
    width: 200px;
    border-right: 1px solid #ddd;
    padding: 10px;
  }
  .member-list ul {
    list-style: none;
    padding: 0;
  }
  .member-list li {
    padding: 5px;
    cursor: pointer;
  }
  .member-list li:hover {
    background-color: #f0f0f0;
    cursor: pointer; /* 滑鼠懸停時變成手指樣式 */
    color: blue; /* 滑鼠懸停時改變字體顏色 */
  }
  .clickable-member {
    cursor: pointer;
    transition: background-color 0.3s ease, color 0.3s ease; /* 平滑的點擊效果 */
  }
  .clickable-member:hover {
    background-color: #e0e0e0; /* 滑鼠懸停時的背景顏色變化 */
  }
  </style>
  