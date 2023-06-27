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
import cl.tbd.control1.models.Habilidad;
import cl.tbd.control1.services.HabilidadService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/habilidad")
public class HabilidadController {
    @Autowired
    HabilidadService habilidadService;
    @GetMapping("")
    public List <Habilidad> getAll(){
        return habilidadService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Habilidad> select(@PathVariable int id){
        try{
            Habilidad habilidad= habilidadService.select(id);
            return new ResponseEntity<Habilidad>(habilidad, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Habilidad>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody Habilidad habilidad){
        habilidadService.crearHabilidad(habilidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Habilidad habilidad,@PathVariable int id){
        try{
            habilidadService.actualizarHabilidad(habilidad, id);
            return new ResponseEntity<Habilidad>(habilidad, HttpStatus.OK);   
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Habilidad>(HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        habilidadService.deleteHabilidad(id);
    }
}