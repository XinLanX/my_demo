import sysUser from "@/main/sysUser";
import Vue from 'vue'
import {createRouter, createWebHashHistory} from 'vue-router'

export default new createRouter({

    history: createWebHashHistory(),
    routes: [
        //默认路径下显示该路由
        {
            path: '/',
            name: 'sysUser',
            component: sysUser //组件名称，这个路由对应跳转的组件
        }
    ]
})
