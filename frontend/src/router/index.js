import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/login',
        name: 'login',
        component: () => import(/* webpackChunkName: "about" */ '../components/Login.vue')
    },
    {
        path: '/forgotPwd',
        name: 'forgotPwd',
        component: () => import(/* webpackChunkName: "about" */ '../components/ForgotPassword.vue')
    },
    {
        path: '/',
        name: 'home',

        component: Home,
        children:[
            {
                path: '/',
                name: 'list',
                component: () => import( '../views/list/index')
            },
            {
                // 进行中的悬赏页面组件
                path: '/home/oderList',
                name: 'oderList',
                component: () => import( '../views/oderList/index')
            },
            {
                path: '/Addxs',
                name: 'Addxs',
                component: () => import( '../views/Addxs/index')
            },
            {
                //我的悬赏,包括可接和已接
                path: '/home/reward',
                name: 'reward',
                component: () => import( '../views/aboutUser/my-offer-a-reward.vue')
            }
        ]
    }
]


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
