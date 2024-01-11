
import VueRouter from 'vue-router'
import Vue from 'vue'

Vue.use(VueRouter)


const routes  = [
    {
        path:'/',
        redirect:'/home',
        
    },
    {
        path: '/',
        component : {
            render(h) {
                return h('router-view')
            },
        },
        children: [
            {
                path:'/inicio',
                name: 'name',
                component: () => import('../components/Inicio.vue')
            }
        ]
    }


]

const router = new VueRouter({routes})
export default router