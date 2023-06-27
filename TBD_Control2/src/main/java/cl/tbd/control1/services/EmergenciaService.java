package cl.tbd.control1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.control1.models.Emergencia;
import cl.tbd.control1.repository.EmergenciaRepositoryImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class EmergenciaService {
    @Autowired
    private EmergenciaRepositoryImp emergenciaRepository  = new EmergenciaRepositoryImp();

    @GetMapping("/Emergencia") 
    public List <Emergencia> getAll(){
    return emergenciaRepository.findAllEmergencia();  
    }
    @GetMapping("/Emergencia/{id}")
    public Emergencia select(@PathVariable int id){
        return emergenciaRepository.getEmergencia(id);
    }

    @PostMapping("/Create/Emergencia")
    public Emergencia crearEmergencia(@RequestBody Emergencia emergencia){
        System.out.print(emergencia);
        return  emergenciaRepository.createEmergencia(emergencia);
    }
    @PutMapping("/Emergencia/{id}")
    @ResponseBody
    public void actualizarEmergencia(@RequestBody Emergencia emergencia,@PathVariable int id) {

        emergenciaRepository.updateEmergencia(emergencia, id);
    }
    @DeleteMapping("/Emergencia/{id}")
    public void deleteEmergencia(@PathVariable int id){
        emergenciaRepository.deleteEmergencia(id);
    }

}
