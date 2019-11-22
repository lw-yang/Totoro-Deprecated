<template>
    <div>
        <van-row id="orderStatus">
            <van-grid id="grid" clickable gutter=".2rem" icon-size="2.5rem">
                <van-grid-item icon="credit-pay" text="代付款" to="#" />
                <van-grid-item icon="send-gift-o" text="代收货" to="#"/>
                <van-grid-item icon="comment-o" text="代评价" to="#"/>
                <van-grid-item icon="orders-o" text="订 单" to="#"/>
            </van-grid>
        </van-row>

    </div>
</template>

<script>
    import Vue from 'vue';
    import { Grid, GridItem } from 'vant';
    Vue.use(Grid).use(GridItem);

    export default {
        name: "OrderStatus"
    }
</script>

<style scoped>

    #orderStatus{
        background-color: #ed6a0c;
        height: 4.9rem;
        padding-top: .2rem;
    }

</style>

<style>
    .van-grid-item__text {
        font-size: .9rem;
    }
</style>