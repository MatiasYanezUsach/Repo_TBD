<template>
    <div class="container">
        <h1>Eliminar una Emergencia</h1>
        <form>
            <div class="form-item">
                <label for="id">Id de la Emergencia</label>
                <input placeholder="Ingrese id" type="text" id="id" v-model="id">
            </div>
            <div>
                <button type="button" @click="del" class="main">Eliminar</button>
            </div>
        </form>
        <h1>{{mensaje}}</h1>

    </div>
</template>
<script>
    export default {
        //Función que contiene los datos del componente
        data(){
            return{
                id:"",
                mensaje:"",
            }
        },
        methods:{
            del:async function(){
                try {
                    var result = await this.$axios.delete(`Emergencia/${this.id}`);
                    this.mensaje="Emergencia eliminada con exito"
                } catch (error) {
                    console.log('error', error)
                    this.mensaje="Error en eliminar emergencia"
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