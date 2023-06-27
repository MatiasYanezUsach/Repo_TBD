package cl.tbd.control1.models;




public class Ranking {


    private int id;
    private int id_voluntario;
    private int id_tarea;
    private int puntaje;

    //GETTERS
    public int getId() {
        return this.id;
    }
     public int getId_voluntario() {
        return this.id_voluntario;
    }
    public int getId_tarea() {
        return this.id_tarea;
    }
    public int getPuntaje() {
        return this.puntaje;
    }

    //SETTERS
    public void setId(int id) {
        this.id = id;
    }
    public void setId_voluntario(int id_voluntario) {
        this.id_voluntario=id_voluntario;
    }
    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}