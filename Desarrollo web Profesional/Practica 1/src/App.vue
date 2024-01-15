
<template>
  <div id="app">
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
                  ><b-link >
                    <b-icon icon="calendar-check" aria-hidden="true" class="mr-2"></b-icon>
                    Reservas
                    </b-link>
                </b-nav-item>

                <b-nav-item class="selecteable" :to="{ name: 'VuelosDisponibles' }"
                  ><b-link >
                    <b-icon icon="cursor" aria-hidden="true" class="mr-2"></b-icon>
                    Vuelos disponibles
                    </b-link>
                </b-nav-item>

                <b-nav-item class="selecteable" :to="{ name: 'VuelosCancelados' }"
                  ><b-link >
                    <b-icon icon="folder-x" aria-hidden="true" class="mr-2"></b-icon>
                    Vuelos cancelados
                    </b-link>
                </b-nav-item>
              </b-nav>      
          </b-sidebar>
        </b-col>

        
        <b-col lg="10" cols="12" :class="buttonSidebar ? '' : 'pl-5'">
          <b-container fluid>
            <b-nav>
              <b-nav-item active @click="isVisibleSidebar = !isVisibleSidebar"> 
                <b-icon
                  v-if="buttonSidebar"
                  class="selectable" 
                  icon="list" 
                  
                  aria-hidden="true"
                  />
              </b-nav-item>
              <b-nav-item active :to="{name:'home'}">Inicio</b-nav-item>
              <b-nav-item active>Active</b-nav-item>
              <b-nav-item>Link</b-nav-item>
              <b-nav-item>Another Link</b-nav-item>
            </b-nav>
          
            
            <router-view :class="buttonSidebar ? '' : 'pl-5'"/>
          </b-container>
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