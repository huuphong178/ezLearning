<template>
  <div style="position: relative;">
    <!-- <NavBarHome/> -->
     <div style="height: 60px; content: ''"></div>
     <div class="big-banner">
        <div class="container">
           <BannerHome/>
        </div>
     </div> 
   
    <Statistic/>
    <div class="container" style="padding-top: 90px; margin-bottom: 50px;">
      <Sale/>

      <ListHotCats/>

      <ListCourseCard sectionTitle="Phổ biến" v-bind:listCourse="listCoursePopular"/>
      <ListCourseCard sectionTitle="Được đánh giá cao" v-bind:listCourse="listHighRatingCourse"/>
      <ListCourseCard sectionTitle="Mới nhất" v-bind:listCourse="listNewCourse"/>

      <ListFamousTeacher/>
    </div>
    
  </div>
</template>

<script>

import NavBarHome from "@/components/NavBarHome.vue";
import BannerHome from "@/components/BannerHome.vue";
import Statistic from "@/components/Statistic.vue";
import Sale from "@/components/Sale.vue";
import ListHotCats from "@/components/ListHotCats.vue";
import ListCourseCard from "@/components/ListCourseCard.vue";
import ListFamousTeacher from "@/components/ListFamousTeacher.vue";

import { mapState, mapActions } from "vuex";

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
  computed: {
    ...mapState(["listCoursePopular"]),
    ...mapState(["listHighRatingCourse"]),
    ...mapState(["listNewCourse"])
  },
  methods: {
    ...mapActions(["init"])
  },
  mounted() {
    this.init();
  }
};
</script>

