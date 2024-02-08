
import VueRouter from 'vue-router'
import Vue from 'vue'

Vue.use(VueRouter)


const routes  = [
    {
        path: '/',
        component : {
            render(h) {
                return h('router-view')
            },
        },
        children: [
            {
                path:'/',
                name: 'home',
                component: () => import('../components/Home.vue'),
                children:[
                    {
                        path:'/formulario',
                        name: 'formulario',
                        component: () => import('../views/formulario/Formulario.vue')
                    },
                    {
                        path:'/Libros',
                        name: 'libros',
                        component: () => import('../views/crud_libros/boocks_management.vue')
                    },
                    {
                        path:'/Personas',
                        name: 'Personas',
                        component: () => import('../views/personas/Personas.vue')
                    },
                    {
                        path:'/ReservasDeVuelos',
                        name: 'ReservasDeVuelos',
                        component: () => import('../views/Reservas.vue')
                    },
                    {
                        path:'/AsientosReservados',
                        name: 'AsientosReservados',
                        component: () => import('../views/AsientosReservados.vue')
                    },
                    {
                        path:'/VuelosDisponibles',
                        name: 'VuelosDisponibles',
                        component: () => import('../views/VuelosDisponibles.vue')
                    },
                    {
                        path:'/LineasDeVuelo',
                        name: 'LineasDeVuelo',
                        component: () => import('../views/LineasDeVuelo.vue')
                    },
                    {
                        path:'/VuelosCancelados',
                        name: 'VuelosCancelados',
                        component: () => import('../views/VuelosCancelados.vue')
                    },
                    {
                        path:'/ProximosVuelos',
                        name: 'ProximosVuelos',
                        component: () => import('../views/ProximosVuelos.vue')
                    }
                ]
            },
        ]
    },
    {
        path:'*',
        component: () => import('../views/errorpages/Error404.vue')
    }


]

const router = new VueRouter({routes})
export default router