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
        url: '/customer/',
        method: 'post',
        data
    })
}

export function getCustomer(data) {
    return request({
        url: '/customer/' + data,
        method: 'get'
    })
}

export function editCustomer(data) {
    return request({
        url: '/customer/',
        method: 'put',
        data
    })
}