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
import cl.tbd.control1.models.Vol_habilidad;
import cl.tbd.control1.services.Vol_habilidadService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/vol_habilidad")
public class Vol_habilidadController {
    @Autowired
    Vol_habilidadService vol_habilidadService;
    @GetMapping("")
    public List <Vol_habilidad> getAll(){
        return vol_habilidadService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vol_habilidad> select(@PathVariable int id){
        try{
            Vol_habilidad vol_habilidad= vol_habilidadService.select(id);
            return new ResponseEntity<Vol_habilidad>(vol_habilidad, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Vol_habilidad>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody Vol_habilidad vol_habilidad){
        System.out.println(vol_habilidad.getId());
        vol_habilidadService.crearVol_habilidad(vol_habilidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Vol_habilidad vol_habilidad,@PathVariable int id){
        try{
            vol_habilidadService.actualizarVol_habilidad(vol_habilidad, id);
            return new ResponseEntity<Vol_habilidad>(vol_habilidad, HttpStatus.OK);   
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Vol_habilidad>(HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        vol_habilidadService.deleteVol_habilidad(id);
    }
}