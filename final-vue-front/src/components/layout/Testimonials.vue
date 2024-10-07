<template>
  <div class="testimonials-section">
    <h3 class="section-title">消費者心得</h3>
    <v-row>
      <v-col v-for="testimonial in testimonials" :key="testimonial.id" cols="12" md="4">
        <v-card class="testimonial-card">
          <v-card-title>
            <v-avatar class="mr-3">
              <img :src="testimonial.avatar" alt="用戶大頭貼" />
            </v-avatar>
            <div>
              <span class="testimonial-author">{{ testimonial.author }}</span>
              <div class="circle-rating">
                <!-- 使用圓形來表示評分 -->
                <div
                  v-for="circle in 5"
                  :key="circle"
                  class="circle"
                  :class="{'filled': circle <= testimonial.rating}"
                ></div>
              </div>
            </div>
          </v-card-title>
          <v-card-text>
            <p class="testimonial-text">{{ testimonial.text }}</p>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </div>
</template>

<script setup>
import { defineProps } from 'vue';

// 定義接收的屬性
const props = defineProps({
  testimonials: {
    type: Array,
    required: true
  }
});
</script>

<style scoped>
.testimonials-section {
  margin: 2rem 0;
}

.section-title {
  text-align: center;
  font-size: 2rem;
  margin-bottom: 1rem;
}

.testimonial-card {
  padding: 1rem;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
}

.testimonial-author {
  font-weight: bold;
  font-size: 1.2rem;
}

.circle-rating {
  display: flex;
  margin-top: 0.2rem;
}

.circle {
  width: 20px; /* 圓形的直徑 */
  height: 20px; /* 圓形的直徑 */
  border-radius: 50%; /* 使元素圓形 */
  border: 2px solid #FFD700; /* 金色邊框 */
  margin-right: 4px; /* 圓形之間的間距 */
  transition: background-color 0.3s; /* 過渡效果 */
}

.circle.filled {
  background-color: #FFD700; /* 當評分在這裡的圓形填充為金色 */
}
</style>
