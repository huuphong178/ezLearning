<template>
  <div>
    <div class="container" style="padding-top: 90px; margin-bottom: 50px;">
      <div id="vouchers">
        <div style="margin-bottom: 10px;">
          <span class="section-subTitle">Kết quả tìm kiếm cho</span>
          <br>
          <div class="row">
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
              <span class="section-keyword">{{query}}</span>
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3"></div>
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
              Đánh giá &ensp;
              <select>
                <option value="4">4 sao trở lên</option>
                <option value="3">3 sao trở lên</option>
                <option value="2">2 sao trở lên</option>
                <option value="1">1 sao trở lên</option>
              </select>
            </div>

            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" v-on:click="FilterPrice()">
              Giá &ensp;
              <span class="box">0đ - 1.000.000đ</span>
            </div>
          </div>
        </div>
        <div class="tile-container">
          <CourseCard/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CourseCard from "@/components/CourseCard.vue";

import { mapActions } from "vuex";

export default {
  name: "home",
  data() {
    return {
      query: ""
    };
  },
  components: {
    CourseCard
  },
  created() {
    this.query = this.$route.params.query;
  },
  watch: {
    $route(to, from) {
      this.query = to.params.query;
    }
  }
};
</script>