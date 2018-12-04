<template>
  <div id="app">
    <Home/>
  </div>
</template>


<script>
// @ is an alias to /src
import Home from '@/views/Home.vue'

export default {
  name: 'app',
  components: {
    Home
  }
}
</script>