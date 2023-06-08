import axios from 'axios'
import { Message } from 'element-ui'

const service = axios.create({
    baseURL: "http://localhost:18090/devuc/", // url = base url + request url
    // withCredentials: true, // send cookies when cross-domain requests
    timeout: 50000 // request timeout
})

export default service
// 请求拦截器
// service.interceptors.request.use(
//     config => {
//         if(localStorage.token) {
//             config.headers.token = localStorage.token;
//         }
//         return config;
//     },
//     error => {
//         console.log(error);
//         return Promise.reject(error);
//     }
// )
