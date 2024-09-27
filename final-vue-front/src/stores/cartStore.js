import { defineStore } from 'pinia';
import { ref, computed } from 'vue';
import { removeFromCartAPI as delCartAPI, addCartAPI, findNewCartListAPI, plusOneAPI, minusOneAPI, ClearCartAPI } from '@/apis/cart';
import useUserStore from '@/stores/user.js'; // 確保路徑正確
import Swal from 'sweetalert2';


export const useCartStore = defineStore('cartStore', () => {

  const userStore = useUserStore();
  const membersId = computed(() => userStore.membersId); // 使用 computed 確保 membersId 總是最新的
  const cartList = ref([]);
  const cartId = ref(null);
  const sortedCartList = computed(() => {
    return [...cartList.value].sort((a, b) => {
      return a.cartId - b.cartId; // 按升序排序
    });
  });
  const showCartDrawer = ref(false);  // 控制小視窗是否顯示
  // 切換購物車顯示狀態的方法
  const toggleCartDrawer = () => {
    showCartDrawer.value = !showCartDrawer.value; // 切換購物車小視窗顯示狀態
  };

  const rentalStartDate = ref(null);
  const rentalEndDate = ref(null);
  const shouldShowCartIcon = ref(true); // 控制購物車圖標的顯示
  const setRentalDates = (startDate, endDate) => {
    rentalStartDate.value = startDate;
    rentalEndDate.value = endDate;
  };



  // 定義方法
  const setMembersId = (id) => {
    userStore.setMembersId(id); // 這裡調用 userStore 的方法來設置 membersId
  };

  // 新增 shippingMethod 狀態
  const shippingMethod = ref(null); // 定義運輸方式的狀態

  // 設置運輸方式的方法
  const setShippingMethod = (method) => {
    shippingMethod.value = method;
  };


  const updateNewList = async () => {
    try {
      const res = await findNewCartListAPI(membersId.value);
      console.log('API response for cart:', res.data);  //API response for cart:  [ , , ,]
      console.log('updateNewList＿Rental Start Date:', rentalStartDate.value);
      console.log('updateNewList＿Rental End Date:', rentalEndDate.value);

      cartList.value = res.data; // 更新 cartList


    } catch (error) {
      console.error('獲取購物車列表失敗:', error);
    }
  };





  const addCart = async (goods) => {
    const { productId, count } = goods;
    const currentMembersId = userStore.membersId; 
    console.log('Request payload:', { productId, count, membersId: currentMembersId });
    console.log('Adding to cart with membersId:', currentMembersId); // 調試用

    try {
      const response = await addCartAPI(
        {
          productId, count, membersId: currentMembersId,
          rentalStartDate: rentalStartDate.value,
          rentalEndDate: rentalEndDate.value
        }
      );
      console.log('Rental Start Date:', rentalStartDate.value);
      console.log('Rental End Date:', rentalEndDate.value);
      console.log('API response carstore:', response);  

      await updateNewList();
      // 判斷商品是否成功加入購物車
      // 判斷商品是否成功加入購物車
      if (response.data && response.data.data && response.data.data.cartId) {
        showCartDrawer.value = true;
        cartId.value = response.data.data.cartId; // 使用 .value
        console.log('cartId.value:', cartId.value);
    } else {
        console.error('Cart ID not found in the response:', response);
    }
} catch (error) {
    console.error('Failed to add to cart:', error.message);
    console.error('Error stack trace:', error.stack);
}
};


  const addProduct = (product) => {
    console.log('Adding product:', product);  // Debug output
    const existingProduct = cartList.value.find(item => item.productId === product.productId);
    if (existingProduct) {
      existingProduct.count += product.count;
    } else {
      cartList.value.push(product);
    }

    console.log('Current cartList:', cartList.value);  // Debug outpu
    t
  };







  const delCart = async (productId) => {
    try {
      await delCartAPI({ membersId: membersId.value, productId });
      await updateNewList(); // 更新購物車列表


    } catch (error) {
      console.error('從購物車中刪除失敗:', error);
      // 本地邏輯
      const idx = cartList.value.findIndex(item => item.productId === productId);
      if (idx > -1) {
        cartList.value.splice(idx, 1);
      }
    }
  };

  const plusOne = async (productId) => {
    try {
        await plusOneAPI({ membersId: membersId.value, productId });
        // 更新狀態，例如
        const product = cartList.value.find(item => item.productId === productId);
        if (product) {
            product.count += 1; // 直接更新購物車中的商品數量
        }
        await updateNewList(); // 更新購物車列表

    } catch (error) {
        console.error('增加數量失敗:', error);
        Swal.fire({
            title: '錯誤',
            text: "增加數量失敗，請稍後再試。",
            icon: "error",
            confirmButtonText: '確定',
            position: 'center'
        });
    }
};

const minusOne = async (productId) => {
    try {
        const product = cartList.value.find(item => item.productId === productId);
        if (product && product.count > 1) {
            await minusOneAPI({ membersId: membersId.value, productId });
            product.count -= 1; // 直接更新購物車中的商品數量
            await updateNewList(); // 更新購物車列表
        } else if (product && product.count === 1) {
            // 考慮是否要從購物車中移除該商品
            await delCartAPI({ membersId: membersId.value, productId });
            await updateNewList(); // 更新購物車列表

            
        }
    } catch (error) {
        console.error('減少數量失敗:', error);
        Swal.fire({
            title: '錯誤',
            text: "減少數量失敗，請稍後再試。",
            icon: "error",
            confirmButtonText: '確定',
            position: 'center'
        });
    }
};


  const clearCart = async () => {
    try {
      await ClearCartAPI(membersId.value); // 調用 ClearCartAPI
      cartList.value = []; // 清空本地購物車列表
      localStorage.removeItem('cartList'); // 清空 localStorage


    } catch (error) {
      console.error('清空購物車失敗:', error);
      Swal.fire({
        title: '錯誤',
        text: "清空購物車失敗，請稍後再試。",
        icon: "error",
        confirmButtonText: '確定',
        position: 'center'
      });
    }
  };


// 加價服務的狀態
const selectedServices = ref({
  delivery1: false, // 自取
  delivery2: false, // 1-20 公里
  delivery3: false, // 20-40 公里
});

// 計算加價服務的總價
const selectedServicesPrice = computed(() => {
  let total = 0;
  if (selectedServices.value.delivery2) total += 300;
  if (selectedServices.value.delivery3) total += 500;
  return total;
});

// 控制互斥邏輯
const handleServiceSelection = (selectedOption) => {
  if (selectedOption === 1) {
    selectedServices.value.delivery2 = false;
    selectedServices.value.delivery3 = false;
  } else {
    selectedServices.value.delivery1 = false;
  }
};


 




  return {
    membersId,
    cartList,
    setMembersId,
    updateNewList,
    addCart,
    delCart,
    plusOne,
    minusOne,
    clearCart,
    showCartDrawer,
    toggleCartDrawer,
    addProduct,
    cartList,
    clearCart,
    rentalStartDate,
    rentalEndDate,
    setRentalDates,
    shouldShowCartIcon,
    cartId,
    sortedCartList,
    selectedServices,
    selectedServicesPrice,
    handleServiceSelection,
    shippingMethod,
    setShippingMethod,

  };
},
  {
    persist: true

  }

);
