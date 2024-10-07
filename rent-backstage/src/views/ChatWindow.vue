<template>
    <div class="chat-window">
      <h3>與 {{ currentMember.realName }} 的對話</h3>
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
          <p class="message-content">{{ message.sender }}: {{ message.message }}</p>
          <p class="message-timestamp">{{ new Date(message.timestamp).toLocaleString() }}</p>
        </div>
      </div>
      <textarea
        v-model="newMessage"
        placeholder="輸入訊息..."
        @keyup.enter="sendMessage"
        class="message-input"
      ></textarea>
      <button @click="sendMessage" class="send-btn">發送</button>
      <button @click="markAsResolved" class="resolve-btn">已解決</button> <!-- 新增按鈕 -->
    </div>
  </template>
  
  <script>
  import { Client } from '@stomp/stompjs';
  import { ref, onMounted, watch, nextTick } from 'vue';
  import axiosapi from '@/plugins/axios';
  
  export default {
    props: ['currentMember'],
    setup(props, { emit }) {
      const messages = ref([]);
      const newMessage = ref('');
      const messageContainer = ref(null);
      let stompClient = null;
      let subscription = null;
  
      const scrollToBottom = () => {
        nextTick(() => {
          if (messageContainer.value) {
            messageContainer.value.scrollTop = messageContainer.value.scrollHeight;
          }
        });
      };
  
      const connectWebSocket = () => {
        if (!props.currentMember) {
          console.error('未選擇會員，無法建立 WebSocket 連接');
          return;
        }
  
        if (stompClient && stompClient.connected) {
          if (subscription) {
            subscription.unsubscribe();
          }
          stompClient.deactivate();
        }
  
        stompClient = new Client({
          brokerURL: 'ws://192.168.1.102:8080/ws/websocket',
          connectHeaders: {
            login: 'user',
            passcode: 'password',
          },
          debug: (str) => {
            console.log(str);
          },
          reconnectDelay: 5000,
          heartbeatIncoming: 4000,
          heartbeatOutgoing: 4000,
        });
  
        stompClient.onConnect = (frame) => {
          console.log('Connected: ' + frame);
  
          subscription = stompClient.subscribe(`/topic/member/${props.currentMember.membersId}`, (message) => {
            const receivedMessage = JSON.parse(message.body);
            if (!messages.value.some(m => m.timestamp === receivedMessage.timestamp)) {
              messages.value.push(receivedMessage);
              scrollToBottom();
            }
          });
        };
  
        stompClient.activate();
      };
  
      const sendMessage = () => {
        if (!newMessage.value.trim()) {
          console.error('無法發送消息，輸入框為空');
          return;
        }
  
        const message = {
          member: { membersId: props.currentMember.membersId },
          sender: 'support',
          message: newMessage.value,
          sessionId: `session-${props.currentMember.membersId}`,
          timestamp: new Date().toISOString(),
        };
  
        if (stompClient && stompClient.connected) {
          stompClient.publish({
            destination: `/app/sendMessage`,
            body: JSON.stringify(message),
          });
          newMessage.value = '';
        } else {
          console.error('WebSocket 未連接，無法發送消息');
        }
      };
  
      const markAsResolved = () => {
        if (!props.currentMember.customerRequestId) {
          console.error('缺少 customerRequestId，無法刪除');
          return;
        }
  
        axiosapi.delete(`/api/customer-support-request/${props.currentMember.customerRequestId}`)
          .then(response => {
            console.log('客服請求已刪除', response.data);
            alert('客服請求已標記為解決並刪除。');
            emit('request-resolved', props.currentMember.customerRequestId);
          })
          .catch(error => {
            console.error('無法刪除客服請求:', error);
          });
      };
  
      const loadChatHistory = () => {
        axiosapi.get(`/api/chat-history?memberId=${props.currentMember.membersId}`)
          .then(response => {
            messages.value = response.data;
            scrollToBottom();
          })
          .catch(error => {
            console.error('無法加載聊天紀錄:', error);
          });
      };
  
      onMounted(() => {
        if (props.currentMember) {
          connectWebSocket();
          loadChatHistory();
        } else {
          console.warn('未選擇會員，無法加載聊天記錄');
        }
      });
  
      watch(() => props.currentMember, (newMember) => {
        if (stompClient) {
          stompClient.deactivate();
        }
        connectWebSocket();
        loadChatHistory();
      });
  
      return {
        messages,
        newMessage,
        sendMessage,
        markAsResolved,
        messageContainer,
      };
    }
  };
  </script>
  
  <style scoped>
 .chat-window {
    background-color: #2c3e50;
    border-radius: 10px;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
    padding: 20px;
    width: 100%;
    color: #ecf0f1; /* 設定整體文字顏色 */
}

h3 {
    font-size: 1.6em;
    font-weight: bold;
    text-align: center;
    color: #ecf0f1;
}

.messages {
    height: 400px;
    overflow-y: auto;
    border: 1px solid #34495e;
    padding: 15px;
    margin-bottom: 10px;
    background-color: #34495e;
    border-radius: 10px;
    display: flex;
    flex-direction: column;
    gap: 15px;
}

.user-message {
    align-self: flex-start;
    background-color: #3498db;
    color: white;
    padding: 12px;
    border-radius: 10px;
    max-width: 70%;
    word-wrap: break-word;
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
}

.support-message {
    align-self: flex-end;
    background-color: #e74c3c;
    color: white;
    padding: 12px;
    border-radius: 10px;
    max-width: 70%;
    word-wrap: break-word;
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
}

.message-box {
    display: flex;
    flex-direction: column;
}

.message-content {
    font-size: 1.1em;
    margin: 0;
}

.message-timestamp {
    font-size: 0.9em;
    color: #bdc3c7;
    margin-top: 5px;
}

textarea {
    width: 100%;
    height: 60px;
    padding: 12px;
    border-radius: 10px;
    border: none;
    font-size: 1.1em;
    background-color: #34495e;
    color: white;
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
}

textarea:focus {
    outline: none;
    box-shadow: 0 2px 8px rgba(0, 255, 255, 0.2);
}

.send-btn, .resolve-btn {
    margin-top: 10px;
    padding: 12px 20px;
    border-radius: 10px;
    border: none;
    cursor: pointer;
    font-size: 1.1em;
}

.send-btn {
    background-color: #2980b9;
    color: white;
    transition: background-color 0.3s ease;
}

.send-btn:hover {
    background-color: #1c638c;
}

.resolve-btn {
    background-color: #27ae60;
    color: white;
    transition: background-color 0.3s ease;
}

.resolve-btn:hover {
    background-color: #1e8e4a;
}

.send-btn:active, .resolve-btn:active {
    background-color: #1c638c;
}

  </style>
  