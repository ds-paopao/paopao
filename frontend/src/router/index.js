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
        path: '/home/list',
        name: 'list',
        component: () => import( '../views/list/index')
      }
    ]
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
