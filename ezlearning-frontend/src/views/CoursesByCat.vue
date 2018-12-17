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
          <div v-for="course in courseByCat" :key="course.id">
            <CourseCard v-bind:course="course"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import CourseCard from "@/components/CourseCard.vue";
import { mapActions, mapState } from "vuex";

export default {
  name: "CoursesByCat",
  data() {
    return {
      catId: ""
    };
  },
  created() {
    this.catId = this.$route.params.catId;
    if (this.catId == "all") {
      this.$store.dispatch("getAllCourses");
    } else {
      this.$store.dispatch("getCourseByCat", this.catId);
    }
  },
  components: {
    CourseCard
  },
  computed: {
    ...mapState(["courseByCat"])
  },
  watch: {
    $route(to, from) {
      this.catId = to.params.catId;
      if (this.catId == "all") {
        this.$store.dispatch("getAllCourses");
      } else {
        this.$store.dispatch("getCourseByCat", this.catId);
      }
    }
  }
};
</script>