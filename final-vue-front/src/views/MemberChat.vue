<template>
  <div class="member-chat">
    <h3>客服對話</h3>
    <div class="messages" ref="messageContainer">
      <div
        v-for="message in messages"
        :key="message.timestamp"
        :class="{
          'user-message': message.sender === 'user',
          'support-message': message.sender === 'support'
        }"
        class="message-box"
      >
        <p class="message-sender">{{ message.sender }} - {{ formatTimestamp(message.timestamp) }}</p>
        <p class="message-content">{{ message.message }}</p>
      </div>
    </div>
    <div class="input-area">
      <textarea
        v-model="newMessage"
        placeholder="輸入訊息..."
        @keyup.enter="sendMessage"
        class="input-message"
      ></textarea>
      <button @click="sendMessage" class="send-button">發送</button>
    </div>
  </div>
</template>

<script>
import { Client } from '@stomp/stompjs';
import router from '@/router/router';
import Swal from 'sweetalert2';
import { ref, onMounted, watch, nextTick } from 'vue';
import axiosapi from '@/plugins/axios';
import useUserStore from '@/stores/user'; // 引入 Pinia 的 store

export default {
  setup() {
    const userStore = useUserStore();
    const membersId = ref(userStore.membersId); // 獲取會員ID
    const messages = ref([]); // 聊天消息列表
    const newMessage = ref(''); // 新消息
    const messageContainer = ref(null); // 滾動容器
    let stompClient = null; // Stomp 客戶端
    let subscription = null; // 訂閱的對象
    let hasCustomerRequest = ref(false); // 判斷是否已有客服請求

    // 滾動到最底部的函數
    const scrollToBottom = () => {
      nextTick(() => {
        if (messageContainer.value) {
          messageContainer.value.scrollTop = messageContainer.value.scrollHeight;
        }
      });
    };

    // 監聽消息列表變化並自動滾動
    watch(messages, () => {
      scrollToBottom(); // 每當 `messages` 列表更新時，滾動到底部
    });

    // 格式化時間戳為時間軸顯示
    const formatTimestamp = (timestamp) => {
      const date = new Date(timestamp);
      return date.toLocaleString(); // 可根據需要修改為不同的時間格式
    };

    // 連接 WebSocket
    const connectWebSocket = () => {
      if (!membersId.value) {
        console.error('membersId 為 null，無法建立 WebSocket 連接');
        return;
      }

      // 如果已有連接則先斷開
      if (stompClient && stompClient.connected) {
        if (subscription) {
          subscription.unsubscribe(); // 取消之前的訂閱
        }
        stompClient.deactivate(); // 斷開之前的 WebSocket 連接
      }

      // 初始化 Stomp 客戶端
      stompClient = new Client({
        brokerURL: 'wss://09c6-1-160-11-21.ngrok-free.app/ws/websocket',
        connectHeaders: {
          login: 'user',
          passcode: 'password',
        },
        debug: (str) => {
          console.log(str); // 調試信息
        },
        reconnectDelay: 5000,
        heartbeatIncoming: 4000,
        heartbeatOutgoing: 4000,
      });

      stompClient.onConnect = (frame) => {
        console.log('Connected: ' + frame);

        // 訂閱特定話題
        subscription = stompClient.subscribe(`/topic/member/${membersId.value}`, (message) => {
          const receivedMessage = JSON.parse(message.body);
          if (!messages.value.some(m => m.timestamp === receivedMessage.timestamp)) {
            messages.value.push(receivedMessage);
            scrollToBottom(); // 接收到新消息後立即滾動到底部
          }
        });
      };

      stompClient.activate();
    };

    // 加載聊天歷史
    const loadChatHistory = () => {
      axiosapi.get(`/api/chat-history?memberId=${membersId.value}`)
        .then(response => {
          messages.value = response.data; // 加載歷史紀錄
          scrollToBottom(); // 加載歷史紀錄後滾動到最底部
        })
        .catch(error => {
          console.error('無法加載聊天紀錄:', error);
        });
    };

    // 創建新的客服請求
    const createCustomerRequest = () => {
      const memberId = userStore.membersId;
      const issueDescription = "Requesting customer support.";

      axiosapi.post('/api/customer-support-request', {
        memberId: memberId,
        issueDescription: issueDescription,
      })
      .then(response => {
        console.log('Request created successfully', response.data);
        hasCustomerRequest.value = true; // 請求成功後標記已創建
      })
      .catch(error => {
        console.error('Error creating request:', error);
      });
    };

    // 發送消息
    const sendMessage = () => {
      if (!newMessage.value.trim()) {
        console.error('無法發送消息，輸入框為空');
        return;
      }

      if (!hasCustomerRequest.value) {
        createCustomerRequest();
      }

      const message = {
        member: { membersId: userStore.membersId },
        sender: 'user',
        message: newMessage.value,
        sessionId: `session-${userStore.membersId}`,
        timestamp: new Date().toISOString(),
      };

      if (stompClient && stompClient.connected) {
        stompClient.publish({
          destination: `/app/sendMessage`,
          body: JSON.stringify(message),
        });
        newMessage.value = ''; // 清空輸入框
      } else {
        console.error('WebSocket 未連接，無法發送消息');
      }
    };

    onMounted(() => {
      // 檢查是否已登錄
      if (!userStore.isLogin) { 
        Swal.fire({
          icon: 'warning',
          title: '請先登錄會員',
          text: '請登錄後再繼續操作',
          confirmButtonText: '前往登錄',
        }).then(() => {
          router.push('/secure/login'); // 重定向到登錄頁面
        });
      } else if (membersId.value) {
        connectWebSocket();
        loadChatHistory(); // 加載歷史紀錄
      } else {
        console.warn('membersId 未初始化，請檢查用戶數據設置');
      }
    });

    return {
      messages,
      newMessage,
      sendMessage,
      messageContainer,
      formatTimestamp, // 格式化時間戳的函數
    };
  },
};
</script>

<style scoped>
.member-chat {
  width: 600px;
  margin: 50px auto;
  font-family: 'Helvetica Neue', Arial, sans-serif;
  background: linear-gradient(135deg, #2c3e50, #4ca1af); /* 使用相同的背景漸層效果 */
  border-radius: 10px;
  padding: 20px;
  color: #fff;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h3 {
  font-size: 24px;
  font-weight: 700;
  text-align: center;
  margin-bottom: 20px;
  color: #ecf0f1;
}

.messages {
  height: 400px;
  overflow-y: auto;
  padding: 15px;
  margin-bottom: 20px;
  background-color: #34495e;
  border-radius: 10px;
  box-shadow: inset 0 2px 6px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column;
  gap: 12px;
}

.message-box {
  padding: 14px;
  border-radius: 8px;
  max-width: 75%;
  word-wrap: break-word;
  display: flex;
  flex-direction: column;
  transition: background-color 0.3s ease;
}

.user-message {
  align-self: flex-start;
  background-color: #1abc9c;
  color: white;
}

.support-message {
  align-self: flex-end;
  background-color: #e74c3c;
  color: white;
}

.message-sender {
  font-weight: 600;
  font-size: 13px;
  margin-bottom: 8px;
  color: #ecf0f1;
}

.message-content {
  margin: 0;
  font-size: 15px;
}

.input-area {
  display: flex;
  gap: 10px;
  align-items: center;
}

.input-message {
  flex: 1;
  padding: 12px;
  border-radius: 8px;
  border: none;
  font-size: 15px;
  background-color: #2c3e50;
  color: #ecf0f1;
  transition: box-shadow 0.3s ease;
}

.input-message:focus {
  box-shadow: 0 0 6px rgba(46, 204, 113, 0.5);
  outline: none;
}

.send-button {
  background-color: #1abc9c;
  color: white;
  border: none;
  padding: 12px 18px;
  border-radius: 8px;
  cursor: pointer;
  font-size: 15px;
  transition: background-color 0.3s ease;
}

.send-button:hover {
  background-color: #16a085;
}

.send-button:active {
  background-color: #149174;
}

.send-button:disabled {
  background-color: #bdc3c7;
  cursor: not-allowed;
}



</style>
