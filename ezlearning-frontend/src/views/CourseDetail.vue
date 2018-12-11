<template>
  <div>
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
              <div class="col-sm-3 tab-enabled">
                <img src="/icons/course-detail/info.png" width="23px" class="tab-icon">
                Thông tin chung
              </div>
              <div class="col-sm-3 tab-disabled">
                <img src="/icons/course-detail/lecture.png" width="17px" class="tab-icon">
                Giáo trình
              </div>
              <div class="col-sm-3 tab-disabled">
                <img src="/icons/course-detail/teacher.png" width="19px" class="tab-icon">
                Giảng viên
              </div>
              <div class="col-sm-3 tab-disabled">
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
    <div id="payment" class="container course-detail" style>
      <div class="row">
        <div class="col-sm-9"></div>

        <div class="col-sm-3" style="padding-left: 0px; padding-right: 0px; right: 0px;">
          <div class="tab-content">
            <div class="cover-content">
              <img src="/imgs/courses/course5.png" class="cover-content-img">
            </div>
            <div>
              <div style="float: left; padding-top: 10px;">
                <img src="/icons/course-detail/payment-color.png" width="22px">
              </div>
              <div class="course-price">599,000 đ</div>
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
          <div class="tab-content">
            <div class="tab-content-title">Thông tin chung</div>
            <div>
              Nếu như vài năm trước đây JavaScript chỉ là một ngôn ngữ lập trình ít người quan tâm thì gần
              đây cùng với sự phát triển mạnh mẽ của HTML5, Boostrap, NodeJs đã biến JavaScript thành một
              trong 2 ngôn ngữ lập trình, thiết kế web quan trọng nhất. Do vậy, nắm rõ về JavaScript sẽ giúp
              bạn có lợi thế lớn trong công việc.
              <br>
              <br>Hiểu được nhu cầu tìm hiểu về JavaScript ngày càng lớn hiện nay, tôi cùng Edumall đã hợp tác
              sản suất khóa học "Một giờ học JavaScript" nhằm giúp các bạn nắm được kiến thức và lập trình
              được các chương trình cơ bản chỉ trong 1 giờ.
              <br>
              <br>Không chỉ cung cấp lý thuyết, khóa học còn mang đến cơ hội thực hành bằng cách hướng dẫn
              bạn tạo ra project, lưu file và xử lý biến. Sau khi hoàn thành khóa học các bạn sẽ:
              <br>
              <br>+ Tự lập trình được các ứng dụng cơ bản trong thời gian ngắn.
              <br>
              <br>+ Được trang bị một nền tảng kiến thức cơ bản vững chắc về JavaScript.
              <br>
              <br>+ Thành thạo sử dụng các công cụ cơ bản của JavaScript.
              <br>
              <br>Công nghệ thay đổi từng ngày, đừng chờ đợi rồi đi sau xu thế, hãy nắm lấy cơ hội và tham gia
              cùng tôi ngay hôm nay.
            </div>
          </div>

          <!--Lecture-->
          <div class="tab-content">
            <div class="tab-content-title">Thông tin chung</div>
            <div class="row" style="margin-bottom: 15px;">
              <div class="col-sm-10 parent-title"></div>
              <div class="col-sm-2">
                <span class="lecture-count" style="color: #000">24 bài</span>
              </div>
            </div>
            <div class="parent">
              <div class="row">
                <div class="col-sm-10 parent-title">Phần 1: Tìm hiểu về Javascript</div>
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
            <div class="parent">
              <div class="row">
                <div class="col-sm-10 parent-title">Phần 2: Tương tác cơ bản với web</div>
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
            <div class="parent">
              <div class="row">
                <div class="col-sm-10 parent-title">Phần 3: Thực hành làm ứng dụng nhỏ</div>
                <div class="col-sm-2">
                  <span class="lecture-count">2 bài</span>
                  <img
                    src="/icons/course-detail/lecture-expand.png"
                    width="17px"
                    class="flip chapter-expand"
                  >
                </div>
              </div>
              <div class="lecture">
                <img src="/icons/course-detail/lecture-play.png" width="30px">
                <span class="lecture-title">Bài 22: Project: Lời hay ý đẹp</span>
              </div>
              <div class="lecture">
                <img src="/icons/course-detail/lecture-play.png" width="30px">
                <span class="lecture-title">Bài 23: Project: Quản lý To-do</span>
              </div>
            </div>
            <div class="parent">
              <div class="row">
                <div class="col-sm-10 parent-title">Phần 4: Tổng kết</div>
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
        </div>
      </div>
    </div>
  </div>
</template>