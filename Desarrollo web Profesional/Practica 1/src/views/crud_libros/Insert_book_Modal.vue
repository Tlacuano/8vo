<template>
    <b-modal id="InsertBookModal" title="Registrar libro" hide-footer centered>
        <b-container fluid>
            <div v-if="showSpinner" class="text-center">
                <b-spinner variant="primary" label="Text Centered"></b-spinner>
            </div>
            <b-row>
                <b-col>
                    <b-form-group label="Titulo">
                        <b-form-input v-model="form.titulo" type="text" placeholder="Ingrese el titulo del libro"></b-form-input>
                    </b-form-group>
                </b-col>
            </b-row>
            <b-row>
                <b-col>
                    <b-form-group label="Autor">
                        <b-form-input v-model="form.autor" type="text" placeholder="Ingrese el autor del libro"></b-form-input>
                    </b-form-group>
                </b-col>
            </b-row>
            <b-row>
                <b-col>
                    <b-form-group label="Genero">
                        <b-form-input v-model="form.genero" type="text" placeholder="Ingrese el genero del libro"></b-form-input>
                    </b-form-group>
                </b-col>
            </b-row>
            <b-row>
                <b-col>
                    <b-form-group label="Fecha de publicación">
                        <b-form-input v-model="form.fechaPublicacion" type="date" placeholder="Ingrese la fecha de publicación del libro"></b-form-input>
                    </b-form-group>
                </b-col>
            </b-row>
            <b-row>
                <b-col class="text-right
                ">
                    <b-button @click="insertBook" variant="dark">Registrar</b-button>
                </b-col>
            </b-row>
        </b-container>
    </b-modal>   
</template>

<script>
import axios from 'axios'
export default {
    name: 'InsertBookModal',
    data(){
        return{
            showSpinner: false,
            form: {
                titulo: '',
                autor: '',
                genero: '',
                fechaPublicacion: ''
            }
        }
    },
    methods:{
        async insertBook(){
            try {
                this.spinnerHandler()
                //pasar la fecha de publicacion a tipo LocalDate
                this.form.fechaPublicacion = new Date(this.form.fechaPublicacion).toISOString().split('T')[0]

                const response = await axios.post('http://localhost:8080/api/libros/save', this.form)
                
                
                this.form = {
                    titulo: '',
                    autor: '',
                    genero: '',
                    fechaPublicacion: ''
                }
                this.spinnerHandler()
                window.location.reload()
                this.$bvModal.hide('InsertBookModal')

            } catch (error) {
                console.log(error)
            }
        },

        spinnerHandler(){
            this.showSpinner = !this.showSpinner
        }
    }
}
</script>