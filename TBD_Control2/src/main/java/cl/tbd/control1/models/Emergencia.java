
package cl.tbd.control1.models;


public class Emergencia {
    
    private int id;
    private String nombre;
    private String ubicacion;
    private String descripcion;



    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }

    

    public void setId(int id_estado){
        this.id = id_estado;
    }


    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }


    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getUbicacion(){
        return this.ubicacion;
    }

    public String getDescripcion(){
        return this.descripcion;
    }





}