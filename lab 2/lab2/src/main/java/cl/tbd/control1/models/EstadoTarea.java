package cl.tbd.control1.models;




public class EstadoTarea {

    private int id;
    private String estado;
    
    //GETTERS
    public int getId(){
        return this.id;
    }

    public String getEstado(){
        return this.estado;
    }

    //SETTERS
    public void setId(int id){
        this.id=id;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
}