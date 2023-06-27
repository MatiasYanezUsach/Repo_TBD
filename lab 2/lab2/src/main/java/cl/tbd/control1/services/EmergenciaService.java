package cl.tbd.control1.services;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cl.tbd.control1.models.Emergencia;
import cl.tbd.control1.repository.EmergenciaRepositoryImp;

@Service

public class EmergenciaService {
    @Autowired
    private EmergenciaRepositoryImp emergenciaRepository  = new EmergenciaRepositoryImp();

    public List <Emergencia> getAll(){
    return emergenciaRepository.findAllEmergencia();  
    }

    public Emergencia select(int id){
        return emergenciaRepository.getEmergencia(id);
    }

    public Emergencia crearEmergencia(Emergencia emergencia){
        return  emergenciaRepository.createEmergencia(emergencia);
    }
    public void actualizarEmergencia(Emergencia emergencia,int id) {
        emergenciaRepository.updateEmergencia(emergencia, id);
    }
    public void deleteEmergencia(int id){
        emergenciaRepository.deleteEmergencia(id);
    }

}
