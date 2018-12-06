<template>
  <div class="home">
    <NavBar/>
    <BannerHome/>
    <Statistic/>
    <Sale/>
    <ListCats/>
    <Footer/>
  </div>
</template>

<script>
// @ is an alias to /src
import NavBar from '@/components/NavBar.vue'
import BannerHome from '@/components/BannerHome.vue'
import Statistic from '@/components/Statistic.vue'
import Sale from '@/components/Sale.vue'
import ListCats from '@/components/ListCats.vue'
import Footer from '@/components/Footer.vue'

import { mapState, mapActions } from 'vuex';

export default {
  name: 'home',
  components: {
    NavBar,
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
}
</script>
