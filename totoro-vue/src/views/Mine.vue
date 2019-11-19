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
        <div v-if="isLogin">
            <div id="info" style="float: left">
                <div id="username">{{username}}</div>
                <div id="points">积分值: {{points}}</div>
            </div>
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
                username: this.$store.getters.username,
                points:'0'
            }
        },
        computed: {
            isLogin() {
                return this.$store.getters.token !== '';
            }
        },
        methods:{

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