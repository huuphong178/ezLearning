<template>
<div>
    <!-- <div v-for="course in courseBanner" :key="course.id"> -->
    <img src="/pics/banner.png" alt="">
        <!-- <div>
            {{course.catName}}
        </div>
        <div>
            {{course.courseName}}
        </div>
        <div>
            <img src="/pics/teacher.png" alt="" style="display:inline-block">   
            <div style="display:inline-block">{{course.teacherName}}</div>
        </div>
        <button>ĐĂNG KÝ NGAY</button>
    </div> -->
</div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  data() {
    return {

    }
  },
  computed: {
    ...mapState(['courseBanner'])
  }
};
</script>