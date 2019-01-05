<template>
  <div>
    <div id="vouchers">
      <div style="margin-bottom: 10px;">
        <span class="section-title">Khuyến mãi</span>
        <router-link to="/type/sale">
          <button class="button-white-small" style="float: right;">Xem thêm</button>
        </router-link>
      </div>
      <div class="tile-container">
        <AdvertiseHome/>
        <div v-for="course in saleCourese" :key="course.id">
          <CourseCard :course="course"/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import CourseCard from "@/components/CourseCard.vue";
import AdvertiseHome from "@/components/AdvertiseHome.vue";
import { mapState } from "vuex";

export default {
  name: "home",
  components: {
    CourseCard,
    AdvertiseHome
  },
  computed: {
    ...mapState(["saleCourese"])
  }
};
</script>