<template>
    <div class="container">
        <h1>Actualizar una Emergencia</h1>
        <form>
            <div class="form-item">
                <label for="id">Id de la Emergencia</label>
                <input type="text" placeholder="ingrese id" id="id" v-model="emergencia.id">
                <label for="id">Nombre</label>
                <input type="text" placeholder="ingrese nombre" id="nombre" v-model="emergencia.nombre">
                <label for="id">Descripcion</label>
                <input type="text" id="descripcion" placeholder="ingrese descripcion" v-model="emergencia.descripcion">
                <label for="id">Ubicacion</label>
                <input type="text" id="ubicacion" placeholder="ingrese Ubicacion" v-model="emergencia.ubicacion">
            </div>
            <div>
                <button type="button" @click="del" class="main">Actualizar</button>
            </div>
            <h1>{{mensaje}}</h1>
        </form>

    </div>
</template>

<script>
    export default {
        //Función que contiene los datos del componente
        data(){
            return{
                emergencia:{},
                mensaje:"",
            }
        },
        methods:{
            del:async function(){
                try {
                    var result = await this.$axios.put(`Emergencia/${this.emergencia.id}`,this.emergencia);
                    this.mensaje="Se actualizo con exito";
                } catch (error) {
                    console.log('error', error);
                    this.mensaje="Se actualizo con exito"
                }
            }
        },

    }
    </script>
<style >
    .container{
        padding: 10px;
        height: 10px;
    }
    .container div
    {
        padding: 20px;
        text-align: left;
    }
    .container button{
        padding: 15px;
    }
</style>