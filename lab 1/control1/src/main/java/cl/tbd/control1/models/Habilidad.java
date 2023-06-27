package cl.tbd.control1.models;





public class Habilidad{

    private int id;
    private String nombre;
    private String descripcion;

    //GETTERS
    public int getId(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    //SETTERS
    public void setId(int id){
        this.id=id;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
}