<template>
  <div id="app">
    <NavBarGeneral/>
    <router-view/>
    <!--Modal-->
    <FormLogin v-if="isLogged"></FormLogin>
    <Footer/>
  </div>
</template>

<script>
import NavBarGeneral from "@/components/NavBarGeneral.vue";
import Footer from "@/components/Footer.vue";
import FormLogin from "@/components/FormLogin.vue";
import { mapState } from 'vuex';

export default {
  name: "app",
  computed: {
    ...mapState(['isLogged'])
  },
  components: {
    NavBarGeneral,
    Footer,
    FormLogin
  },
};
</script>