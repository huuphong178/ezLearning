<template>
  <div id="app">
      <NavBarGeneral/>
    <router-view/>
       <Footer/>
  </div>
</template>

<script>
import NavBarGeneral from "@/components/NavBarGeneral.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: 'app',
  components:{
    NavBarGeneral,
    Footer
  }
}
</script>