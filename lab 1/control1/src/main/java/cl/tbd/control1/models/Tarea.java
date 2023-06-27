package cl.tbd.control1.models;





public class Tarea{


    
    private int id;
    private String nombre;
    private String descripcion;
    private int id_emergencia;
    private int id_estado_tarea;

    //GETTERS
    public int getId() {
        return this.id;
    }
     public String getNombre() {
        return this.nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public int getId_emergencia(){
        return this.id_emergencia;
    }
    public int getId_estado_tarea(){
        return this.id_estado_tarea;
    }
    //SETTERS
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setId_emergencia(int id_emergencia){
        this.id_emergencia=id_emergencia;
    }
    public void setId_estado_tarea(int id_estado_tarea){
        this.id_estado_tarea=id_estado_tarea;
    }

}