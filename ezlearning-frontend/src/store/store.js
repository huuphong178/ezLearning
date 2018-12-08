import Vue from 'vue'
import Vuex from 'vuex'
import actions from './actions'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    catogaries: [],
    courseBanner: [],
    statistic: [],
    saleCoureses: [],
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
    }
  },
  actions,
})
