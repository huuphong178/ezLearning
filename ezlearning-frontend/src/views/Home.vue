<template>
  <div style="position: relative;">
    <NavBarGeneral/>
    <NavBarHome/>
    <!-- <BannerHome/> -->
    <Statistic/>
    <div class="container" style="margin-top: 90px; margin-bottom: 50px;">
      <Sale/>
      <ListCourseCard sectionTitle="Phổ biến"/>
      <ListCourseCard sectionTitle="Được đánh giá cao"/>
      <ListCourseCard sectionTitle="Mới nhất"/>
    </div>
    <!-- <ListCats/>
    <Footer/>-->
  </div>
</template>

<script>
// @ is an alias to /src
import NavBarHome from "@/components/NavBarHome.vue";
import NavBarGeneral from "@/components/NavBarGeneral.vue";
import BannerHome from "@/components/BannerHome.vue";
import Statistic from "@/components/Statistic.vue";
import Sale from "@/components/Sale.vue";
import ListCats from "@/components/ListCats.vue";
import Footer from "@/components/Footer.vue";
import ListCourseCard from "@/components/ListCourseCard.vue";

import { mapActions } from "vuex";

export default {
  name: "home",
  components: {
    NavBarHome,
    NavBarGeneral,
    BannerHome,
    Statistic,
    Sale,
    ListCats,
    Footer,
    ListCourseCard
  },
  methods: {
    ...mapActions(["init"])
  },
  mounted() {
    this.init();
  }
};
</script>
