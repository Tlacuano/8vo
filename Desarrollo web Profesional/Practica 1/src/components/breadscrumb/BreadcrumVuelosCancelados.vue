<template>
    <b-breadcrumb >
      <b-breadcrumb-item :to="{ name: 'home' }">
        <b-icon icon="house-fill" scale="1.25" shift-v="1.25" aria-hidden="true"></b-icon>
        Home
      </b-breadcrumb-item>
      <b-breadcrumb-item :to="{ name: 'VuelosCancelados' }" >Vuelos cancelados</b-breadcrumb-item>
      <b-breadcrumb-item :to="{ name: 'ProximosVuelos' }" >Proximos vuelos</b-breadcrumb-item>
    </b-breadcrumb>
</template>

<script>
  export default {
  }
</script>