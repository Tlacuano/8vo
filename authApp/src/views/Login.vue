<script>
export default {
  name: 'profile',
  methods: {
    login() {
      this.$auth.loginWithRedirect();
    }
  }
}
</script>

<template>
  <div>
    <b-row style="height: 100vh">
      <b-col>
        <b-card>
          <b-button v-if="!$auth.isAuthenticated" @click="login">Log in</b-button>
        </b-card>
      </b-col>
      <b-col>

      </b-col>
    </b-row>
  </div>
</template>

<style scoped>

</style>