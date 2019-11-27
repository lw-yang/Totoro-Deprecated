import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home,
    children: [
      {
        path: '/mine',
        name: 'mine',
        component: () => import('@/views/Mine')
      },
      {
        path: '/category',
        name: 'category',
        component: () => import('@/views/Category')
      },
      {
        path: '/message',
        name: 'message',
        component: () => import('@/views/Message')
      },
      {
        path: '/cart',
        name: 'cart',
        component: () => import('@/views/ShoppingCart')
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/mine/Login')
  },
  {
    path: '/register',
    name: 'register',
    component: () => import('@/views/mine/Register')
  },
  {
    path: '/customerSetting',
    name: 'customerSetting',
    component: () => import('@/views/mine/CustomerSetting')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
