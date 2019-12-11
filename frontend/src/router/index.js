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
                path: '/home/oderList',
                name: 'oderList',
                component: () => import( '../views/oderList/index')
            },
            {
                path: '/Addxs',
                name: 'Addxs',
                component: () => import( '../views/Addxs/index')
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
