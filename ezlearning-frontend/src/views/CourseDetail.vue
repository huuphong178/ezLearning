<template>
  <div style="position: relative">
    <!-- <div v-if="notLogged === true">
        <FormLogin/>
    </div> -->

    <div style="height: 60px; content: ''"></div>

    <!--Cover-->
    <div>
      <div class="course-cover-container">
        <div class="course-cover-info">
          <div class="container">
            <div class="row">
              <div class="col-sm-8">
                <span class="course-cover-title">Nhập môn ngôn ngữ lập trình Javascript</span>
              </div>
              <div class="col-sm-4 text-right align-bottom">
                <div class="course-cover-oi">
                  <div>241 học viên</div>
                  <div>
                    <span>
                      <img src="/icons/ratings/rate-full-white.png" width="18px">
                      <img src="/icons/ratings/rate-full-white.png" width="18px">
                      <img src="/icons/ratings/rate-full-white.png" width="18px">
                      <img src="/icons/ratings/rate-half-white.png" width="18px">
                      <img src="/icons/ratings/rate-outline-white.png" width="18px">
                    </span>
                    <span style="float: right; margin-left: 10px;">(07)</span>
                  </div>
                  <div>
                    <div style="display: inline-block;">
                      <img src="/imgs/teachers/teacher3.png" class="course-cover-ava">
                    </div>
                    <span style="margin-left: 10px;">Phan Văn Luân</span>
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
          <div class="col-sm-3 payment-tab">
            <img src="/icons/course-detail/payment.png" width="22px" class="tab-icon">
            Thanh toán
          </div>
        </div>
      </div>
    </div>

    <!--Payment-->
    <div id="payment" class="container course-detail">
      <div class="row">
        <div class="col-sm-9"></div>

        <div class="col-sm-3" style="padding-left: 0px; padding-right: 0px; right: 0px;">
          <div class="box-content" style="padding: 30px;">
            <div class="cover-content">
              <img src="/imgs/courses/course5.png" class="cover-content-img">
            </div>
            <div class="price-sections">
              <div style="float: left; padding-top: 10px;">
                <img src="/icons/course-detail/payment-color.png" width="22px">
              </div>
              <div class="course-price">599,000 đ</div>
            </div>
            <div class="price-sections discount-section-seperator" style="margin-top: 50px;">
              <div class="discount-title">Mã khuyến mãi</div>
              <div style="margin-top: 10px">
                <input class="input-small" type="text" style="width: 65%;">
                <button class="small-btn" style="margin-left: 10px;">Nhập</button>
              </div>
            </div>
            <div class="add-to-cart">THÊM VÀO GIỎ</div>
          </div>
          <div class="box-content course-addinfo" style="margin-top: 15px;">
            <div class="container" style="padding: 0px">
              <div class="row">
                <div class="col-sm-6">
                  <img src="/icons/course-detail/cat.png" width="16px" style="margin-right: 10px">
                  <span class="course-addin-title">Thể loại</span>
                </div>
                <div class="col-sm-6 text-right">Lập trình</div>
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

    <!--Content-->
    <div id="content" class="container course-detail">
      <div class="row">
        <div class="col-sm-9" style="padding-left: 0px; padding-right: 25px;">
          <!--Info-->
          <div id="info" class="box-content">
            <div class="tab-content-title">Thông tin chung</div>
            <div>
              Nếu như vài năm trước đây JavaScript chỉ là một ngôn ngữ lập trình ít người quan tâm thì
              gần
              đây cùng với sự phát triển mạnh mẽ của HTML5, Boostrap, NodeJs đã biến JavaScript thành một
              trong 2 ngôn ngữ lập trình, thiết kế web quan trọng nhất. Do vậy, nắm rõ về JavaScript sẽ
              giúp
              bạn có lợi thế lớn trong công việc.
              <br>
              <br>Hiểu được nhu cầu tìm hiểu về JavaScript ngày càng lớn hiện nay, tôi cùng Edumall đã hợp
              tác
              sản suất khóa học "Một giờ học JavaScript" nhằm giúp các bạn nắm được kiến thức và lập
              trình
              được các chương trình cơ bản chỉ trong 1 giờ.
              <br>
              <br>Không chỉ cung cấp lý thuyết, khóa học còn mang đến cơ hội thực hành bằng cách hướng
              dẫn
              bạn tạo ra project, lưu file và xử lý biến. Sau khi hoàn thành khóa học các bạn sẽ:
              <br>
              <br>+ Tự lập trình được các ứng dụng cơ bản trong thời gian ngắn.
              <br>
              <br>+ Được trang bị một nền tảng kiến thức cơ bản vững chắc về JavaScript.
              <br>
              <br>+ Thành thạo sử dụng các công cụ cơ bản của JavaScript.
              <br>
              <br>Công nghệ thay đổi từng ngày, đừng chờ đợi rồi đi sau xu thế, hãy nắm lấy cơ hội và tham
              gia
              cùng tôi ngay hôm nay.
            </div>
          </div>

          <!--Lecture-->
          <div id="lecture" class="box-content">
            <div class="tab-content-title">Giáo trình</div>
            <div class="row" style="margin-bottom: 15px;">
              <div class="col-sm-10 chapter-title"></div>
              <div class="col-sm-2">
                <span class="lecture-count" style="color: #000">24 bài</span>
              </div>
            </div>
            <div class="chapter">
              <div class="row">
                <div class="col-sm-10 chapter-title">Phần 1: Tìm hiểu về Javascript</div>
                <div class="col-sm-2">
                  <span class="lecture-count">15 bài</span>
                  <img
                    src="/icons/course-detail/lecture-expand.png"
                    width="17px"
                    class="chapter-expand"
                  >
                </div>
              </div>
            </div>
            <div class="chapter">
              <div class="row">
                <div class="col-sm-10 chapter-title">Phần 2: Tương tác cơ bản với web</div>
                <div class="col-sm-2">
                  <span class="lecture-count">16 bài</span>
                  <img
                    src="/icons/course-detail/lecture-expand.png"
                    width="17px"
                    class="chapter-expand"
                  >
                </div>
              </div>
            </div>
            <div class="chapter">
              <div class="row">
                <div class="col-sm-10 chapter-title">Phần 3: Thực hành làm ứng dụng nhỏ</div>
                <div class="col-sm-2">
                  <span class="lecture-count">2 bài</span>
                  <img
                    src="/icons/course-detail/lecture-expand.png"
                    width="17px"
                    class="flip chapter-expand"
                  >
                </div>
              </div>
              <!-- thay v-for -->
              <div class="lecture">
                <router-link to="/lecture/2?1">
                  <img src="/icons/course-detail/lecture-play.png" width="30px">
                  <span class="lecture-title">Bài 22: Project: Lời hay ý đẹp</span>
                </router-link>
              </div>
              <div class="lecture">
                <img src="/icons/course-detail/lecture-play.png" width="30px">
                <span class="lecture-title">Bài 23: Project: Quản lý To-do</span>
              </div>
            </div>
            <div class="chapter">
              <div class="row">
                <div class="col-sm-10 chapter-title">Phần 4: Tổng kết</div>
                <div class="col-sm-2">
                  <span class="lecture-count">1 bài</span>
                  <img
                    src="/icons/course-detail/lecture-expand.png"
                    width="17px"
                    class="chapter-expand"
                  >
                </div>
              </div>
            </div>
          </div>

          <!--Teacher-->
          <div id="teacher" class="box-content">
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
                      <div class="teacher-name">Phan Văn Luân</div>
                      <div>
                        <img src="/icons/ratings/rate-full.png" width="18px">
                        <img src="/icons/ratings/rate-full.png" width="18px">
                        <img src="/icons/ratings/rate-full.png" width="18px">
                        <img src="/icons/ratings/rate-full.png" width="18px">
                        <img src="/icons/ratings/rate-outline.png" width="18px">
                        <span class="teacher-rate-count">(07)</span>
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
              Thầy Phan Văn Luân đã từng làm việc tại FPT với vai trò technical leader, đồng thời là
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
          <div id="rating" class="box-content">
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
                      <img src="/icons/ratings/rate-full.png" width="22px" style="margin: 0px 5px">
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
                      <img src="/icons/ratings/rate-full.png" width="22px" style="margin: 0px 5px">
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
                      <img src="/icons/ratings/rate-full.png" width="22px" style="margin: 0px 5px">
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
                      <img src="/icons/ratings/rate-full.png" width="22px" style="margin: 0px 5px">
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
                      <img src="/icons/ratings/rate-full.png" width="22px" style="margin: 0px 5px">
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
</template>

<script>
// import * as query from "../assets/course-detail.js";
import { mapState } from "vuex";
import FormLogin from "@/components/FormLogin.vue"

export default {
  data() {
    return {
      notLogged: false
    }
  },
  components:{
    FormLogin
  },
  computed: {
    ...mapState(["user"])
  },
  beforeRouteLeave(to, from, next) {
    if (to.name == "Lecture") {
      if (this.user != null) {
        next();
      } else {
        this.notLogged = true;
      }
    }
  }
};
</script>