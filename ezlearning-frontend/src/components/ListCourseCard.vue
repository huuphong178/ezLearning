<template>
  <div class="popular">
    <div style="margin-bottom: 10px;">
      <span class="section-title">{{sectionTitle}}</span>
    </div>
    <div style="position: relative; width: 100%">
      <div class="popular-left arrow-white left" style="display: none;">
        <img src="icons/home-right.png" width="10px">
      </div>
      <div class="popular-right arrow-white right">
        <img src="icons/home-left.png" width="10px">
      </div>
    </div>
    <div style="width: 100%; padding: 5px; overflow: hidden;">
      <div class="popular-list" style="width: 200%;">
        <div class="tile-container-long" >
          <div v-for="courseItem in listCourse" :key="courseItem">
              <CourseCard v-bind:course="courseItem"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CourseCard from "@/components/CourseCard.vue";
import { mapState } from "vuex";

export default {
  name: "ListCourseCard",
  props: {
    sectionTitle: String
  },
  components: {
    CourseCard
  },
  computed: {
    ...mapState(["listCourse"]),
  },
};
</script>
