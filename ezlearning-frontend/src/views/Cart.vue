<template>
  <div>
    <div style="height: 60px; content: ''"></div>
    <div v-if="cart.length <= 0">Không có sản phẩm nào trong giỏ hàng
      <router-link to="/">
        <button>Mua sắm ngay</button>
      </router-link>
    </div>
    <div v-if="cart.length > 0">
      <div class="container">
        <!--Title-->
        <div class="page-title">Giỏ hàng</div>

        <!--Content-->
        <div id="order-content">
          <!--Cart-->
          <div class="co-section-title">Giỏ hàng</div>

          <div style="margin-top: -20px;">
            <div class="row">
              <div class="col-sm-8">
                <CartItem/>

                <!--Voucher-->
                <div
                  class="box-content"
                  style="padding: 15px 20px !important; margin-bottom: 50px;"
                >
                  <div class="row">
                    <div class="col-sm-6 voucher-tit">Mã khuyến mãi</div>
                    <div class="col-sm-6" style="text-align: right;">
                      <input class="input-small" type="text" style="width: 65%;">
                      <button class="small-btn" style="margin-left: 10px;">Nhập</button>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-sm-4">
                <div class="box-content" style="padding: 20px 30px 10px 30px !important;">
                  <div class="row">
                    <div class="col-sm-6">
                      <div class="order-id">Tổng hóa đơn</div>
                    </div>
                    <div class="col-sm-6 text-right">
                      <div class="order-o-price">599,000</div>
                      <div class="order-discount">0</div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-12 text-right">
                      <div class="order-price">599,000</div>
                    </div>
                  </div>
                </div>
                <div style="width: 100%; text-align: center; margin-bottom: 20px;">
                  <button
                    id="checkout-submit"
                    class="big-button"
                    style="width: 100%; margin-top: 15px;">
                    THANH TOÁN
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CartItem from "@/components/CartItem.vue";
import { mapState } from "vuex";

export default {
  components: {
    CartItem
  },
  computed: {
    ...mapState(["cart"])
  }
};
</script>
