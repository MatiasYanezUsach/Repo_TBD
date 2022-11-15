package cl.tbd.control1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.control1.models.Habilidad;
import cl.tbd.control1.services.Consulta31Service;
import cl.tbd.control1.models.TareaEstructura;
import cl.tbd.control1.models.EmergenciaEstructura;

@RestController
@CrossOrigin(origins = "*", methods={RequestMethod.GET})
@RequestMapping("/consulta31")
public class Consulta31Controller {

    @Autowired
    Consulta31Service consulta31Service;

    @GetMapping("/{id}")
    public List<Object> getRequisitos(@PathVariable int id){
        return consulta31Service.getRequisitos(id);
    }
}
