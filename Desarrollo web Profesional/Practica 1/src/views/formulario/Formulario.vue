<template>
    <div>
        <b-container fluid>
            <b-row>
                <b-col>
                    <h1>Formulario de personas</h1>
                </b-col>
            </b-row>
            <b-row class="mt-3">
                <b-col>
                    <b-form
                    >
                        <b-row>
                            <b-col cols="4">
                                <b-form-group
                                    label="Nombre(s)"
                                >
                                    <b-form-input
                                        type="text"
                                    >

                                    </b-form-input>
                                </b-form-group>
                            </b-col>
                            <b-col cols="4">
                                <b-form-group
                                    label="Apellido paterno"
                                >
                                    <b-form-input
                                        type="text"
                                    >

                                    </b-form-input>
                                </b-form-group>
                            </b-col>
                            <b-col cols="4">
                                <b-form-group
                                    label="Apellido materno"
                                >
                                    <b-form-input
                                        type="text"
                                    >

                                    </b-form-input>
                                </b-form-group>
                            </b-col>
                        </b-row>
                        <b-row>
                            <b-col cols="6">
                                <b-form-group
                                    label="Correo electronico"
                                >
                                    <b-form-input
                                        type="email"
                                    >

                                    </b-form-input>
                                </b-form-group>
                            </b-col>
                            <b-col cols="6">
                                <b-form-group
                                    label="Numero telefono"
                                >
                                    <b-form-input
                                        type="text"
                                    >
                                        
                                    </b-form-input>
                                </b-form-group>
                            </b-col>
                        </b-row>
                        <b-row>
                            <b-col cols="4">
                                <b-form-group
                                    label="Fecha de nacimiento"
                                >
                                    <b-calendar />
                                </b-form-group>
                            </b-col>
                            <b-col >
                                <b-form-group
                                    label="Foto"
                                >
                                    <b-form-file>
                                    
                                    </b-form-file>

                                </b-form-group>
                            </b-col>
                        </b-row>
                        <b-row>
                            <b-col>
                                <b-form-group
                                    label="Direccion"
                                >
                                    <b-form-input
                                        type="text"
                                    >

                                    </b-form-input>
                                </b-form-group>
                            </b-col>
                        </b-row>
                        <b-row class="my-5">
                            <b-col class="text-right">
                                <b-button @click="validar()" variant="danger">Enviar</b-button>
                            </b-col>
                        </b-row>
                    </b-form>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
export default {
    data () {
       return{
            persona:{
                nombreCompleto:{
                    nombres:"",
                    apellidoMaterno:"",
                    apellidoPaterno:"",
                },
                correoElectronico:"",
                numeroTelefono:"",
                fechaNacimiento:"",
                foto: file | null,
                direccion: ""
            },
            errors: new Map(),
       }
    },
    methods : {
        validar(){
            //validar normbre




        }
    }
    
}
</script>