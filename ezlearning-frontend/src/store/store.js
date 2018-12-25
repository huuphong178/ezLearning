import Vue from 'vue'
import Vuex from 'vuex'
import actions from './actions'

Vue.use(Vuex)

// function ParseBlobToImage(Blob blob){

// }

export default new Vuex.Store({
  state: {
    isLogged: false,
    catogaries: [], //for page courses-by-cat,
    listCourse: [{
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
    courseByCat: [],
    coursesSearch: [], //for page search
    user: null,
    cart: [],
  },
  mutations: {
    SET_LOGGED(state, payload) {
      state.isLogged = payload;
    },
    SET_CATOGARIES(state, payload) {
      state.catogaries = payload;
    },
    SET_BANNER(state, payload) {
      state.courseBanner = payload;
    },
    SET_STATISTIC(state, payload) {
      state.statistic = payload;
    },
    SET_SALE(state, payload) {
      state.saleCourese = payload;
    },
    SET_COURSES_SEARCH(state, payload) {
      if (payload == "") {
        state.coursesSearch = [];
      } else state.coursesSearch = payload;
      alert(JSON.stringify(state.coursesSearch));

    },
    SET_USER(state, payload) {
      state.user = payload;
    },
    UPDATE_LOGIN_STATUS(state) {
      state.cart = {};
      state.user = null;
    },
    ADD_CART(state, payload) {
      state.cart.push(payload);
    },
    SET_COURSES_BY_CAT(state, payload) {
      state.courseByCat = payload;
    },
    REMOVE_CART_ITEM(state, payload) {
      var index = state.cart.indexOf(payload);
      state.cart.splice(index, 1);
    },
    REMOVE_COURSE_SEARCH(state){
      state.coursesSearch = [];
    }
  },
  actions,
})