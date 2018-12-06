import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    catogaries: [],
    courseBanner: [],
    statistic: [],
    saleCourese: [],
    
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
    }
  },
  actions: {
    init(ctx){
      //danh mục navbar
      axios.get("http:domain:port/category").then(response => {
        if (response.status == 200){
          ctx.commit(SET_CATOGARIES, response.data);
        }
      }).catch(err => {
        alert("Error:" + err);
      });

      axios.get("http:domain:port/course/random?n=5").then(response => {
        if (response.status == 200){
          ctx.commit(SET_BANNER, response.data);
        }
      }).catch(err => {
        alert("Error:" + err);
      });

      axios.get("http:domain:port/").then(response => {
        if (response.status == 200){
          ctx.commit(SET_STATISTIC, response.data);
        }
      }).catch(err => {
        alert("Error:" + err);
      });
    }
  }
})
