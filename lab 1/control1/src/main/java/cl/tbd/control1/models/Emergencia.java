package cl.tbd.control1.models;




public class Emergencia {
    


    private int id;
    private String nombre;
    private String ubicacion;
    private String descripcion;
    private int id_institucion;

    //GETTERS
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

    public int getId_institucion(){
        return this.id_institucion;
    }

    //SETTERS
    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setId_institucion(int id_institucion){
        this.id_institucion = id_institucion;
    }

}