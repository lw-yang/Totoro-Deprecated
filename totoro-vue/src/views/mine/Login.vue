<template>
    <div>
        <NavTop :title="title" @onClickLeft="onClickLeft"/>

        <div id="login">
            <van-field
                    v-model="username"
                    clearable
                    label="用户名: "
                    placeholder="请输入用户名">
                <label class="key" slot="label">
                    <van-col>用</van-col>
                    <van-col>户</van-col>
                    <van-col>名:</van-col>
                </label>
            </van-field>
            <van-field
                    v-model="password"
                    type="password"
                    label="密 码:"
                    placeholder="请输入密码">
                <label class="key" slot="label">
                    <van-col>密</van-col>
                    <van-col>码:</van-col>
                </label>
            </van-field>
        </div>

        <div class="flexDiv">
            <van-button id="loginButton" @click="login" size="large" type="primary">
                登 录
            </van-button>
        </div>

        <van-row id="register">
            <van-col span="10" offset="16">
                <router-link to="/register">新用户注册</router-link>
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
                    this.$store.commit('set_username',this.username)
                    window.localStorage.setItem("token", token)
                    window.localStorage.setItem("username", this.username)
                    this.$router.push('/mine')

                }).catch(()=>{})
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
        background-color: #fff7cc;
        height: 8rem;
        display: flex;
        flex-direction: column;
    }
    .key{
        display: flex;
        justify-content: space-between;
        font-size: 1.3rem;
        flex: 1.1;
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
        margin-top: 2rem;
        font-size: .8rem;
        color: #1989fa;
    }


</style>

<style>

    .van-field{
        display: flex;
        height: 3.5rem;
        align-items: center;
        margin: 2rem 0 0 1.8rem;
    }
    .van-field__label{
        font-size: 1.3rem;
        flex: 1.1;
        margin-right: 1.5rem;
    }
    .van-cell__value{
        font-size: 1.3rem;
        flex: 3;
    }

</style>