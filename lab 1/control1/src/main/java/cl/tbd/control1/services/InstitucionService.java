package cl.tbd.control1.services;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cl.tbd.control1.models.Institucion;
import cl.tbd.control1.repository.InstitucionRepositoryImp;
@Service
public class InstitucionService {
    @Autowired
    private InstitucionRepositoryImp institucionRepository  = new InstitucionRepositoryImp();

    public List <Institucion> getAll(){
    return institucionRepository.findAllInstitucion();  
    }

    public Institucion select(int id){
        return institucionRepository.getInstitucion(id);
    }

    public Institucion crearInstitucion(Institucion institucion){
        return  institucionRepository.createInstitucion(institucion);
    }
    public void actualizarInstitucion(Institucion institucion,int id) {

        institucionRepository.updateInstitucion(institucion, id);
    }
    public void deleteInstitucion(int id){
        institucionRepository.deleteInstitucion(id);
    }

}
