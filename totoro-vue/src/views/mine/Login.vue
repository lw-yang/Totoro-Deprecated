<template>
    <div>
        <NavTop :title="title" @onClickLeft="onClickLeft"/>

        <div id="login">
            <van-row class="flexDiv">
                <label class="key">
                    <van-col>用</van-col>
                    <van-col>户</van-col>
                    <van-col>名:</van-col>
                </label>
                <input type="text" v-model="username" class="value"  placeholder="请输入用户名"/>
            </van-row>
            <van-row class="flexDiv">
                <label class="key">
                    <van-col>密</van-col>
                    <van-col>码:</van-col>
                </label>
                <input type="password" v-model="password" class="value"  placeholder="请输入密码"/>
            </van-row>

        </div>

        <div class="flexDiv">
            <van-button id="loginButton" @click="login" size="large" type="primary">
                登 录
            </van-button>
        </div>

        <van-row id="register" type="flex" justify="end">
            <van-col >
                <router-link to="/register" id="registerText">新用户注册</router-link>
            </van-col>
        </van-row>
    </div>
</template>

<script>
    import Vue from 'vue';
    import {Button, Cell, CellGroup, Col, Field, NavBar, Row} from 'vant';
    import {login} from "../../api/customer";
    import NavTop from "../../components/NavTop";

    Vue.use(Row).use(Col);
    Vue.use(Button);
    Vue.use(Cell).use(CellGroup);
    Vue.use(Field);
    Vue.use(NavBar);
    export default {
        name: "Login",
        components: {NavTop},
        data(){
            return{
                title: '用 户 登 录',
                username: this.$store.getters.username,
                password: '',
            }
        },
        methods:{
            onClickLeft:function () {
                this.$router.go(-1)
            },
            login:function () {
                login(this.loginData).then(res => {
                    let token = res.data.data.token
                    let userId = res.data.data.userId
                    this.$store.commit('set_username',this.username)
                    this.$store.commit('set_userId', userId)
                    window.localStorage.setItem("token", token)
                    window.localStorage.setItem("username", this.username)
                    this.$router.push('/mine')
                }).catch((reason)=>{console.log(reason)})
            }
        },
        computed:{
            loginData() {
                return {
                    username: this.username,
                    password: this.password
                }
            }
        }
    }
</script>

<style scoped>

    #login{
        height: 9rem;
        display: flex;
        flex-direction: column;

    }

    .key{
        display: flex;
        justify-content: space-between;
        font-size: 1.3rem;
        flex: 1;
        margin-left: 1.5rem;
        margin-right: .5rem;
        padding: .3rem;
    }
    .value{
        display: flex;
        flex: 3;
        font-size: 1.2rem;
        margin-right: 1.5rem;
    }

    .flexDiv{
        display: flex;
        justify-content: center;
        padding-top: 2rem;
    }

    #loginButton{
        width: 70%;
        height: 2rem;
        font-size: 1rem;
    }

    #register{
        display: flex;
        margin-top: 2rem;
        margin-right: 3rem;
        font-size: .8rem;
    }
    #registerText{
        color: royalblue;
    }

</style>