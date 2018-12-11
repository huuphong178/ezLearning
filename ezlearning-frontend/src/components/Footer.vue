<template>
  <div class="footer">
    <div class="container">
      <div class="row">
        <div class="col-sm-3">
          <img src="/icons/logos/footer.png" width="155px">
        </div>
        <div class="col-sm-2" style="margin-left: 20px;">
          <div class="footer-section-title">Về EZLearning</div>
          <div>
            <ul>
              <li>Giới thiệu</li>
              <li>Điều khoản sử dụng</li>
              <li>Quy chế hoạt động</li>
              <li>Chính sách bảo mật</li>
              <li>Chăm sóc khách hàng</li>
            </ul>
          </div>
        </div>
        <div class="col-sm-4" style="margin-left: 20px;">
          <div class="footer-section-title">Danh mục</div>
          <div>
            <ul class="split">
              <div v-for="cat in catogaries" :key="cat.id">
                <li v-on:click="Catogaries(cat.id)">{{cat.name}}</li>
              </div>
            </ul>
          </div>
        </div>
        <div class="col-sm-2" style="margin-left: 20px;">
          <div class="footer-section-title">Liên hệ</div>
          <div>
            <ul>
              <li>Liên hệ</li>
              <li>Facebook</li>
              <li>Điều khoản người dùng</li>
              <li>Trở thành giảng viên</li>
            </ul>
          </div>
        </div>
      </div>
      <hr>
      <div style="width: 100%; text-align: center">@2018 EZLearning</div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  data() {
    return {};
  },
  computed: {
    ...mapState(["catogaries"])
  },
  methods: {
    Catogaries(catID) {
      this.$router.replace(`/courses/${catID}`);
    }
  }
};
</script>
