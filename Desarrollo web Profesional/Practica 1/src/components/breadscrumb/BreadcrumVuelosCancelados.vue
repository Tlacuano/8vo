<template>
    <b-breadcrumb :items="items"></b-breadcrumb>
</template>

<script>
  export default {
    data() {
      return {
        items: [
          {
            text: 'Vuelos Cancelados',
            href: '#',
            to: { name: 'VuelosCancelados' }
          },
          {
            text: 'Próximos vuelos',
            href: '#',
            to: { name: 'ProximosVuelos' }
          },
        ]
      }
    }
  }
</script>