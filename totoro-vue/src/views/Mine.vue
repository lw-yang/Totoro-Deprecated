<template>
    <div>
        <div style="margin-top: 5rem">

        <div id="image">
            <van-image
                    round
                    width="5rem"
                    height="5rem"
                    src="https://img.yzcdn.cn/vant/cat.jpeg"
            />
        </div>
        <div v-if="isLogin" @click="customerSetting">
            <div id="info" style="float: left">
                <div id="username">{{username}}</div>
                <div id="points">积分值: {{points}}</div>
            </div>
            <van-icon name="records" size="2.1rem" style="float: right; margin-right: 2rem; margin-top: 1.5rem" />

        </div>
        <div v-else >
            <div style="height: 5rem; float:left; line-height: 3rem">
                <p >
                    <router-link to="/login" id="loginOrRegister">
                        登录 / 注册
                    </router-link>
                </p>
            </div>
        </div>
        </div>

        <van-grid style="clear: both;padding-top: 2rem" clickable gutter=".2rem" icon-size="2.5rem">
            <van-grid-item icon="credit-pay" text="文字" >
                <p slot="text" style="font-size: .8rem; margin-top: .4rem">代付款</p>
            </van-grid-item>
            <van-grid-item icon="send-gift-o" text="文字" >
                <p slot="text" style="font-size: .8rem; margin-top: .4rem">代收货</p>
            </van-grid-item>
            <van-grid-item icon="comment-o" text="文字" >
                <p slot="text" style="font-size: .8rem; margin-top: .4rem">代评价</p>
            </van-grid-item>
            <van-grid-item icon="orders-o" text="文字" >

                <p slot="text" style="font-size: .8rem; margin-top: .4rem; ">订 单</p>
            </van-grid-item>
        </van-grid>

        <div style="text-align: center; width: 100%; height: 15rem; line-height: 15rem; color: #c8c9cc; font-size: 2rem">待 开 发...</div>
    </div>
</template>

<script>
    import Vue from 'vue';
    import { Image } from 'vant';
    import { Row, Col } from 'vant';
    import { Grid, GridItem } from 'vant';

    Vue.use(Grid).use(GridItem);
    Vue.use(Row).use(Col);
    Vue.use(Image);

    export default {
        name: "Mine",
        data() {
            return {
                username: window.localStorage.getItem("username"),
                points:'0'
            }
        },
        computed: {
            isLogin() {
                return window.localStorage.getItem("token") !== null;
            }
        },
        methods:{
            customerSetting: function () {
                this.$router.push('/customerSetting')
            }
        },
        components: {
        }
    }
</script>

<style scoped>
#image{
    float: left;
    margin-left: 3rem;
    margin-right: 3rem;
}
#username{
    margin-top: .6rem;
    font-size: 1.6rem;
    font-family: Consolas;
}
#points {
    margin-top: 1rem;
}
#loginOrRegister{
    font-size: 1.6rem;
}

</style>