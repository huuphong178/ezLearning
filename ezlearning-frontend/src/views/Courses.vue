<template>
<div style="position: relative;">
    <NavBarGeneral/>
  <div class="container" style="padding-top: 90px; margin-bottom: 50px;">
        <div id="vouchers">
            <div style="margin-bottom: 10px;">
                <span class="section-subTitle">Các khóa học thuộc</span> <br/>
                <span class="section-keyword">{{catId}}</span>
            </div>
            <div class="tile-container">
               <CourseCard/>
            </div>
        </div>
    </div>
    <Footer/>
    </div>
</template>

<script>
// @ is an alias to /src
import CourseCard from '@/components/CourseCard.vue'
import Footer from '@/components/Footer.vue'
import NavBarGeneral from '@/components/NavBarGeneral.vue'

import { mapActions } from 'vuex';

export default {
  name: 'home',
  data(){
      return{
          catId: ""
      }
  },
  components: {
    CourseCard,
    Footer,
    NavBarGeneral
  },
  created() {
      this.catId = this.$route.params.catId;
      alert(this.catId);
  }
}
</script>