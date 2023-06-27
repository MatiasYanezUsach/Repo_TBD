package cl.tbd.control1.models;

public class Voluntario {

    private int id;
    private String nombre;
    private String correo;
    private String contrasenia;

    //GETTERS
    public int getId(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getCorreo(){
        return this.correo;
    }
    public String getContrasenia(){
        return this.contrasenia;
    }
    //SETTERS
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCorreo(String correo){
        this.correo=correo;
    }
    public void setContrasenia(String contrasenia){
        this.contrasenia=contrasenia;
    }
}