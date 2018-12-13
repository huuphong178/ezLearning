import Vue from 'vue'
import Vuex from 'vuex'
import actions from './actions'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    catogaries: [],  //for page courses-by-cat,
    listCourse: [
      {
        id: 5,
        name: "Vẽ 3D"
      },
      {
        id: 3,
        name: "Vẽ 2D"
      }
    ], //for listcoursecard
    courseBanner: [],
    statistic: [],
    saleCoureses: [],
    coursesSearch: [],  //for page search
    signInSuccess: false,
    signUpSuccess: false,
    cart: []
  },
  mutations: {
    SET_CATOGARIES(state, payload)
    {
      state.catogaries = payload;
    },
    SET_BANNER(state, payload)
    {
      state.courseBanner = payload;
    },
    SET_STATISTIC(state, payload){
      state.statistic = payload;
    },
    SET_SALE(state, payload){
      state.saleCourese = payload;
    },
    SET_COURSES_SEARCH(state, payload) {
      state.coursesSearch = payload;
    },
    SET_USER(state , payload){
      this.$localStorage.set("user", payload);
    },
    UPDATE_LOGIN_STATUS(state){
      state.signInSuccess = true;
      state.cart = {};
    },
    ADD_CART(state, payload){
      if (state.signInSuccess == false){
        state.cart.push(payload);
      }
      else {
        // hiên popup đăng nhập
      }
    }
  },
  actions,
})
