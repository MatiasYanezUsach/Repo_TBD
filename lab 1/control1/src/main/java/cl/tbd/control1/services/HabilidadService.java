package cl.tbd.control1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tbd.control1.models.Habilidad;
import cl.tbd.control1.repository.HabilidadRepositoryImp;

@Service

public class HabilidadService {
    @Autowired
    private HabilidadRepositoryImp habilidadRepository  = new HabilidadRepositoryImp();

    public List <Habilidad> getAll(){
    return habilidadRepository.findAllHabilidad();  
    }
    public Habilidad select(int id){
        return habilidadRepository.getHabilidad(id);
    }
    public Habilidad crearHabilidad(Habilidad habilidad){
        return  habilidadRepository.createHabilidad(habilidad);
    }
    public void actualizarHabilidad(Habilidad habilidad,int id) {

        habilidadRepository.updateHabilidad(habilidad, id);
    }
    public void deleteHabilidad(int id){
        habilidadRepository.deleteHabilidad(id);
    }
}