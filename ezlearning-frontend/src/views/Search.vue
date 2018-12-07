<template>
  <div class="container" style="margin-top: 90px; margin-bottom: 50px;">
    <div id="vouchers">
      <div style="margin-bottom: 10px;">
        <span class="section-subTitle">Kết quả tìm kiếm cho</span>
        <br>
        <div class="row">
          <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
            <span class="section-keyword">ABC</span>
          </div>
          <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3"></div>
          <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
            Đánh giá &ensp;
            <span class="box">
              5 sao trở lên
              <img src="icons/more-cat.png" width="11px" style="margin-left: 15px">
            </span>
          </div>
          <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
              Giá &ensp;
              <span class="box">
              0đ - 1.000.000đ
            </span>
         </div>
        </div>
      </div>
      <div class="tile-container">
        <CourseCard/>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import CourseCard from "@/components/CourseCard.vue";

import { mapActions } from "vuex";

export default {
  name: "home",
  components: {
    CourseCard
  }
};
</script>