<template>
  <div class="popular">
    <div style="margin-bottom: 10px;">
      <span class="section-title">{{sectionTitle}}</span>
    </div>
    <div style="position: relative; width: 100%">
      <div @click="popularLeftClick()" class="popular-left arrow-white left" style="display: none;">
        <img src="icons/home-right.png" width="10px">
      </div>
      <div @click="popularRightClick()" class="popular-right arrow-white right">
        <img src="icons/home-left.png" width="10px">
      </div>
    </div>
    <div style="width: 100%; padding: 5px; overflow: hidden;">
      <div class="popular-list" style="width: 200%;">
        <div class="tile-container-long">
          <div v-for="courseItem in listCourse" :key="courseItem.id">
            <CourseCard v-bind:course="courseItem"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CourseCard from "@/components/CourseCard.vue";

export default {
  name: "ListCourseCard",
  props: {
    sectionTitle: String,
    listCourse: []
  },
  components: {
    CourseCard
  },
  methods: {
    popularLeftClick() {
      this.$jQuery(event.target)
        .parents(".popular")
        .find(".popular-list")
        .animate({marginLeft: "0%"}, 600);
      this.$jQuery(event.target).fadeOut("fast");
      this.$jQuery(event.target)
        .parents(".popular")
        .find(".popular-right")
        .fadeIn("fast");
    },
    popularRightClick() {
      this.$jQuery(event.target)
        .parents(".popular")
        .find(".popular-list")
        .animate({ marginLeft: "-102%" }, 600);
      this.$jQuery(event.target).fadeOut("fast");
      this.$jQuery(event.target)
        .parents(".popular")
        .find(".popular-left")
        .fadeIn("fast");
    }
  }
};
</script>
