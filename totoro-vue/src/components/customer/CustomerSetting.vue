<template>
    <div>
        <van-nav-bar
                left-arrow
                @click-left="onClickLeft"
        >
            <div slot="left" style="font-size: 1.3rem;margin-left: 1rem">
                <van-icon size="1.5rem" name="arrow-left" />
            </div>
            <div slot="title" style="font-size: 1.3rem; font-weight: bold">个 人 设 置</div>
        </van-nav-bar>

        <div style="margin: 2.5rem 1.5rem 0rem 1.5rem;font-size: 1.3rem">

            <van-row type="flex" justify="space-between">
                <van-col class="key" span="7" >
                    用户名:
                </van-col>
                <van-col class="value" span="17">{{username}}</van-col>
            </van-row>

            <van-row type="flex" justify="space-between">
                <van-col class="key" span="7">
                    邮<p style="color: white; display: inline">一</p>箱:
                </van-col>
                <van-col class="value" span="17">{{email}}</van-col>
            </van-row>

            <van-row type="flex" justify="space-between">
                <van-col class="key" span="7">
                    年<p style="color: white; display: inline">一</p>龄:
                </van-col>
                <van-col class="value" span="17" >{{age}}</van-col>
            </van-row>

            <van-row type="flex" justify="space-between">
                <van-col class="key" span="7">
                    性<p style="color: white; display: inline">一</p>别:
                </van-col>
                <van-col class="value" span="17">{{sex === '1'? '男': '女'}}</van-col>
            </van-row>

        </div>
        <van-button  @click="ToEditCustomerInfo" type="primary" size="large" style="height: 2.5rem; font-size: 1.2rem;margin-top: 2rem; padding-bottom: .3rem">修改个人资料</van-button >

        <van-button @click="logout" type="danger" size="large" style="height: 2.5rem; font-size: 1.2rem;margin-top: 1rem ">退 出 登 录</van-button>



        <van-popup v-model="show" round closeable position="bottom">
            <van-cell-group style="line-height: 60px;margin-top: 2rem;margin-left: 1rem">
                <van-field
                        disabled
                        v-model="username"
                        clearable
                        label="用户名: "
                        placeholder="请输入用户名"
                        label-width="80px"
                        style="line-height: 3rem;font-size: 1.2rem; margin-left: 2rem"
                />

                <van-field
                        @input="editEmail"
                        v-model="email"
                        type="email "
                        placeholder="请输入邮箱"
                        label-width="80px"
                        style="line-height: 3rem;font-size: 1.2rem;margin-left: 2rem"
                >
                    <label slot="label">邮<p style="color: white; display: inline">一</p>箱: </label>
                </van-field>
                <label style="float: left; width:80px;margin-left: 2.5rem;font-size: 1.2rem;line-height: 3rem; padding-top: .4rem"> 年<p style="color: white; display: inline">一</p>龄: </label>
                <van-stepper @change="editAge" id="age" v-model="age" integer  step="1"  input-width="5rem" button-size="2.2rem" min="1" max="100" />

                <label style="float: left; width:80px;margin-left: 2.5rem;font-size: 1.2rem;line-height: 3rem;"> 性<p style="color: white; display: inline">一</p>别: </label>
                <van-radio-group @change="editSex" v-model="sex" icon-size="1.2rem" style="padding-top: 1rem">
                    <van-radio name="1" style="float: left;margin-right: 2rem">男</van-radio>
                    <van-radio name="2">女</van-radio>
                </van-radio-group>

            </van-cell-group>
            <div style="text-align: center;clear: both ">
                <van-button  @click="edit" size="large" type="primary" style="margin-top: 3rem;margin-bottom: 1rem;height: 2.5rem;width: 18rem;font-size: 1rem">修 改</van-button>
            </div>

        </van-popup>

            <van-dialog
                    style="width: 15rem; height: 6rem"
                    v-model="dialogShow"
                    show-cancel-button
                    show-confirm-button
                    @confirm="confirmLogout"
            >
                <p slot="default" style="font-size: 1rem; text-align: center; padding-top: .7rem">确认退出登录吗？</p>
            </van-dialog>

    </div>
</template>

<script>
    import Vue from 'vue';
    import { Field } from 'vant';
    import { Cell, CellGroup } from 'vant';
    import { Button } from 'vant';
    import { Row, Col } from 'vant';
    import { NavBar } from 'vant';
    import { Divider } from 'vant';
    import { Popup } from 'vant';
    import { Stepper } from 'vant';
    import { RadioGroup, Radio } from 'vant';
    import { Toast } from 'vant';
    import {getCustomer} from "../../api/customer";
    import {editCustomer} from "../../api/customer";

    Vue.use(RadioGroup);
    Vue.use(Radio);
    Vue.use(Stepper);
    Vue.use(Popup);
    Vue.use(Divider);
    Vue.use(Row).use(Col);
    Vue.use(Button);
    Vue.use(Cell).use(CellGroup);
    Vue.use(Field);
    Vue.use(NavBar);
    Vue.use(Toast);
    export default {
        name: "CustomerSetting",
        data(){
            return{
                dialogShow:false,
                show:false,
                username: '',
                age: '1',
                sex: '1',
                email: '',
                editData: {}
            }
        },
        methods:{
            onClickLeft: function () {
                this.$router.push('/mine')
            },
            logout: function () {
                this.dialogShow = true

            },
            confirmLogout: function(){
                window.localStorage.removeItem("token")
                window.localStorage.removeItem("username")
                this.$router.push('/mine')
            },
            ToEditCustomerInfo: function () {
                this.show = true
            },
            edit: function () {
                this.show = false
                this.editData.username = this.username
                editCustomer(this.editData).then(res =>{
                    console.log(res.data.code)
                    Toast({
                        type: 'html',
                        message: '<P style="font-size: .6rem;margin: .3rem">修改成功</P>',
                        position: 'bottom',
                        closeOnClick: "true",
                    });
                }).catch(()=>{})
            },
            editEmail: function () {
                this.editData.email = this.email
            },
            editAge: function () {
                this.editData.age = this.age
            },
            editSex: function () {
                this.editData.sex = parseInt(this.sex)
            }

        },
        computed:{
        },
        mounted() {
            let username = window.localStorage.getItem("username")
            getCustomer(username).then(res => {
                let customer = res.data.data
                this.username = customer.username
                this.age = customer.age
                this.sex = ''+customer.sex
                this.email = customer.email
            }).catch(()=>{})
        }
    }
</script>

<style scoped>
.key{
    color: #7d7e80;
    margin-top: .5rem;
}

.value{
    text-align: left;
    margin-top: .5rem;
    color: #969799;
}
</style>
<style>

    .van-dialog__footer .van-button--large{
        font-size: .8rem;
    }

</style>