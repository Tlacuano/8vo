<template>
    <div>
        <div v-if="showSpinner" class="text-center" style="position: fixed; width: 75%; background-color: rgba(255, 255, 255, 0.5); display: flex; justify-content: center; align-items: center; z-index: 1000;">
            <b-spinner variant="primary" label="Text Centered"></b-spinner>
        </div>
        <b-container fluid>
            <b-row>
                <b-col class="text-center">
                    <h1>Libros</h1>
                </b-col>
            </b-row>
            <b-row>
                <b-col>
                    <h4>Registro chido:</h4>
                </b-col>
                <b-col class="text-right">
                    <b-button @click="crearCard()" variant="dark">Registrar</b-button>
                </b-col>
            </b-row>
            <b-row class="mb-3 pb-2 pt-2 container-books">
                

                <b-col cols="4" v-for="libro in librosARegistrar" :key="libro.id">
                    <b-card>
                        <b-row>
                            <b-col>
                                <b-form-group>
                                    <b-form-input v-model="libro.titulo" type="text" placeholder="Ingrese el titulo del libro"></b-form-input>
                                </b-form-group>
                            </b-col>
                        </b-row>
                        <b-row>
                            <b-col>
                                <b-form-group >
                                    <b-form-input v-model="libro.autor" type="text" placeholder="Ingrese el autor del libro"></b-form-input>
                                </b-form-group>
                            </b-col>
                        </b-row>
                        <b-row>
                            <b-col>
                                <b-form-group>
                                    <b-form-input v-model="libro.genero" type="text" placeholder="Ingrese el genero del libro"></b-form-input>
                                </b-form-group>
                            </b-col>
                        </b-row>
                        <b-row>
                            <b-col>
                                <b-form-group >
                                    <b-form-input v-model="libro.fechaPublicacion" type="date" placeholder="Ingrese la fecha de publicación del libro"></b-form-input>
                                </b-form-group>
                            </b-col>
                        </b-row>
                    </b-card>
                </b-col>
            </b-row>
            <b-row>
                <b-col>
                    <h4>Resgistrados:</h4>
                </b-col>
            </b-row>
            <b-row align-h="between" class="mt-1" >
                <b-col cols="12" md="7" lg="7"  v-if="busqueda.filtro != 3 && busqueda.filtro != 4 && busqueda.filtro != 5">
                    <b-form-group>
                        <b-form-input v-model="busqueda.entrada" type="text" placeholder="Buscar..." @input="searchLibro()"></b-form-input>
                    </b-form-group>
                </b-col>
                <b-col cols="12" md="7" lg="7" v-if="busqueda.filtro == 3">
                    <b-form-group>
                        <b-form-select v-model="busqueda.genero" @change="searchLibro()">
                            <b-form-select-option value="">Seleccione un genero</b-form-select-option>
                            <b-form-select-option v-for="genero in generos" :key="genero" :value="genero">{{ genero }}</b-form-select-option>
                        </b-form-select>
                    </b-form-group>
                </b-col>
                <b-col cols="12" md="7" lg="7" v-if="busqueda.filtro == 4">
                    <b-row>
                        <b-col cols="12" md="6" lg="6">
                            <b-form-group>
                                <b-form-input v-model="busqueda.fechaInicio" type="date" placeholder="Fecha inicio" @input="searchLibro()"></b-form-input>
                            </b-form-group>
                        </b-col>
                        <b-col cols="12" md="6" lg="6">
                            <b-form-group>
                                <b-form-input v-model="busqueda.fechaFin" type="date" placeholder="Fecha fin" @input="searchLibro()"></b-form-input>
                            </b-form-group>
                        </b-col>
                    </b-row>
                </b-col>



                <b-col cols="12" md="4" lg="3">
                    <b-form-group>
                        <b-form-select v-model="busqueda.filtro" @change="cleanSearch()">
                            <b-form-select-option value="1">Titulo</b-form-select-option>
                            <b-form-select-option value="2">Autor</b-form-select-option>
                            <b-form-select-option value="3">Genero</b-form-select-option>
                            <b-form-select-option value="4">Rango de fechas</b-form-select-option>
                            <b-form-select-option value="5">Fechas descendente</b-form-select-option>
                        </b-form-select>
                    </b-form-group>
                </b-col>
                <b-col cols="12" md="12" lg="2" class="text-right">
                    <b-button v-b-modal.InsertBookModal variant="dark">Registrar</b-button>
                </b-col>
            </b-row>
            <b-row align-h="between" class="mb-3 pb-3 pt-1 container-books">
                <b-col cols="4" v-for="libro in libros" :key="libro.id">
                    <b-card class="mt-2">
                        <b-row>
                            <b-col>
                                <div>
                                    <h5>{{ libro.titulo }}</h5>
                                </div>
                            </b-col>
                            <b-col cols="auto" class="mx-0 px-0 ">
                                <b-dropdown variant="link-dark" toggle-class="text-decoration-none" no-caret>
                                    <template v-slot:button-content>
                                        <b-icon icon="three-dots"></b-icon>
                                    </template>
                                    <b-dropdown-item @click="updateLibro(libro)">Editar</b-dropdown-item>
                                    <b-dropdown-item @click="deleteLibro(libro)">Eliminar</b-dropdown-item>
                                </b-dropdown>
                            </b-col>
                        </b-row>
                        <b-row>
                            <b-col>
                                <div>
                                    Autor: <span class="text-secondary"> {{ libro.autor }}</span>
                                </div>
                            </b-col>
                        </b-row>
                        <b-row>
                            <b-col>
                                <div>
                                    Genero: <span class="text-secondary"> {{ libro.genero }}</span>
                                </div>
                            </b-col>
                        </b-row>
                        <b-row>
                            <b-col>
                                <div>
                                    Fecha publicación: <span class="text-secondary"> {{ libro.fechaPublicacion }}</span>
                                </div>
                            </b-col>
                        </b-row>
                        
                    </b-card>
                </b-col>
            </b-row>
            <b-row>
                <b-col>
                    <b-pagination
                        v-model="currentPage"
                        :total-rows="totalRows"
                        :per-page="perPage"
                        aria-controls="my-table"
                    ></b-pagination>
                </b-col>
                <b-col cols="auto">
                    <b-form-group label="mostrar:">
                        <b-form-select v-model="perPage" @change="perPageHandler()">
                            <b-form-select-option value="6">6</b-form-select-option>
                            <b-form-select-option value="12">12</b-form-select-option>
                            <b-form-select-option value="24">24</b-form-select-option>
                            <b-form-select-option value="48">48</b-form-select-option>
                        </b-form-select>
                    </b-form-group>
                </b-col>
            </b-row>
        </b-container>

        <InsertBookModal/>
        <updateLibroModal :libro="currentLibro"/>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'boocks_management',
    components: {
        InsertBookModal: () => import('./Insert_book_Modal.vue'),
        updateLibroModal: () => import('./update_book_Modal.vue'),
    },
    data () {
        return {
            //manejadores de estado
            showSpinner: false,

            //paginador
            perPage: 6,
            currentPage: 1,
            totalRows: 0,

            //data
            libros: [],
            generos: [],

            librosARegistrar: [

            ],

            currentLibro: {},

            //busqueda
            busqueda: {
                entrada: '',
                filtro: '1',
                genero: '',
                fechaInicio: '',
                fechaFin: ''
            }
        }
    },
    methods: {
        //funciones que se ejecutan al inicio
        async getLibros(){
            try {
                const page = this.currentPage - 1

                const response = await axios.get(`http://localhost:8080/api/libros/getAll?page=${page}&size=${this.perPage}`)
                
                this.libros = response.data.content;
                this.totalRows = response.data.totalElements
            } catch (error) {
                
            }
        },
        async getGeneros(){
            try {
                const response = await axios.get(`http://localhost:8080/api/libros/getGenero`)
                this.generos = response.data
            } catch (error) {
                console.log(error)
            }
        },

        //funciones para el registro chido
        crearCard(){
            this.librosARegistrar.push({
                id: this.librosARegistrar.length,
                titulo: '',
                autor: '',
                genero: '',
                fechaPublicacion: ''
            })
        },

        


        //funciones para el crud normal
        async deleteLibro(lbro){
            try {
                this.spinnerHandler()
                const response = await axios.post(`http://localhost:8080/api/libros/delete`, lbro)
                this.spinnerHandler()
                window.location.reload()
            } catch (error) {
                console.log(error)
            }
        },

        updateLibro(lbro){
            this.currentLibro = lbro
            this.$bvModal.show('updateLibroModal')
        },

        //funciones para la busqueda y paginacion
        async searchLibro(){
            try {
                this.spinnerHandler()
                switch(this.busqueda.filtro){
                    case '1':
                        if(this.busqueda.entrada != ''){
                            this.resetPagination();
                            const page = this.currentPage - 1

                            const response = await axios.post(`http://localhost:8080/api/libros/findByTitulo?page=${page}&size=${this.perPage}`,{
                                titulo: this.busqueda.entrada
                            });
                            
                            this.libros = response.data.content;
                            this.totalRows = response.data.totalElements
                        }else{
                            this.getLibros()
                        }
                        break;
                    case '2':
                        if(this.busqueda.entrada != ''){
                            this.resetPagination();
                            const page = this.currentPage - 1

                            const response = await axios.post(`http://localhost:8080/api/libros/findByAutor?page=${page}&size=${this.perPage}`,{
                                autor: this.busqueda.entrada
                            });
                            
                            this.libros = response.data.content;
                            this.totalRows = response.data.totalElements
                        }else{
                            this.getLibros()
                        }

                        break;
                    case '3':
                        if(this.busqueda.genero != ''){
                            this.resetPagination();
                            const page = this.currentPage - 1

                            const response = await axios.post(`http://localhost:8080/api/libros/findByGenero?page=${page}&size=${this.perPage}`,{
                                genero: this.busqueda.genero
                            });
                            
                            this.libros = response.data.content;
                            this.totalRows = response.data.totalElements
                        }else{
                            this.getLibros()
                        }

                        break;
                    case '4':
                        if(this.busqueda.fechaInicio != '' && this.busqueda.fechaFin != ''){
                            if(this.busqueda.fechaInicio <= this.busqueda.fechaFin){
                                this.resetPagination();
                                const page = this.currentPage - 1

                                const response = await axios.post(`http://localhost:8080/api/libros/findByFechaPublicacion?page=${page}&size=${this.perPage}`,{
                                    fechaInicio: this.busqueda.fechaInicio,
                                    fechaFin: this.busqueda.fechaFin
                                });
                                
                                this.libros = response.data.content;
                                this.totalRows = response.data.totalElements
                            }else{
                                this.getLibros()
                            }
                        }else{
                            this.getLibros()
                        }
                        break;
                    case '5':
                        console.log('entro')
                        this.resetPagination();
                        const page = this.currentPage - 1

                        const response = await axios.get(`http://localhost:8080/api/libros/getOrderByFechaPublicacion?page=${page}&size=${this.perPage}`)
                        console.log(response.data)
                        this.libros = response.data.content;
                        this.totalRows = response.data.totalElements
                        break;
                }
            } catch (error) {
                console.log(error)
            } finally{
                this.spinnerHandler()
            }
        },

        cleanSearch(){
            this.busqueda.entrada = ''
            this.busqueda.genero = ''
            this.busqueda.fechaInicio = ''
            this.busqueda.fechaFin = ''

            if(this.busqueda.filtro == 5){
                this.searchLibro()
            }
        },

        perPageHandler(){
            this.resetPagination()
            this.searchLibro()
        },

        resetPagination(){
            this.currentPage = 1
        },

        //manejadores de estado
        spinnerHandler(){
            this.showSpinner = !this.showSpinner
        }
    },
    mounted() {
        this.getLibros(),
        this.getGeneros()
    },
    watch: {
        currentPage(){
            this.getLibros()
        }
    },
    
}
</script>

<style>
.page-item.active .page-link {
    color: #fff;
    background-color: #343a40;
    border-color: 343a40;
}
.container-books{
    background-color: #f9fafb;
}

.add-book-card{
    aspect-ratio: 1 / 1;
}

.add-book-card:hover{
    background-color: #ededed;
    color: #56595b;
    
}

</style>