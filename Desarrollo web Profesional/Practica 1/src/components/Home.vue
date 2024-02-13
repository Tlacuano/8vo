
<template>
    <div>
      <b-container fluid>
        <b-row>
          <b-col :lg="buttonSidebar ? '12' : '2'" md="12">
            <b-sidebar v-model="isVisibleSidebar"  bg-variant="dark" text-variant="light"  no-close-on-backdrop no-close-on-esc no-close-on-route-change no-header>
              <!-- header del navbar -->
                <b-col v-if="buttonSidebar" cols="12" class="text-right pr-3 pt-3  text-secondary">
                  <b-icon
                    class="selectable" 
                    icon="x" 
                    @click="isVisibleSidebar = !isVisibleSidebar"
                    aria-hidden="true"
                    font-scale="2"
                    />
                </b-col>
                
                <b-nav vertical >
                  <b-nav-item class="selecteable mt-3" :to="{ name: 'ReservasDeVuelos' }"
                    ><b-link :to="{ name: 'ReservasDeVuelos' }" >
                      <b-icon icon="calendar-check" aria-hidden="true" class="mr-2"></b-icon>
                      Reservas
                      </b-link>
                  </b-nav-item>
  
                  <b-nav-item class="selecteable" :to="{ name: 'VuelosDisponibles' }"
                    ><b-link :to="{ name: 'VuelosDisponibles' }">
                      <b-icon icon="cursor" aria-hidden="true" class="mr-2"></b-icon>
                      Vuelos disponibles
                      </b-link>
                  </b-nav-item>
  
                  <b-nav-item class="selecteable" :to="{ name: 'VuelosCancelados' }"
                    ><b-link :to="{ name: 'VuelosCancelados' }">
                      <b-icon icon="folder-x" aria-hidden="true" class="mr-2"></b-icon>
                      Vuelos cancelados
                      </b-link>
                  </b-nav-item>

                  <b-nav-item class="selecteable" :to="{ name: 'formulario' }"
                    ><b-link :to="{ name: 'formulario' }">
                      <b-icon icon="box" aria-hidden="true" class="mr-2"></b-icon>
                      Formulario
                      </b-link>
                  </b-nav-item>

                  <b-nav-item class="selecteable" :to="{ name: 'Personas' }"
                    ><b-link :to="{ name: 'Personas' }">
                      <b-icon icon="person" aria-hidden="true" class="mr-2"></b-icon>
                      Gestion de Personas
                      </b-link>
                  </b-nav-item>

                  <b-nav-item class="selecteable" :to="{ name: 'libros' }"
                    ><b-link :to="{ name: 'libros' }">
                      <b-icon icon="book" aria-hidden="true" class="mr-2"></b-icon>
                      Gestion de Libros
                      </b-link>
                  </b-nav-item>
                </b-nav>      
            </b-sidebar>
          </b-col>
  
          
          <b-col :lg="buttonSidebar ? '' : '10'" :class="buttonSidebar ? '' : 'pl-5'">
            <router-view class="mt-3" :class="buttonSidebar ? '' : 'pl-5'"/>
          </b-col>
        </b-row>
      </b-container>
    </div>
  </template>
  
  <script >
    import Vue from 'vue';
  
    export default Vue.extend({
        name: 'Navbar',
        data () {
          return {
            // variables para mostrar y ocultar el sidebar
            isVisibleSidebar: true,
            buttonSidebar: false,
          }
        },
        methods:{
          navigator(link){
            if(this.$route.path !== link){
              this.$router.push(link)
            }
          },
  
          handdlerSidebar(){
            //para tablet y movil
            if(window.innerWidth < 1339){
              this.buttonSidebar = true
              if(this.isVisibleSidebar){
                this.isVisibleSidebar = false
              }
            }
  
            //para pc
            if(window.innerWidth > 1330){
              this.buttonSidebar = false
              this.isVisibleSidebar = true
            }
          }
        },
        mounted(){
          window.addEventListener('resize', this.handdlerSidebar);
          this.handdlerSidebar();
        },
    });
  </script>
  
  
  <style >
  #app {
    height: 97.6vh;
  }
  
  .selecteable a{
    cursor: pointer;
    padding: 10px;
    color: white;
  }
  
  .selecteable a:hover {
    background-color: #8f8f8f;
    color: rgb(219, 219, 219);
    text-decoration: none;
  }
  
  
  
  
  </style>