package cl.tbd.control1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tbd.control1.models.Emergencia;
import cl.tbd.control1.models.Tarea;
import cl.tbd.control1.models.Voluntario;
import cl.tbd.control1.repository.VoluntarioRepositoryImp;

@Service

public class VoluntarioService {
    @Autowired
    private VoluntarioRepositoryImp voluntarioRepository  = new VoluntarioRepositoryImp();

    @Autowired
    TareaService tareaService;

    @Autowired
    EmergenciaService emergenciaService;

    public List <Voluntario> getAll(){
    return voluntarioRepository.findAllVoluntario();  
    }
    public Voluntario select(int id){
        return voluntarioRepository.getVoluntario(id);
    }
    public Voluntario crearVoluntario(Voluntario voluntario){
        return  voluntarioRepository.createVoluntario(voluntario);
    }
    public void actualizarVoluntario(Voluntario voluntario,int id) {

        voluntarioRepository.updateVoluntario(voluntario, id);
    }
    public void deleteVoluntario(int id){
        voluntarioRepository.deleteVoluntario(id);
    }

    //FUNCIONALIDAD 22//
    //FUNCIONALIDAD 22//
    public List<Voluntario> getCercanos(int idTarea, int numero){
        Tarea tarea=tareaService.select(idTarea);
        Emergencia emergencia=emergenciaService.select(tarea.getId_emergencia());
        //Para nuestro caso, como solo se pide agregar la localizacion a la entidad emergencia
        //entonces asumimos que la localización de la tarea es la misma de la emergencia.
        String point = "POINT("+emergencia.getLongitude()+" "+emergencia.getLatitude()+")";
        return voluntarioRepository.getCercanos(point, numero);

    }
    //FUNCIONALIDAD 22//
    //FUNCIONALIDAD 22//
}