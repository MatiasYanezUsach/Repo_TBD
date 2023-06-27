package cl.tbd.control1.repository;
import cl.tbd.control1.models.Voluntario;
import java.util.List;
public interface VoluntarioRepository{
    public List<Voluntario> findAllVoluntario();
    public Voluntario getVoluntario(int id);
    public Voluntario createVoluntario(Voluntario voluntario);
    public void updateVoluntario(Voluntario voluntario,int id);
    public void deleteVoluntario(int id);
    public int newId();
}