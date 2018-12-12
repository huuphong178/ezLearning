<template>
  <div style="position: relative;">
    <div class="container" style="padding-top: 90px; margin-bottom: 50px;">
      <div id="vouchers">
        <div style="margin-bottom: 10px;">
          <span class="section-subTitle">Các khóa học thuộc</span>
          <br>
          <span class="section-keyword">{{catId}}</span>
        </div>
        <div class="tile-container">
          <CourseCard/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import CourseCard from "@/components/CourseCard.vue";

export default {
  name: "CoursesByCat",
  data() {
    return {
      catId: ""
    };
  },
  components: {
    CourseCard
  },
  mounted() {
    this.catId = this.$route.params.catId;
  },
  watch: {
    $route(to, from) {
      this.catId = to.params.catId;
    }
  }
};
</script>