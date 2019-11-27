<template>
    <div class="home">
      <router-view />
      <van-tabbar route id="tabbar">
        <van-tabbar-item  replace to="/" class="tabbarItem" >
            <van-icon slot="icon" name="wap-home-o" size="2.6rem"/>
            主页</van-tabbar-item>
        <van-tabbar-item replace to="/category" class="tabbarItem" >
            <van-icon slot="icon" name="apps-o" size="2.6rem"/>
            分类</van-tabbar-item>
        <van-tabbar-item replace to="/message" class="tabbarItem" >
            <van-icon slot="icon" name="chat-o" size="2.6rem"/>
            消息</van-tabbar-item>
        <van-tabbar-item replace to="/cart" class="tabbarItem" >
            <van-icon slot="icon" name="shopping-cart-o" size="2.6rem"/>
            购物车</van-tabbar-item>
        <van-tabbar-item replace to="/mine" class="tabbarItem">
            <van-icon slot="icon" name="friends-o" size="2.6rem"/>
            我的
        </van-tabbar-item>
      </van-tabbar>

    </div>
</template>

<script>

  import Vue from 'vue';
  import {Tabbar, TabbarItem} from 'vant';
  import { Icon } from 'vant';
  Vue.use(Tabbar).use(TabbarItem);
  Vue.use(Icon);
  export default {
    data() {
      return {
        active: 'home'

      }
    }
  }
</script>

<style scoped>
    #tabbar{
        height: 4.5rem;
    }
    .tabbarItem{
        font-size: 1rem
    }
</style>
