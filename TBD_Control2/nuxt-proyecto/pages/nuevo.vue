<template>
<div class="container">
    <h1>Agregar una emergencia</h1>
    <form>
        <div class="form-item">
            <label for="nombre">Nombre</label>
            <input type="text" id="name" v-model="emergencia.nombre">
        </div>
        <div class="form-item">
            <label for="descripcion">Descripcion</label>
            <input type="text" id="name" v-model="emergencia.descripcion">
        </div>
        <div class="form-item">
            <label for="ubicacion">Ubicacion</label>
            <input type="text" id="name" v-model="emergencia.ubicacion">
        </div>
        <div>
            <button type="button" @click="send" class="main">Crear</button>
        </div>
        <div class="info">
            <h2>Objeto</h2>
            <code>{{emergencia}}</code>
            <p class="message">
                {{message}}
            </p>
        </div>
    </form>

</div>
</template>
<script>
export default {
    data(){
        return{
            message:'',
            emergencia:{}
        }
    },
    methods:{
        send:async function(){
            this.message = '';
            //validaciones de formulario
            if (this.emergencia.nombre == ''||this.emergencia.descripcion==''||this.emergencia.ubicacion==''){
                this.message = 'Debes ingresar todos los datos'
                return false
            }
            console.log(this.emergencia);
            //envío de datos del formulario
            try {
                var result = await this.$axios.post('/Create/Emergencia/', this.emergencia);
                this.message = `Se creó una nueva emergencia`;
            } catch (error) {
                //mensaje de error
                console.log('error', error)
                this.message = 'Ocurrió un error'
            }
        }
    }
}
</script>
<style>
code{
    padding: .5rem 1rem;
    color:white;
    background:#444;
    font-size: 1rem;
    width: 100%;
    display:inline-block;
}
p.message{
    border:solid 1px rgba(255, 255, 255, 0.25);
    padding: .5rem 1rem;
    font-weight: bold;
}
</style>