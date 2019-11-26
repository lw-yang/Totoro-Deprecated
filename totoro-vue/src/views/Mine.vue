<template>
    <div>
        <van-row type="flex " justify="space-between">
            <van-col span="24">
                <div id="header">TODO</div>
            </van-col>
        </van-row>

        <UserInfo :isLogin="isLogin"
                  :sex="sex"
                  :points="points"
                  :username="username"/>

        <OrderStatus/>


        <div style="text-align: center; width: 100%; height: 15rem; line-height: 15rem; color: #c8c9cc; font-size: 2rem">待 开 发...</div>
    </div>
</template>

<script>
    import Vue from 'vue';
    import {Image} from 'vant';
    import {getCustomer} from "../api/customer";
    import UserInfo from "../components/mine/UserInfo";
    import OrderStatus from "../components/mine/OrderStatus";

    Vue.use(Image);

    export default {
        name: "Mine",
        data() {
            return {
                username: window.localStorage.getItem("username"),
                points: 0,
                sex: 0,
                age: 0,
                email: ''
            }
        },
        computed: {
            isLogin() {
                return window.localStorage.getItem("token") !== null;
            }
        },
        methods:{
            customerSetting: function () {
                this.$router.push('/customerSetting')
            }
        },
        components: {
            OrderStatus,
            UserInfo
        },
        created() {
            let userId = this.$store.getters.userId
            if(userId === '' || userId === null){
                return
            }
            getCustomer(userId).then(res => {
                let customer = res.data.data
                this.username = customer.username
                this.age = customer.age
                this.sex = customer.sex
                this.email = customer.email
                this.points = customer.points
            }).catch(()=>{})
        }
    }
</script>

<style scoped>
    #header {
        height: 2.5rem;
        width: 100%;
        margin: auto;
        background-color: #969799;
        text-align: center;
        line-height: 3rem;
    }
</style>