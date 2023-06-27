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
import cl.tbd.control1.models.EstadoTarea;
import cl.tbd.control1.services.EstadoTareaService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/estadoTarea")
public class EstadoTareaController {
    @Autowired
    EstadoTareaService estadoTareaService;
    @GetMapping("")
    public List <EstadoTarea> getAll(){
        return estadoTareaService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<EstadoTarea> select(@PathVariable int id){
        try{
            EstadoTarea estadoTarea= estadoTareaService.select(id);
            return new ResponseEntity<EstadoTarea>(estadoTarea, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<EstadoTarea>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody EstadoTarea estadoTarea){
        estadoTareaService.crearEstadoTarea(estadoTarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody EstadoTarea estadoTarea,@PathVariable int id){
        try{
            estadoTareaService.actualizarEstadoTarea(estadoTarea, id);
            return new ResponseEntity<EstadoTarea>(estadoTarea, HttpStatus.OK);   
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<EstadoTarea>(HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        estadoTareaService.deleteEstadoTarea(id);
    }
}