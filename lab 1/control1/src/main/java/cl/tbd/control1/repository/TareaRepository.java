package cl.tbd.control1.repository;
import cl.tbd.control1.models.Tarea;
import java.util.List;
public interface TareaRepository{
    public List<Tarea> findAllTarea();
    public Tarea getTarea(int id);
    public Tarea createTarea(Tarea tarea);
    public void updateTarea(Tarea tarea,int id);
    public void deleteTarea(int id);
    public int newId();
}