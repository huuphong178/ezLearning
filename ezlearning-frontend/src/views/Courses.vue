<template>
  <div class="container" style="margin-top: 90px; margin-bottom: 50px;">
        <div id="vouchers">
            <div style="margin-bottom: 10px;">
                <span class="section-subTitle">Các khóa học thuộc</span> <br/>
                <span class="section-keyword">Tất cả khóa học</span>
            </div>
            <div class="tile-container">
               <CourseCard/>
            </div>
        </div>
    </div>
</template>

<script>
// @ is an alias to /src
import CourseCard from '@/components/CourseCard.vue'

import { mapActions } from 'vuex';

export default {
  name: 'home',
  components: {
    CourseCard
  }
}
</script>