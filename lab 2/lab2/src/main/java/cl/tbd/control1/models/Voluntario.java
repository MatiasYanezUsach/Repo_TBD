package cl.tbd.control1.models;

public class Voluntario {

    private int id;
    private String nombre;
    private String correo;
    private String contrasenia;
    private double longitude;
    private double latitude;

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
    public double getLongitude(){
        return this.longitude;
    }
    public double getLatitude(){
        return this.latitude;
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
    public void setLongitude(double longitude){
        this.longitude=longitude;
    }
    public void setLatitude(double latitude){
        this.latitude=latitude;
    }
}