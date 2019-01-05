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

            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" v-on:click="FilterPrice()">Giá &ensp;
              <!-- <span class="box">0đ - 1.000.000đ</span> -->
              <select>
                <option value="4">0đ - 200.000đ</option>
                <option value="3">200.000đ - 500.000đ</option>
                <option value="2">500.000đ - 800.000đ</option>
                <option value="1">Trên 800.000đ</option>
              </select>
            </div>
          </div>
        </div>
        <div>
          <div v-if="coursesSearch.length <= 0">Không có kết quả tìm kiếm phù hợp</div>
          <div v-if="coursesSearch.length > 0">
            <div class="tile-container">
              <div v-for="course in coursesSearch" :key="course.id">
                <CourseCard :course="course"/>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CourseCard from "@/components/CourseCard.vue";

import { mapState, mapActions } from "vuex";

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
  computed: {
    ...mapState(["coursesSearch"])
  },
  created() {
    this.query = this.$route.params.query;
    this.$store.dispatch("applySearch", this.query);
  },
  watch: {
    $route(to, from) {
      this.query = to.params.query;
      this.$store.dispatch("applySearch", this.query);
    }
  }
};
</script>