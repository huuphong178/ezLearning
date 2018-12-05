<template>
  <div>
    <p>Khuyến mãi</p>
    <button>Xem thêm</button>
    <AdvertiseHome/>
    <CourseCard/>
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