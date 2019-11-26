<template>
    <div>
        <NavTop :title="title" @onClickLeft="onClickLeft"/>

        <div id="registerForm">

            <van-row class="flexDiv">
                <label class="key">
                    <van-col>用</van-col>
                    <van-col>户</van-col>
                    <van-col>名:</van-col>
                </label>
                <input type="text" v-model="username" class="value" placeholder="请输入用户名"/>
            </van-row>
            <van-row class="flexDiv">
                <label class="key">
                    <van-col>密</van-col>
                    <van-col>码:</van-col>
                </label>
                <input type="password" v-model="password" class="value" placeholder="请输入密码"/>
            </van-row>

            <van-row class="flexDiv">
                <label class="key">
                    <van-col>密</van-col>
                    <van-col>保</van-col>
                    <van-col>问</van-col>
                    <van-col>题:</van-col>
                </label>
                <input type="text"  v-model="question" class="value" placeholder="请输入密保问题"/>
            </van-row>
            <van-row class="flexDiv">
                <label class="key">
                    <van-col>密</van-col>
                    <van-col>保</van-col>
                    <van-col>答</van-col>
                    <van-col>案:</van-col>
                </label>
                <input type="text"  v-model="answer" class="value" placeholder="请输入密保答案"/>
            </van-row>

            <van-row class="flexDiv">
                <label class="key">
                    <van-col>邮</van-col>
                    <van-col>箱:</van-col>
                </label>
                <input type="email" v-model="email" class="value" placeholder="请输入邮箱"/>
            </van-row>

            <van-row class="flexDiv">
                <label class="key">
                    <van-col>年</van-col>
                    <van-col>龄:</van-col>
                </label>
                <div class="value">
                    <van-stepper id="ageValue"  v-model="age" integer  step="1" min="1" max="100"/>
                </div>
            </van-row>

            <van-row class="flexDiv">
                <label class="key">
                    <van-col>性</van-col>
                    <van-col>别:</van-col>
                </label>
                <van-radio-group id="sexValue" class="value" v-model="sex" icon-size="1rem" >
                    <van-radio name="1" style="margin-right: 1rem">男</van-radio>
                    <van-radio name="2">女</van-radio>
                </van-radio-group>
            </van-row>

        </div>

        <div class="flexDiv">
            <van-button id="registerButton" @click="register" size="large" type="primary" >注 册</van-button>
        </div>
    </div>
</template>

<script>
    import Vue from 'vue';
    import {Button, Cell, CellGroup, Col, Field, Icon, NavBar, Radio, RadioGroup, Row, Stepper, Toast} from 'vant';
    import {register} from '@/api/customer'
    import NavTop from "../../components/NavTop";

    Vue.use(Row).use(Col);
    Vue.use(Toast);
    Vue.use(NavBar);
    Vue.use(Button);
    Vue.use(RadioGroup);
    Vue.use(Radio);
    Vue.use(Stepper);
    Vue.use(Icon);
    Vue.use(Cell).use(CellGroup);
    Vue.use(Field);

    export default {
        name: "Register",
        components: {NavTop},
        data(){
            return{
                title: '用 户 注 册',
                username: '',
                password: '',
                question: '',
                answer: '',
                age: 1,
                sex: '1',
                email: '',
                customerName: ''
            }
        },
        methods:{
            onClickLeft:function () {
                this.$router.go(-1)
            },
            register:function () {
                register(this.registerData).then(res =>{
                    this.customerName = res.data.data.username
                    this.$store.commit('set_username',this.customerName)
                    Toast({
                        message: '注册成功',
                        position: 'bottom',
                        closeOnClick: "true",
                    });
                    this.$router.push('/login')
                }).catch(() => {})
            }
        },
        computed: {
            registerData() {
                return {
                    username: this.username,
                    password: this.password,
                    question: this.question,
                    answer: this.answer,
                    age: this.age,
                    sex: parseInt(this.sex),
                    email: this.email
                }
            }
        }
    }
</script>

<style scoped>

    #registerForm{
        background-color: #fff7cc;
    }

    .key{
        display: flex;
        justify-content: space-between;
        font-size: 1.3rem;
        flex: 1.2;
        margin-left: 1.2rem;
        margin-right: .5rem;
        padding: .3rem;
    }
    .value{
        display: flex;
        flex: 3;
        font-size: 1.2rem;
        margin-right: 1.2rem;
    }
    #ageValue{
        display: flex;
        width: 60%;
        height: 1.8rem;
    }

    #sexValue{
        display: flex;
        height: 1.8rem;
    }

    .flexDiv:first-child{
        padding-top: 1.5rem;
    }
    .flexDiv{
        display: flex;
        justify-content: center;
        padding-top: 1rem;
    }

    #registerButton{
        margin-top: 1rem;
        height: 2rem;
        font-size: 1rem;
        width: 70%;
    }

</style>