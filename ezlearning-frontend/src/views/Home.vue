<template>
  <div style="position: relative;">
    <!-- <NavBarHome/> -->
    <!-- <BannerHome/> -->
    <Statistic/>
    <div class="container" style="padding-top: 90px; margin-bottom: 50px;">
      <Sale/>

      <ListHotCats/>

      <ListCourseCard sectionTitle="Phổ biến"/>
      <ListCourseCard sectionTitle="Được đánh giá cao"/>
      <ListCourseCard sectionTitle="Mới nhất"/>

      <ListFamousTeacher/>
    </div>
    
  </div>
</template>

<script>
// $(document).ready(function () {
//  $(document).scroll(function () {
//         if ($(this).scrollTop() > 50) {
//             $(".navbar").slideDown(200);
//         } else {
//             $('.navbar').slideUp(200);
//         }
//     });
// });
import NavBarHome from "@/components/NavBarHome.vue";
import BannerHome from "@/components/BannerHome.vue";
import Statistic from "@/components/Statistic.vue";
import Sale from "@/components/Sale.vue";
import ListHotCats from "@/components/ListHotCats.vue";
import ListCourseCard from "@/components/ListCourseCard.vue";
import ListFamousTeacher from "@/components/ListFamousTeacher.vue";

import { mapActions } from "vuex";

export default {
  name: "home",
  components: {
    BannerHome,
    Statistic,
    Sale,
    ListHotCats,
    ListCourseCard,
    ListFamousTeacher
  },
  methods: {
    ...mapActions(["init"])
  },
  mounted() {
    this.init();
  }
};
</script>

