<template>
    <div>
      <h2>會員管理</h2>
      <table>
        <thead>
          <tr>
            <th>會員ID</th>
            <th>會員名稱</th>
            <th>電子郵件</th>
            <th>電話</th>
            <th>地址</th>
            <th>黑名單狀態</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="member in members" :key="member.membersId">
            <td>{{ member.membersId }}</td>
            <td>{{ member.realName }}</td>
            <td>{{ member.email }}</td>
            <td>{{ member.phone }}</td>
            <td>{{ member.address }}</td>
            <td>{{ member.blacklisted ? '是' : '否' }}</td>
            <td>
              <button v-if="!member.blacklisted" @click="addToBlacklist(member.membersId)">加入黑名單</button>
              <button v-else @click="removeFromBlacklist(member.membersId)">移出黑名單</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script>
  import Swal from 'sweetalert2';
  import axiosapi from '../plugins/axios';  // 引入 axios
  
  export default {
    data() {
      return {
        members: [] // 存儲會員數據
      };
    },
    mounted() {
      this.fetchMembers(); // 在組件加載時獲取會員數據
    },
    methods: {
      // 獲取所有會員數據
      fetchMembers() {
        axiosapi.get('/api/backend/members/all')
          .then(response => {
            this.members = response.data;
          })
          .catch(error => {
            console.error('獲取會員數據時發生錯誤:', error);
          });
      },
      // 將會員加入黑名單
      addToBlacklist(memberId) {
        axiosapi.post(`/api/backend/members/blacklist/${memberId}`)
          .then(() => {
            Swal.fire({
              title: '已加入黑名單',
              icon: 'success',
              timer: 1500,
              showConfirmButton: false
            });
            this.fetchMembers(); // 刷新列表
          })
          .catch(error => {
            console.error('將會員加入黑名單時發生錯誤:', error);
          });
      },
      // 將會員移出黑名單
      removeFromBlacklist(memberId) {
        axiosapi.post(`/api/backend/members/removeBlacklist/${memberId}`)
          .then(() => {
            Swal.fire({
              title: '已移出黑名單',
              icon: 'success',
              timer: 1500,
              showConfirmButton: false
            });
            this.fetchMembers(); // 刷新列表
          })
          .catch(error => {
            console.error('將會員移出黑名單時發生錯誤:', error);
          });
      }
    }
  };
  </script>
  
<style scoped>
/* 表格樣式 */
table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
  background-color: #f9f9f9;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
  overflow: hidden;
}

th, td {
  padding: 15px;
  text-align: left;
  border-bottom: 1px solid #ddd;
  font-size: 16px;
}

/* 表頭樣式 */
th {
  background-color: #357ae8;
  color: white;
  text-transform: uppercase;
  font-weight: bold;
}

/* 表格行交替顏色 */
tr:nth-child(even) {
  background-color: #f2f2f2;
}

/* 鼠標懸停時高亮表格行 */
tr:hover {
  background-color: #f1f1f1;
}

/* 按鈕樣式 */
button {
  padding: 10px 15px;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

/* 黑名單按鈕樣式 */
button:hover {
  background-color: #1e5fb4;
}

button:active {
  background-color: #174b89;
}

/* 加入黑名單按鈕 */
button:nth-of-type(1) {
  background-color: #f44336; /* 紅色 */
}

button:nth-of-type(1):hover {
  background-color: #d32f2f; /* 懸停顏色 */
}

button:nth-of-type(1):active {
  background-color: #b71c1c; /* 點擊時顏色 */
}

/* 移出黑名單按鈕 */
button:nth-of-type(2) {
  background-color: #4caf50; /* 綠色 */
}

button:nth-of-type(2):hover {
  background-color: #388e3c; /* 懸停顏色 */
}

button:nth-of-type(2):active {
  background-color: #2e7d32; /* 點擊時顏色 */
}

/* 版面排版 */
h2 {
  text-align: center;
  color: #357ae8;
  margin-bottom: 20px;
}

div {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

</style>
