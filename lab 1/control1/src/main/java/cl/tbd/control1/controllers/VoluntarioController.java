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
import cl.tbd.control1.models.Voluntario;
import cl.tbd.control1.services.VoluntarioService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/voluntario")
public class VoluntarioController {
    @Autowired
    VoluntarioService voluntarioService;
    @GetMapping("")
    public List <Voluntario> getAll(){
        return voluntarioService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Voluntario> select(@PathVariable int id){
        try{
            Voluntario voluntario= voluntarioService.select(id);
            return new ResponseEntity<Voluntario>(voluntario, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Voluntario>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody Voluntario voluntario){
        List<Voluntario> voluntarios =  voluntarioService.getAll();
        for (int i = 0; i < voluntarios.size(); i++) {
            if(voluntarios.get(i).getCorreo().equals(voluntario.getCorreo())){
                System.out.println("correo repetido");
                return;
            }
        }
        voluntarioService.crearVoluntario(voluntario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Voluntario voluntario,@PathVariable int id){
        try{
            voluntarioService.actualizarVoluntario(voluntario, id);
            return new ResponseEntity<Voluntario>(voluntario, HttpStatus.OK);   
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Voluntario>(HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        voluntarioService.deleteVoluntario(id);
    }
}
