package cl.tbd.control1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tbd.control1.models.Voluntario;
import cl.tbd.control1.repository.VoluntarioRepositoryImp;

@Service

public class VoluntarioService {
    @Autowired
    private VoluntarioRepositoryImp voluntarioRepository  = new VoluntarioRepositoryImp();

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
}