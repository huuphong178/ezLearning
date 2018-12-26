<template>
 <div class="show-off">
        <div class="row">
            <div class="col-sm">
                <img src="icons/show-off-courses.png" width="58px" style="float: left; margin-right: 20px;">
                <div>
                    <span class="show-off-number">
                        {{statistic.sumcourse}}+
                    </span>
                    <br>
                    Khóa học
                </div>
            </div>
            <div class="col-sm">
                <img src="icons/show-off-students.png" width="58px" style="float: left; margin-right: 20px;">
                <div>
                    <span class="show-off-number">
                        {{statistic.sumstudent}}+
                    </span>
                    <br>
                    Học viên
                </div>
            </div>
            <div class="col-sm">
                <img src="icons/show-off-teachers.png" width="58px" style="float: left; margin-right: 20px;">
                <div>
                    <span class="show-off-number">
                        {{statistic.sumteacher}}+
                    </span>
                    <br>
                    Giảng viên
                </div>
            </div>
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
    ...mapState(["statistic"])
  }
};
</script>
