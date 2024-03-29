import Vue from 'vue'
import App from './App.vue'
import router from './router'

import './utils/css/main.css'

import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

// Import Bootstrap and BootstrapVue CSS files (order is important)
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)
Vue.use(IconsPlugin)


//importacion de animaciones
import 'animate.css';





new Vue({
  router,
  render: (h) => h(App)
}).$mount('#app')
