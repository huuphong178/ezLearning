<template>
  <div class="navbar" style="width: 100%; position: fixed; z-index: 10">
    <div class="row" style="width: 100%">
      <div class="col-sm" style="width: 35%; margin-top: 3px;">
        <!-- <router-link :to="{ name: 'home' }"> -->
          <img v-on:click="Home()" src="/icons/logos/navbar.png" width="138px">
        <!-- </router-link> -->
        <span style="margin-left: 50px" id="nav-cats">
          Danh mục
          <img src="/icons/more-cat.png" width="11px" style="margin-left: 15px">
        </span>
        <div
          id="dropdown-cats"
          class="menu-dropdown"
          style="display: none; left: 75px; min-width: 350px !important;"
        >
          <div class="dropdown-content">
            <div class="dropdown">
              <ul class="split">
                <div v-for="cat in catogaries" :key="cat.id">
                  <!-- <router-link :to="`/courses/${cat.id}`"> -->
                  <li v-on:click="Catogaries(cat.id)">{{cat.name}}</li>
                  <!-- </router-link> -->
                </div>
              </ul>
            </div>
          </div>
          <router-link :to="`/courses/all`">
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
          <input type="text" placeholder="Tìm kiếm khóa học, giảng viên, ...">
          <img src="/icons/search.png" style="float: right; margin-top: 3px" width="13px">
        </div>
      </div>
      <div class="col-sm text-right" style="width: 40%; margin-top: 5px;">
        <span>Đăng nhập</span>
        <span class="sign-up-btn" style="margin-left: 30px;">Đăng ký</span>
      </div>
    </div>
  </div>
</template>

<script>
$(document).ready(function () {
$(".tile-course").hover(
    function () {
        $(this).parent("div").find(".tile-preview").show();
    },
    function () {
        $(this).parent("div").find(".tile-preview").hide();
    }
);
});

import { mapState } from "vuex";

export default {
  data() {
    return {};
  },
  computed: {
    ...mapState(["catogaries"])
  },
  methods:{
    Home(){
      this.$router.replace('/')
    },
    Catogaries(catID){
      this.$router.replace(`/courses/${catID}`);
    }
  }
};

</script>
