import Vue from 'vue'
import VueRouter from 'vue-router'
import { authGuard } from '@/auth/authGuard'


Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  base: import.meta.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'app',
      redirect: '/login',
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/Login.vue'),
      beforeEnter: authGuard,
    },
    {
      path: '/home',
      name: 'home',
      component: () => import('@/views/Home.vue'),
      beforeEnter: authGuard,
    }
  ]
})

export default router
