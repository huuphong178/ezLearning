<template>
  <div style="height: 100%; position: relative;">
    <div v-for="course in profileCourse" :key="course.courseid">
    <div class="tile tile-course" style="height: 230px">
      <div class="tile-info" style="background-color: rgba(0, 178, 203, 0.75);">
        <div style="position: relative; height: 195px;">
          <div>
            <div class="tile-cat">{{course.catname}}</div>
          </div>
          <div style="bottom: 0; position: absolute;">
            <div class="tile-course-name">{{course.name}}</div>
            <div>
              <div
                class="tile-ava-container"
                style="float: left; margin-right: 15px; margin-top: 5px"
              >
                <img src="/imgs/teachers/teacher1.png" class="tile-ava-img">
              </div>
              <span>{{course.teachername}}</span>
            </div>
            <div>
              <div class="row" style="margin-top: 15px;">
                <div class="col-sm-9">
                  <div class="process-bg">
                    <div class="process-bar" style="width: 70%"></div>
                  </div>
                </div>
                <div v-if="course.percentage != 0" class="col-sm-3 process-num no-padding">{{course.percentage}}%</div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div>
        <img src="/imgs/courses/course1.png" class="tile-cover">
      </div>
    </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex"

export default {
  computed: {
    ...mapState(["profileCourse"])
  },
  created() {
    this.$store.dispatch("getProfileCourses", this.$store.state.user.id);
  },
}
</script>
