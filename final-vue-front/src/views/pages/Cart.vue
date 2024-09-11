<template>
  <div class="cart-container">
    <h1>購物車</h1>

    <table class="cart-table">
      <thead>
        <tr>
          <th>產品圖片</th>
          <th>產品名稱</th>
          <th>數量</th>
          <th>租借開始日期</th>
          <th>租借結束日期</th>
          <th>租借天數</th>
          <th>單價（每天）</th>
          <th>小計</th>
          <th>操作</th> <!-- 新增操作列 -->
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in cartItems" :key="item.product_cart_id" class="cart-item">
          <td><img :src="item.main_photo" alt="產品圖片" class="product-image" /></td>
          <td>{{ item.product_name }}</td>
          <td>
            <div class="quantity-container">
              <button class="quantity-btn" @click="changeQuantity(item.product_cart_id, item.count - 1)">-</button>
              {{ item.count }}
              <button class="quantity-btn" @click="changeQuantity(item.product_cart_id, item.count + 1)">+</button>
            </div>
          </td>
          <td><input type="date" v-model="item.rental_start_date" @change="updateRentalDays(item.product_cart_id)" /></td>
          <td><input type="date" v-model="item.rental_end_date" @change="updateRentalDays(item.product_cart_id)" /></td>
          <td>{{ item.rental_days }} 天</td>
          <td>{{ formatCurrency(item.daily_rate) }}</td>
          <td>{{ formatCurrency(item.subtotal) }}</td>
          <td>
            <button class="delete-btn" @click="confirmRemoveItem(item.product_cart_id)">刪除</button>
          </td>
        </tr>
      </tbody>
    </table>

    <!-- 運輸方式選擇 -->
    <div class="shipping-method">
      <h3>運輸方式</h3>
      <select v-model="shippingMethod" @change="updateShippingFee">
        <option value="standard">標準運輸 - $100</option>
        <option value="express">快速運輸 - $200</option>
      </select>
    </div>



    <div class="cart-container">
    <!-- 其他內容 -->
    
    <!-- 折扣碼輸入框 -->
    <div class="discount-code">
      <h3>折扣碼</h3>
      <input type="text" v-model="discountCode" placeholder="輸入折扣碼" />
      <button class="apply-discount-btn" @click="applyDiscount">應用折扣碼</button>
      <div v-if="discountApplied">
        <p>折扣金額: {{ formatCurrency(discountAmount) }}</p>
      </div>
    </div>

     <!-- 顯示折扣後的總共價格 -->
     <div class="total-price">
      <h3>產品總計: {{ formatCurrency(totalProductAmount) }}</h3>
      <h3>運輸費用: {{ formatCurrency(shippingFee) }}</h3>
      <h3>折扣後價格: {{ formatCurrency(totalPrice) }}</h3>
    </div>



    <!-- 付款方式選擇 -->
    <div class="payment-method">
      <h3>付款方式</h3>
      <select v-model="paymentMethod">
        <option value="credit-card">信用卡</option>
        <option value="cash">現金</option>
      </select>
    </div>

    <!-- 如果選擇信用卡，顯示信用卡資訊表單 -->
    <div v-if="paymentMethod === 'credit-card'" class="credit-card-info">
      <h3>信用卡資訊</h3>
      <input type="text" v-model="creditCard.number" placeholder="信用卡號碼" />
      <input type="text" v-model="creditCard.expiry" placeholder="到期日 MM/YY" />
      <input type="text" v-model="creditCard.cvc" placeholder="CVC 安全碼" />
    </div>

    <button class="checkout-btn" @click="checkout">結帳</button>
  </div>
    </div>
</template>

<script src="./CartScript.js"></script>


<style src="./CartStyle.css"></style>


