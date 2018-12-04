<template>
  <div>
      <b-navbar toggleable="md" type="dark" variant="info">

    <!-- <b-navbar-toggle target="nav_collapse"></b-navbar-toggle> -->

    <b-navbar-brand href="#">EZLearning</b-navbar-brand>

    <b-collapse is-nav id="nav_collapse">

      <b-navbar-nav>
        <b-nav-item-dropdown text="Danh mục">
          <b-dropdown-item href="#">EN</b-dropdown-item>
          <b-dropdown-item href="#">ES</b-dropdown-item>
          <b-dropdown-item href="#">RU</b-dropdown-item>
          <b-dropdown-item href="#">FA</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>

       <b-nav-form>
          <b-form-input size="sm" class="mr-sm-4" type="text" placeholder="Tìm khóa học, giảng viên..."/>
          <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
        </b-nav-form>

    <b-navbar-nav class="ml-auto">
       <b-navbar-nav >
        <b-nav-item href="#">Đăng nhập</b-nav-item>
      </b-navbar-nav>

       <b-navbar-nav> 
        <b-nav-item href="#">Đăng ký</b-nav-item>
      </b-navbar-nav>
    </b-navbar-nav>


    </b-collapse>
  </b-navbar>
  </div>
</template>

<script>

export default {
  data(){
    return;
  }
}
</script>
