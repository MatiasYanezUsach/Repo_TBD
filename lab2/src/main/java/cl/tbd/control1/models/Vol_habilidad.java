package cl.tbd.control1.models;





public class Vol_habilidad{



    private int id;
    private int id_voluntario;
    private int id_habilidad;

    //GETTERS
    public int getId(){
        return this.id;
    }
    public int getId_voluntario(){
        return this.id_voluntario;
    }
    public int getId_Habilidad(){
        return this.id_habilidad;
    }
    //SETTERS
    public void setId(int id) {
        this.id = id;
    }
    public void setId_voluntario(int id_voluntario){
        this.id_voluntario=id_voluntario;
    }
    public void setId_habilidad(int id_habilidad){
        this.id_habilidad=id_habilidad;
    }
}