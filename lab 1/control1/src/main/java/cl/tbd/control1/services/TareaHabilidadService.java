package cl.tbd.control1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tbd.control1.models.TareaHabilidad;
import cl.tbd.control1.repository.TareaHabilidadRepositoryImp;

@Service

public class TareaHabilidadService{
    @Autowired
    private TareaHabilidadRepositoryImp TareaHabilidadRepository  = new TareaHabilidadRepositoryImp();

    public List <TareaHabilidad> getAll(){
    return TareaHabilidadRepository.findAllTarea_Habilidad();  
    }
    public TareaHabilidad select(int id){
        return TareaHabilidadRepository.getTarea_Habilidad(id);
    }
    public TareaHabilidad crearTarea_Habilidad(TareaHabilidad tarea_Habilidad){
        return  TareaHabilidadRepository.createTarea_Habilidad(tarea_Habilidad);
    }
    public void actualizarTarea_Habilidad(TareaHabilidad tarea_Habilidad,int id) {

        TareaHabilidadRepository.updateTarea_Habilidad(tarea_Habilidad, id);
    }
    public void deleteTareaHabilidad(int id){
        TareaHabilidadRepository.deleteTarea_Habilidad(id);
    }
}