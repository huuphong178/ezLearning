import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import CoursesByCat from './views/CoursesByCat.vue'
import Search from './views/Search.vue'
import CourseDetail from './views/CourseDetail.vue'
import ProfileStudent from './views/ProfileStudent.vue'
import Lecture from './views/Lecture.vue'
import Cart from './views/Cart.vue'
import Checkout from './views/Checkout.vue'
import CourseCreate from './views/CourseCreate.vue'
import LectureCreate from './views/LectureCreate.vue'
import ProfileTeacher from './views/ProfileTeacher.vue'

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
      path: '/profile-student/:role?:userid',
      name: 'ProfileStudent',
      component: ProfileStudent
    },
    {
      path: '/profile-teacher/:role?:userid',
      name: 'ProfileTeacher',
      component: ProfileTeacher
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
    },
    {
      path: '/course-create',
      name: 'CourseCreate',
      component: CourseCreate
    },
    {
      path: '/lecture-create',
      name: 'LectureCreate',
      component: LectureCreate
    }
  ]
});

// router.beforeEach(to, from, next)
// {

// }

export default router;
