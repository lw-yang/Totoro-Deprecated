<template>
    <div>
        <van-row v-if="isLogin"  class="info">
            <van-col class="avatar">
                <van-image
                        round
                        width="5rem"
                        height="5rem"
                        src="https://img.yzcdn.cn/vant/cat.jpeg"
                />
            </van-col>

            <van-col class="userInfo" >
                <div id="username">
                    <router-link to="/customerSetting">
                        {{username}}
                        <div id="sexIcon">
                            <van-icon  v-if="sex === 1" class-prefix="iconfont" name="male" color="#1989fa" size="1.5rem"/>
                            <van-icon  v-else class-prefix="iconfont" name="female" color="hotpink" size="1.5rem"/>
                        </div>
                    </router-link>

                </div>
                <div id="userPoints">
                    积分值: {{points}}
                </div>
            </van-col>

            <van-col id="editIcon" >
                <router-link to="/customerSetting">
                    <van-icon name="records" size="3rem" />
                </router-link>
            </van-col>
        </van-row>

        <van-row v-else type="flex " justify="space-between" class="info">
            <van-col class="avatar">
                <van-image
                        round
                        width="5rem"
                        height="5rem"
                        src="https://img.yzcdn.cn/vant/cat.jpeg"
                />
            </van-col>
            <van-col class="userInfo">
                <router-link to="/login" id="loginOrRegister">
                    登录 / 注册
                </router-link>
            </van-col>
        </van-row>
    </div>
</template>

<script>
    export default {
        name: "UserInfo",
        props: {
            isLogin: Boolean,
            username: String,
            sex: Number,
            points: Number,
        }
    }
</script>

<style scoped>
    .info{
        height: 6rem;
        display: flex;
    }
    .avatar{
        display: flex;
        background-color: #1989fa;
        flex: 1.2;
        justify-content: center;
        align-items: center;
    }
    .userInfo{
        background-color: #ed6a0c;
        flex: 2;
        display: flex;
        flex-direction: column;
        justify-content: center;
    }
    #editIcon{
        display: flex;
        background-color: #ff976a;
        flex: .7;
        justify-content: center;
        align-items: center;
    }
    #username{
        display: flex;
        background-color: #b3d4fc;
        flex: 2;
        align-items: center;
        font-size: 1.6rem;
    }
    #userPoints{
        display: flex;
        background-color: #ffd01e;
        flex: 1;
        align-items: center;
        font-size: 1rem;
    }
    #sexIcon{
        margin-left: .5rem;
        display: inline;
    }

    #loginOrRegister{
        font-size: 1.4rem;
    }
    a:link {color:#000000;} /* 未访问的链接 */
    a:visited {color:#000000;} /* 已访问的链接 */
    a:hover {color:#000000;} /* 鼠标划过链接 */
    a:active {color:#000000;} /* 已选中的链接 */


</style>