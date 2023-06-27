package cl.tbd.control1.repository;
import cl.tbd.control1.models.TareaHabilidad;
import java.util.List;
public interface TareaHabilidadRepository {
    public List<TareaHabilidad> findAllTarea_Habilidad();
    public TareaHabilidad getTarea_Habilidad(int id);
    public TareaHabilidad createTarea_Habilidad(TareaHabilidad ranking);
    public void updateTarea_Habilidad(TareaHabilidad ranking,int id);
    public void deleteTarea_Habilidad(int id);
    public int newId();
}
