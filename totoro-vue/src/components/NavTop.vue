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
        padding-top: 1rem;
        display: flex;
        height: 2.5rem;
    }

     .van-nav-bar__arrow{
         height: 2.5rem;
         display: flex;
         align-items: center;
         font-size: 1.5rem;
    }
     .van-nav-bar__title{
         display: flex;
         align-items: center;
         font-size: 1.3rem;
         font-weight: bold;
     }
</style>