<template>
  <div id="hot-cats">
    <div style="margin-bottom: 10px;">
      <span class="section-title">Danh mục hot</span>
      <button class="button-white-small" style="float: right;">Xem thêm</button>
    </div>
    <div class="hot-cats-container">
      <router-link :to="`/search/Ngoại ngữ`">
        <div class="hot-cats lang">
          <img src="icons/hot-cats/lang.png" width="41px" style="margin-bottom: 5px;">
          <br>Ngoại ngữ
        </div>
      </router-link>

      <router-link :to="`/search/Marketing`">
        <div class="hot-cats marketing">
          <img src="icons/hot-cats/marketing.png" width="32px" style="margin-bottom: 5px;">
          <br>Marketing
        </div>
      </router-link>

      <router-link :to="`/search/Kinh doanh`">
        <div class="hot-cats business">
          <img src="icons/hot-cats/business.png" width="34px" style="margin-bottom: 5px;">
          <br>Kinh doanh
        </div>
      </router-link>

      <router-link :to="`/search/Phát triển cá nhân`">
        <div class="hot-cats personal">
          <img src="icons/hot-cats/personal.png" width="32px" style="margin-bottom: 5px;">
          <br>Phát triển cá nhân
        </div>
      </router-link>

      <router-link :to="`/search/Đồ họa`">
        <div class="hot-cats design">
          <img src="icons/hot-cats/design.png" width="28px" style="margin-bottom: 5px;">
          <br>Đồ họa
        </div>
      </router-link>

      <router-link :to="`/search/Lập trình`">
        <div class="hot-cats programming">
          <img src="icons/hot-cats/programming.png" width="32px" style="margin-bottom: 5px;">
          <br>Lập trình
        </div>
      </router-link>
    </div>
  </div>
</template>