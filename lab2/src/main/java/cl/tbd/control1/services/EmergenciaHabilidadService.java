package cl.tbd.control1.services;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import cl.tbd.control1.models.EmergenciaHabilidad;
import cl.tbd.control1.repository.EmergenciaHabilidadRepositoryImp;

@Service

public class EmergenciaHabilidadService {
    @Autowired
    private EmergenciaHabilidadRepositoryImp emergenciaHabilidadRepository  = new EmergenciaHabilidadRepositoryImp();

    public List <EmergenciaHabilidad> getAll(){
    return emergenciaHabilidadRepository.findAllEmergenciaHabilidad();  
    }

    public EmergenciaHabilidad select(int id){
        return emergenciaHabilidadRepository.getEmergenciaHabilidad(id);
    }

    public EmergenciaHabilidad crearEmergencia(EmergenciaHabilidad emergencia){
        return  emergenciaHabilidadRepository.createEmergenciaHabilidad(emergencia);
    }
    public void actualizarEmergencia(EmergenciaHabilidad emergencia,int id) {

        emergenciaHabilidadRepository.updateEmergenciaHabilidad(emergencia, id);
    }
    public void deleteEmergencia(int id){
        emergenciaHabilidadRepository.deleteEmergenciaHabilidad(id);
    }

}
