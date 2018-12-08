<template>
  <div class="big-banner">
    <div class="container">
      <div class="navbar-banner">
        <div class="row" style="width: 100%">
          <div class="col-sm" style="width: 35%">
            <router-link :to="'/home'">
              <img src="icons/logos/navbar-white.png" width="138px">
            </router-link>
            <span style="margin-left: 50px">
              Danh mục
              <img src="icons/more-cat-white.png" width="11px" style="margin-left: 15px" v-on:click="ListCats()">
            </span>
          </div>
          <div class="col-sm" style="width: 40%; margin: auto;">
            <div class="search-box-white">
              <input type="text" placeholder="Tìm kiếm khóa học, giảng viên, ...">
              <img src="icons/search-white.png" style="float: right; margin-top: 3px" width="13px">
            </div>
          </div>
          <div class="col-sm text-right" style="width: 40%">
            <span v-on:click="LogIn()">Đăng nhập</span>
            <span class="sign-up-btn-white" style="margin-left: 30px;" v-on:click="Signup()">Đăng ký</span>
          </div>
        </div>
      </div>
    </div>
  </div>

      <!-- <b-collapse is-nav id="nav_collapse" class="row">
        <b-navbar-nav class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
          <b-nav-item-dropdown text="Danh mục">
            <div v-for="cat in catogaries" :key="cat.id">
              <b-dropdown-item href="#">{{cat.name}}</b-dropdown-item>
            </div>
          </b-nav-item-dropdown>
        </b-navbar-nav>
         -->
</template>

<script>
import { mapState } from "vuex";

export default {
  data() {
    return {};
  },
  computed: {
    ...mapState(["catogaries"])
  },
  methods: {
    ListCats(){
      //hiện menu danh mục
    },
    LogIn() {},
    Signup() {},

  }
};
</script>

