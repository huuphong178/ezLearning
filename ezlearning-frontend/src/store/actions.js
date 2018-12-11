import axios from 'axios'

export default {
    init(ctx){
      axios.get("http://localhost:3000/category").then(response => {
        if (response.status == 200){
          ctx.commit('SET_CATOGARIES', response.data);
        }
      }).catch(err => {
        alert(err);
      });

      //banner
      // axios.get("http:domain:port/course/random?n=5").then(response => {
      //   if (response.status == 200){
      //     ctx.commit('SET_BANNER', response.data);
      //   }
      // }).catch(err => {
      //   alert("Error:" + err);
      // });

      //thống kê   chưa có api
      // axios.get(`http://localhost:3000/statistic`).then(response => {
      //   alert(JSON.stringify(response));
      //   if (response.status == 200){
      //     ctx.commit('SET_STATISTIC', response.data);
      //   }
      // }).catch(err => {
      //   alert("Error:" + err);
      // });

      // //sale
      // axios.get(`http:domain:port/course/promotion?from=${a}&to=${y-m-d}&n=7`).then(response => {
      //   if (response.status == 200){
      //     ctx.commit('SET_SALE', response.data);
      //   }
      // }).catch(err => {
      //   alert("Error:" + err);
      // });
    }
  }