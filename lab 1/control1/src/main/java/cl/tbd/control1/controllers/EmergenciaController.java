package cl.tbd.control1.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import cl.tbd.control1.models.Emergencia;
import cl.tbd.control1.services.EmergenciaService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/emergencia")
public class EmergenciaController {
    @Autowired
    EmergenciaService emergenciaService;
    @GetMapping("")
    public List <Emergencia> getAll(){
        return emergenciaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emergencia> select(@PathVariable int id){
        try{
            Emergencia emergencia= emergenciaService.select(id);
            return new ResponseEntity<Emergencia>(emergencia, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Emergencia>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody Emergencia emergencia){
        emergenciaService.crearEmergencia(emergencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Emergencia emergencia,@PathVariable int id){
        try{
            emergenciaService.actualizarEmergencia(emergencia, id);
            return new ResponseEntity<Emergencia>(emergencia, HttpStatus.OK);   
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Emergencia>(HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        emergenciaService.deleteEmergencia(id);
    }

    
}
