<template>
    <div id="customerSetting">

        <NavTop :title="title" @onClickLeft="onClickLeft"/>

        <UserDetailsInfo :username="username"
                         :age="age"
                         :email="email"
                         :sex="sex"/>


        <van-button class="button" @click="ToEditCustomerInfo" type="primary" size="large" >修改个人资料</van-button >

        <van-button class="button" @click="logout" type="danger" size="large">退 出 登 录</van-button>


        <van-popup v-model="show" round closeable position="top">
            <div id="popup">
                <van-row class="flexDiv">
                    <label class="key">
                        <van-col>用</van-col>
                        <van-col>户</van-col>
                        <van-col>名:</van-col>
                    </label>
                    <input type="text" disabled v-model="username" class="value"/>
                </van-row>

                <van-row class="flexDiv">
                    <label class="key">
                        <div>邮</div>
                        <van-col>箱:</van-col>
                    </label>
                    <input type="email" @input="editEmail" v-model="email" class="value" placeholder="请输入邮箱"/>
                </van-row>

                <van-row class="flexDiv">
                    <label class="key">
                        <van-col>年</van-col>
                        <van-col>龄:</van-col>
                    </label>
                    <div class="value">
                        <van-stepper id="ageValue" @change="editAge" v-model="age" integer  step="1" min="1" max="100"/>
                    </div>
                </van-row>

                <van-row class="flexDiv">
                    <label class="key">
                        <van-col>性</van-col>
                        <van-col>别:</van-col>
                    </label>
                    <van-radio-group id="sexValue" class="value" @change="editSex" v-model="sex" icon-size="1rem" >
                        <van-radio name="1" style="margin-right: 1rem">男</van-radio>
                        <van-radio name="2">女</van-radio>
                    </van-radio-group>
                </van-row>

            </div>
            <div id="editButton">
                <van-button id="edit" @click="edit" size="large" type="primary" >修 改</van-button>
            </div>
        </van-popup>

        <van-dialog
                v-model="dialogShow"
                show-cancel-button
                show-confirm-button
                @confirm="confirmLogout">
            <p slot="default" id="dialogText">确认退出登录吗？</p>
        </van-dialog>

    </div>
</template>

<script>
    import Vue from 'vue';
    import {Button, Cell, CellGroup, Col, Divider, Field, Popup, Radio, RadioGroup, Row, Stepper, Toast} from 'vant';

    import {editCustomer, getCustomer} from "../../api/customer";
    import NavTop from "../../components/NavTop";
    import UserDetailsInfo from "../../components/mine/UserDetailsInfo";

    Vue.use(Stepper);
    Vue.use(RadioGroup);
    Vue.use(Radio);
    Vue.use(Popup);
    Vue.use(Divider);
    Vue.use(Row).use(Col);
    Vue.use(Button);
    Vue.use(Cell).use(CellGroup);
    Vue.use(Field);

    Vue.use(Toast);
    export default {
        name: "CustomerSetting",
        components: {UserDetailsInfo, NavTop},
        data(){
            return{
                title: '个 人 设 置',

                dialogShow:false,
                show:false,
                username: '',
                age: 1,
                sex: '1',
                email: '',
                editData: {}
            }
        },
        methods:{
            onClickLeft: function () {
                this.$router.go(-1)
            },
            logout: function () {
                this.dialogShow = true
            },
            confirmLogout: function(){
                window.localStorage.removeItem("token")
                window.localStorage.removeItem("userId")
                this.$router.push('/mine')
            },
            ToEditCustomerInfo: function () {
                this.show = true
            },
            edit: function () {
                this.show = false
                this.editData.id = window.localStorage.getItem("userId")
                editCustomer(this.editData).then(res =>{
                    console.log("return: "+res.data.code)
                    Toast({
                        message: '修改成功',
                        position: 'bottom',
                        closeOnClick: "true",
                    });
                }).catch((reason)=>{console.log(reason)})
            },
            editEmail: function () {
                this.editData.email = this.email
            },
            editAge: function () {
                this.editData.age = this.age
            },
            editSex: function () {
                this.editData.sex = parseInt(this.sex)
            },
        },
        computed:{
        },
        created() {
            let userId = window.localStorage.getItem("userId")
            if(userId === '' || userId === null){
                return
            }
            getCustomer(userId).then(res => {
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
    input:disabled{
        background-color: #ffffff;
        color: #7d7e80;
        border: 0;
    }
    .button{
        height: 2.5rem;
        font-size: 1.1rem;
        text-align: center;
        margin-top: 1.5rem;
    }
    .button:last-child{
        margin-top: .8rem;
    }

    #popup{
        padding-top: 1rem;
        padding-left: 2rem;
        padding-right: 2rem;
    }

    .key{
        display: flex;
        align-items: center;
        justify-content: space-between;
        margin-right: 1rem;
        flex: 1;
        font-size: 1.3rem;
        color: #7d7e80;
    }
    .value{
        display: flex;
        flex: 3;
        padding: 0;
        font-size: 1.2rem;
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

    #edit{
        height: 2rem;
        width: 70%;
        font-size: 1rem;
    }

    #editButton{
        padding-top: 2rem;
        padding-bottom: 2rem;
        display: flex;
        justify-content: center;
    }

    #dialogText{
        text-align: center;
        font-size: 1.1rem;
        padding-bottom: .5rem;
    }
    .flexDiv{
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: 1.5rem;
    }
</style>