<template>
    <div>
        <NavTop :title="title" @onClickLeft="onClickLeft"/>

        <div id="registerForm">
            <van-field
                    v-model="username"
                    clearable
                    placeholder="请输入用户名"
                    label-width="120px"
            >
                <label class="key" slot="label">
                    <van-col>用</van-col>
                    <van-col>户</van-col>
                    <van-col>名:</van-col>
                </label>
            </van-field>
            <van-field
                    v-model="password"
                    type="password"
                    placeholder="请输入密码"
                    label-width="120px"
            >
                <label class="key" slot="label">
                    <van-col>密</van-col>
                    <van-col>码:</van-col>
                </label>
            </van-field>
            <van-field
                    v-model="question"
                    type="textarea "
                    placeholder="请输入密保问题"
                    label-width="120px"

            >
                <label class="key" slot="label">
                    <van-col>密</van-col>
                    <van-col>保</van-col>
                    <van-col>问</van-col>
                    <van-col>题:</van-col>
                </label>
            </van-field>
            <van-field
                    v-model="answer"
                    type="textarea "
                    label="密保答案:"
                    placeholder="请输入密保答案"
                    label-width="120px"
            >
                <label class="key" slot="label">
                    <van-col>密</van-col>
                    <van-col>保</van-col>
                    <van-col>答</van-col>
                    <van-col>案:</van-col>
                </label>
            </van-field>
            <van-field
                    v-model="email"
                    type="email "
                    label="邮 箱:"
                    placeholder="请输入邮箱"
                    label-width="120px"
            >
                <label class="key" slot="label">
                    <van-col>邮</van-col>
                    <van-col>箱:</van-col>
                </label>
            </van-field>

            <van-field id="age">
                <label slot="label" class="key">
                    <van-col>年</van-col>
                    <van-col>龄:</van-col>
                </label>
                <van-stepper id="ageValue" slot="input" v-model="age" integer  step="1" min="1" max="100"/>

            </van-field>

            <van-field id="sex">
                <label slot="label" class="key">
                    <van-col>性</van-col>
                    <van-col>别:</van-col>
                </label>

                <van-radio-group id="sexValue" slot="input" v-model="sex" icon-size="1rem" >
                    <van-radio name="1" style="margin-right: 1rem">男</van-radio>
                    <van-radio name="2">女</van-radio>
                </van-radio-group>
            </van-field>
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

    .registerForm{

    }

    .key{
        display: flex;
        justify-content: space-between;
        font-size: 1.3rem;
        flex: 1.1;
    }
    #age, #sex{
        display: flex;
        align-items: center;
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

    .flexDiv{
        display: flex;
        justify-content: center;
        padding-top: 2rem;
    }

    #registerButton{
        height: 2rem;
        font-size: 1rem;
        width: 70%;
    }
</style>

<style>
    .van-field{
        display: flex;
        height: 1.2rem;
        align-items: center;
        margin-top: 2rem;
    }
    .van-field__label{
        font-size: 1.3rem;
        flex: 1.1;
        margin-right: 1.3rem;
        margin-left: 2rem;
    }
    .van-cell__value{
        font-size: 1.3rem;
        flex: 3;
    }

    .van-stepper__minus, .van-stepper__plus{
        height: 1.8rem;
        flex: 1;
    }
    .van-stepper__input{
        height: 1.8rem;
        flex: 2;
        font-size: 1.1rem;
    }
    .van-toast__text{
        line-height: 1.3rem;
        width: 5rem;
        height: 1.3rem;
        font-size: .8rem;
    }
</style>