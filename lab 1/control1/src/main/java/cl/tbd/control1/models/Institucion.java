package cl.tbd.control1.models;





public class Institucion {

    private int id;
    private String nombre;
    private String direccion;

    //GETTERS
    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getDireccion(){
        return this.direccion;
    }

    //SETTERS
    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
}