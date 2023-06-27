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
import cl.tbd.control1.models.Ranking;
import cl.tbd.control1.services.RankingService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/ranking")
public class RankingController {
    @Autowired
    RankingService rankingService;
    @GetMapping("")
    public List <Ranking> getAll(){
        return rankingService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ranking> select(@PathVariable int id){
        try{
            Ranking ranking= rankingService.select(id);
            return new ResponseEntity<Ranking>(ranking, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Ranking>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody Ranking ranking){
        rankingService.crearRanking(ranking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Ranking ranking,@PathVariable int id){
        try{
            rankingService.actualizarRanking(ranking, id);
            return new ResponseEntity<Ranking>(ranking, HttpStatus.OK);   
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Ranking>(HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        rankingService.deleteRanking(id);
    }
}