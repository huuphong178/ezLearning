import axios from 'axios'

export default {
  init(ctx) {
    axios.get("http://192.168.0.148:3000/category").then(response => {
      if (response.status == 200) {
        ctx.commit('SET_CATOGARIES', response.data);
      }
    }).catch(err => {
      alert(err);
    });

    //banner
    axios.get("http://192.168.0.148:3000/course/popular?n=2").then(response => {
      if (response.status == 200) {
        ctx.commit('SET_BANNER', response.data);
      }
    }).catch(err => {
      alert(err);
    });

    //thống kê   chưa có api
    // axios.get(`http://192.168.0.148:3000/statistic`).then(response => {
    //   alert(JSON.stringify(response));
    //   if (response.status == 200){
    //     ctx.commit('SET_STATISTIC', response.data);
    //   }
    // }).catch(err => {
    //   alert("Error:" + err);
    // });

    //sale
    axios.get(`http://192.168.0.148:3000/course/promotion?from=${Date.now() - (7*24*3600*1000)}&to=${Date.now()}&n=7`).then(response => {

      if (response.status == 200) {
        ctx.commit('SET_SALE', response.data);
      }
    }).catch(err => {
      alert(err);
    });

    //popular
    axios.get("http://192.168.0.148:3000/course/popular?n=5").then(response => {
      alert(JSON.stringify(response));
      if (response.status == 200) {
        ctx.commit('SET_POPULAR_COURSES', response.data);
        // axios.get("http://192.168.0.148:3000/course/popular?n=5").then(response => {
        //   alert(JSON.stringify(response));
        //   if (response.status == 200) {
        //     ctx.commit('SET_POPULAR_COURSES', response.data);
        //   }
        // }).catch(err => {
        //   alert(err);
        // });
      }
    }).catch(err => {
      alert(err);
    });
  },
  setIsLogged(ctx, data) {
    ctx.commit('SET_LOGGED', data);
  },
  applySearch(ctx, query) {
    axios.get(`http://192.168.0.148:3000/course/search?categoryname=${query}`).then(response => {
      if (parseInt(response.status / 100) == 2) {
        ctx.commit('SET_COURSES_SEARCH', response.data);
      }
    }).catch(err => {
      alert(err);
    });

  },
  signIn(ctx, data) {
    axios.post(`http://192.168.0.148:3000/user/login`, data).then(response => {
      if (response.data.status == null) {
        alert(JSON.stringify(response.data));
        ctx.commit('SET_USER', response.data);
        ctx.commit('SET_LOGGED', false);
      } else {
        ctx.commit('SET_LOGGED', true);
      }
    }).catch(err => {
      alert(err);
    });
  },
  signUp(ctx, data) {
    alert(JSON.stringify(data));
    axios.post(`http://192.168.0.148:3000/signup`, data).then(response => {
      if (response.status == 200) {
        alert("success");
        // ctx.commit('SET_USER', data);
      }
    }).catch(err => {
      alert(err);
    });
  },
  logOut(ctx) {
    ctx.commit('UPDATE_LOGIN_STATUS');
  },
  addCart(ctx, course) {
    ctx.commit('ADD_CART', course);
  },
  getCourseByCat(ctx, catId) {
    axios.get(`http://192.168.0.148:3000/course/search?catid=${catId}`).then(response => {
      alert(JSON.stringify(response));
      if (response.status == 200) {
        ctx.commit('SET_COURSES_BY_CAT', response.data.courses);
      }
    }).catch(err => {
      alert(err);
    });
  },
  getAllCourses(ctx) {
    axios.get(`http://192.168.0.148:3000/course/`).then(response => {
      alert(JSON.stringify(response));
      if (response.status == 200) {
        ctx.commit('SET_COURSES_BY_CAT', response.data);
      }
    }).catch(err => {
      alert(err);
    });
  },
  removeCartItem(ctx, cartItem) {
    ctx.commit('REMOVE_CART_ITEM', cartItem);
  },
  removeCourseSearch(ctx) {
    ctx.commit('REMOVE_COURSE_SEARCH');
  }
}