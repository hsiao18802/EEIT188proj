<template>
  <div class="member-chat">
    <h3>會員對話</h3>
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
        brokerURL: 'wss://edc1-1-160-11-21.ngrok-free.app/ws/websocket',
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
  margin: 0 auto;
  font-family: 'Helvetica Neue', Arial, sans-serif;
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  padding: 20px;
}

h3 {
  font-size: 24px;
  font-weight: 600;
  text-align: center;
  color: #333;
}

.messages {
  height: 400px;
  overflow-y: auto;
  border: 1px solid #eee;
  padding: 15px;
  margin-bottom: 20px;
  background-color: #fafafa;
  border-radius: 10px;
  box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.05);
  display: flex;
  flex-direction: column;
  gap: 10px; /* 增加訊息框之間的距離 */
}

.message-box {
  padding: 12px;
  border-radius: 8px;
  max-width: 75%; /* 限制最大寬度，不會超出視窗 */
  word-wrap: break-word; /* 自動換行 */
  transition: background-color 0.3s ease;
  display: flex;
  flex-direction: column;
}

.user-message {
  align-self: flex-start; /* 讓用戶消息靠左 */
  background-color: #e0f7fa;
  color: #00796b;
}

.support-message {
  align-self: flex-end; /* 讓客服消息靠右 */
  background-color: #ffebee;
  color: #c62828;
}

.message-sender {
  font-weight: 700;
  font-size: 12px;
  margin-bottom: 6px;
  color: #555;
}

.message-content {
  margin: 0;
  font-size: 14px;
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
  border: 1px solid #ddd;
  font-size: 14px;
  transition: border-color 0.3s ease;
}

.input-message:focus {
  border-color: #00796b;
  outline: none;
  box-shadow: 0 0 5px rgba(0, 121, 107, 0.2);
}

.send-button {
  background-color: #00796b;
  color: white;
  border: none;
  padding: 12px 20px;
  border-radius: 8px;
  cursor: pointer;
  font-size: 14px;
  transition: background-color 0.3s ease;
}

.send-button:hover {
  background-color: #004d40;
}

.send-button:active {
  background-color: #00251a;
}


</style>
