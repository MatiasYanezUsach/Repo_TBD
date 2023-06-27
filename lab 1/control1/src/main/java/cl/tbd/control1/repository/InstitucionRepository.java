package cl.tbd.control1.repository;
import cl.tbd.control1.models.Institucion;
import java.util.List;
public interface InstitucionRepository {
    public List<Institucion> findAllInstitucion();
    public Institucion getInstitucion(int id);
    public Institucion createInstitucion(Institucion institucion);
    public void updateInstitucion(Institucion institucion,int id);
    public void deleteInstitucion(int id);
    public int newId();
}