<template>
  <div style="position: relative">
    <FormLogin v-if="user == null && notLogged"></FormLogin>

    <div style="height: 60px; content: ''"></div>

    <!--Cover-->
    <div>
      <div class="course-cover-container">
        <div class="course-cover-info">
          <div class="container">
            <div class="row">
              <div class="col-sm-8">
                <span class="course-cover-title">{{courseDetail.name}}</span>
              </div>
              <div class="col-sm-4 text-right align-bottom">
                <div class="course-cover-oi">
                  <!-- <div>241 học viên</div> -->
                  <div>
                    <img
                      src="/icons/ratings/rate-full-white.png"
                      width="18px"
                      v-for="item in +courseDetail.rating"
                      :key="item"
                    >
                    
                    <img
                      src="/icons/ratings/rate-outline-white.png"
                      width="18px"
                      v-for="item in (5 - +courseDetail.rating)"
                      :key="item"
                    >
                    <span>(0{{courseDetail.rating}})</span>
                  </div>
                  <div>
                    <div style="display: inline-block;">
                      <img src="/imgs/teachers/teacher3.png" class="course-cover-ava">
                    </div>
                    <span style="margin-left: 10px;">{{courseDetail.teachername}}</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="course-cover-overlay"></div>
        <img src="/imgs/courses/course5.png" class="course-cover-img">
      </div>
    </div>

    <!--Tab bar-->
    <div class="course-tab">
      <div class="container" style="height: 100%;">
        <div class="row" style="height: 100%;">
          <div class="col-sm-9">
            <div class="row" style="height: 100%; padding-right: 25px;">
              <div id="info-tab" class="col-sm-3 tab tab-enabled">
                <img src="/icons/course-detail/info.png" width="23px" class="tab-icon">
                Thông tin chung
              </div>
              <div id="lecture-tab" class="col-sm-3 tab tab-disabled">
                <img src="/icons/course-detail/lecture.png" width="17px" class="tab-icon">
                Giáo trình
              </div>
              <div id="teacher-tab" class="col-sm-3 tab tab-disabled">
                <img src="/icons/course-detail/teacher.png" width="19px" class="tab-icon">
                Giảng viên
              </div>
              <div id="rating-tab" class="col-sm-3 tab tab-disabled">
                <img src="/icons/course-detail/rates.png" width="21px" class="tab-icon">
                Đánh giá
              </div>
            </div>
          </div>
          <div class="col-sm-3 payment-tab" >
             <router-link to="/cart">
            <img src="/icons/course-detail/payment.png" width="22px" class="tab-icon">
            Thanh toán
             </router-link>
          </div>
        </div>
      </div>
    </div>

    <!--Payment-->
    <div id="payment" class="container course-detail">
      <div class="row">
        <div class="col-sm-9">
          <!--Content-->
          <div id="content" class="container course-detail">
            <div style="padding-left: 0px; padding-right: 25px;">
              <!--Info-->
              <div id="info" class="box-content">
                <div class="tab-content-title">Thông tin chung</div>
                <div>{{courseDetail.description}}</div>
              </div>

              <!--Lecture-->
              <div id="lecture" class="box-content">
                <div class="tab-content-title">Giáo trình</div>
                <div class="row" style="margin-bottom: 15px;">
                  <div class="col-sm-10 chapter-title"></div>
                </div>
                <div class="chapter" v-for="chapter in listLecture" :key="chapter.id">
                  <div class="row">
                    <div
                      class="col-sm-10 chapter-title"
                    >Phần {{chapter.chapter_order}}: {{chapter.name}}</div>
                    <div class="col-sm-2">
                      <span class="lecture-count">{{chapter.lecturelist.length}} bài</span>
                      <img
                        v-if="chapter.lecturelist.length > 0"
                        @click="ExpandLecture()"
                        id="expand"
                        src="/icons/course-detail/lecture-expand.png"
                        width="17px"
                        class="normal chapter-expand"
                      >
                    </div>
                  </div>

                  <div class="lecture" v-if="expand == true">
                    <div v-for="lecture in chapter.lecturelist" :key="lecture.id">
                      <router-link :to="`/lecture/${courseId}?${lecture.id}`">
                        <img src="/icons/course-detail/lecture-play.png" width="30px">
                        <span class="lecture-title">{{lecture.name}}</span>
                      </router-link>
                    </div>
                  </div>
                </div>

                <!--Teacher-->
                <div id="teacher" style="margin-bottom: 50px">
                  <div class="tab-content-title">Giảng viên</div>
                  <div class="teacher-info container">
                    <div class="row">
                      <div class="col-sm-3">
                        <img src="/imgs/teachers/teacher3.png" class="teacher-ava">
                      </div>
                      <div class="col-sm-9" style="margin-left: -30px;">
                        <div class="row">
                          <div class="col-sm-6" style="padding-top: 20px;">
                            <div class="teacher-title">Giảng viên</div>
                            <div class="teacher-name">{{courseDetail.teachername}}</div>
                            <div>
                              <img
                                src="/icons/ratings/rate-full.png"
                                width="18px"
                                v-for="item in +courseDetail.rating"
                                :key="item"
                              >
                              
                              <img
                                src="/icons/ratings/rate-outline.png"
                                width="18px"
                                v-for="item in (5 - +courseDetail.rating)"
                                :key="item"
                              >
                              <span>(0{{courseDetail.rating}})</span>
                            </div>
                          </div>
                          <div class="col-sm-6 info-seperator" style="padding-top: 20px;">
                            <p>
                              Học viên:
                              <span class="teacher-count">507</span>
                            </p>
                            <p>
                              Khóa học:
                              <span class="teacher-count">3</span>
                            </p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div>
                    Thầy đã từng làm việc tại với vai trò technical leader, đồng thời là
                    giảng
                    viên đào tạo các khóa fher của FOT.
                    <br>Làm việc tại LINE cũng là team leader đội phát triển ứng dụng Mobile.
                    <br>Là founder của trang web chuyên chia sẻ các kỹ năng lập trình web (website: laptrinh.io).
                    <br>Tham gia và các dự án mã nguồn mở trên thế giới liên quan tới các nền tảng framework như
                    Laravel, lonic, Framework, Codeconcept JS.
                    <br>Là một blogger về kỹ thuật chia sẻ hướng dẫn một số thủ thuật lập trình trên trang blog cá
                    nhân
                    (website: blog.petehouston.com).
                  </div>
                </div>

                <!--Rating-->
                <div id="rating" >
                  <div class="tab-content-title">Đánh giá</div>

                  <!--Rates-->
                  <div class="container">
                    <div class="row">
                      <div class="col-sm-5 rate-seperator" style="text-align: center;">
                        <div class="rate-avg">4.1</div>
                        <div>
                          <img
                            src="/icons/ratings/rate-full-large.png"
                            width="34px"
                            style="margin: 0px 3px 10px 3px;"
                          >
                          <img
                            src="/icons/ratings/rate-full-large.png"
                            width="34px"
                            style="margin: 0px 3px 10px 3px;"
                          >
                          <img
                            src="/icons/ratings/rate-full-large.png"
                            width="34px"
                            style="margin: 0px 3px 10px 3px;"
                          >
                          <img
                            src="/icons/ratings/rate-full-large.png"
                            width="34px"
                            style="margin: 0px 3px 10px 3px;"
                          >
                          <img
                            src="/icons/ratings/rate-outline-large.png"
                            width="34px"
                            style="margin: 0px 3px 10px 3px;"
                          >
                        </div>
                        <span class="rate-count">7 đánh giá</span>
                      </div>
                      <div class="col-sm-7" style="padding-left: 40px !important;">
                        <div id="5-star" class="row rate-detail">
                          <div class="col-sm-2" style="padding-right: 0px;">
                            5
                            <img
                              src="/icons/ratings/rate-full.png"
                              width="22px"
                              style="margin: 0px 5px"
                            >
                          </div>
                          <div class="col-sm-8" style="padding-top: 7px;">
                            <div class="rate-pipe-bg">
                              <div class="rate-pipe" style="width: 71.43%"></div>
                            </div>
                          </div>
                          <div class="col-sm-2">
                            <b>5</b>
                          </div>
                        </div>
                        <div id="4-star" class="row rate-detail">
                          <div class="col-sm-2" style="padding-right: 0px;">
                            4
                            <img
                              src="/icons/ratings/rate-full.png"
                              width="22px"
                              style="margin: 0px 5px"
                            >
                          </div>
                          <div class="col-sm-8" style="padding-top: 7px;">
                            <div class="rate-pipe-bg">
                              <div class="rate-pipe" style="width: 0%"></div>
                            </div>
                          </div>
                          <div class="col-sm-2">
                            <b>0</b>
                          </div>
                        </div>
                        <div id="3-star" class="row rate-detail">
                          <div class="col-sm-2" style="padding-right: 0px;">
                            3
                            <img
                              src="/icons/ratings/rate-full.png"
                              width="22px"
                              style="margin: 0px 5px"
                            >
                          </div>
                          <div class="col-sm-8" style="padding-top: 7px;">
                            <div class="rate-pipe-bg">
                              <div class="rate-pipe" style="width: 14.29%"></div>
                            </div>
                          </div>
                          <div class="col-sm-2">
                            <b>1</b>
                          </div>
                        </div>
                        <div id="2-star" class="row rate-detail">
                          <div class="col-sm-2" style="padding-right: 0px;">
                            2
                            <img
                              src="/icons/ratings/rate-full.png"
                              width="22px"
                              style="margin: 0px 5px"
                            >
                          </div>
                          <div class="col-sm-8" style="padding-top: 7px;">
                            <div class="rate-pipe-bg">
                              <div class="rate-pipe" style="width: 0%"></div>
                            </div>
                          </div>
                          <div class="col-sm-2">
                            <b>0</b>
                          </div>
                        </div>
                        <div id="1-star" class="row rate-detail">
                          <div class="col-sm-2" style="padding-right: 0px;">
                            1
                            <img
                              src="/icons/ratings/rate-full.png"
                              width="22px"
                              style="margin: 0px 5px"
                            >
                          </div>
                          <div class="col-sm-8" style="padding-top: 7px;">
                            <div class="rate-pipe-bg">
                              <div class="rate-pipe" style="width: 14.29%"></div>
                            </div>
                          </div>
                          <div class="col-sm-2">
                            <b>1</b>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>

                  <!--Comments-->
                  <div class="container comment-seperator">
                    <div class="row comment-margin">
                      <div class="col-sm-2">
                        <img src="/imgs/students/student2.png" class="rater-ava">
                      </div>
                      <div class="col-sm-10" style="margin-left: -20px !important;">
                        <div class="rater-name">Nguyễn Công Thành</div>
                        <div>
                          <img src="/icons/ratings/rate-full.png" width="20px">
                          <img src="/icons/ratings/rate-full.png" width="20px">
                          <img src="/icons/ratings/rate-full.png" width="20px">
                          <img src="/icons/ratings/rate-full.png" width="20px">
                          <img src="/icons/ratings/rate-outline.png" width="20px">
                        </div>
                        <div class="rater-cmt">
                          Bài giảng chất lượng, dễ hiểu, mong rằng thầy sẽ có nhiều bài giảng dạy nâng
                          cao
                          hơn nữa :v
                        </div>
                      </div>
                    </div>
                    <div class="row comment-margin">
                      <div class="col-sm-2">
                        <img src="/imgs/students/student1.png" class="rater-ava">
                      </div>
                      <div class="col-sm-10" style="margin-left: -20px !importa   nt;">
                        <div class="rater-name">Nguyễn Công Thành</div>
                        <div>
                          <img src="/icons/ratings/rate-full.png" width="20px">
                          <img src="/icons/ratings/rate-full.png" width="20px">
                          <img src="/icons/ratings/rate-full.png" width="20px">
                          <img src="/icons/ratings/rate-full.png" width="20px">
                          <img src="/icons/ratings/rate-outline.png" width="20px">
                        </div>
                        <div class="rater-cmt"></div>
                      </div>
                    </div>
                  </div>

                  <!--Your comment-->
                  <div class="container" style="padding: 0px; margin-top: -15px;">
                    <div class="your-comment-title">Đánh giá của bạn</div>
                    <div class="row comment-act">
                      <div class="col-sm-3 rate-star" style="padding-top: 5px;">
                        <img
                          id="rate-1"
                          class="rate-act"
                          src="/icons/ratings/rate-outline.png"
                          width="20px"
                        >
                        <img
                          id="rate-2"
                          class="rate-act"
                          src="/icons/ratings/rate-outline.png"
                          width="20px"
                        >
                        <img
                          id="rate-3"
                          class="rate-act"
                          src="/icons/ratings/rate-outline.png"
                          width="20px"
                        >
                        <img
                          id="rate-4"
                          class="rate-act"
                          src="/icons/ratings/rate-outline.png"
                          width="20px"
                        >
                        <img
                          id="rate-5"
                          class="rate-act"
                          src="/icons/ratings/rate-outline.png"
                          width="20px"
                        >
                      </div>
                      <div
                        class="col-sm-9"
                        style="padding:0px; margin-left: -40px !important; max-width: 80%; flex-basis: 80%;"
                      >
                        <input class="input-normal" type="text" style="width: 87%">
                        <button
                          id="rate-submit"
                          class="big-button"
                          style="height: 38px; margin-left: 15px;"
                        >Gửi</button>
                      </div>
                    </div>
                    <div class="re-rate">
                      Đã đánh giá vào ngày 12/12/2018.
                      <a>Đánh giá lại</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="col-sm-3" style="padding-left: 0px; padding-right: 0px; right: 0px;">
          <div class="box-content" style="padding: 30px;">
            <div class="cover-content">
              <img src="/imgs/courses/course5.png" class="cover-content-img">
            </div>
            <div class="price-sections">
              <div style="float: left; padding-top: 10px;">
                <img src="/icons/course-detail/payment-color.png" width="22px">
              </div>
              <div class="course-price" v-if="courseDetail.percentage == 0">{{courseDetail.price}}đ</div>
              <div class="course-price" v-if="courseDetail.percentage != 0">{{courseDetail.promotionalPrice}}đ</div>

            </div>
            <div class="price-sections discount-section-seperator" style="margin-top: 50px;">
              <div class="discount-title">Mã khuyến mãi</div>
              <div style="margin-top: 10px">
                <input class="input-small" type="text" style="width: 65%;">
                <button class="small-btn" style="margin-left: 10px;">Nhập</button>
              </div>
            </div>
            <div class="add-to-cart" @click="AddToCart(courseDetail, user)">THÊM VÀO GIỎ</div>
          </div>
          <div class="box-content course-addinfo" style="margin-top: 15px;">
            <div class="container" style="padding: 0px">
              <div class="row">
                <div class="col-sm-6">
                  <img src="/icons/course-detail/cat.png" width="16px" style="margin-right: 10px">
                  <span class="course-addin-title">Thể loại</span>
                </div>
                <div class="col-sm-6 text-right">{{courseDetail.catname}}</div>
              </div>
              <div class="row">
                <div class="col-sm-6">
                  <img
                    src="/icons/course-detail/lecture-count.png"
                    width="10px"
                    style="margin-right: 10px"
                  >
                  <span class="course-addin-title">Số bài học</span>
                </div>
                <div class="col-sm-6 text-right">24</div>
              </div>
              <div class="row">
                <div class="col-sm-6">
                  <img
                    src="/icons/course-detail/created-date.png"
                    width="14px"
                    style="margin-right: 10px"
                  >
                  <span class="course-addin-title">Ngày mở</span>
                </div>
                <div class="col-sm-6 text-right">15/11/2018</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import * as query from "../assets/course-detail.js";
import { mapState, mapActions } from "vuex";
import FormLogin from "@/components/FormLogin.vue";

export default {
  data() {
    return {
      courseId: "",
      expand: false
    };
  },
  components: {
    FormLogin
  },
  computed: {
    ...mapState(["user"]),
    ...mapState(["courseDetail"]),
    ...mapState(["listLecture"])
  },
  created() {
    this.courseId = this.$route.params.courseId;
    this.$store.dispatch("getCourseDetail", this.courseId);
    this.$store.dispatch("getLectures", this.courseId);
  },
  methods: {
    ExpandLecture() {
      if (this.$jQuery("#expand").hasClass("flip")) {
        this.$jQuery("#expand").removeClass("flip");
        this.expand = false;
      } else {
        this.$jQuery("#expand").addClass("flip");
        this.expand = true;
      }
    },
    AddToCart(course, user) {
      if (user != null) {
        this.$store.dispatch("addCart", course);
      } else {
         this.$store.dispatch("setIsLogged", true);
      }
    }
  },
  beforeRouteLeave(to, from, next) {
    if (to.name == "Lecture") {
      if (this.user != null) {
        next();
      } else {
        this.$store.dispatch("setIsLogged", true);
      }
    } else {
      next();
    }
  }
};
</script>