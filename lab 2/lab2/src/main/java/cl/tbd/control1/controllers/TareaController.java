package cl.tbd.control1.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

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

    //BACKEND FUNCIONALIDAD 31//
    //BACKEND FUNCIONALIDAD 31//
    @GetMapping("/voluntario")
    public List<List<String>> getDisponibles(){
        List<Tarea> tareas=tareaService.getAll();
        List<List<String>> respuestaFinal=new ArrayList<>();
        List<String> respuesta=new ArrayList<>();
        List<String> respuesta1=new ArrayList<>();
        for (int i=0;i<tareas.size();i++){
            respuesta.add(tareas.get(i).getNombre());
            respuesta1.add(tareas.get(i).getNombre());
        }
        respuestaFinal.add(respuesta);
        respuestaFinal.add(respuesta);
        return respuestaFinal;
    }   
    //BACKEND FUNCIONALIDAD 31//
    //BACKEND FUNCIONALIDAD 31//

   
}