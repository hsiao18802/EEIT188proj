<template>
    <div class="customer-support">
      <member-list :members="members" @member-selected="selectMember"></member-list>
      <chat-window
        v-if="currentMember"
        :currentMember="currentMember"
        @request-resolved="handleRequestResolved"
      ></chat-window>
      <div v-else class="placeholder">請選擇一個會員進行對話</div>
    </div>
  </template>
  
  <script>
  import MemberList from '../views/MemberList.vue';
  import ChatWindow from '../views/ChatWindow.vue';
  import axiosapi from '../plugins/axios';
  import { ref, onMounted } from 'vue';
  import { Client } from '@stomp/stompjs'; // 引入 Stomp 客戶端
  
  export default {
    components: {
      MemberList,
      ChatWindow,
    },
    setup() {
      const members = ref([]); // 會員列表
      const currentMember = ref(null); // 當前選中的會員
      let stompClient = null; // Stomp 客戶端
  
      // 加載等待支援的會員列表
      const loadMembers = () => {
        axiosapi
          .get('/api/customer-support-requests')
          .then((response) => {
            members.value = response.data; // 更新會員列表
          })
          .catch((error) => {
            console.error('加載會員列表時出錯', error);
          });
      };
  
      // 連接 WebSocket 並訂閱新請求
      const connectWebSocket = () => {
        stompClient = new Client({
          brokerURL: 'ws://192.168.36.65:8080/ws/websocket', // WebSocket 服務器的 URL
          connectHeaders: {
            login: 'user', // 如果需要身份驗證，這裡可以設置用戶名
            passcode: 'password', // 密碼
          },
          debug: (str) => {
            console.log(str); // 調試信息
          },
          reconnectDelay: 5000, // 自動重連間隔時間
          heartbeatIncoming: 4000, // 心跳檢查間隔
          heartbeatOutgoing: 4000, // 心跳發送間隔
        });
  
        // 連接成功後訂閱新的客服請求
        stompClient.onConnect = (frame) => {
          console.log('Connected to WebSocket server: ' + frame);
  
          // 訂閱新客服請求
          stompClient.subscribe('/topic/new-support-request', (message) => {
            const newRequest = JSON.parse(message.body);
            console.log('Received new customer support request: ', newRequest);
            members.value.push(newRequest); // 新客服請求添加到會員列表
          });
        };
  
        // 連接失敗或斷開時的回調
        stompClient.onStompError = (frame) => {
          console.error('WebSocket 連接錯誤: ' + frame.headers['message']);
          console.error('WebSocket 詳細錯誤: ', frame.body);
        };
  
        // 開始 WebSocket 連接
        stompClient.activate();
      };
  
      // 當選擇某個會員時，更新當前選中的會員
      const selectMember = (member) => {
        currentMember.value = member;
      };
  
      // 當客服請求被標記為已解決時從列表中刪除該請求
      const handleRequestResolved = (resolvedRequestId) => {
        members.value = members.value.filter(
          (member) => member.id !== resolvedRequestId
        );
        currentMember.value = null; // 清除當前選擇的會員
      };
  
      // 當組件加載時執行
      onMounted(() => {
        loadMembers(); // 加載等待支援的會員
        connectWebSocket(); // 連接 WebSocket 訂閱新請求
      });
  
      return {
        members,
        currentMember,
        selectMember,
        handleRequestResolved, // 當請求被刪除後更新列表
      };
    },
  };
  </script>
  
  <style scoped>
  .customer-support {
    display: flex;
    height: 100vh;
  }
  .placeholder {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 18px; /* 調整字體大小 */
  font-weight: bold; /* 使字體更粗 */
  color: #000; /* 黑色文字 */
  background-color: #f0f0f0; /* 添加背景色，讓文字更突出 */
  border: 1px solid #ccc; /* 增加邊框，讓區塊更明顯 */
  padding: 20px; /* 添加內邊距，避免內容太靠邊 */
  height: 100%; /* 確保占滿容器的高度 */
}

  </style>
  