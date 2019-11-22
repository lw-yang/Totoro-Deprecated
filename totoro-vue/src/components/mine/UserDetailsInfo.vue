<template>
    <div id="userDetailsInfo">
        <van-row class="row" >
            <van-col class="key"  >
                <van-col>用</van-col>
                <van-col>户</van-col>
                <van-col>名:</van-col>
            </van-col>
            <van-col class="value" >{{username}}</van-col>
        </van-row>

        <van-row class="row" >
            <van-col class="key" >
                <van-col>邮</van-col>
                <van-col>箱:</van-col>
            </van-col>
            <van-col class="value" >{{email}}</van-col>
        </van-row>

        <van-row class="row" >
            <van-col class="key" >
                <van-col>年</van-col>
                <van-col>龄:</van-col>
            </van-col>
            <van-col class="value"  >{{age}}</van-col>
        </van-row>

        <van-row class="row" >
            <van-col class="key" >
                <van-col>性</van-col>
                <van-col>别:</van-col>
            </van-col>
            <van-col class="value" >{{sex === '1'? '男': '女'}}</van-col>
        </van-row>
<!--        <p style="color: white; display: inline">一</p>-->
    </div>
</template>

<script>
    export default {
        name: "UserDetailsInfo",
        props: {
            username: String,
            email: String,
            age: Number,
            sex: String
        }
    }
</script>

<style scoped>
#userDetailsInfo{
    display: flex;
    flex-direction: column;
    height: 10rem;
    background-color: #cccccc;
    padding: 1.5rem 0 0 1rem;
}
    .row{
        flex: 1;
        display: flex;
        align-items: center;

    }
    .key{
        background-color: #fff7cc;
        display: flex;
        justify-content: space-between;
        flex: 1.1;
        font-size: 1.5rem;
        margin-right: 1rem;
    }
    .value{
        background-color: #fff7cc;
        flex: 3;
        font-size: 1.2rem;
    }


</style>