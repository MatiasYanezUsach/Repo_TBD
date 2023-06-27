# Lab1TBD
Laboratorio 1 Taller de base de datos, Springboot &amp; vue.

● Base de datos PostgreSQL
● Servicio REST desarrollado con Java Spring, conectado utilizando Sq12o
● Frontend desarrollado con Vue

Integrantes:
Matias Vargas
Matias Yañez
Agustin Henriquez
Rodolfo Unanue
Mauricio Valdes
Manuel Villar

Instrucciones
1. Antes de ejecutar el proyecto SpringBoot, crear base de datos local en Postgresql, se sugiere nombre control1.
2. Cargar el archivo dbCreate.sql en el query Tool de su base de datos, ejecutarlo.
3. Cargar el archivo inserts.sql en el query Tool de su base de datos, ejecutarlo.
4. Entrar al archivo DatabaseContext.java de la carpeta repository y ubicar la instrucción.
public Sql2o sql2o(){
        return new Sql2o("jdbc:postgresql://127.0.0.1:5432/<nombreBD>","<postgres>","<postgresql>");
    }
5. Reemplazar los valores entre <> por sus valores locales
6. Notar que el Frontend se encuentra en otro repositorio debido a dificultades al subir dichos archivos.
    El link del frontend: https://github.com/MatiasVargasMolina/frontTBDLab1.git
7. En el README del repositorio del frontend se encuentran las instrucciones de cómo correrlo.