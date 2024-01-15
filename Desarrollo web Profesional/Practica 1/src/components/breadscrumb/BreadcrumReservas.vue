<template>
    <b-breadcrumb >
      <b-breadcrumb-item :to="{ name: 'home' }">
        <b-icon icon="house-fill" scale="1.25" shift-v="1.25" aria-hidden="true"></b-icon>
        Home
      </b-breadcrumb-item>
      <b-breadcrumb-item :to="{ name: 'ReservasDeVuelos' }" >Reservas de vuelos</b-breadcrumb-item>
      <b-breadcrumb-item :to="{ name: 'AsientosReservados' }" >Asientos reservados</b-breadcrumb-item>
    </b-breadcrumb>
</template>

<script>
  export default {
  }
</script>