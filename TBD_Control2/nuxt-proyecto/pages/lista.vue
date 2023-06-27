<template>
    <div class="container">
    <h1>Todos las emergencias</h1>
    <ul class="item-list">
        <div>
            <li class="container" v-for="(item, index) in items" :key="index">
            <!-- <img :src="'https://loremflickr.com/160/120/dog?lock='+i"/>-->
                <!-- {{index}} -  -->
                <h2>ID: {{item.id}}</h2>
                <h2>Nombre: {{item.nombre}}</h2>
                <h2>Descripcion: {{item.descripcion}}</h2>
                <h2>Ubicacion: {{item.ubicacion}}</h2>

            </li>
        </div>
    </ul>
    <div v-if="items.length==0" class="empty-list">
      <em>No se han cargado los datos</em>
    </div>
  </div>
</template>
<script>
export default {
    //Función que contiene los datos del componente
    data(){
        return{
            //Lista de ítems a mostrar
            items:[],
            id:""
        }
    },
    methods:{
        //Función asíncrona para consultar los datos
        getData: async function(){
            try {
                let response = await this.$axios.get('/emergencia');
                this.items  = response.data;
                console.log(response)
            } catch (error) {
                console.log('error', error);
            }
        },
        actualizarId:function(id){
            this.id=id;
            this.borrar();
        },
        borrar:async function(){
            try {
                var result = await this.$axios.delete(`Delete/Emergencia/${this.id}`);
                console.log(result.data)
            } catch (error) {
                console.log('error', error)
                this.message = 'Ocurrió un error'
            }
        }
    },
    //Función que se ejecuta al cargar el componente
    created:function(){
        this.getData();
    }
}
</script>
<style >
    .container{
        padding-bottom: 4rem;
        display: flex;
        flex-direction: column;
        height: 8rem;
    }
</style>