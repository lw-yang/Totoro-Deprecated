import Vue from 'vue'
import axios from 'axios'
import store from '@/store'
import { Toast } from 'vant';

Vue.use(Toast);

const service = axios.create({
    baseURI: process.env.VUE_APP_BASE_API,
    timeout: 5000
})

// 给每个请求头部加上Token
service.interceptors.request.use(
    config => {
        if (store.getters.token){
            config.headers['X-Totoro-Token'] = store.getters.token
        }

        alert(process.env.VUE_APP_BASE_API)
        return config;
    },
    err => Promise.reject(err)
)

service.interceptors.response.use(
    response => {
        const res = response.data

        if (res.code !== 0){
            Toast.fail(res.message)
        }
    },
    err => Promise.reject(err)
)

export default service