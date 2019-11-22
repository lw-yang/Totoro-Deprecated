<template>
    <van-nav-bar
            left-arrow
            @click-left="onClickLeft"
            :title="title">
    </van-nav-bar>
</template>

<script>
    export default {
        name: "NavTop",
        props: {
            title: String,
        },
        methods: {
            onClickLeft() {
                this.$emit('onClickLeft')
            }
        }
    }
</script>

<style scoped>

</style>

<style>

    .van-nav-bar{
        display: flex;
        height: 2.5rem;
        background-color: #b3d4fc;
    }

     .van-nav-bar__arrow{
         background-color: #ff976a;
         height: 2.5rem;
         display: flex;
         align-items: center;
         font-size: 1.5rem;
    }
     .van-nav-bar__title{
         background-color: #ff976a;
         display: flex;
         align-items: center;
         font-size: 1.3rem;
         font-weight: bold;
     }
</style>