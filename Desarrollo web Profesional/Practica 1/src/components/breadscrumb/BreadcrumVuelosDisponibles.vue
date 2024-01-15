<template>
    <b-breadcrumb :items="items"></b-breadcrumb>
</template>

<script>
  export default {
    data() {
      return {
        items: [
          {
            text: 'Vuelos disponibles',
            href: '#',
            to: { name: 'VuelosDisponibles' }
          },
          {
            text: 'Lineas de vuelo',
            href: '#',
            to: { name: 'LineasDeVuelo' }
          },
        ]
      }
    }
  }
</script>