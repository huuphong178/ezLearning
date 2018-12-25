<template>
  <div
    @mouseenter="mouseenter()"
    @mouseleave="mouseleave()"
    style="height: 100%; position: relative;"
  >
    <div class="tile-price" v-on:click="AddToCart(course, user)">
      <button class="price-button" v-if="course.percentage != null">{{course.promotionalPrice}} đ</button>
      <button class="price-button" v-if="course.percentage == null">{{course.Price}} đ</button>

    </div>
    <div class="tile tile-course">
      <router-link :to="`/course/${course.id}`">
        <div class="tile-preview">
          <div style="position: relative; height: 100%;">
            <div>
              <div class="tile-cat">{{course.catName}}</div>
            </div>
            <div>
              <div>
                <img
                src="/icons/ratings/rate-full.png"
                width="18px"
                v-for="item in +course.rating"
                :key="item">
              
              <img
                src="/icons/ratings/rate-outline.png"
                width="18px"
                v-for="item in (5 - +course.rating)"
                :key="item"
              >
                <span>(0{{course.rating}})</span>
              </div>
              <div class="tile-preview-name">{{course.name}}</div>
              <div>
                <div
                  class="tile-ava-container"
                  style="float: left; margin-right: 15px; margin-top: 5px"
                >
                  <img src="/imgs/teachers/teacher1.png" class="tile-ava-img">
                </div>
                <span>{{course.teacherName}}</span>
              </div>
              <div class="tile-preview-des">{{course.description}}</div>
            </div>
          </div>
        </div>
        <div class="tile-info" style="background-color: rgba(0, 178, 203, 0.75);">
          <div style="position: relative; height: 100%;">
            <div>
              <div class="tile-discount" style="margin-bottom: 5px;">{{course.percentage}}%</div>
              <br>
              <div class="tile-cat">{{course.catName}}</div>
            </div>
            <div style="bottom: 0; position: absolute;">
              <img
                src="/icons/ratings/rate-full-white.png"
                width="18px"
                v-for="item in +course.rating"
                :key="item">
              
              <img
                src="/icons/ratings/rate-outline-white.png"
                width="18px"
                v-for="item in (5 - +course.rating)"
                :key="item"
              >
              
              <span>(0{{course.rating}})</span>

              <div class="tile-course-name">{{course.name}}</div>
              <div>
                <div
                  class="tile-ava-container"
                  style="float: left; margin-right: 15px; margin-top: 5px"
                >
                  <img src="/imgs/teachers/teacher1.png" class="tile-ava-img">
                </div>
                <span>{{course.teacherName}}</span>
              </div>
              <div v-if="course.percentage != null">
                Giá cũ:
                <span class="tile-old-price">{{course.price}}đ</span>
              </div>
            </div>
          </div>
        </div>
        <div>
          <img src="/imgs/courses/course1.png" class="tile-cover">
        </div>
      </router-link>
    </div>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

export default {
  data() {
    return {};
  },
  props: {
    course: {}
  },
  computed: {
    ...mapState(["user"])
  },
  methods: {
    mouseleave() {
      this.$jQuery(event.target)
        .parent("div")
        .find(".tile-preview")
        .hide();
    },
    mouseenter() {
      var self = this;
      this.$jQuery(event.target)
        .parent("div")
        .find(".tile-preview")
        .show();
    },
    AddToCart(course, user) {
      if (user != null) {
        this.$store.dispatch("addCart", course);
      } else {
      }
    }
  }
};
</script>

