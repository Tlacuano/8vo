<template>
    <div>
        <div v-if="showSpinner" class="text-center">
            <b-spinner variant="primary" label="Text Centered"></b-spinner>
        </div>
        <b-container fluid>
            <b-row>
                <b-col>
                    <h1>Libros</h1>
                </b-col>
            </b-row>
            <b-row>
                <b-col class="text-right">
                    <b-button v-b-modal.InsertBookModal variant="dark">Registrar</b-button>
                </b-col>
            </b-row>
            <b-row align-v="between" class="mb-3">
                <b-col cols="4" v-for="libro in libros" :key="libro.id">
                    <b-card class="mt-2">
                        <b-row>
                            <b-col class="text-right p-0 m-0">
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
                            <b-col class="text-center">
                                <div>
                                    <h5>{{ libro.titulo }}</h5>
                                    
                                </div>
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
        updateLibroModal: () => import('./update_book_Modal.vue')
    },
    data () {
        return {
            //manejadores de estado
            showSpinner: false,

            //paginador
            perPage: 6,
            currentPage: 1,
            totalRows: 0,

            libros: [],

            currentLibro: {}
        }
    },
    methods: {

        async getLibros(){
            try {
                const page = this.currentPage - 1

                const response = await axios.get(`http://localhost:8080/api/libros/getAll?page=${page}&size=${this.perPage}`)
                
                this.libros = response.data.content;
                this.totalRows = response.data.totalElements

            } catch (error) {
                
            }
        },

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







        spinnerHandler(){
            this.showSpinner = !this.showSpinner
        }
    },
    mounted() {
        this.getLibros()
        
    },
    watch: {
        currentPage(){
            this.getLibros()
        }
    },
    
}
</script>