<template>
    <div>

        <van-nav-bar
                left-text="返回"
                left-arrow
                @click-left="onClickLeft"
        >
            <div slot="left" style="font-size: 1.1rem"><van-icon name="arrow-left" /> 返回</div>
        </van-nav-bar>
        <div style="text-align: center; clear: both">
            <p style="font-size: 1.3rem; margin-bottom: 1rem; font-weight: bold">用 户 注 册</p>
        </div>
        <van-cell-group style="line-height: 60px;">
            <van-field
                    v-model="username"
                    clearable
                    label="用户名: "
                    placeholder="请输入用户名"
                    label-width="120px"
                    style="line-height: 3rem;font-size: 1.2rem; margin-left: 2rem"
            />
            <van-field
                    v-model="password"
                    type="password"
                    label="密 码: "
                    placeholder="请输入密码"
                    label-width="120px"
                    style="line-height: 3rem;font-size: 1.2rem;margin-left: 2rem"
            />
            <van-field
                    v-model="question"
                    type="textarea "
                    label="密保问题:"
                    placeholder="请输入密保问题"
                    label-width="120px"
                    style="line-height: 3rem;font-size: 1.2rem;margin-left: 2rem"
            />
            <van-field
                    v-model="answer"
                    type="textarea "
                    label="密保答案:"
                    placeholder="请输入密保答案"
                    label-width="120px"
                    style="line-height: 3rem;font-size: 1.2rem;margin-left: 2rem"
            />
            <van-field
                    v-model="email"
                    type="email "
                    label="邮 箱:"
                    placeholder="请输入邮箱"
                    label-width="120px"
                    style="line-height: 3rem;font-size: 1.2rem;margin-left: 2rem"
            />
            <label style="float: left; width:100px;margin-left: 2.5rem;font-size: 1.2rem;line-height: 3rem; padding-top: .5rem"> 年龄: </label>
            <van-stepper id="age" v-model="age" integer  step="1"  input-width="5rem" button-size="2rem" min="1" max="100"/>

            <label style="float: left; width:100px;margin-left: 2.5rem;font-size: 1.2rem;line-height: 3rem;"> 性别: </label>
            <van-radio-group v-model="sex" icon-size="1.2rem" style="padding-top: 1rem">
                <van-radio name="1" style="float: left;margin-right: 2rem">男</van-radio>
                <van-radio name="2">女</van-radio>
            </van-radio-group>

            <div style="text-align: center;clear: both ">
                <van-button  @click="register" size="large" type="primary" style="margin-top: 3rem;height: 2.5rem;width: 18rem;font-size: 1rem">注 册</van-button>
            </div>
        </van-cell-group>
    </div>
</template>

<script>
    import Vue from 'vue';
    import { Field } from 'vant';
    import { Cell, CellGroup } from 'vant';
    import { Icon } from 'vant';
    import { Stepper } from 'vant';
    import { RadioGroup, Radio } from 'vant';
    import { Button } from 'vant';
    import { NavBar } from 'vant';
    import {register} from '@/api/customer'
    import { Toast } from 'vant';
    import { Row, Col } from 'vant';
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
        data(){
            return{
                username: '',
                password: '',
                question: '',
                answer: '',
                age: '1',
                sex: '1',
                email: '',
                customerName: ''
            }
        },
        methods:{
            onClickLeft:function () {
                this.$router.push('/login')
            },
            register:function () {
                register(this.registerData).then(res =>{
                    this.customerName = res.data.data.username
                    this.$store.commit('set_username',this.customerName)
                    Toast.success("注册成功"+this.$store.getters.username)
                    this.$router.push('/login')
                })
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
                    sex: this.sex,
                    email: this.email
                }
            }
        }
    }
</script>

<style scoped>

</style>