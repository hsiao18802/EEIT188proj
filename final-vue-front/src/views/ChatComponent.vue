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
          <div v-for="(message, index) in messages" :key="index" :class="['message-row', message.sender]">
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
import useUserStore from '@/stores/user.js'; // 引入 Pinia 的 store

export default {
  data() {
    return {
      messages: [], // 聊天記錄
      userInput: '', // 用戶輸入的消息
      sessionId: uuidv4(), // 使用 UUID 生成唯一的 sessionId
      chatVisible: false, // 控制聊天窗口的顯示/隱藏，默認隱藏
      isHumanAgentMode: false // 是否進入人工客服模式
    };
  },
  computed: {
    membersId() {
      // 從 Pinia 的 user store 中獲取會員 ID
      const userStore = useUserStore();
      return userStore.membersId;
    }
  },
  mounted() {
    // 檢查 localStorage 是否有 sessionId，如果有則使用，否則生成一個新的
    const savedSessionId = localStorage.getItem('sessionId');
    if (savedSessionId) {
      this.sessionId = savedSessionId;
    } else {
      localStorage.setItem('sessionId', this.sessionId);
    }

    this.loadChatHistory();
    // this.triggerWelcomeEvent();
  },
  methods: {
    // 加載歷史聊天紀錄
    loadChatHistory() {
      if (!this.membersId) {
        console.error('會員 ID 未找到，無法加載聊天紀錄。');
        return;
      }

      axiosapi.post('/api/chat-history', { membersId: this.membersId })
        .then(response => {
          const chatHistory = response.data;
          this.messages = chatHistory.map(record => ({
            sender: record.sender === 'user' ? 'user' : 'bot',
            text: record.text
          }));
        })
        .catch(error => {
          console.error("加載聊天紀錄時發生錯誤：", error);
        });
    },
    // 發送歡迎消息
    // triggerWelcomeEvent() {
    //   axiosapi.post('/api/welcome', { sessionId: this.sessionId })
    //     .then(response => {
    //       const botResponse = response.data.responseText;
    //       this.messages.push({ sender: 'bot', text: botResponse });
    //     })
    //     .catch(error => {
    //       console.error("Error:", error);
    //       this.messages.push({ sender: 'bot', text: '抱歉，處理您的請求時發生了錯誤。' });
    //     });
    // },
    // 發送消息
    sendMessage() {
  if (this.userInput.trim() !== '') {
    // 先將用戶輸入的消息加入到消息列表中顯示
    this.messages.push({ sender: 'user', text: this.userInput });

    if (this.isHumanAgentMode) {
      // 發送消息到客服人員
      console.log("進入人工客服模式，發送消息到客服人員。");
      this.sendMessageToAgent(this.userInput);
    } else {
      // 普通模式下，通過 Dialogflow 處理
      const requestBody = {
        sessionId: this.sessionId || '',
        queryInput: {
          text: {
            text: this.userInput,
            languageCode: 'zh-TW'
          }
        },
        membersId: this.membersId // 傳遞會員 ID
      };

      axiosapi.post('/api/dialogflow', requestBody)
        .then(response => {
          console.log("後端回應：", response.data); // 打印後端回應
          const botResponse = response.data.responseText;
          const isHumanAgent = response.data.isHumanAgent;

          // 如果有回應內容，才顯示機器人回應
          if (botResponse && botResponse.trim() !== '') {
            this.messages.push({ sender: 'bot', text: botResponse });
          } else {
            // 如果沒有回應，則在控制台提示，前端不做任何顯示
            console.log("無法識別的輸入，沒有回應內容。");
          }

          // 如果需要轉人工客服，設置標記並提示用戶
          if (isHumanAgent) {
            this.isHumanAgentMode = true;
            this.messages.push({ sender: 'bot', text: '您已進入人工客服模式，稍候將有客服人員與您聯繫。' });
          }
        })
        .catch(error => {
          console.error("Error:", error);
          if (error.response && error.response.data) {
            console.error("Error Response Data:", error.response.data);
          }
          this.messages.push({ sender: 'bot', text: '抱歉，處理您的請求時發生了錯誤。' });
        });
    }

    // 清空輸入框
    this.userInput = '';
  }


    },
    // 發送消息給人工客服
    sendMessageToAgent(message) {
      // 只在消息內容不為空時發送
      if (message.trim() !== '') {
        axiosapi.post('/api/customer-support', {
          membersId: this.membersId,
          issueDescription: message, // 傳遞訊息內容
          sessionId: this.sessionId
        })
        .then(response => {
          console.log('消息已發送到客服人員：', response.data);
        })
        .catch(error => {
          console.error("無法發送消息到客服人員：", error);
        });
      }
    },
    // 切換聊天窗口顯示狀態
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
