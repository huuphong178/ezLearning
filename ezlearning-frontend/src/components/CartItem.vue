<template>
  <div class="box-content cart-item">
    <div class="row">
      <div class="col-sm-4 no-padding">
        <div class="course-cover-cart">
          <img src="/imgs/courses/course5.png" class="course-cover-cart-img">
        </div>
      </div>
      <div class="col-sm-8 cart-item-info" style="padding-right: 0px">
        <div class="row">
          <div class="col-sm-11">
            <span class="cart-item-title">{{cartItem.name}}</span>
          </div>
          <div class="col-sm-1" v-on:click="DeleteItem(cartItem)">
            <img src="/icons/lecture-create/delete.png" width="16px" class="btn-img">
          </div>
        </div>
        <div class="row" style="margin-top: 5px; bottom: 0; width: 100%; position: absolute;">
          <div class="col-sm-6">
            <img src="/imgs/teachers/teacher2.png" class="cart-item-ava">
            <span class="cart-item-name">Phan Văn Luân</span>
          </div>
          <div class="col-sm-6 text-right no-padding">
            <span class="cart-item-price">599,000</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  props:{
    cartItem: {}
  },
  methods:{
    DeleteItem(cartItem){
      alert("Xóa khỏi giỏ hàng");
      this.$store.dispatch("removeCartItem", cartItem);
    }
  }
}
</script>
