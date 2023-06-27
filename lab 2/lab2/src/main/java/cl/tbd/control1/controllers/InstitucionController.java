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
import cl.tbd.control1.models.Institucion;
import cl.tbd.control1.services.InstitucionService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/institucion")
public class InstitucionController {
    @Autowired
    InstitucionService institucionService;
    @GetMapping("")
    public List <Institucion> getAll(){
        return institucionService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Institucion> select(@PathVariable int id){
        try{
            Institucion institucion= institucionService.select(id);
            return new ResponseEntity<Institucion>(institucion, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Institucion>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody Institucion institucion){
        institucionService.crearInstitucion(institucion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Institucion institucion,@PathVariable int id){
        try{
            institucionService.actualizarInstitucion(institucion, id);
            return new ResponseEntity<Institucion>(institucion, HttpStatus.OK);   
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Institucion>(HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        institucionService.deleteInstitucion(id);
    }
}
