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
      <div class="chat-window" ref="chatWindow">
        <div class="messages">
          <div v-for="(message, index) in filteredMessages" :key="index" :class="['message-row', message.sender]">
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
      sessionId: null // 追蹤會話 ID
    };
  },
  computed: {
    filteredMessages() {
      return this.messages.filter(message => message.text && message.text.trim() !== '');
    }
  },
  mounted() {
    this.loadCustomerRequests(); // 加載所有客服請求
    this.connectWebSocket(); // 在一開始就建立 WebSocket 連接
  },
  methods: {
    loadCustomerRequests() {
      axiosapi.get('api/customer-support-requests')
        .then(response => {
          this.customerRequests = response.data;
        })
        .catch(error => {
          console.error("無法加載客服請求列表:", error);
        });
    },
    // 當選中某個客服請求時
    selectRequest(request) {
      this.selectedRequest = request;
      this.messages = [];
      this.loadChatHistory(request.membersId);
      this.sessionId = request.sessionId || this.generateSessionId();

      // 每次選中客服請求時檢查該會員是否有未解決的客服請求
      this.checkExistingSupportRequest(request.membersId).then(exists => {
        if (exists) {
          console.log("已經有未解決的客服請求，不需要創建新的。");
        } else {
          console.log("沒有未解決的客服請求，可以創建新的請求。");
        }
      });
    },
    loadChatHistory(membersId) {
      axiosapi.post('api/chat-history', { membersId })
        .then(response => {
          this.messages = response.data.map(record => ({
            sender: record.sender === 'user' ? 'user' : 'support',
            text: record.text,
          }));
          this.scrollToBottom(); // 加載歷史消息後滾動到底部
        })
        .catch(error => {
          console.error("加載聊天歷史記錄時發生錯誤:", error);
        });
    },
    connectWebSocket() {
      // 斷開之前的連接
      if (this.stompClient) {
        this.stompClient.deactivate();
      }

      // 連接新的 WebSocket
      const socket = new SockJS('http://localhost:8080/ws');
      this.stompClient = new Client({
        webSocketFactory: () => socket,
        debug: function (str) {
          console.log(str);
        },
        onConnect: () => {
          console.log("已連接 WebSocket");

          // 訂閱所有客戶的消息頻道
          this.customerRequests.forEach(request => {
            this.subscribeToCustomer(request.membersId);
          });
        },
        onStompError: (frame) => {
          console.error('STOMP Error:', frame);
        }
      });
      this.stompClient.activate();
    },
    // 訂閱指定會員的消息頻道
    subscribeToCustomer(membersId) {
      if (this.stompClient) {
        // 訂閱客戶的消息頻道
        this.stompClient.subscribe('/topic/customer/' + membersId, message => {
          const receivedMessage = JSON.parse(message.body);
          if (receivedMessage.text && receivedMessage.text.trim() !== '') {
            this.messages.push({
              sender: 'user',
              text: receivedMessage.text,
            });
            this.scrollToBottom(); // 每次收到新消息時滾動到底部
          }
        });

        // 訂閱客服的消息頻道
        this.stompClient.subscribe('/topic/support/' + membersId, message => {
          const receivedMessage = JSON.parse(message.body);
          if (receivedMessage.text && receivedMessage.text.trim() !== '') {
            this.messages.push({
              sender: 'support',
              text: receivedMessage.text,
            });
            this.scrollToBottom(); // 每次收到新消息時滾動到底部
          }
        });
      }
    },
    // 生成會話 ID
    generateSessionId() {
      return 'session_' + Math.random().toString(36).substr(2, 9);
    },
    sendMessage() {
      if (this.userInput.trim() !== '' && this.selectedRequest) {
        const message = {
          sender: 'support',
          text: this.userInput,
          membersId: this.selectedRequest.membersId,
          sessionId: this.sessionId
        };

        // 儲存消息到資料庫
        axiosapi.post('/api/send-support-message', message)
          .then(() => {
            this.messages.push(message); // 立即將消息添加到消息列表中顯示

            // 通過 WebSocket 發送消息到客戶的頻道
            this.stompClient.publish({
              destination: '/app/sendMessage/support/' + this.selectedRequest.membersId,
              body: JSON.stringify(message)
            });

            this.scrollToBottom(); // 發送消息後滾動到底部

            // 清空輸入框
            this.userInput = '';
          })
          .catch(error => {
            console.error("儲存訊息到資料庫失敗：", error);
          });
      }
    },
    scrollToBottom() {
      // 將消息窗口滾動到底部
      this.$nextTick(() => {
        const chatWindow = this.$refs.chatWindow;
        if (chatWindow) {
          chatWindow.scrollTop = chatWindow.scrollHeight;
        }
      });
    },
    // 檢查是否已經存在未解決的客服請求
    checkExistingSupportRequest(membersId) {
      return axiosapi.post('/api/check-support-request', { membersId })
        .then(response => {
          return response.data.exists; // 返回是否存在
        })
        .catch(error => {
          console.error("檢查客服請求時發生錯誤:", error);
          return false;
        });
    }
  },
  watch: {
    // 當 customerRequests 改變時，重新訂閱
    customerRequests(newRequests) {
      if (this.stompClient && this.stompClient.connected) {
        newRequests.forEach(request => {
          this.subscribeToCustomer(request.membersId);
        });
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
  overflow-y: auto; /* 使用 auto 让消息窗口支持滚动 */
}
.messages {
  flex: 1;
  overflow-y: auto;
  padding: 10px;
  background-color: #f9f9f9;
}
.message-row {
  display: flex;
  width: 100%;
  margin-bottom: 10px;
}
.user {
  justify-content: flex-start; /* 將用戶訊息向左對齊 */
}
.support {
  justify-content: flex-end; /* 將客服訊息向右對齊 */
}
.message-bubble {
  max-width: 70%; /* 最大寬度為 70% */
  padding: 10px 15px;
  border-radius: 15px;
  word-break: break-word; /* 當單詞過長時自動換行 */
  display: inline-block;
}

.user .message-bubble {
  background-color: #e9f6ff; /* 用戶訊息背景顏色 */
  color: #007bff;
  align-self: flex-start; /* 用戶訊息對齊左邊 */
}

.support .message-bubble {
  background-color: #d4edda; /* 客服訊息背景顏色 */
  color: #155724;
  align-self: flex-end; /* 客服訊息對齊右邊 */
}

.bot .message-bubble {
  background-color: #f0f0f0; /* 機器人訊息背景顏色 */
  color: #333;
  align-self: flex-start; /* 機器人訊息對齊左邊 */
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
