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
import cl.tbd.control1.models.Tarea;
import cl.tbd.control1.services.TareaService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/tarea")
public class TareaController {
    @Autowired
    TareaService tareaService;
    @GetMapping("")
    public List <Tarea> getAll(){
        return tareaService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> select(@PathVariable int id){
        try{
            Tarea tarea= tareaService.select(id);
            return new ResponseEntity<Tarea>(tarea, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Tarea>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody Tarea tarea){
       tareaService.crearTarea(tarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Tarea tarea,@PathVariable int id){
        try{
            tareaService.actualizarTarea(tarea, id);
            return new ResponseEntity<Tarea>(tarea, HttpStatus.OK);   
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Tarea>(HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        tareaService.deleteTarea(id);
    }
}