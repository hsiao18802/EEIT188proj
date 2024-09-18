import { defineStore } from 'pinia';
import { ref, computed } from 'vue';
import { removeFromCartAPI as delCartAPI, addCartAPI, findNewCartListAPI, plusOneAPI, minusOneAPI } from '@/apis/cart';
import useUserStore from '@/stores/user.js'; // 確保路徑正確
import Swal from 'sweetalert2';


export const useCartStore = defineStore('cartStore', () => {
    // 定義狀態
    //const membersId = ref(null);
    const membersId = computed(() => userStore.membersId); // 使用 computed 確保 membersId 總是最新的

    const cartList = ref([]);


    // 初始化 userStore
    const userStore = useUserStore();

    // 計算屬性
    const allCount = computed(() => cartList.value.reduce((a, c) => a + c.count, 0));
    const allPrice = computed(() => cartList.value.reduce((a, c) => a + c.count * c.dailyFeeOriginal, 0));
    const selectedCount = computed(() => cartList.value.filter(item => item.selected).reduce((a, c) => a + c.count, 0));
    const selectedPrice = computed(() => cartList.value.filter(item => item.selected).reduce((a, c) => a + c.count * c.dailyFeeOriginal, 0));
    const isAll = computed(() => cartList.value.every(item => item.selected));

    // 定義方法
    const setMembersId = (id) => {
        membersId.value = id;
    };


    const updateNewList = async () => {
        try {
            const res = await findNewCartListAPI(membersId.value);
            console.log('API response for cart:', res.data); // 確保數據正確 //
            //API response for cart:  [ , , ,]   no dailyFeeOriginal


            cartList.value = res.data; // 更新 cartList
            console.log('Cart list after update:', JSON.parse(JSON.stringify(cartList.value)));


        } catch (error) {
            console.error('獲取購物車列表失敗:', error);
        }
    };





    const addCart = async (goods) => {
        const { productId, count } = goods;
        const currentMembersId = userStore.membersId; // 確保 userStore 已初始化

        if (!currentMembersId) {
            console.error('未找到 membersId，無法添加到購物車');
            return;
        }

        console.log('Adding to cart with membersId:', currentMembersId); // 調試用

        try {
            const response = await addCartAPI({ productId, count, membersId: currentMembersId });
            console.log('API response carstore:', response);

            await updateNewList();
            console.log('商品已加入購物車cartstore:', response.data.message);
            // Swal.fire({
            //     text: "商品已成功加入購物車",
            //     icon: "success",
            // });
        } catch (error) {
            console.error('添加到購物車失敗:', error);
            Swal.fire({
                text: "添加到購物車失敗",
                icon: "error",
            });
        }
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
            await updateNewList(); // 更新購物車列表
        } catch (error) {
            console.error('增加數量失敗:', error);
        }
    };

    const minusOne = async (productId) => {
        try {
            await minusOneAPI({ membersId: membersId.value, productId });
            await updateNewList(); // 更新購物車列表
        } catch (error) {
            console.error('減少數量失敗:', error);
        }
    };

    const clearCart = () => {
        cartList.value = [];
    };

    const singleCheck = (productId, selected) => {
        const item = cartList.value.find(item => item.productId === productId);
        if (item) {
            item.selected = selected;
        }
    };

    const allCheck = (selected) => {
        cartList.value.forEach(item => item.selected = selected);
    };

    return {
        membersId,
        cartList,
        allCount,
        allPrice,
        selectedCount,
        selectedPrice,
        isAll,
        setMembersId,
        updateNewList,
        addCart,
        delCart,
        plusOne,
        minusOne,
        clearCart,
        singleCheck,
        allCheck,
    };
});
