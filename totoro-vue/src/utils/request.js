import Vue from 'vue'
import axios from 'axios'
import store from '@/store'
import { Toast } from 'vant';

Vue.use(Toast);

const service = axios.create({
    baseURL: process.env.VUE_APP_BASE_API,
    timeout: 5000,
})

// 给每个请求头部加上Token
service.interceptors.request.use(
    config => {
        if (store.getters.token){
            config.headers['X-Totoro-Token'] = store.getters.token
        }
        return config;
    },
    err => Promise.reject(err)
)

service.interceptors.response.use(
    response => {
        const res = response.data
        if (res.code !== 0){
            Toast({
                message: res.message,
                position: 'bottom',
                closeOnClick: "true",
            });
            return Promise.reject(response)
        }
        return response
    },
    err => Promise.reject(err)
)

export default service

