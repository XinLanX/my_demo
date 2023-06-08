import request from '@/util/request'

export function getSysUser() {
    return request({
        url: '/hello/user',
        method:'post'
    })
}
export function datasourceCheckCon(data) {
    return request({
        url: '/sql/checkCon',
        method: 'post',
        data
    })
}

export function executeSql(data) {
    return request({
        url: '/sql/executeSql',
        method: 'post',
        data
    })
}
export function executeSqlTable(data) {
    return request({
        url: '/sql/executeSqlTable',
        method: 'post',
        data
    })
}
