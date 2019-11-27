<template>
    <div id="childCategory">
        <div id="generalText">常用分类</div>
        <van-grid :border="false" :column-num="3" clickable gutter="1rem">
            <van-grid-item v-for="(item, index) in childCategory"
                            :key="index">
                <van-image :src="item.src" />
                <div class="name">{{item.name}}</div>
            </van-grid-item>
        </van-grid>
    </div>
</template>

<script>
    import Vue from 'vue';
    import { Grid, GridItem } from 'vant';

    Vue.use(Grid).use(GridItem);
    export default {
        name: "childCategory",
        props: {
            childCategory: [],
        },

    }
</script>

<style scoped>

    #childCategory{
        /*margin-top: .8rem;*/
    }
    #generalText{
        font-weight: bold;
        padding-top: .2rem;
        padding-left: .8rem;
        font-size: 1rem;
        height: .8rem;
    }
    .name{
        margin-top: .5rem;
    }
</style>