<template>
    <b-modal id="updateLibroModal" title="Acualizar libro" hide-footer centered>
        <b-container fluid>
            <div v-if="showSpinner" class="text-center">
                <b-spinner variant="primary" label="Text Centered"></b-spinner>
            </div>
            <b-row>
                <b-col>
                    <b-form-group label="Titulo">
                        <b-form-input v-model="libro.titulo" type="text" placeholder="Ingrese el titulo del libro"></b-form-input>
                    </b-form-group>
                </b-col>
            </b-row>
            <b-row>
                <b-col>
                    <b-form-group label="Autor">
                        <b-form-input v-model="libro.autor" type="text" placeholder="Ingrese el autor del libro"></b-form-input>
                    </b-form-group>
                </b-col>
            </b-row>
            <b-row>
                <b-col>
                    <b-form-group label="Genero">
                        <b-form-input v-model="libro.genero" type="text" placeholder="Ingrese el genero del libro"></b-form-input>
                    </b-form-group>
                </b-col>
            </b-row>
            <b-row>
                <b-col>
                    <b-form-group label="Fecha de publicación">
                        <b-form-input v-model="libro.fechaPublicacion" type="date" placeholder="Ingrese la fecha de publicación del libro"></b-form-input>
                    </b-form-group>
                </b-col>
            </b-row>
            <b-row>
                <b-col class="text-right">
                    <b-button @click="updateBook" variant="dark">Actualizar</b-button>
                </b-col>
            </b-row>
        </b-container>
    </b-modal>
</template>

<script>
import axios from 'axios'
export default {
    name: 'updateLibroModal',
    props: {
        libro: {}
    },
    data(){
        return{
            showSpinner: false,
        }
    },
    methods:{
        async updateBook(){
            try {
                this.spinnerHandler()
                const response = await axios.post(`http://localhost:8080/api/libros/update`, this.libro)
                this.spinnerHandler()
                this.$emit('updateLibro', this.libro)
                this.$bvModal.hide('updateLibroModal')
                

            } catch (error) {
                
            }
        },
        spinnerHandler(){
            this.showSpinner = !this.showSpinner
        }
    }

}
</script>