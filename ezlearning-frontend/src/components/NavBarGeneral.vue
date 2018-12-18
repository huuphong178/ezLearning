<template>
  <div>
    <div class="navbar" style="width: 100%; position: fixed; z-index: 10">
      <div class="container">
        <div class="row" style="width: 100%">
          <div class="col-sm" style="width: 35%; margin-top: 3px;">
            <router-link to="/">
              <img src="/icons/logos/navbar.png" width="138px">
            </router-link>
            <span @mouseenter="navCatMouseEnter()" style="margin-left: 50px" id="nav-cats">
              Danh mục
              <img src="/icons/more-cat.png" width="11px" style="margin-left: 15px">
            </span>
            <div
              @mouseenter="dropdownCatsMouseEnter()"
              @mouseleave="dropdownCatsMouseLeave()"
              id="dropdown-cats"
              class="menu-dropdown"
              style="display: none; left: 75px; min-width: 350px !important;"
            >
              <div class="dropdown-content">
                <div class="dropdown">
                  <ul class="split">
                    <div v-for="cat in catogaries" :key="cat.id">
                      <router-link :to="`/courses-by-cat/${cat.id}`">
                        <li>{{cat.name}}</li>
                      </router-link>
                    </div>
                  </ul>
                </div>
              </div>
              <router-link :to="`/courses-by-cat/all`">
                <div class="dropdown-addon">
                  Tất cả khóa học
                  <img
                    id="allcats"
                    src="/icons/all-cats.png"
                    width="15px"
                    style="margin-top: 3px; float: right"
                  >
                </div>
              </router-link>
            </div>
          </div>
          <div class="col-sm" style="width: 40%; margin: auto;">
            <div class="search-box">
              <input v-model="query" type="text" placeholder="Tìm kiếm khóa học, giảng viên, ...">
              <router-link :to="`/search/${query}`">
                <img
                  src="/icons/search.png"
                  v-on:click="applySearch(query)"
                  style="float: right; margin-top: 3px"
                  width="13px"
                >
              </router-link>
            </div>
          </div>
          <div v-if="user == null" class="col-sm text-right" style="width: 40%; margin-top: 5px;">
            <span @click="setIsLogged(true)" class="sign-in-btn">Đăng nhập</span>
            <span @click="setIsLogged(true)" class="sign-up-btn" style="margin-left: 30px;">Đăng ký</span>
          </div>
          <div
            v-if="user != null"
            id="logged-in-student"
            class="col-sm text-right"
            style="width: 40%"
          >
            <span class="sign-up-btn" style="margin-left: 30px;">Kích hoạt</span>
            <img src="/icons/cart.png" width="16px" style="margin-left: 20px;">
            <div class="cart" style="margin-left: 5px;">{{cart.length}}</div>
            <span id="nav-profile-s" style="cursor: pointer;">
              <div class="navbar-ava-container" style="margin-left: 20px;">
                <img src="/imgs/students/student1.png" class="navbar-ava-img">
              </div>
              <img src="/icons/more-cat.png" width="11px" style="margin-left: 10px">
            </span>
            <div
              id="dropdown-profile"
              class="menu-dropdown"
              style="display: none; right: -60px; min-width: 230px; text-align: left;"
            >
              <div class="dropdown-addon-top" style="font-weight: bold;">Võ Thịnh Chuẩn</div>
              <div class="dropdown-content">
                <div class="dropdown">
                  <ul>
                    <li>Các khóa học của tôi</li>
                    <li>Lịch sử giao dịch</li>
                  </ul>
                </div>
              </div>
              <div class="dropdown-addon" v-on:click="logOut()">Đăng xuất</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";

export default {
  data() {
    return {
      query: "",
      dataSignIn: {},
      dataSignUp: {}
    };
  },
  computed: {
    ...mapState(["catogaries"]),
    ...mapState(["cart"]),
    ...mapState(["user"]),

  },
  methods: {
    dropdownCatsMouseEnter() {
      this.$jQuery(event.target).fadeIn("fast");
    },
    navCatMouseEnter(){
      this.$jQuery(event.target).parent().find("#dropdown-cats").fadeIn("fast");
    },
    dropdownCatsMouseLeave() {
      this.$jQuery(event.target).fadeOut("fast");
    },
    ...mapActions(["applySearch"]),
    ...mapActions(["signIn"]),
    ...mapActions(["signUp"]),
    ...mapActions(["logOut"]),
    ...mapActions(["setIsLogged"]),
    SignInFacebook() {},
    SignUpFacebook() {},
    CloseSignInForm() {
      document.getElementById("si-warn").style.display = "none";
      document.getElementById("su-warn").style.display = "none";

      this.dataSignIn = {};
      this.dataSignUp = {};
    },
  },
  watch: {
    $route(to, from) {
      this.query = "";
    }
  }
};
</script>
