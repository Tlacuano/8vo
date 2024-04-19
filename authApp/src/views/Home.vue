<script>
export default {
  name: 'profile',
  components:{
    Carousel : () => import('@/components/Carousel.vue')
  },
  methods: {
    login() {
      this.$auth.loginWithRedirect();
    }
  }
}

</script>
<template>
  <b-row class="mt-0 pt-0">
    <b-col>
        <b-row class="position-relative mt-0 pt-0">
          <b-col class="text-center">
            <Carousel />
          </b-col>

        </b-row>
        <!-- Coloca el contenedor de la imagen fuera de la fila del carrusel -->
        <div class="profile-image-container">
          <b-img :src="$auth.user.picture" class="profile-image rounded-circle border p-3"></b-img>
        </div>

        <b-row>
          <b-col class="text-center pt-5 mt-5"> <!-- Añade un margen superior para compensar el espacio de la imagen -->
            <h1>
              {{ $auth.user.name }}
            </h1>
            <span>
              {{ $auth.user.email }}
            </span>
          </b-col>
        </b-row>
        <b-row class="text-center mt-4">
          <b-col>
            <b-button @click="$auth.logout()">Cerrar sesión</b-button>
          </b-col>
        </b-row>
    </b-col>
  </b-row>
</template>

<style scoped>
.profile-image-container {
  position: absolute;
  width: 100%;
  display: flex;
  justify-content: center; /* Centra la imagen */
  padding-right: 43px;
  margin-top: -50px; /* Ajusta este valor según sea necesario */
}
.profile-image {
  width: 120px; /* Ajusta el tamaño según sea necesario */
  height: 120px; /* Asegúrate de que la imagen sea cuadrada */
  z-index: 2; /* Asegura que la imagen esté sobre otros elementos */
}
</style>
