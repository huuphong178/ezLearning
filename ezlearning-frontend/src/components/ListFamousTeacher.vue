<template>
  <div id="fteachers">
    <div style="margin-bottom: 10px;">
      <span class="section-title">Giảng viên tiêu biểu</span>
    </div>
    <div style="position: relative; width: 100%">
      <div
        @click="fteachersLeftClick()"
        id="fteachers-left"
        class="arrow-white left"
        style="margin-top: 200px; display: none;"
      >
        <img src="icons/home-right.png" width="10px">
      </div>
      <div
        @click="fteachersRightClick()"
        id="fteachers-right"
        class="arrow-white right"
        style="margin-top: 200px;"
      >
        <img src="icons/home-left.png" width="10px">
      </div>
    </div>
    <div
      style="width: calc(100% - 104px); padding: 5px; overflow: hidden; margin-left: 52px; margin-right: 52px;"
    >
      <div id="fteachers-list" style="width: 200%; height: 600px;">
        <div class="fteachers-container">
          <FamousTeacher/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FamousTeacher from "@/components/FamousTeacher.vue";

export default {
  name: "home",
  components: {
    FamousTeacher
  },
  methods: {
    fteachersLeftClick() {
      this.$jQuery(event.target)
        .parents("#fteachers")
        .find("#fteachers-list")
        .animate(
          {
            marginLeft: "0%"
          },
          600
        );
      this.$jQuery(event.target)
        .parents("#fteachers")
        .find("#fteachers-right")
        .fadeIn("fast");
      this.$jQuery(event.target).fadeOut("fast");
    },
    fteachersRightClick() {
      this.$jQuery(event.target)
        .parents("#fteachers")
        .find("#fteachers-list")
        .animate(
          {
            marginLeft: "-102%"
          },
          600
        );
      this.$jQuery(event.target).fadeOut("fast");
      this.$jQuery(event.target)
        .parents("#fteachers")
        .find("#fteachers-left")
        .fadeIn("fast");
    }
  }
};
</script>