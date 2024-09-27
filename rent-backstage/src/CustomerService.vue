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
      sessionId: null, // 追蹤會話 ID
      subscribedMembers: [] // 存儲已經訂閱的會員 ID
    };
  },
  computed: {
    filteredMessages() {
      return this.messages.filter(message => message.text && message.text.trim() !== '');
    }
  },
  mounted() {
    this.loadCustomerRequests(); // 加載所有客服請求
    this.connectWebSocket(); // 建立 WebSocket 連接
  },
  methods: {
    // 加載所有客服請求
    loadCustomerRequests() {
      axiosapi.get('api/customer-support-requests')
        .then(response => {
          this.customerRequests = response.data;
          // 在 WebSocket 連接成功後訂閱所有客戶的消息
          if (this.stompClient && this.stompClient.connected) {
            this.customerRequests.forEach(request => {
              this.subscribeToCustomer(request.membersId);
            });
          }
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

    // 加載歷史聊天紀錄
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

    // 建立 WebSocket 連接
    connectWebSocket() {
      // 確保 WebSocket 斷開前先進行清理
      if (this.stompClient) {
        this.stompClient.deactivate(); // 斷開之前的連接
      }

      // 建立新的 WebSocket 連接
      const socket = new SockJS('http://localhost:8080/ws'); // WebSocket 路徑與後端一致
      this.stompClient = new Client({
        webSocketFactory: () => socket,
        debug: (str) => {
          console.log('WebSocket Debug: ', str); // 監控 WebSocket 的狀態
        },
        heartbeatIncoming: 4000, // 設置心跳機制
        heartbeatOutgoing: 4000,
        reconnectDelay: 5000, // 設置自動重連時間
        onConnect: () => {
          console.log("WebSocket 連接成功");

          // 連接成功後，訂閱所有已存在的客戶請求
          this.customerRequests.forEach(request => {
            this.subscribeToCustomer(request.membersId);
          });
        },
        onDisconnect: () => {
          console.log("WebSocket 已斷開，將自動重連...");
          this.handleReconnect(); // 處理自動重連
        },
        onStompError: (frame) => {
          console.error('STOMP Error:', frame);
          this.handleReconnect(); // STOMP 錯誤時進行重連
        }
      });

      // 激活 WebSocket 連接
      this.stompClient.activate();
    },

    // 處理 WebSocket 重新連接
    handleReconnect() {
      if (this.reconnectAttempts < 5) { // 限制重連次數
        this.reconnectAttempts += 1;
        console.log(`WebSocket 嘗試重新連接 (${this.reconnectAttempts})...`);
        setTimeout(() => {
          this.connectWebSocket();
        }, 5000); // 每 5 秒嘗試重連一次
      } else {
        console.error("WebSocket 無法重新連接，達到最大重試次數");
      }
    },

    // 訂閱指定會員的消息頻道
    subscribeToCustomer(membersId) {
      if (this.stompClient) {
        // 檢查是否已經訂閱過
        if (this.isSubscribed(membersId)) {
          return; // 如果已經訂閱，則不進行重複訂閱
        }

        // 訂閱客戶的消息頻道
        this.stompClient.subscribe('/topic/customer/' + membersId, message => {
          console.log('收到新消息: ', message.body); // 確保消息被接收
          const receivedMessage = JSON.parse(message.body);
          if (receivedMessage.text && receivedMessage.text.trim() !== '') {
            this.messages.push({
              sender: 'user',
              text: receivedMessage.message,
            });
            this.scrollToBottom(); // 每次收到新消息時滾動到底部
          }
        });


        // 標記已訂閱
        this.subscribedMembers.push(membersId);
      }
    },

    // 檢查是否已經訂閱
    isSubscribed(membersId) {
      return this.subscribedMembers.includes(membersId);
    },

    // 生成會話 ID
    generateSessionId() {
      return 'session_' + Math.random().toString(36).substr(2, 9);
    },

    // 發送消息
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
            // 即時顯示消息
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
            // 顯示錯誤提示
            this.messages.push({
              sender: 'system',
              text: '發送消息失敗，請重試'
            });
          });
      }
    },

    // 滾動到最新消息
    scrollToBottom() {
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
    // 當 customerRequests 改變時，重新檢查並訂閱新的客戶
    customerRequests(newRequests) {
      if (this.stompClient && this.stompClient.connected) {
        newRequests.forEach(request => {
          if (!this.isSubscribed(request.membersId)) {
            this.subscribeToCustomer(request.membersId);
          }
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
