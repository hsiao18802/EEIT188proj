<template>
  <!-- <div class="chat-container">
    <div class="messages">
      <div v-for="(message, index) in messages" :key="index" :class="message.type">
        <span>{{ message.text }}</span>
      </div>
    </div>
    <input v-model="userInput" @keyup.enter="sendMessage" placeholder="請輸入您的問題..." />
    <button @click="sendMessage">發送</button>
  </div> -->
</template>

<script>
import axiosapi from '@/plugins/axios';
import { v4 as uuidv4 } from 'uuid'; // 使用 uuid 生成唯一的 sessionId

export default {
  data() {
    return {
      messages: [], // 聊天記錄
      userInput: '', // 用戶輸入的消息
      sessionId: uuidv4() // 使用 UUID 生成唯一的 sessionId
    };
  },
  methods: {
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
    }
  }
}
</script>

<style scoped>
.chat-container {
  position: fixed; /* 固定位置 */
  bottom: 20px; /* 距離頁面底部 */
  right: 20px; /* 距離頁面右側 */
  width: 300px; /* 固定寬度 */
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 10px;
  background: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  z-index: 1000; /* 保證在最上層顯示 */
}

.messages {
  max-height: 300px;
  overflow-y: auto;
  margin-bottom: 20px;
}

.user {
  text-align: right;
  color: blue;
}

.bot {
  text-align: left;
  color: green;
}

input {
  width: calc(100% - 60px);
  padding: 10px;
  margin-right: 10px;
}

button {
  padding: 10px;
}
</style>
