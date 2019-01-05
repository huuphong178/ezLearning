<template>
  <div>
    <!--Modal-->
    <div
      id="modal-template"
      class="modal-backdrop"
      style="background-color: rgba(0,0,0,0.25); display: none;"
    >
      <div class="modal" role="dialog" style="display: block; padding-top: 25px;">
        <div class="modal-dialog" role="document" style="width: 430px;">
          <div
            class="modal-content modal-style"
            style="position: relative; border: none !important; border-radius: 10px;"
          >
            <div class="modal-padding" style="text-align: center;">
              <img
                id="tmodal-close"
                src="/icons/modal-close.png"
                width="13px"
                style="position: absolute; float: right; cursor: pointer; right: 30px;"
              >
              <img
                id="tmodal-success"
                src="/icons/modal-success.png"
                width="47px"
                style="display: none; margin-bottom: 10px;"
              >
              <img
                id="tmodal-failure"
                src="/icons/modal-failure.png"
                width="47px"
                style="display: none; margin-bottom: 10px;"
              >
              <div class="tmodal-title"></div>
              <div class="tmodal-msg"></div>
            </div>
            <div id="addon" class="dropdown-addon tmodal-addon" style="display:none;">
              <router-link :to="`/profile-student/${user.role}?${user.name}`">
                <span id="addon-text"></span>
              </router-link>
              <img
                id="allcats"
                src="/icons/all-cats.png"
                width="15px"
                style="margin-top: 3px; float: right"
              >
            </div>
          </div>
        </div>
      </div>
    </div>

    <div style="height: 60px; content: ''"></div>

    <div class="container">
      <!--Title-->
      <div class="page-title">Thanh toán</div>

      <!--Content-->
      <div id="order-content">
        <!--Cart-->
        <div class="co-section-title">Giỏ hàng</div>
        <div style="margin-top: -20px;">
          <div class="row">
            <div class="col-sm-8">
              <div v-for="cartItem in cart" :key="cartItem.id">
                <CartItem v-bind:cartItem="cartItem"/>
              </div>
            </div>
            <div class="col-sm-4">
              <TotalBill/>
            </div>
          </div>
        </div>

        <!--Payment Methods-->
        <div class="co-section-title" style="margin-top: 50px;">Phương thức thanh toán</div>
        <div>
          <ul class="methods">
            <li class="method-item enabled">
              <img src="/imgs/methods/napas.png">
            </li>
            <li class="method-item disabled">
              <img src="/imgs/methods/visa.png">
            </li>
            <li class="method-item disabled" style="padding-top: 20px;">
              <img src="/imgs/methods/mastercard.png">
            </li>
          </ul>
        </div>
        <div
          class="box-content"
          style="margin-top: 0px; padding-left: 100px; padding-right: 100px; margin-bottom: 25px;"
        >
          <div class="containter">
            <div class="row">
              <div class="col-sm-6" style="padding-right: 50px;">
                <label class="label-normal">Ngân hàng</label>
                <div>
                  <select class="select-custom">
                    <option value="0">Chọn ngân hàng:</option>
                    <option value="1">Sacombank</option>
                    <option value="2">ViettinBank</option>
                    <option value="3">VietcomBank</option>
                    <option value="4">Agribank</option>
                    <option value="5">EximBank</option>
                    <option value="6">ACB</option>
                    <option value="7">ShinhanBank</option>
                    <option value="8">SCB</option>
                    <option value="9">TPBank</option>
                    <option value="10">VPBank</option>
                  </select>
                </div>
              </div>
              <div class="col-sm-6" style="padding-left: 50px;">
                <label class="label-normal">Số tài khoản</label>
                <input class="input-normal" type="text" placeholder="Nhập số tài khoản">
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6" style="padding-right: 50px;">
                <label class="label-normal">Tên chủ thẻ</label>
                <input class="input-normal" type="text" placeholder="Nhập tên chủ thẻ">
              </div>
              <div class="col-sm-6" style="padding-left: 50px;">
                <label class="label-normal">Mật khẩu</label>
                <input class="input-normal" type="password" placeholder="Nhập mật khẩu">
                <label style="font-weight: bold; font-size: 14px; color: #888;">
                  Chúng tôi cam kết không lưu
                  mật khẩu thẻ của bạn
                </label>
              </div>
            </div>
          </div>
        </div>
        <div style="width: 100%; text-align: center; margin-bottom: 35px;">
          <button
            v-on:click="CheckoutNotice()"
            id="checkout-submit"
            class="big-button"
            style="width: 350px; margin-top: 15px;"
          >THANH TOÁN</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CartItem from "@/components/CartItem.vue";
import TotalBill from "@/components/TotalBill.vue";
import { mapState } from "vuex";

export default {
  components: {
    CartItem,
    TotalBill
  },
  computed: {
    ...mapState(["cart"]),
    ...mapState(["user"]),
  },
  methods: {
    CheckoutNotice() {
      this.$store.dispatch("deleteCart");
      function tmodalAction(iconToggle, title, msg, addonToggle, addonText) {
        //iconToggle: 1 - hiện icon thành công, 0 - hiện icon thất bại, khác - không hiện
        //title: tiêu đề thông báo
        //msg: nội dung thông báo
        //addonToggle: 1 - hiện link dẫn đến trang khác (như Tất cả khóa học), khác - không hiện
        //addon Text: nội dung link nếu addonToggle == 1

        var modal = $("#modal-template");
        modal.find(".tmodal-title").html(title);
        modal.find(".tmodal-msg").html(msg);
        if (iconToggle == 0) {
          modal.find("#tmodal-failure").show();
        } else if (iconToggle == 1) {
          modal.find("#tmodal-success").show();
        }
        if (addonToggle == 1) {
          modal.find("#addon").show();
          modal.find("#addon-text").html(addonText);
        }
        modal.fadeIn();
        modal.find("#tmodal-close").click(function() {
          modal.fadeOut();
        });
      }

      tmodalAction(
        1,
        "Thanh toán thành công",
        "Bạn đã thanh toán thành công khóa học",
        1,
        "Xem đơn hàng"
      );
    }
  }
};
</script>

