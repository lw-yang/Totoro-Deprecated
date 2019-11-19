<template>
    <div>
        <van-row id="setting" type="flex" justify="end">
            <van-col span="5">设置</van-col>
        </van-row>

        <div id="image">
            <van-image
                    round
                    width="5rem"
                    height="5rem"
                    src="https://img.yzcdn.cn/vant/cat.jpeg"
            />
        </div>
        <div v-if="isLogin">
            <div id="info">
                <div id="username">{{username}}</div>
                <div id="points">积分值: {{points}}</div>
            </div>
        </div>
        <div v-else>
            <div id="">
                <p id="loginOrRegister">
                    <router-link to="/login">
                        登录 / 注册
                    </router-link>
                </p>
            </div>
        </div>

    </div>
</template>

<script>
    import Vue from 'vue';
    import { Skeleton } from 'vant';
    import { Image } from 'vant';
    import { Row, Col } from 'vant';

    Vue.use(Row).use(Col);
    Vue.use(Image);
    Vue.use(Skeleton);

    export default {
        name: "Mine",
        data() {
            return {
                isLogin:'',
                username: 'lwyang',
                points:'100'
            }
        },
        methods:{

        },
        components: {
        }
    }
</script>

<style scoped>
#setting{
    font-size: 1.2rem;
}
#image{
    float: left;
    margin-left: 2rem;
    margin-right: 3rem;
}
#username{
    margin-top: .7rem;
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