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
import cl.tbd.control1.models.TareaHabilidad;
import cl.tbd.control1.services.TareaHabilidadService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/tareaHabilidad")
public class TareaHabilidadController {
    @Autowired
    TareaHabilidadService tareaHabilidadService;
    @GetMapping("")
    public List <TareaHabilidad> getAll(){
        return tareaHabilidadService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<TareaHabilidad> select(@PathVariable int id){
        try{
            TareaHabilidad tareaHabilidad= tareaHabilidadService.select(id);
            return new ResponseEntity<TareaHabilidad>(tareaHabilidad, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<TareaHabilidad>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody TareaHabilidad tareaHabilidad){
        System.out.println(tareaHabilidad.getId());
        tareaHabilidadService.crearTarea_Habilidad(tareaHabilidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TareaHabilidad tareaHabilidad,@PathVariable int id){
        try{
            tareaHabilidadService.actualizarTarea_Habilidad(tareaHabilidad, id);
            return new ResponseEntity<TareaHabilidad>(tareaHabilidad, HttpStatus.OK);   
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<TareaHabilidad>(HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        tareaHabilidadService.deleteTareaHabilidad(id);
    }
}