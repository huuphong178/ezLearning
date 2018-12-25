<template>
<div>
    <div v-for="course in courseBanner" :key="course.id">
    <img src="/pics/banner.png" alt="">
        <div>
            {{course.catname}}
        </div>
        <div>
            {{course.coursename}}
        </div>
        <div>
            <img src="/pics/teacher.png" alt="" style="display:inline-block">   
            <div style="display:inline-block">{{course.teachername}}</div>
        </div>
        <button>ĐĂNG KÝ NGAY</button>
    </div>
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