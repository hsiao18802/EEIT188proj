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
    background: linear-gradient(135deg, #f5f7fa, #c3cfe2);
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.member-list h3 {
    font-family: 'Arial', sans-serif;
    font-size: 1.2em;
    text-align: center;
    color: #333;
    padding-bottom: 10px;
    border-bottom: 1px solid #ddd;
}

.member-list ul {
    padding: 0 10px;
}

.member-list li {
    font-family: 'Verdana', sans-serif;
    font-size: 1em;
    margin-bottom: 5px;
    border-radius: 5px;
    padding: 10px;
    transition: all 0.3s ease-in-out;
    background: #fff;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.member-list li:hover {
    background: #e7f3ff;
    transform: translateY(-3px);
    color: #0056b3;
}

.clickable-member::before {
    content: "👤 ";
}

.clickable-member:hover::before {
    content: "👉 ";
}

.clickable-member:hover {
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15);
    border-left: 4px solid #007bff;
}

  </style>
  