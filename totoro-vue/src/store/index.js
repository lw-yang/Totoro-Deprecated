import Vue from 'vue'
import Vuex from 'vuex'
import customer from './modules/customer'
import getters from "./getters";

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    customer
  },
  getters
})
