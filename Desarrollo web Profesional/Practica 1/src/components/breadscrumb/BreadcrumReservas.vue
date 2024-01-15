<template>
    <b-breadcrumb :items="items"></b-breadcrumb>
</template>

<script>
  export default {
    data() {
      return {
        items: [
          {
            text: 'Reservas de vuelos',
            href: '#',
            to: { name: 'ReservasDeVuelos' }
          },
          {
            text: 'Asientos reservados',
            href: '#',
            to: { name: 'AsientosReservados' }
          },
        ]
      }
    }
  }
</script>