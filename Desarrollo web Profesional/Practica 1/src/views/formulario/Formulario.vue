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
                                        v-model="persona.nombreCompleto.nombres"
                                        :state="errors.nombres.error ? !errors.nombres.error : null"
                                    />
                                    <b-form-invalid-feedback v-if="errors.nombres.error">
                                        {{ errors.nombres.message }}
                                    </b-form-invalid-feedback>
                                </b-form-group>
                            </b-col>

                            <b-col cols="4">
                                <b-form-group
                                    label="Apellido paterno"
                                >
                                    <b-form-input
                                        type="text"
                                        v-model="persona.nombreCompleto.apellidoPaterno"
                                        :state="errors.apellidoPaterno.error ? !errors.apellidoPaterno.error : null"
                                    />
                                    <b-form-invalid-feedback v-if="errors.apellidoPaterno.error">
                                        {{ errors.apellidoPaterno.message }}
                                    </b-form-invalid-feedback>
                                </b-form-group>
                            </b-col>
                            <b-col cols="4">
                                <b-form-group
                                    label="Apellido materno"
                                >
                                    <b-form-input
                                        type="text"
                                        v-model="persona.nombreCompleto.apellidoMaterno"
                                        :state="errors.apellidoMaterno.error ? !errors.apellidoMaterno.error : null"
                                    />
                                    <b-form-invalid-feedback v-if="errors.apellidoMaterno.error">
                                        {{ errors.apellidoMaterno.message }}
                                    </b-form-invalid-feedback>
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
                                        v-model="persona.correoElectronico"
                                        :state="errors.correoElectronico.error ? !errors.correoElectronico.error : null"
                                    />
                                    <b-form-invalid-feedback v-if="errors.correoElectronico.error">
                                        {{ errors.correoElectronico.message }}
                                    </b-form-invalid-feedback>
                                </b-form-group>
                            </b-col>
                            <b-col cols="6">
                                <b-form-group
                                    label="Numero telefono"
                                >
                                    <b-form-input
                                        type="text"
                                        v-model="persona.numeroTelefono"
                                        :state="errors.numeroTelefono.error ? !errors.numeroTelefono.error : null"
                                    />
                                    <b-form-invalid-feedback v-if="errors.numeroTelefono.error">
                                        {{ errors.numeroTelefono.message }}
                                    </b-form-invalid-feedback>
                                </b-form-group>
                            </b-col>
                        </b-row>
                        <b-row>
                            <b-col cols="4">
                                <b-form-group
                                    label="Fecha de nacimiento"
                                >
                                    <b-calendar
                                        v-model="persona.fechaNacimiento"
                                        :max="new Date()"
                                        :min="new Date(1900, 0, 1)"
                                        locale="es"
                                        today-button
                                        :state="errors.fechaNacimiento.error ? !errors.fechaNacimiento.error : null"
                                    />
                                    
                                    
                                </b-form-group>
                                <small class="text-danger" v-if="errors.fechaNacimiento.error">
                                    {{ errors.fechaNacimiento.message }}
                                </small>
                                    
                            </b-col>
                            <b-col >
                                <b-row>
                                    <b-col>
                                        <b-form-group
                                            label="Foto"
                                        >
                                            <b-form-file
                                                v-model="persona.foto"
                                                accept="image/*"
                                                placeholder="Seleccione una imagen"
                                                @change="handleFileChange($event)"
                                                :state="errors.foto.error ? !errors.foto.error : null"
                                            >
                                            
                                            </b-form-file>
        
                                        </b-form-group>
                                    </b-col>
                                </b-row>
                                <b-row>
                                    <b-col class="text-center">
                                        <b-img
                                            v-if="imagen"
                                            :src="imagen"
                                            fluid
                                            thumbnail
                                            alt="Responsive image"
                                            style="max-height: 300px;"
                                        />
                                        <small class="text-danger" v-if="errors.foto.error">
                                            {{ errors.foto.message }}
                                        </small>
                                    </b-col>
                                </b-row>
        
                            </b-col>
                        </b-row>
                        <b-row>
                            <b-col>
                                <b-form-group
                                    label="Direccion"
                                >
                                    <b-form-input
                                        type="text"
                                        v-model="persona.direccion"
                                        :state="errors.direccion.error ? !errors.direccion.error : null"
                                    />
                                    <b-form-invalid-feedback v-if="errors.direccion.error">
                                        {{ errors.direccion.message }}
                                    </b-form-invalid-feedback>
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
import Vue from 'vue';

export default Vue.extend( {
    name: 'Formulario',
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
                    foto: null,
                    direccion: ""
                },
                errors: {
                    nombres: {
                        error: null,
                        message: ''
                    },
                    apellidoPaterno: {
                        error: false,
                        message: ''
                    },
                    apellidoMaterno: {
                        error: false,
                        message: ''
                    },
                    correoElectronico: {
                        error: false,
                        message: ''
                    },
                    numeroTelefono: {
                        error: false,
                        message: ''
                    },
                    fechaNacimiento: {
                        error: false,
                        message: ''
                    },
                    foto: {
                        error: false,
                        message: ''
                    },
                    direccion: {
                        error: false,
                        message: ''
                    },
                },
                imagen: null,
        }
    },
    methods : {
        validar(){
            //validar normbre
            if(!(this.persona.nombreCompleto.nombres === "")){
                if(this.persona.nombreCompleto.nombres.length >= 3){
                    if(/^[A-Za-záéíóúüñÁÉÍÓÚÜÑ\s]+$/u.test(this.persona.nombreCompleto.nombres)){
                        this.errors.nombres.error = false;
                        this.errors.nombres.message = "";
                    }else{
                        this.errors.nombres.error = true;
                        this.errors.nombres.message = "El campo nombre solo puede contener letras";
                    }
                }else{
                    this.errors.nombres.error = true;
                    this.errors.nombres.message = "El campo nombre debe tener al menos 3 caracteres";
                }
            }else{
                this.errors.nombres.error = true;
                this.errors.nombres.message = "El campo nombre es obligatorio";
            }

            //validar apellido paterno
            if(!(this.persona.nombreCompleto.apellidoPaterno === "")){
                if(this.persona.nombreCompleto.apellidoPaterno.length >= 3){
                    if(/^[A-Za-záéíóúüñÁÉÍÓÚÜÑ\s]+$/u.test(this.persona.nombreCompleto.apellidoPaterno)){
                        this.errors.apellidoPaterno.error = false;
                        this.errors.apellidoPaterno.message = "";
                    }else{
                        this.errors.apellidoPaterno.error = true;
                        this.errors.apellidoPaterno.message = "El campo apellido paterno solo puede contener letras";
                    }
                }else{
                    this.errors.apellidoPaterno.error = true;
                    this.errors.apellidoPaterno.message = "El campo apellido paterno debe tener al menos 3 caracteres";
                }
            }else{
                this.errors.apellidoPaterno.error = true;
                this.errors.apellidoPaterno.message = "El campo apellido paterno es obligatorio";
            }


            //validar apellido materno
            if(!(this.persona.nombreCompleto.apellidoMaterno === "")){
                if(this.persona.nombreCompleto.apellidoMaterno.length >= 3){
                    if(/^[A-Za-záéíóúüñÁÉÍÓÚÜÑ\s]+$/u.test(this.persona.nombreCompleto.apellidoMaterno)){
                        this.errors.apellidoMaterno.error = false;
                        this.errors.apellidoMaterno.message = "";
                    }else{
                        this.errors.apellidoMaterno.error = true;
                        this.errors.apellidoMaterno.message = "El campo apellido materno solo puede contener letras";
                    }
                }else{
                    this.errors.apellidoMaterno.error = true;
                    this.errors.apellidoMaterno.message = "El campo apellido materno debe tener al menos 3 caracteres";
                }
            }else{
                this.errors.apellidoMaterno.error = false;
                this.errors.apellidoMaterno.message = "";
            }


            //validar correo electronico
            if(!(this.persona.correoElectronico === "")){
                if(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(this.persona.correoElectronico)){
                    this.errors.correoElectronico.error = false;
                    this.errors.correoElectronico.message = "";
                }else{
                    this.errors.correoElectronico.error = true;
                    this.errors.correoElectronico.message = "El campo correo electronico no es valido";
                }
            }else{
                this.errors.correoElectronico.error = true;
                this.errors.correoElectronico.message = "El campo correo electronico es obligatorio";
            }


            //validar numero de telefono
            if(!(this.persona.numeroTelefono === "")){
                if(/^[0-9]+$/.test(this.persona.numeroTelefono)){
                    if(this.persona.numeroTelefono.length >= 10){
                        this.errors.numeroTelefono.error = false;
                        this.errors.numeroTelefono.message = "";
                    }else{
                        this.errors.numeroTelefono.error = true;
                        this.errors.numeroTelefono.message = "El campo numero de telefono debe tener al menos 10 caracteres";
                    }
                }else{
                    this.errors.numeroTelefono.error = true;
                    this.errors.numeroTelefono.message = "El campo numero de telefono solo puede contener numeros";
                }
            }else{
                this.errors.numeroTelefono.error = true;
                this.errors.numeroTelefono.message = "El campo numero de telefono es obligatorio";
            }

            //validar que la foto no sea mayor a 3MB
            if(!(this.persona.foto === null)){
                if(this.persona.foto.size <= 3145728){
                    this.errors.foto.error = false;
                    this.errors.foto.message = "";
                }else{
                    this.errors.foto.error = true;
                    this.errors.foto.message = "El campo foto no puede ser mayor a 3MB";
                }
            }else{
                this.errors.foto.error = true;
                this.errors.foto.message = "El campo foto es obligatorio";
            }
            
            //validar que sea mayor de 18 años
            if(!(this.persona.fechaNacimiento === "")){
                let fechaNacimiento = new Date(this.persona.fechaNacimiento);
                let fechaActual = new Date();
                
                let edadMilisegundos = fechaActual - fechaNacimiento;
                let edad = edadMilisegundos / 31556952000; //esto me lo dio chatGPT

                if(edad >= 18){
                    this.errors.fechaNacimiento.error = false;
                    this.errors.fechaNacimiento.message = "";
                }else{
                    this.errors.fechaNacimiento.error = true;
                    this.errors.fechaNacimiento.message = "El campo fecha de nacimiento debe ser mayor a 18 años";
                }
            }else{
                this.errors.fechaNacimiento.error = true;
                this.errors.fechaNacimiento.message = "El campo fecha de nacimiento es obligatorio";
            }

            //validar direccion solo si existe y regex 
            if(!(this.persona.direccion === "")){
                if(this.persona.direccion.length >= 10){
                    if(/^[A-Za-záéíóúüñÁÉÍÓÚÜÑ#\s]+$/u.test(this.persona.direccion)){
                        this.errors.direccion.error = false;
                        this.errors.direccion.message = "";
                    }else{
                        this.errors.direccion.error = true;
                        this.errors.direccion.message = "El campo direccion solo puede contener letras";
                    }
                }else{
                    this.errors.direccion.error = true;
                    this.errors.direccion.message = "El campo direccion debe tener al menos 10 caracteres";
                }
            }else{
                this.errors.direccion.error = true;
                this.errors.direccion.message = "El campo direccion es obligatorio";
            }
            


        },

        async handleFileChange(event) {
                const fileInput = event.target;
      
                if (fileInput.files.length > 0) {
                    const selectedFile = fileInput.files[0];
                    
                    // Aquí puedes acceder a e.target.result si es relevante para tu caso
                    // Por ejemplo, si necesitas leer el contenido de un archivo de imagen
                    const reader = new FileReader();

                    reader.onload = (e) => {
                    // e.target.result contiene la información del archivo
                        this.imagen = e.target.result 
                    };
                    reader.readAsDataURL(selectedFile);
                }
                
            },

    }
    
})
</script>