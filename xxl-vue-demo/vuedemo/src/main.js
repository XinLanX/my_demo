import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import router from './router/routers'
import ElementUI from 'element-ui';
// import 'element-plus/dist/index.css'

Vue.config.productionTip = false
// Vue.use(VueRouter)
Vue.use(ElementUI)
const debounce = (fn, delay) => {
  let timer = null;
  return function () {
    let context = this;
    let args = arguments;
    clearTimeout(timer);
    timer = setTimeout(function () {
      fn.apply(context, args);
    }, delay);
  }
}

const _ResizeObserver = window.ResizeObserver;
window.ResizeObserver = class ResizeObserver extends _ResizeObserver{
  constructor(callback) {
    callback = debounce(callback, 16);
    super(callback);
  }
}

new Vue({
  el:'#app',
  render: h => h(App),
  router: router
})
