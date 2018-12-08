<template>
 <div>
        <div id="vouchers">
            <div style="margin-bottom: 10px;">
                <span class="section-title">Khuyến mãi</span>
                <button class="button-white-small" style="float: right;">Xem thêm</button>
            </div>
            <div class="tile-container">
              <AdvertiseHome/>
               <CourseCard/>
            </div>
        </div>
    </div>
</template>

<script>
// @ is an alias to /src
import CourseCard from '@/components/CourseCard.vue'
import AdvertiseHome from '@/components/AdvertiseHome.vue'

export default {
  name: 'home',
  components: {
    CourseCard,
    AdvertiseHome
  }
}
</script>