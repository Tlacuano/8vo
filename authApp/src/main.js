import Vue from 'vue'

import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

// Import Bootstrap and BootstrapVue CSS files (order is important)
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)




import { domain, clientId } from '../auth_config.json';

// Import the plugin here
import { Auth0Plugin } from './auth';

// Install the authentication plugin here
Vue.use(Auth0Plugin, {
  domain,
  clientId,
  onRedirectCallback: appState => {
    router.push(
        appState && appState.targetUrl
            ? appState.targetUrl
            : window.location.pathname
    );
  }
});

Vue.config.productionTip = false;





import App from './App.vue'
import router from './router'

import './assets/main.css'

new Vue({
  router,
  render: (h) => h(App)
}).$mount('#app')
