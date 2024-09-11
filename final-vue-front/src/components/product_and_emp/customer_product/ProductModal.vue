<template>
    <div ref="exampleModal" class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Product</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <img class="card-img-top" :alt="product.productName" v-default-img="product.mainPhoto">
                    <table>
                        <tr>
                            <td hidden>編號</td>
                            <td><input type="text" name="id" v-model="product.productId" readonly hidden></td>
                        </tr>
                        <tr>
                            <td>名稱</td>
                            <td>{{ product.productName }}</td>
                        </tr>
                        <tr>
                            <td>價格</td>
                            <td>{{ product.dailyFeeOriginal }}</td>
                        </tr>
                        <tr>
                            <td>商品簡介</td>
                            <td>{{ product.description }}</td>
                        </tr>
                        <tr>
                            <td>租用數量</td>
                            <td><input type="number"   v-model="count" @input="doInput('count', $event)"></td>
                        </tr>
                        <!-- <tr>
                            <td>租用日期</td>
                            <td><input type="date" name="rentalStartDate" @input="doInput('rentalStartDate', $event)"></td>
                        </tr>
                        <tr>
                            <td>歸還日期</td>
                            <td><input type="date" name="rentalEndDate" @input="doInput('rentalEndDate', $event)"></td>
                        </tr> -->
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary"  @click="addCart">加入購物車</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">關閉</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
    const props = defineProps(["product"])

    import bootstrap from 'bootstrap/dist/js/bootstrap.bundle.min.js'
    import { ref, onMounted } from 'vue';
    //hsiao
    import  { useCartStore } from '@/stores/cartStore'


    const exampleModal = ref(null);
    const exampleObj = ref(null);


    //hsiao
    const cartStore = useCartStore()

    // count hsiao
    const count = ref(1)
    const doInput = (count) => {
    console.log(count);

    }

    // +進購物車
// 添加購物車邏輯
const addCart = () => {
    if (props.product) {
        cartStore.addCart({
            id: props.product.id, // 商品 id
            name: props.product.name, // 商品名稱
         //   picture: props.product.mainPictures[0], // 商品圖片
            price: props.product.price, // 最新價格
            count: count.value, // 商品數量
            selected: true // 商品是否選中
        })
        console.log('商品已加入購物車', cartStore.cart)
    } else {
        console.log('無法添加商品，product 未定義')
    }
}




    onMounted(function () {
        exampleObj.value = new bootstrap.Modal(exampleModal.value, null);
    });
    function showModal() {
        exampleObj.value.show();
    }
    function hideModal() {
        exampleObj.value.hide();
    }

    defineExpose({
        showModal, hideModal
    });
</script>

<style>

</style>
