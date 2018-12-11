import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import CoursesByCat from './views/CoursesByCat.vue'
import Search from './views/Search.vue'
import CourseDetail from './views/CourseDetail.vue'

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
      path: '/courses-by-cat/:catId',
      name: 'CoursesByCat',
      component: CoursesByCat
    },
    {
      path: '/search/:query',
      name: 'search',
      component: Search
    },
    {
      path: '/course/:courseId',
      name: 'CourseDetail',
      component: CourseDetail
    }
  ]
})
