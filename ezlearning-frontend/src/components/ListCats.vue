<template>
    <div>
    <p>Danh mục hot</p>
    <button>Tất cả</button>
    <CatItem/>
  </div>
</template>

<script>
// @ is an alias to /src
import CatItem from '@/components/CatItem.vue'

export default {
  name: 'home',
  components: {
    CatItem
  }
}
</script>