<template>
    <b-breadcrumb >
      <b-breadcrumb-item :to="{ name: 'home' }">
        <b-icon icon="house-fill" scale="1.25" shift-v="1.25" aria-hidden="true"></b-icon>
        Home
      </b-breadcrumb-item>
      <b-breadcrumb-item :to="{ name: 'VuelosDisponibles' }" >Vuelos disponibles</b-breadcrumb-item>
      <b-breadcrumb-item :to="{ name: 'LineasDeVuelo' }" >Lineas de vuelos</b-breadcrumb-item>
    </b-breadcrumb>
</template>

<script>
  export default {
  }
</script>