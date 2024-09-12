// 封装购物车模块

import { defineStore } from 'pinia'
import { computed, ref } from 'vue'
//import { useUserStore } from '@/stores/user'
//import { insertCartAPI, findNewCartListAPI, delCartAPI } from '@/apis/cart'

export const useCartStore = defineStore('cart', () => {
    //const userStore = useUserStore()
    //const isLogin = computed(() => userStore.userInfo.token)
    // 1. 定义state - cartList
    const cartList = ref([])
    // 获取最新购物车列表action
    const updateNewList = async () => {
       // const res = await findNewCartListAPI()
        //cartList.value = res.result
    };
    // 2. 定义action - addCart
    const addCart = async (goods) => {
        const { productId, count } = goods
        // if (isLogin.value) {
            // 登录之   后的加入购物车逻辑
            // 登录之后的加入购车逻辑
        //     await insertCartAPI({ productId, count })
        //     updateNewList()
        // } else {
            // 添加购物车操作
            // 已添加过 - count + 1
            // 没有添加过 - 直接push
            // 思路: 通过匹配传递过来的商品对象中的skuId能不能在cartList中找到，找到了就是添加过
            const item = cartList.value.find((item) => item.productId === productId)
            if (item) {
                // 找到了
                item.count++
            } else {
                // 没找到
                cartList.value.push({ ...goods, count });
            }
        // }
    };

    const delCart = async (productId) => {
        // if (isLogin.value) {
        //     await delCartAPI([productId]);
        //     updateNewList();
        // } else {
            const idx = cartList.value.findIndex(item => item.productId === productId);
            if (idx > -1) {
                cartList.value.splice(idx, 1);
            }
        // }
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

    // Computed properties
    const allCount = computed(() => cartList.value.reduce((a, c) => a + c.count, 0));
    const allPrice = computed(() => cartList.value.reduce((a, c) => a + c.count * c.dailyFeeOriginal, 0));
    const selectedCount = computed(() => cartList.value.filter(item => item.selected).reduce((a, c) => a + c.count, 0));
    const selectedPrice = computed(() => cartList.value.filter(item => item.selected).reduce((a, c) => a + c.count * c.dailyFeeOriginal, 0));
    const isAll = computed(() => cartList.value.every(item => item.selected));

    return {
        cartList,
        allCount,
        allPrice,
        isAll,
        selectedCount,
        selectedPrice,
        clearCart,
        addCart,
        delCart,
        singleCheck,
        allCheck,
        updateNewList
    };
}, {
    persist: true,
});