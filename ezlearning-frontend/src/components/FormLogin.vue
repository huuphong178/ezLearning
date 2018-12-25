<template>
  <div id="su-si-modal" class="modal-backdrop" style="background-color: rgba(0,0,0,0.25)">
    <div class="modal" role="dialog" style="display: block; padding-top: 25px;">
      <div class="modal-dialog" role="document" style="width: 430px;">
        <div
          class="modal-content modal-style"
          style="border: none !important; border-radius: 10px;"
        >
          <div class="modal-top">
            <div class="modal-top-tab" style="width: 80%;">
              <div @click="signUpModal()" id="sign-up-tab" class="modal-tab-item active" style="float: left">Đăng ký</div>
              <div @click="signInModal()"
                id="sign-in-tab"
                class="modal-tab-item"
                style="float: left; margin-left: 10px;"
              >Đăng nhập</div>
            </div>
            <img
              v-on:click="CloseSignInForm()"
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
                <input class="input-normal" type="text" v-model="dataSignUp.username">
              </div>
              <div>
                <label class="label-normal">Email hoặc Số điện thoại</label>
                <input class="input-normal" type="text" v-model="dataSignUp.phone">
              </div>
              <div>
                <label class="label-normal">Mật khẩu</label>
                <input class="input-normal" type="password" v-model="dataSignUp.password">
              </div>
              <div id="su-warn" class="form-warning" style="display: none;"></div>
              <button
                id="sign-up-submit"
                class="big-button"
                style="width: 100%; margin-top: 15px;"
                v-on:click="signUp(dataSignUp)"
              >Tạo tài khoản</button>
            </div>
            <div class="sign-up-policy">
              Bằng cách nhấn vào nút Đăng ký, bạn đã đồng ý với
              <a href="#">Điều khoản sử dụng</a> và
              <a href="#">
                Chính sách bảo
                mật
              </a> của chúng tôi
            </div>
            <p>hoặc</p>
            <button
              class="big-button fb-sign-up"
              style="width: 100%;"
              v-on:click="SignUpFacebook()"
            >
              <img src="/icons/fb-sign-up.png" width="7px" style="margin-right: 20px;">
              Đăng ký bằng Facebook
            </button>
          </div>
          <div id="sign-in-modal" class="modal-main" style="display: none;">
            <p class="modal-instruction">Chào mừng trở lại</p>
            <div id="sign-up-form" class="modal-form">
              <div>
                <label class="label-normal">Email hoặc Số điện thoại</label>
                <input class="input-normal" type="text" v-model="dataSignIn.username">
              </div>
              <div>
                <label class="label-normal">Mật khẩu</label>
                <input class="input-normal" type="password" v-model="dataSignIn.password">
              </div>
              <div id="si-warn" class="form-warning" style="display: none;"></div>
              <button
                id="sign-in-submit"
                class="big-button"
                style="width: 100%; margin-top: 15px;"
                v-on:click="signIn(dataSignIn)"
              >ĐĂNG NHẬP</button>
            </div>
            <p style="margin-top: 15px;">hoặc</p>
            <button class="big-button fb-sign-up" style="width: 100%;">
              <img
                src="/icons/fb-sign-up.png"
                width="7px"
                style="margin-right: 20px;"
                v-on:click="SignInFacebook()"
              >
              Đăng nhập bằng Facebook
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";

export default {
name: "FormLogin",
  data() {
    return {
      query: "",
      dataSignIn: {},
      dataSignUp: {}
    };
  },
  computed: {
    ...mapState(["signInSuccess"])
  },
  methods: {
    ...mapActions(["signUp"]),
    
    signIn(dataSignIn){
      this.$store.dispatch("signIn", dataSignIn);
    },
    signInModal() {
    this.$jQuery("#sign-up-modal").hide();
    this.$jQuery("#sign-in-modal").show();
    this.$jQuery("#sign-up-tab").removeClass("active");
    this.$jQuery("#sign-in-tab").addClass("active");
    },

    signUpModal() {
    this.$jQuery("#sign-up-modal").show();
    this.$jQuery("#sign-in-modal").hide();
    this.$jQuery("#sign-in-tab").removeClass("active");
    this.$jQuery("#sign-up-tab").addClass("active");
    },

    SignInFacebook() {},
    SignUpFacebook() {},

    CloseSignInForm() {
      document.getElementById("si-warn").style.display = "none";
      document.getElementById("su-warn").style.display = "none";

      this.dataSignIn = {};
      this.dataSignUp = {};
      this.$store.dispatch("setIsLogged", false);
    }
  },
};
</script>