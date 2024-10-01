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
      <button @click="markAsResolved" class="resolve-btn">以解決</button> <!-- 新增按鈕 -->
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
          brokerURL: 'ws://192.168.36.65:6174/ws/websocket',
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
    background-color: #f9f9f9;
    border-radius: 10px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    padding: 20px;
    width: 100%;
  }
  
  .messages {
    height: 400px;
    overflow-y: auto;
    border: 1px solid #ddd;
    padding: 15px;
    margin-bottom: 10px;
    background-color: white;
  }
  
  .user-message {
    text-align: left;
    background-color: #d3e2ff;
    padding: 10px;
    border-radius: 10px;
    margin-bottom: 5px;
    max-width: 70%;
  }
  
  .support-message {
    text-align: right;
    background-color: #f0f0f0;
    padding: 10px;
    border-radius: 10px;
    margin-bottom: 5px;
    max-width: 70%;
    margin-left: auto;
  }
  
  .message-content {
    font-size: 14px;
    margin: 0;
  }
  
  .message-timestamp {
    font-size: 12px;
    color: gray;
    margin: 5px 0 0;
  }
  
  textarea {
    width: 100%;
    height: 50px;
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ddd;
  }
  
  .send-btn, .resolve-btn {
    margin-top: 10px;
    padding: 10px;
    width: 100px;
    border-radius: 5px;
    border: none;
    cursor: pointer;
  }
  
  .send-btn {
    background-color: #007bff;
    color: white;
  }
  
  .resolve-btn {
    background-color: #28a745;
    color: white;
  }
  
  .send-btn:hover, .resolve-btn:hover {
    opacity: 0.8;
  }
  </style>
  