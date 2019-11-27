<template>
    <div id="user">
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
                            <van-icon  v-if="sex === 1" class-prefix="iconfont" name="male" color="#1989fa" size="1.43rem"/>
                            <van-icon  v-else class-prefix="iconfont" name="female" color="hotpink" size="1.43rem"/>
                        </div>
                    </router-link>

                </div>
                <div id="point">
                    <div id="level">
                        <van-tag v-if="isVip" round type="danger">
                            <div id="vipText">
                                <p>VIP</p>
                            </div>
                        </van-tag>
                        <van-tag v-else round color="#c8c9cc">
                            <div id="notVipText">
                                <p>VIP</p>
                            </div>
                        </van-tag>
                    </div>
                    <div id="userPoints">
                        积分值: {{points}}
                    </div>
                </div>

            </van-col>

            <van-col id="editIcon" >
                <router-link to="/customerSetting">
                    <van-icon name="edit" size="2.3rem" />
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
    import Vue from 'vue';
    import { Tag } from 'vant';

    Vue.use(Tag);
    export default {
        name: "UserInfo",
        props: {
            isLogin: Boolean,
            username: String,
            sex: Number,
            points: Number,
            isVip: Boolean
        },
        computed:{

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
        flex: 1.2;
        justify-content: center;
        align-items: center;
    }


    .userInfo{
        flex: 2;
        display: flex;
        flex-direction: column;
        justify-content: center;
    }
    #editIcon{
        display: flex;
        flex: .7;
        justify-content: left;
        align-items: center;
    }
    #username{
        display: flex;
        flex: 2;
        align-items: center;
        font-size: 1.43rem;
    }
    #point{
        flex: 1;
        display: flex;
    }
    #level{
        flex: 1;
        display: flex;
        align-items: flex-start;
        justify-content: left;
    }
    #vipText{
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: .9rem;
        color: #fff;
    }
    #notVipText{
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: .9rem;
        color: #fff;
    }
    #userPoints{
        display: flex;
        flex: 2;
        align-items: flex-start;
        font-size: 1rem;
    }
    #sexIcon{
        margin-left: .5rem;
        display: inline;
    }

    #loginOrRegister{
        font-size: 1.4rem;
    }

    #user{
        padding-top: 2rem;
        background: url('../../assets/img/userinfo.jpg') repeat 0 0;
    }

    a:link {color:#000000;} /* 未访问的链接 */
    a:visited {color:#000000;} /* 已访问的链接 */
    a:hover {color:#000000;} /* 鼠标划过链接 */
    a:active {color:#000000;} /* 已选中的链接 */
</style>
