<template>
  <div>
    <div class="navbar" style="width: 100%; position: fixed; z-index: 10">
      <div class="row" style="width: 100%">
        <div class="col-sm" style="width: 35%; margin-top: 3px;">
          <router-link to="/">
            <img src="/icons/logos/navbar.png" width="138px">
          </router-link>
          <span style="margin-left: 50px" id="nav-cats">
            Danh mục
            <img src="/icons/more-cat.png" width="11px" style="margin-left: 15px">
          </span>
          <div
            id="dropdown-cats"
            class="menu-dropdown"
            style="display: none; left: 75px; min-width: 350px !important;"
          >
            <div class="dropdown-content">
              <div class="dropdown">
                <ul class="split">
                  <div v-for="cat in catogaries" :key="cat.id">
                    <router-link :to="`/courses-by-cat/${cat.id}`">
                      <li>{{cat.name}}</li>
                    </router-link>
                  </div>
                </ul>
              </div>
            </div>
            <router-link :to="`/courses/all`">
              <div class="dropdown-addon">
                Tất cả khóa học
                <img
                  id="allcats"
                  src="/icons/all-cats.png"
                  width="15px"
                  style="margin-top: 3px; float: right"
                >
              </div>
            </router-link>
          </div>
        </div>
        <div class="col-sm" style="width: 40%; margin: auto;">
          <div class="search-box">
            <input type="text" placeholder="Tìm kiếm khóa học, giảng viên, ...">
            <img src="/icons/search.png" style="float: right; margin-top: 3px" width="13px">
          </div>
        </div>
        <div class="col-sm text-right" style="width: 40%; margin-top: 5px;">
          <span class="sign-in-btn">Đăng nhập</span>
          <span class="sign-up-btn" style="margin-left: 30px;">Đăng ký</span>
        </div>
      </div>
    </div>

    <!--Modal-->
    <div
      id="su-si-modal"
      class="modal-backdrop"
      style="background-color: rgba(0,0,0,0.25); display: none;"
    >
      <div class="modal" role="dialog" style="display: block; padding-top: 25px;">
        <div class="modal-dialog" role="document" style="width: 430px;">
          <div
            class="modal-content modal-style"
            style="border: none !important; border-radius: 10px;"
          >
            <div class="modal-top">
              <div class="modal-top-tab" style="width: 80%;">
                <div id="sign-up-tab" class="modal-tab-item active" style="float: left">Đăng ký</div>
                <div
                  id="sign-in-tab"
                  class="modal-tab-item"
                  style="float: left; margin-left: 10px;"
                >Đăng nhập</div>
              </div>
              <img
                id="su-si-close"
                src="/icons/modal-close.png"
                width="13px"
                style="float: right; margin-top: 23px; cursor: pointer;"
              >
            </div>
            <div id="sign-up-modal" class="modal-main">
              <p
                class="modal-instruction"
              >Đăng ký tài khoản để sở hữu những khóa học chất lượng trọn đời</p>
              <div id="sign-up-form" class="modal-form">
                <div>
                  <label class="label-normal">Họ tên</label>
                  <input class="input-normal" type="text">
                </div>
                <div>
                  <label class="label-normal">Email hoặc Số điện thoại</label>
                  <input class="input-normal" type="text">
                </div>
                <div>
                  <label class="label-normal">Mật khẩu</label>
                  <input class="input-normal" type="password">
                </div>
                <div id="su-warn" class="form-warning" style="display: none;"></div>
                <button
                  id="sign-up-submit"
                  class="big-button"
                  style="width: 100%; margin-top: 15px;"
                >Tạo tài khoản</button>
              </div>
              <div class="sign-up-policy">Bằng cách nhấn vào nút Đăng ký, bạn đã đồng ý với
                <a href="#">Điều khoản sử dụng</a> và
                <a href="#">
                  Chính sách bảo
                  mật
                </a> của chúng tôi
              </div>
              <p>hoặc</p>
              <button class="big-button fb-sign-up" style="width: 100%;">
                <img src="/icons/fb-sign-up.png" width="7px" style="margin-right: 20px;">
                Đăng ký bằng Facebook
              </button>
            </div>
            <div id="sign-in-modal" class="modal-main" style="display: none;">
              <p class="modal-instruction">Chào mừng trở lại</p>
              <div id="sign-up-form" class="modal-form">
                <div>
                  <label class="label-normal">Email hoặc Số điện thoại</label>
                  <input class="input-normal" type="text">
                </div>
                <div>
                  <label class="label-normal">Mật khẩu</label>
                  <input class="input-normal" type="password">
                </div>
                <div id="si-warn" class="form-warning" style="display: none;"></div>
                <button
                  id="sign-in-submit"
                  class="big-button"
                  style="width: 100%; margin-top: 15px;"
                >ĐĂNG NHẬP</button>
              </div>
              <p style="margin-top: 15px;">hoặc</p>
              <button class="big-button fb-sign-up" style="width: 100%;">
                <img src="/icons/fb-sign-up.png" width="7px" style="margin-right: 20px;">
                Đăng nhập bằng Facebook
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
$(document).ready(function() {
  $(".tile-course").hover(
    function() {
      $(this)
        .parent("div")
        .find(".tile-preview")
        .show();
    },
    function() {
      $(this)
        .parent("div")
        .find(".tile-preview")
        .hide();
    }
  );
});

import { mapState } from "vuex";

export default {
  data() {
    return {};
  },
  computed: {
    ...mapState(["catogaries"])
  },
  methods: {}
};
</script>
