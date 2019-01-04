<template>
  <div class="fteachers" style="height: 580px;">
    <div class="container">
      <router-link :to="`/profile-teacher/2?${teacher.teachername}`">
        <div class="row">
          <div class="col-sm-4">
            <div class="fteachers-ava-container">
              <img src="imgs/teachers/teacher2.png" class="fteachers-ava-img">
            </div>
          </div>
          <div class="col-sm-8" style="padding-left: 20px; padding-top: 12px">
            <span class="fteachers-name">{{teacher.teachername}}</span>
            <div style="margin-top: 5px;">
              <img src="icons/student.png" width="15px">
              <span
                class="fteachers-student-count"
                style="margin-left: 7px"
              >{{teacher.sumstudent}} học viên</span>
            </div>
          </div>
        </div>
      </router-link>
      <div style="margin-top: 20px">
        <span class="fteachers-course-count">{{coursesSearch.length}}</span>
        <span class="fteachers-course">Khóa học</span>
      </div>
      <div>
        <div v-for="courses in coursesSearch" :key="courses.id">
          <div class="fteachers-course-tile">
            <div class="fteachers-course-price" @click="AddToCart(courses, user)">
              <button
                v-if="courses.percentage == 0"
                class="price-button fteachers-price"
              >{{courses.price}}</button>
              <button
                v-if="courses.percentage != 0"
                class="price-button fteachers-price"
              >{{courses.promotionalPrice}}</button>
            </div>
            <div class="row">
              <div class="col-sm-5">
                <div class="fteachers-cover-container">
                  <img src="imgs/courses/course2.png" class="fteachers-cover-img">
                </div>
              </div>
              <div class="col-sm-7" style="padding: 0px;">
                <div>
                  <div class="tile-cat">{{courses.catname}}</div>
                  <div class="fteachers-title">{{courses.name}}</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  props: {
    teacher: {}
  },
  computed: {
    ...mapState(["coursesSearch"]),
    ...mapState(["user"])
  },
  created() {
    this.$store.dispatch("getCoursesOfTeacher", this.teacher.idteacher);
  },
  methods: {
    AddToCart(course, user) {
      if (user != null) {
        this.$store.dispatch("addCart", course);
      } else {
        this.$store.dispatch("setIsLogged", true);
      }
    }
  }
};
</script>
