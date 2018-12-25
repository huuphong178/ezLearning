<template>
  <div class="col-sm-8 no-padding">
    <div class="row" style="margin-top: 50px;">
      <div class="col-sm-3">
        <img src="/imgs/students/student2.png" class="profile-ava">
      </div>
      <div class="col-sm-9" style="padding-top: 30px;">
        <div class="profile-label" v-if="user.role == 3">Học sinh</div>
        <div class="profile-label" v-if="user.role == 2">Giảng viên</div>

        <div class="profile-name">{{user.username}}</div>
        <div class="course-count">5 khóa học</div>
      </div>
    </div>
    <div class="tab-group">
      <div class="row" style="height: 100%; width: 50%;">
        <div id="course-tab" class="col tab tab-enabled">
          <img src="/icons/profile/ur-course.png" width="18px" class="tab-icon">
          Khóa học của bạn
        </div>
        <div id="payment-tab" class="col tab tab-disabled">
          <img src="/icons/profile/paymen-history.png" width="18px" class="tab-icon">
          Lịch sử giao dịch
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  computed: {
    ...mapState(["user"])
  },
}
</script>
