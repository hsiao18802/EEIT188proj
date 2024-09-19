import { defineComponent, computed } from 'vue';
import { useCartStore } from '@/stores/cartStore';

import { onMounted } from 'vue';


import Swal from 'sweetalert2';
import axios from 'axios';

export default defineComponent({
  setup() {



    const cartStore = useCartStore();
    console.log('Cart Store State:', cartStore);

    onMounted(() => {
      // 確保在組件掛載時初始化數據
      cartStore.loadCartItems();
    });



    // 讀取購物車的items
    const cartItems = computed(() => cartStore.cartItems);

    // 計算總價格
    const totalProductAmount = computed(() =>
      cartItems.value.reduce((total, item) => total + item.subtotal, 0)
    );
    const totalPrice = computed(() =>
      totalProductAmount.value + cartStore.shippingFee - cartStore.discountAmount
    );

    // 更新數量
    const changeQuantity = async (cart_id, newCount) => {
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
          cartStore.removeItem(cart_id);
        }
        return;
      }
      cartStore.updateQuantity(cart_id, newCount);
    };

    // 更新租借天數
    const updateRentalDays = (cart_id) => {
      cartStore.updateRentalDays(cart_id);
    };

    // 應用折扣碼
    const applyDiscount = async () => {
      if (cartStore.discountCodeUsed) {
        Swal.fire({
          icon: 'error',
          title: '折扣碼已經使用過',
          text: '您已經使用過這個折扣碼。',
          confirmButtonColor: '#d33'
        });
        return;
      }
      await cartStore.applyDiscountCode();
    };

    // 結帳
    const checkout = async () => {
      await cartStore.checkout();
    };

    // 返回需要用於模板的數據和方法
    return {
      cartItems,
      totalProductAmount,
      totalPrice,
      shippingMethod: cartStore.shippingMethod,
      discountCode: cartStore.discountCode,
      discountApplied: cartStore.discountApplied,
      shippingFee: cartStore.shippingFee,
      discountAmount: cartStore.discountAmount,
      paymentMethod: cartStore.paymentMethod,
      creditCard: cartStore.creditCard,
      changeQuantity,
      updateRentalDays,
      applyDiscount,
      checkout,
      cartItems
    };
  },
});
