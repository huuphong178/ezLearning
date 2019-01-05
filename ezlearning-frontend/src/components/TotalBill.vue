<template>
  <div class="box-content" style="padding: 20px 30px 10px 30px !important;">
    <div class="row">
      <div class="col-sm-6">
        <div class="order-id">Tổng hóa đơn</div>
      </div>
      <div class="col-sm-6 text-right">
        <div class="order-o-price">{{sum}}</div>
        <div class="order-discount">0</div>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-12 text-right">
        <div class="order-price">{{sum}}</div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  data() {
    return {
      sum: 0
    };
  },
  computed: {
    ...mapState(["cart"])
  },
  created() {
    var carts = this.$store.state.cart;
    carts.forEach(element => {
      if (element.percentage != 0) {
        this.sum += +element.promotionalPrice;
      } else {
        this.sum += +element.price;
      }
    });
    ////alert(this.sum);
  }
};
</script>