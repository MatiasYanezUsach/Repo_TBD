# Lab2TBD
Laboratorio 2 Taller de base de datos, Springboot + postgis & vue + nuxt.

● Base de datos PostgreSQL
* Extencion para postgresSQL de nombre postgis 
● Servicio REST desarrollado con Java Spring, conectado utilizando Sq12o
● Frontend desarrollado con Vue + nuxt

Integrantes:
Matias Vargas
Matias Yañez
Agustin Henriquez
Rodolfo Unanue
Mauricio Valdes
Manuel Villar

Instrucciones
1. Antes de ejecutar el proyecto SpringBoot, crear base de datos local en Postgresql, se sugiere el nombre de dbTest.
2. Cargar el archivo dbCreate.sql en el query Tool de su base de datos previamente nombrada, ejecutarlo.
3. Cargar el archivo inserts.sql en el query Tool de su base de datos, ejecutarlo.
4. Entrar al archivo DatabaseContext.java de la carpeta repository y ubicar la instrucción.
public Sql2o sql2o(){
        return new Sql2o("jdbc:postgresql://127.0.0.1:5432/<nombreBD>","<postgres>","<postgresql>");
    }
5. Reemplazar los valores entre <> por sus valores locales.
6. Ejecutar la aplicacion.
7. Cabe mencionar que para esta entrega no contamos con un frontend, es por ello que para asegurar que el producto si funciona, les recomendamos usar la aplicacion de postman para realizar la consulta solicitada
8. Para ello al momento de ejecutarse la aplicacion, debe revisar el puerto que se habilita y se muestra por consola, generalmente es el puerto 8080.
9. Una vez obtiene el puerto, debe probar en postman utilizando: localhost:8090
