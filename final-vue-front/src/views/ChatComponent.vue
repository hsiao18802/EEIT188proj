<template>
  <div>
    <!-- 開啟聊天的按鈕 -->
    <div v-if="!chatVisible" class="open-chat" @click="toggleChat">
      💬
    </div>
    <!-- 聊天窗口 -->
    <div v-if="chatVisible" class="chat-container">
      <div class="chat-window">
        <div class="header">
          <span class="header-title">趣露營chatbot</span>
          <span class="close-btn" @click="toggleChat">×</span>
        </div>
        <div class="messages">
          <div v-for="(message, index) in messages" :key="index" :class="['message-row', message.type]">
            <div class="message-bubble">
              <span>{{ message.text }}</span>
            </div>
          </div>
        </div>
        <div class="input-container">
          <input v-model="userInput" @keyup.enter="sendMessage" placeholder="請輸入您的問題..." />
          <button @click="sendMessage">發送</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axiosapi from '@/plugins/axios';
import { v4 as uuidv4 } from 'uuid'; // 使用 uuid 生成唯一的 sessionId

export default {
  data() {
    return {
      messages: [], // 聊天記錄
      userInput: '', // 用戶輸入的消息
      sessionId: uuidv4(), // 使用 UUID 生成唯一的 sessionId
      chatVisible: false // 控制聊天窗口的顯示/隱藏，默認隱藏
    };
  },
  mounted() {
    // 當組件加載時，自動觸發歡迎事件
    this.triggerWelcomeEvent();
  },
  methods: {
    triggerWelcomeEvent() {
      axiosapi.post('/api/welcome', {
        sessionId: this.sessionId // 傳遞 sessionId 作為請求參數
      }).then(response => {
        const botResponse = response.data.responseText;
        this.messages.push({ type: 'bot', text: botResponse });
      }).catch(error => {
        console.error("Error:", error);
        this.messages.push({ type: 'bot', text: '抱歉，處理您的請求時發生了錯誤。' });
      });
    },
    sendMessage() {
      if (this.userInput.trim() !== '') {
        // 添加用戶消息到聊天記錄中
        this.messages.push({ type: 'user', text: this.userInput });

        // 發送用戶消息到後端處理
        axiosapi.post('/api/dialogflow', {
          sessionId: this.sessionId, // 發送當前的 sessionId
          queryInput: {
            text: {
              text: this.userInput,
              languageCode: 'zh-TW'
            }
          }
        }).then(response => {
          const botResponse = response.data.responseText;
          this.messages.push({ type: 'bot', text: botResponse });
        }).catch(error => {
          console.error("Error:", error);
          this.messages.push({ type: 'bot', text: '抱歉，處理您的請求時發生了錯誤。' });
        });

        // 清空輸入框
        this.userInput = '';
      }
    },
    toggleChat() {
      this.chatVisible = !this.chatVisible;
    }
  }
}
</script>

<style scoped>
/* 整體容器 */
.chat-container {
  position: fixed;
  bottom: 20px;
  left: 20px; /* 更改到左下角 */
  z-index: 1000;
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}

.chat-window {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 400px;
  width: 350px;
  border: 1px solid #ddd;
  border-radius: 15px;
  background: #fff;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
  overflow: hidden; /* 確保子元素不會超出邊界 */
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  background-color: #415569;
  color: white;
  border-top-left-radius: 15px;
  border-top-right-radius: 15px;
}

.header-title {
  font-size: 16px;
  font-weight: bold;
}

.close-btn {
  cursor: pointer;
  font-size: 18px;
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

.user .message-bubble {
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

.open-chat {
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #007bff;
  color: white;
  width: 50px;
  height: 50px;
  border-radius: 50%;
  cursor: pointer;
  font-size: 20px;
  position: fixed;
  bottom: 20px;
  left: 20px; /* 調整到左下角 */
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
  transition: background-color 0.3s ease;
}

.open-chat:hover {
  background-color: #0056b3;
}
</style>
