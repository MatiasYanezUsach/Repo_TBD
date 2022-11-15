package cl.tbd.control1.models;




public class Emergencia {
    


    private int id;
    private String nombre;
    private String descripcion;
    private int id_institucion;
    private double longitude;
    private double latitude;

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

    public int getId_institucion(){
        return this.id_institucion;
    }

    public double getLongitude(){
        return this.longitude;
    }

    public double getLatitude(){
        return this.latitude;
    }

    //SETTERS
    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setId_institucion(int id_institucion){
        this.id_institucion = id_institucion;
    }

    public void setLongitude(double longitude){
        this.longitude=longitude;
    }

    public void setLatitude(double latitude){
        this.latitude=latitude;
    }

}