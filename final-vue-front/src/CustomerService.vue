<template>
  <div class="customer-support">
    <h1>客服中心</h1>
    <!-- 顯示所有客服請求列表 -->
    <div class="requests-list">
      <h2>等待處理的客服請求</h2>
      <ul>
        <li v-for="request in customerRequests" :key="request.id" @click="selectRequest(request)">
          <strong>會員 ID:</strong> {{ request.membersId }} - <strong>狀態:</strong> {{ request.status }}
          <br />
          <small>問題描述: {{ request.issueDescription }}</small>
        </li>
      </ul>
    </div>

    <!-- 顯示選中的客服請求的聊天記錄和輸入框 -->
    <div v-if="selectedRequest" class="chat-container">
      <h3>會員 ID: {{ selectedRequest.membersId }}</h3>
      <div class="chat-window">
        <div class="messages">
          <div v-for="(message, index) in messages" :key="index" :class="['message-row', message.sender]">
            <div class="message-bubble">
              <span>{{ message.text }}</span>
            </div>
          </div>
        </div>
        <div class="input-container">
          <input v-model="userInput" @keyup.enter="sendMessage" placeholder="請輸入您的回覆..." />
          <button @click="sendMessage">發送</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axiosapi from './plugins/axios';
import { Client } from '@stomp/stompjs';
import SockJS from 'sockjs-client';

export default {
  data() {
    return {
      customerRequests: [], // 儲存所有客服請求
      selectedRequest: null, // 當前選中的客服請求
      messages: [], // 當前聊天記錄
      userInput: '', // 客服輸入的消息
      stompClient: null, // Stomp 客戶端
    };
  },
  mounted() {
    this.loadCustomerRequests(); // 加載所有客服請求
    this.connectWebSocket(); // 連接 WebSocket
  },
  methods: {
    // 加載客服請求列表
    loadCustomerRequests() {
      axiosapi.get('api/customer-support-requests')
        .then(response => {
          this.customerRequests = response.data;
        })
        .catch(error => {
          console.error("無法加載客服請求列表:", error);
        });
    },
    // 當選中某個客服請求時，加載該請求的聊天記錄
    selectRequest(request) {
      this.selectedRequest = request;
      this.loadChatHistory(request.membersId);
    },
    // 加載聊天歷史記錄
    loadChatHistory(membersId) {
      axiosapi.post('api/chat-history', { membersId })
        .then(response => {
          this.messages = response.data.map(record => ({
            sender: record.sender === 'user' ? 'user' : 'bot',
            text: record.text,
          }));
        })
        .catch(error => {
          console.error("加載聊天歷史記錄時發生錯誤:", error);
        });
    },
    // 連接 WebSocket
    connectWebSocket() {
      const socket = new SockJS('http://localhost:8080/ws');
      this.stompClient = new Client({
        webSocketFactory: () => socket,
        debug: function(str) {
          console.log(str);
        },
        onConnect: () => {
          console.log("已連接 WebSocket");
          this.stompClient.subscribe('/topic/messages', message => {
            const receivedMessage = JSON.parse(message.body);
            this.messages.push({
              sender: receivedMessage.sender,
              text: receivedMessage.text,
            });
          });
        },
        onStompError: (frame) => {
          console.error('STOMP Error:', frame);
        }
      });
      this.stompClient.activate();
    },
    // 發送消息
    sendMessage() {
      if (this.userInput.trim() !== '' && this.selectedRequest) {
        // 先將客服輸入的消息加入到消息列表中顯示
        const message = {
          sender: 'support',
          text: this.userInput,
          membersId: this.selectedRequest.membersId
        };
        this.messages.push(message);

        // 通過 WebSocket 發送消息
        this.stompClient.publish({
          destination: '/app/sendMessage',
          body: JSON.stringify(message)
        });

        // 清空輸入框
        this.userInput = '';
      }
    }
  }
};
</script>

<style scoped>
.customer-support {
  padding: 20px;
}
.requests-list {
  margin-bottom: 20px;
}
.requests-list ul {
  list-style-type: none;
  padding: 0;
}
.requests-list li {
  background: #f9f9f9;
  margin: 5px 0;
  padding: 10px;
  border: 1px solid #ddd;
  cursor: pointer;
}
.chat-container {
  margin-top: 20px;
}
.chat-window {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 400px;
  width: 100%;
  border: 1px solid #ddd;
  border-radius: 5px;
  background: #fff;
  overflow: hidden;
}
.messages {
  flex: 1;
  overflow-y: auto;
  padding: 10px;
  background-color: #f9f9f9;
}
.message-row {
  display: flex;
  margin-bottom: 10px;
}
.message-bubble {
  max-width: 70%;
  padding: 10px 15px;
  border-radius: 15px;
  word-break: break-word;
  display: inline-block;
  background-color: #f0f0f0;
}
.user {
  justify-content: flex-end; /* 將用戶訊息向右對齊 */
}
.bot {
  justify-content: flex-start; /* 將機器人訊息向左對齊 */
}
.support {
  justify-content: flex-end; /* 將客服訊息向右對齊 */
}
.user .message-bubble, .support .message-bubble {
  background-color: #e9f6ff;
  color: #007bff;
  margin-left: auto; /* 向右對齊 */
}
.bot .message-bubble {
  background-color: #f0f0f0;
  color: #333;
  margin-right: auto; /* 向左對齊 */
}
.input-container {
  display: flex;
  padding: 10px;
  border-top: 1px solid #ddd;
  background-color: #f9f9f9;
}
input {
  flex: 1;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 5px;
  outline: none;
  margin-right: 10px;
  font-size: 14px;
}
button {
  padding: 10px 20px;
  background-color: #007bff;
  border: none;
  color: white;
  border-radius: 5px;
  cursor: pointer;
}
button:hover {
  background-color: #0056b3;
}
</style>
