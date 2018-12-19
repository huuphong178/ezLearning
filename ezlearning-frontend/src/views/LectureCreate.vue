<template>
  <div>
    <div style="height: 60px; content: ''"></div>

    <div class="container">
      <!--Title-->
      <div class="page-title">
        Quản lý bài giảng
        <button
          id="checkout-submit"
          class="big-button"
          style="width: 150px; float: right"
        >Lưu</button>
      </div>

      <!--Content-->
      <div id="lecture-content">
        <div
          class="box-content"
          style="margin-top: 0px; padding-left: 100px; padding-right: 100px; margin-bottom: 25px;"
        >
          <div class="course-title">
            <div class="course-cat">Lập trình</div>Nhập môn ngôn ngữ lập trình Javascript
          </div>

          <!--Chapter list-->
          <div class="chapter-list">
            <div class="chapter container">
              <div class="row">
                <div class="col-sm-1">1</div>
                <div class="col-sm-9">Phần 1: Tìm hiểu về Javascript</div>
                <div class="col-sm-2" style="text-align: right">
                  <div>
                    <img src="/icons/lecture-create/add.png" width="15px" class="btn-img">
                    <img src="/icons/lecture-create/delete.png" width="16px" class="btn-img">
                    <img src="/icons/lecture-create/edit.png" width="15px" class="btn-img">
                  </div>
                </div>

                <div class="container">
                  <div class="row lecture">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-9">
                      <div class="row">
                        <div class="col-sm-1">
                          <img src="/icons/lecture-create/done.png" width="30px">
                        </div>
                        <div class="col-sm-11">
                          <span class="lecture-title">Bài 22: Project: Lời hay ý đẹp</span>
                        </div>
                      </div>
                    </div>
                    <div class="col-sm-2" style="text-align: right">
                      <img src="/icons/lecture-create/delete.png" width="16px" class="btn-img">
                      <img src="/icons/lecture-create/edit.png" width="15px" class="btn-img">
                    </div>
                  </div>
                  <div class="row lecture">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-9">
                      <div class="row">
                        <div class="col-sm-1"></div>
                        <div class="col-sm-11">
                          <div class="row">
                            <div class="col-sm-6">
                              <input
                                class="input-normal lecture-title"
                                type="text"
                                placeholder="Bài 22: Project: Lời hay ý đẹp"
                              >
                            </div>
                            <div class="col-sm-6">
                              <input type="file" id="upload-input" style="display:none;">
                              <label for="upload-input" id="custom-upload">
                                <span class="small-btn" style="padding: 8px 20px;">
                                  Chọn
                                  tệp
                                </span>
                                <span id="filename" style="margin-left: 15px; font-size: 14px;">
                                  Chưa
                                  chọn tệp
                                </span>
                              </label>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-sm-2" style="text-align: right">
                      <img src="/icons/lecture-create/delete.png" width="16px" class="btn-img">
                      <img src="/icons/lecture-create/edit.png" width="15px" class="btn-img">
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="chapter container">
              <div class="row">
                <div class="col-sm-1">
                  <input
                    class="input-small"
                    type="number"
                    placeholder="2"
                    style="width: 100% !important; text-align: center"
                  >
                </div>
                <div class="col-sm-6">
                  <input
                    class="input-small"
                    type="text"
                    placeholder="Phần 2: DEF"
                    style="width: 100% !important"
                  >
                </div>
                <div class="col-sm-3">
                  <button class="small-btn" style="margin-left: 10px;">Hoàn tất</button>
                </div>
                <div class="col-sm-2" style="text-align: right">
                  <div style="display: none;">
                    <img src="/icons/lecture-create/add.png" width="15px" class="btn-img">
                    <img src="/icons/lecture-create/delete.png" width="16px" class="btn-img">
                    <img src="/icons/lecture-create/edit.png" width="15px" class="btn-img">
                  </div>
                </div>
              </div>
            </div>

            <button class="small-btn" style="margin-left: 10px;">Thêm bài giảng</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
