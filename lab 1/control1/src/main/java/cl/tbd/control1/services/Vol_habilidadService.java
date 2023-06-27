package cl.tbd.control1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tbd.control1.models.Vol_habilidad;
import cl.tbd.control1.repository.Vol_habilidadRepositoryImp;

@Service
public class Vol_habilidadService {
    @Autowired
    private Vol_habilidadRepositoryImp vol_habilidadRepository  = new Vol_habilidadRepositoryImp();

    public List <Vol_habilidad> getAll(){
    return vol_habilidadRepository.findAllVol_habilidad();  
    }
    public Vol_habilidad select(int id){
        return vol_habilidadRepository.getVol_habilidad(id);
    }
    public Vol_habilidad crearVol_habilidad(Vol_habilidad vol_habilidad){
        return  vol_habilidadRepository.createVol_habilidad(vol_habilidad);
    }
    public void actualizarVol_habilidad(Vol_habilidad vol_habilidad,int id) {

        vol_habilidadRepository.updateVol_habilidad(vol_habilidad, id);
    }
    public void deleteVol_habilidad(int id){
        vol_habilidadRepository.deleteVol_habilidad(id);
    }
}