import axios from 'axios';
import Swal from 'sweetalert2';

export default {
  data() {
    return {
      cartItems: [
        {
          product_cart_id: 1,
          product_name: '帳篷 A',
          count: 2,
          daily_rate: 100,
          rental_start_date: '2024-09-10',
          rental_end_date: '2024-09-15',
          rental_days: 6,
          main_photo: 'https://d2otiughgt5pr2.cloudfront.net/wp-content/uploads/sites/4250/2023/09/SDE-001RH-AW23_switch7_515Wx515H-2a67.jpeg'
        },
        {
          product_cart_id: 2,
          product_name: '帳篷 B',
          count: 1,
          daily_rate: 100,
          rental_start_date: '2024-09-12',
          rental_end_date: '2024-09-18',
          rental_days: 7,
          main_photo: 'https://d2otiughgt5pr2.cloudfront.net/wp-content/uploads/sites/4250/2023/12/2000x-1-0bd2-570x570.png'
        },
        {
          product_cart_id: 3,
          product_name: '帳篷 C',
          count: 1,
          daily_rate: 100,
          rental_start_date: '2024-09-21',
          rental_end_date: '2024-09-28',
          rental_days: 8,
          main_photo: 'https://d2otiughgt5pr2.cloudfront.net/wp-content/uploads/sites/4250/2023/10/TP-660_main_515Wx515H111-4f09-570x570.png'
        }
      ],

      discountCode: '', // 折扣碼
      discountApplied: false, // 是否應用折扣碼
      discountAmount: 0, // 折扣金額
      discountCodeUsed: false, // 是否使用過折扣碼

      shippingMethod: 'standard',
      shippingFee: 100,
      paymentMethod: 'cash',  // 預設付款方式
      creditCard: {
        number: '',
        expiry: '',
        cvc: ''
      }  // 預設運輸費用
    };
  },
  computed: {
    totalProductAmount() {
      return this.cartItems.reduce((total, item) => total + item.subtotal, 0);
    },
    totalPrice() {
      return this.totalProductAmount + this.shippingFee - this.discountAmount; // 包含折扣金額
    }
  },
  methods: {
    formatCurrency(value) {
      return `$${value}`;
    },
    async changeQuantity(product_cart_id, newCount) {
      if (newCount < 1) {
        const confirmResult = await Swal.fire({
          title: '確認刪除',
          text: '是否要刪除此項目？',
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: '刪除',
          cancelButtonText: '取消'
        });

        if (confirmResult.isConfirmed) {
          this.removeItem(product_cart_id);
        }
        return;
      }

      const item = this.cartItems.find(i => i.product_cart_id === product_cart_id);
      if (item) {
        item.count = newCount;
        this.updateSubtotal(item);
      }
    },
    async confirmRemoveItem(product_cart_id) {
      const result = await Swal.fire({
        title: '確認刪除',
        text: '您確定要刪除此項目嗎？',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: '刪除',
        cancelButtonText: '取消'
      });

      if (result.isConfirmed) {
        this.removeItem(product_cart_id);
      }
    },
    updateRentalDays(product_cart_id) {
      const item = this.cartItems.find(i => i.product_cart_id === product_cart_id);
      if (item) {
        const startDate = new Date(item.rental_start_date);
        const endDate = new Date(item.rental_end_date);
        const diffTime = endDate - startDate;
        const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24)) + 1; // 包含當天
        item.rental_days = diffDays > 0 ? diffDays : 0;
        this.updateSubtotal(item);
      }
    },
    updateSubtotal(item) {
      item.subtotal = item.count * item.rental_days * item.daily_rate;
    },
    updateShippingFee() {
      this.shippingFee = this.shippingMethod === 'standard' ? 100 : 200;
    },
    applyDiscount() {

         // 檢查折扣碼是否已使用
    if (this.discountCodeUsed) {
        Swal.fire({
          icon: 'error',
          title: '折扣碼已經使用過',
          text: '您已經使用過這個折扣碼。',
          confirmButtonColor: '#d33'
        });
        return;
      }

        // 假設折扣碼 "DISCOUNT100" 可折價 100 元
        if (this.discountCode === 'DISCOUNT100') {
          this.discountAmount = 100;
          this.discountApplied = true;
          this.discountCodeUsed = true; // 標記折扣碼已使用
      
          Swal.fire({
            icon: 'success',
            title: '折扣碼已應用',
            text: `您使用的折扣碼是: ${this.discountCode}\n折扣金額: ${this.formatCurrency(this.discountAmount)}`,
            confirmButtonColor: '#3085d6'
          });
        } else {
          Swal.fire({
            icon: 'error',
            title: '無效的折扣碼',
            text: '請檢查您的折扣碼。',
            confirmButtonColor: '#d33'
          });
        }
      },
      
    async checkout() {
      try {
        const orderData = {
          items: this.cartItems.map(item => ({
            product_cart_id: item.product_cart_id,
            count: item.count,
            rental_start_date: item.rental_start_date,
            rental_end_date: item.rental_end_date,
            rental_days: item.rental_days,
            daily_rate: item.daily_rate,
            subtotal: item.subtotal
          })),
          totalAmount: this.totalPrice,
          shippingMethod: this.shippingMethod,
          shippingFee: this.shippingFee,
          discountAmount: this.discountAmount, // 添加折扣金額
          userId: 123 // 假設有一個用戶 ID
        };

        const response = await axios.post('/api/checkout', orderData);

        

        if (response.status === 200) {
          Swal.fire({
            icon: 'success',
            title: '訂單提交成功！',
            showConfirmButton: false,
            timer: 2000
          });
          this.cartItems = [];
        }
      } catch (error) {
        console.error('結帳失敗:', error);
        Swal.fire({
          icon: 'error',
          title: '結帳失敗',
          text: '請稍後再試。',
        });
      }
    },
    removeItem(product_cart_id) {
      this.cartItems = this.cartItems.filter(item => item.product_cart_id !== product_cart_id);
    }
  },
  created() {
    // 初始化計算小計
    this.cartItems.forEach(item => {
      this.updateRentalDays(item.product_cart_id);
    });
  }
};
