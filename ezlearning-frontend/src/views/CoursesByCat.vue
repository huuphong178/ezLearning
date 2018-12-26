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
          <div v-for="course in listCourse" :key="course.id">
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
  computed: {
    listCourse() {
      var path = this.$route.path;
      if (path.startsWith("/courses-by-cat")) {
        return this.$store.state.courseByCat;
      }
      else{
         if (this.$route.params.typename == "sale") {
           return this.$store.state.saleCourese;
         }
      }
    }
  },
  created() {
    var path = this.$route.path;
    if (path.startsWith("/courses-by-cat")) {
      this.catId = this.$route.params.catId;
      if (this.catId == "all") {
        this.$store.dispatch("getAllCourses");
      } else {
        this.$store.dispatch("getCourseByCat", this.catId);
      }
    } else {
      //type/:typename
      if (this.$route.params.typename == "sale") {
        this.$store.dispatch("getAllCoursesSale");
      }
    }
  },
  components: {
    CourseCard
  },
  watch: {
    $route(to, from) {
      var path = this.$route.path;
      if (path.startsWith("/courses-by-cat")) {
        this.catId = this.$route.params.catId;
        if (this.catId == "all") {
          this.$store.dispatch("getAllCourses");
        } else {
          this.$store.dispatch("getCourseByCat", this.catId);
        }
      } else {
        //type/:typename
        if (this.$route.params.typename == "sale") {
          this.$store.dispatch("getAllCoursesSale");
        }
      }
    }
  }
};
</script>