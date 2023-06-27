package cl.tbd.control1.repository;
import cl.tbd.control1.models.Habilidad;
import java.util.List;
public interface HabilidadRepository{
    public List<Habilidad> findAllHabilidad();
    public Habilidad getHabilidad(int id);
    public Habilidad createHabilidad(Habilidad habilidad);
    public void updateHabilidad(Habilidad habilidad,int id);
    public void deleteHabilidad(int id);
    public int newId();
}