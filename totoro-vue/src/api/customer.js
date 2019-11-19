import request from '@/utils/request'

export function login(data) {
    return request({
        url: '/customer/login',
        method: 'post',
        data
    })
}

export function register(data) {
    return request({
        url: '/customer/register',
        method: 'post',
        data
    })
}