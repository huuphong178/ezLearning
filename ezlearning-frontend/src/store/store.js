import Vue from 'vue'
import Vuex from 'vuex'
import actions from './actions'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    catogaries: [],  //for page courses-by-cat
    courseBanner: [],
    statistic: [],
    saleCoureses: [],
    coursesSearch: [],  //for page search
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
    }
  },
  actions,
})
