import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import CoursesByCat from './views/CoursesByCat.vue'
import Search from './views/Search.vue'
import CourseDetail from './views/CourseDetail.vue'
import Profile from './views/Profile.vue'
import Lecture from './views/Lecture.vue'
import Cart from './views/Cart.vue'
import Checkout from './views/Checkout.vue'

Vue.use(Router);

var router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/courses-by-cat/:catId', // gồm cả danh mục hot
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
    },
    {
      path: '/profile/:role?:userid',
      name: 'Profile',
      component: Profile
    },
    {
      path: '/lecture/:courseid?:lectureid',
      name: 'Lecture',
      component: Lecture
    },
    {
      path: '/cart',
      name: 'Cart',
      component: Cart
    },
    {
      path: '/checkout',
      name: 'Checkout',
      component: Checkout
    }
  ]
});

// router.beforeEach(to, from, next)
// {

// }

export default router;
