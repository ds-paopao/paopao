import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import mock from '../mock/api'

axios.defaults.baseURL =  'http://localhost:8080'
Vue.prototype.$axios = axios;
Vue.use(ElementUI)
Vue.config.productionTip = false

new Vue({
  router,
  store,
  mock,
  render: h => h(App)
}).$mount('#app')
