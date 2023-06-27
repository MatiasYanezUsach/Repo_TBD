package cl.tbd.control1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tbd.control1.models.Tarea;
import cl.tbd.control1.repository.TareaRepositoryImp;

@Service

public class TareaService {
    @Autowired
    private TareaRepositoryImp tareaRepository  = new TareaRepositoryImp();

    public List <Tarea> getAll(){
    return tareaRepository.findAllTarea();  
    }
    public Tarea select(int id){
        return tareaRepository.getTarea(id);
    }
    public Tarea crearTarea(Tarea tarea){
        return  tareaRepository.createTarea(tarea);
    }
    public void actualizarTarea(Tarea tarea,int id) {

        tareaRepository.updateTarea(tarea, id);
    }
    public void deleteTarea(int id){
        tareaRepository.deleteTarea(id);
    }
}