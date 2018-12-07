import axios from 'axios'

export default {
    init(ctx){
      //danh mục navbar
      var banner = [
        {
          id: 1,
          name: "Giáo dục",
          catname: "aaa",
          teachername: "An"
        }
      ]
      ctx.commit('SET_BANNER', banner);

      // axios.get("http:domain:port/category").then(response => {
      //   if (response.status == 200){
      //     ctx.commit(SET_CATOGARIES, response.data);
      //   }
      // }).catch(err => {
      //   alert("Error:" + err);
      // });

      //banner
      // axios.get("http:domain:port/course/random?n=5").then(response => {
      //   if (response.status == 200){
      //     ctx.commit(SET_BANNER, response.data);
      //   }
      // }).catch(err => {
      //   alert("Error:" + err);
      // });

      // //thống kê
      // axios.get(`http:domain:port/`).then(response => {
      //   if (response.status == 200){
      //     ctx.commit(SET_STATISTIC, response.data);
      //   }
      // }).catch(err => {
      //   alert("Error:" + err);
      // });

      // //sale
      // axios.get(`http:domain:port/course/promotion?from=${a}&to=${y-m-d}&n=7`).then(response => {
      //   if (response.status == 200){
      //     ctx.commit(SET_SALE, response.data);
      //   }
      // }).catch(err => {
      //   alert("Error:" + err);
      // });
    }
  }