import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Courses from './views/Courses.vue'
import Search from './views/Search.vue'

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/courses/:catId',
      name: 'courses',
      component: Courses
    },
    {
      path: '/search',
      name: 'search',
      component: Search
    }
  ]
})
