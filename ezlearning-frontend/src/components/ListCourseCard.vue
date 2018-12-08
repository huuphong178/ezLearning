<template>
    <div id="popular">
            <div style="margin-bottom: 10px;">
                <span class="section-title">{{sectionTitle}}</span>
            </div>
            <div style="position: relative; width: 100%">
                <div id="popular-left" class="arrow-white left">
                    <img src="icons/home-right.png" width="10px">
                </div>
                <div id="popular-right" class="arrow-white right">
                    <img src="icons/home-left.png" width="10px">
                </div>
            </div>
            <div style="width: 100%; padding: 5px; overflow: hidden;">
                <div id="popular-list" style="width: 200%;">
                    <div class="tile-container-long">
                       <CourseCard/>
                       <CourseCard/>
                       <CourseCard/>
                       <CourseCard/>
                       <CourseCard/>
                       <CourseCard/>
                       <CourseCard/>
                       <CourseCard/>
                    </div>
                </div>
            </div>

        </div>
</template>

<script>
import CourseCard from '@/components/CourseCard.vue'

export default {
  name: 'ListCourseCard',
   props:{
      sectionTitle: String
  },
  components: {
    CourseCard
  },
 
}
</script>
