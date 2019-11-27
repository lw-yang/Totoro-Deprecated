import request from '@/utils/request'

export function getRootCategories() {
    return request({
        url: '/category/',
        method: 'get',
    })
}
export function getChildCategories(id) {
    return request({
        url: '/category/' + id,
        method: 'get',
    })
}

