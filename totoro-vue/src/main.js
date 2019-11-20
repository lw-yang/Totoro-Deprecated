import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import { Dialog } from 'vant';

// 全局注册
Vue.use(Dialog);
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
