<template>
    <b-container fluid>
        <b-row>
            <b-col>
                <h3>Personas</h3>
            </b-col>
        </b-row>
        <b-row>
            <b-col>
                <b-table
                    striped
                    hover
                    :items="personas"
                    :fields="fields"
                    :per-page="perPage"
                    :sort-by.sync="sortBy"
                >
                    <template v-slot:cell(actions)="data">
                        <b-row no-gutters>
                            <b-col>
                                <b-button variant="primary" size="sm">Editar</b-button>
                            </b-col>
                            <b-col>
                                <b-button variant="danger" size="sm">Eliminar</b-button>
                            </b-col>
                        </b-row>
                    </template>
                </b-table>
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
</template>

<script>
import axios from 'axios'

export default {
    name: 'Personas',
    data(){
        return{
            perPage: 5,
            currentPage: 1,
            totalRows: 0,
            sortBy: null,
            personas: [],

            fields:[
                {
                    key: 'name',
                    label: 'Nombre',
                    sortable: true
                },
                {
                    key: 'email',
                    label: 'Email',
                    sortable: true
                },
                {
                    key: 'actions',
                    label: 'Acciones'
                }
            ]
        }
    },
    methods:{
        async getPersonas(){

            const page = this.currentPage - 1

            try {
                const respuesta = await axios.post(`http://localhost:8080/api/personas/page?size=${this.$data.perPage}&page=${page}`)

                console.log(respuesta.data)
                this.totalRows = respuesta.data.totalElements
                this.personas = respuesta.data.content
            } catch (error) {
                
            }
        }
    },
    mounted(){
        this.getPersonas()
    },
    watch:{
        currentPage(){
            this.getPersonas()
        }
    }
    

}
</script>