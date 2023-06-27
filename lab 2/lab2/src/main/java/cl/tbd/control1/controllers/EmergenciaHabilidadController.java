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
import cl.tbd.control1.models.EmergenciaHabilidad;
import cl.tbd.control1.services.EmergenciaHabilidadService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/emergencia_habilidad")
public class EmergenciaHabilidadController {
    @Autowired
    EmergenciaHabilidadService eme_habilidadService;
    @GetMapping("")
    public List <EmergenciaHabilidad> getAll(){
        return eme_habilidadService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmergenciaHabilidad> select(@PathVariable int id){
        try{
            EmergenciaHabilidad eme_habilidad= eme_habilidadService.select(id);
            return new ResponseEntity<EmergenciaHabilidad>(eme_habilidad, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<EmergenciaHabilidad>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody EmergenciaHabilidad eme_habilidad){
        System.out.println(eme_habilidad.getId());
        eme_habilidadService.crearEmergencia(eme_habilidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody EmergenciaHabilidad eme_habilidad,@PathVariable int id){
        try{
            eme_habilidadService.actualizarEmergencia(eme_habilidad, id);
            return new ResponseEntity<EmergenciaHabilidad>(eme_habilidad, HttpStatus.OK);   
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<EmergenciaHabilidad>(HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        eme_habilidadService.deleteEmergencia(id);
    }
}