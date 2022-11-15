package cl.tbd.control1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tbd.control1.models.EstadoTarea;
import cl.tbd.control1.repository.EstadoTareaRepositoryImp;

@Service

public class EstadoTareaService {
    @Autowired
    private EstadoTareaRepositoryImp estadoTareaRepository  = new EstadoTareaRepositoryImp();

    public List <EstadoTarea> getAll(){
    return estadoTareaRepository.findAllEstadoTarea();  
    }
    public EstadoTarea select(int id){
        return estadoTareaRepository.getEstadoTarea(id);
    }
    public EstadoTarea crearEstadoTarea(EstadoTarea estadoTarea){
        return  estadoTareaRepository.createEstadoTarea(estadoTarea);
    }
    public void actualizarEstadoTarea(EstadoTarea estadoTarea,int id) {

        estadoTareaRepository.updateEstadoTarea(estadoTarea, id);
    }
    public void deleteEstadoTarea(int id){
        estadoTareaRepository.deleteEstadoTarea(id);
    }
}