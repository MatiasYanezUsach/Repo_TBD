package cl.tbd.control1.repository;
import cl.tbd.control1.models.EstadoTarea;
import java.util.List;
public interface EstadoTareaRepository{
    public List<EstadoTarea> findAllEstadoTarea();
    public EstadoTarea getEstadoTarea(int id);
    public EstadoTarea createEstadoTarea(EstadoTarea estadoTarea);
    public void updateEstadoTarea(EstadoTarea estadoTarea,int id);
    public void deleteEstadoTarea(int id);
    public int newId();
}