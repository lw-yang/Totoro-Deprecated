import request from '@/utils/request'

export function login(data) {
    return request({
        url: '/customers/login',
        method: 'post',
        data
    })
}

export function register(data) {
    return request({
        url: '/customers/',
        method: 'post',
        data
    })
}

export function getCustomer(data) {
    return request({
        url: '/customers/' + data,
        method: 'get'
    })
}

export function editCustomer(data, id) {
    return request({
        url: '/customers/' + id,
        method: 'put',
        data
    })
}