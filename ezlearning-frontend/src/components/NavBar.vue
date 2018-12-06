<template>
  <div id="navbar">
      <b-navbar toggleable="md" type="dark" variant="info">

    <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

    <b-navbar-brand href="#">
      <router-link :to="'/home'">EZLearning</router-link>
      </b-navbar-brand>

    <b-collapse is-nav id="nav_collapse" class="row">

      <b-navbar-nav class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
        <b-nav-item-dropdown text="Danh mục">
          <div v-for="cat in catogaries" :key="cat.id">
          <b-dropdown-item href="#">{{cat.name}}</b-dropdown-item>
          </div>
        </b-nav-item-dropdown>
      </b-navbar-nav>

       <b-nav-form class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
          <b-form-input size="sm" class="mr-sm-2" type="text" placeholder="Tìm khóa học, giảng viên..."/>
          <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
        </b-nav-form>

    <b-navbar-nav class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
       <b-navbar-nav >
        <b-nav-item v-on:click="LogIn()">Đăng nhập</b-nav-item>
      </b-navbar-nav>
 
       <b-navbar-nav> 
        <b-nav-item v-on:click="Signup()">Đăng ký</b-nav-item>
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
  },
  methods: {
    LogIn(){
    },
    Signup(){

    }
  }
}
</script>

