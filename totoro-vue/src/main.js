import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import { Dialog } from 'vant'
import { Row, Col } from 'vant';
import { NavBar } from 'vant';
import '@/assets/iconfont.css'

// 全局注册
Vue.use(Dialog);
Vue.use(Row).use(Col);
Vue.use(NavBar);
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
