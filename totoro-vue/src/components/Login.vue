<template>
    <div>
        <van-nav-bar
                left-text="返回"
                left-arrow
                @click-left="onClickLeft"
                style="margin-top: 0rem"
        >
            <p slot="left" style="font-size: 1rem;"><van-icon name="arrow-left" /> 返回</p>
        </van-nav-bar>
        <van-row>
            <van-col span="10" offset="9" style="font-size: 1.3rem; margin-bottom: 1rem; font-weight: bold">用 户 登 录</van-col>
        </van-row>
        <van-cell-group style="line-height: 60px;margin-top: 2rem">
            <van-field
                    v-model="username"
                    clearable
                    label="用户名: "
                    placeholder="请输入用户名"
                    label-width="120px"
                    style="line-height: 3rem;font-size: 1.2rem; margin-left: 3rem"
            />
            <van-field
                    v-model="password"
                    type="password"
                    label="密 码:"
                    placeholder="请输入密码"
                    label-width="120px"
                    style="line-height: 3rem;font-size: 1.2rem; margin-left: 3rem"
            />

            <van-button  size="large" type="primary" style="margin-top: 3rem;margin-left: 2.3rem;height: 2.5rem;width: 18rem;font-size: 1rem">登录</van-button>
        </van-cell-group>
        <van-row id="register">
            <van-col span="10" offset="16">
                <router-link to="/register">新用户注册</router-link>
            </van-col>
        </van-row>
    </div>
</template>

<script>
    import Vue from 'vue';
    import { Field } from 'vant';
    import { Cell, CellGroup } from 'vant';
    import { Button } from 'vant';
    import { Row, Col } from 'vant';
    import { NavBar } from 'vant';
    Vue.use(Row).use(Col);
    Vue.use(Button);
    Vue.use(Cell).use(CellGroup);
    Vue.use(Field);
    Vue.use(NavBar);
    export default {
        name: "Login",
        data(){
            return{
                username: '',
                password: '',
            }
        },
        methods:{
            onClickLeft:function () {
                this.$router.push('/mine')
            }
        }
    }
</script>

<style scoped>
#register{
    margin-top: 2rem;
    font-size: .8rem;
    color: #1989fa;
}
</style>