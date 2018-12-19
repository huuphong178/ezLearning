<template>
  <div>
    <div style="height: 60px; content: ''"></div>

    <div class="container">
      <!--Title-->
      <div class="page-title">Tạo khóa học
        <router-link to="/lecture-create">
          <button id="checkout-submit" class="big-button" style="width: 150px; float: right">TẠO</button>
        </router-link>
      </div>

      <!--Content-->
      <div id="course-content">
        <div
          class="box-content"
          style="margin-top: 0px; padding-left: 100px; padding-right: 100px; margin-bottom: 25px;"
        >
          <div class="containter">
            <div class="row">
              <div class="col-sm-6" style="padding-right: 50px;">
                <label class="label-normal">Danh mục</label>
                <div>
                  <select class="select-custom">
                    <option value="0">Chọn danh mục:</option>
                    <option v-for="cat in catogaries" :key="cat.id" value="1">{{cat.name}}</option>
                  </select>
                </div>
              </div>
              <div class="col-sm-6" style="padding-left: 50px;">
                <label class="label-normal">Tên khóa học</label>
                <input class="input-normal" type="text" placeholder="Nhập tên khóa học">
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6" style="padding-right: 50px;">
                <label class="label-normal">Giá</label>
                <input class="input-normal" type="text" placeholder="Nhập giá khóa học">
              </div>
              <div class="col-sm-6" style="padding-left: 50px;">
                <label class="label-normal">Cover</label>
                <input type="file" id="upload-input" style="display:none;">
                <label for="upload-input" id="custom-upload">
                  <span class="small-btn" style="padding: 10px 20px;">Chọn tệp</span>
                  <span id="filename" style="margin-left: 15px; font-size: 14px;">Chưa chọn tệp</span>
                </label>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-12">
                <label class="label-normal">Mô tả</label>
                <textarea
                  class="input-normal"
                  style="height: auto !important"
                  rows="2"
                  type="text"
                  placeholder="Nhập mô tả"
                ></textarea>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  computed: {
    ...mapState(["catogaries"])
  }
};
</script>
