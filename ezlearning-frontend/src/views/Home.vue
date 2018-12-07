<template>
  <div class="home">
    <NavBarHome/>
    <!-- <BannerHome/> -->
    <Statistic/>
    <Sale/>
    <!-- <ListCats/>
    <Footer/> -->
  </div>
</template>

<script>
// @ is an alias to /src
import NavBarHome from '@/components/NavBarHome.vue'
import BannerHome from '@/components/BannerHome.vue'
import Statistic from '@/components/Statistic.vue'
import Sale from '@/components/Sale.vue'
import ListCats from '@/components/ListCats.vue'
import Footer from '@/components/Footer.vue'

import { mapActions } from 'vuex';

export default {
  name: 'home',
  components: {
    NavBarHome,
    BannerHome,
    Statistic,
    Sale,
    ListCats,
    Footer
  },
   methods: {
    ...mapActions([
      'init'
    ])
  },
  mounted() {
    this.init();
  }
}
</script>
