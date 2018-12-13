<template>
  <div style="height: 100%; position: relative;">
    <div class="tile-price" v-on:click="AddToCart(course)">
      <button class="price-button">149,500 đ</button>
    </div>
    <div class="tile tile-course">
    <router-link :to="`/course/${course.id}`">
      <div class="tile-preview">
        <div style="position: relative; height: 100%;">
          <div>
            <div class="tile-cat">Kế toán</div>
          </div>
          <div>
            <div>
              <img src="/icons/ratings/rate-full.png" width="18px">
              <img src="/icons/ratings/rate-full.png" width="18px">
              <img src="/icons/ratings/rate-full.png" width="18px">
              <img src="/icons/ratings/rate-full.png" width="18px">
              <img src="/icons/ratings/rate-outline.png" width="18px">
              <span>(04)</span>
            </div>
            <div class="tile-preview-name">Trọn bộ làm video và kỹ thuật AE</div>
            <div>
              <div
                class="tile-ava-container"
                style="float: left; margin-right: 15px; margin-top: 5px"
              >
                <img src="/imgs/teachers/teacher1.png" class="tile-ava-img">
              </div>
              <span>Trần Đình Dần (Master Trần)</span>
            </div>
            <div class="tile-preview-des">
              Dành cho những nhà làm marketing chuyên nghiệp bạn luôn phải cắt ghép nhân vật,
              hình ảnh và phông nền xanh. Khóa ...
            </div>
          </div>
        </div>
      </div>
      <div class="tile-info" style="background-color: rgba(0, 178, 203, 0.75);">
        <div style="position: relative; height: 100%;">
          <div>
            <div class="tile-discount" style="margin-bottom: 5px;">50%</div>
            <br>
            <div class="tile-cat">Kế toán</div>
          </div>
          <div style="bottom: 0; position: absolute;">
            <div>
              <img src="/icons/ratings/rate-full-white.png" width="18px">
              <img src="/icons/ratings/rate-full-white.png" width="18px">
              <img src="/icons/ratings/rate-full-white.png" width="18px">
              <img src="/icons/ratings/rate-full-white.png" width="18px">
              <img src="/icons/ratings/rate-outline-white.png" width="18px">
              <span>(04)</span>
            </div>
            <div class="tile-course-name">Trọn bộ làm video và kỹ thuật AE</div>
            <div>
              <div
                class="tile-ava-container"
                style="float: left; margin-right: 15px; margin-top: 5px"
              >
                <img src="/imgs/teachers/teacher1.png" class="tile-ava-img">
              </div>
              <span>Trần Đình Dần (Master Trần)</span>
            </div>
            <div>
              Giá cũ:
              <span class="tile-old-price">299,000 đ</span>
            </div>
          </div>
        </div>
      </div>
      <div>
        <img src="/imgs/courses/course1.png" class="tile-cover">
      </div>
      </router-link>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";

export default {
    props:{
        course: {}
    },
    methods:{
      AddToCart(course){
        this.$store.dispatch('addCart', course);
      }
    }
}
</script>

