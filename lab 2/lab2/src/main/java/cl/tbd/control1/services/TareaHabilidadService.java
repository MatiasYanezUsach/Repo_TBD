package cl.tbd.control1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tbd.control1.models.TareaHabilidad;
import cl.tbd.control1.repository.TareaHabilidadRepositoryImp;

@Service

public class TareaHabilidadService{
    @Autowired
    private TareaHabilidadRepositoryImp tareaHabilidadRepository  = new TareaHabilidadRepositoryImp();

    public List <TareaHabilidad> getAll(){
    return tareaHabilidadRepository.findAllTarea_Habilidad();  
    }
    public TareaHabilidad select(int id){
        return tareaHabilidadRepository.getTarea_Habilidad(id);
    }
    public TareaHabilidad crearTarea_Habilidad(TareaHabilidad tarea_Habilidad){
        return  tareaHabilidadRepository.createTarea_Habilidad(tarea_Habilidad);
    }
    public void actualizarTarea_Habilidad(TareaHabilidad tarea_Habilidad,int id) {

        tareaHabilidadRepository.updateTarea_Habilidad(tarea_Habilidad, id);
    }
    public void deleteTareaHabilidad(int id){
        tareaHabilidadRepository.deleteTarea_Habilidad(id);
    }

    public List<TareaHabilidad> getAllByTarea(int id){
        return tareaHabilidadRepository.getAllByTarea(id);
    }
}