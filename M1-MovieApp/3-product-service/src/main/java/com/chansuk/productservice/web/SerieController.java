package com.chansuk.productservice.web;

import com.chansuk.productservice.dao.FilmDao;
import com.chansuk.productservice.dao.SerieDao;
import com.chansuk.productservice.model.Film;
import com.chansuk.productservice.model.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@EnableEurekaClient
@CrossOrigin()
public class SerieController {
    @Autowired
    private SerieDao serieDao;


    //Récupérer la liste des produits
    @RequestMapping(value = "/Serie", method = RequestMethod.GET)
    public List<Serie> allSeries() {
        return serieDao.findAll();
    }

    //Récupérer un produit par son Id
    @GetMapping(value = "/Serie/id/{id}")
    public Serie oneSerie(@PathVariable int id) {
        return serieDao.findById(id);
    }

    @GetMapping(value = "/Serie/nom/{recherche}")
    public List<Serie> testRequest(@PathVariable String recherche) {
        return serieDao.findByNomLike("%"+recherche+"%");
    }

    //ajouter un produit
    @PostMapping(value = "/Serie")
    public ResponseEntity<Void> addSerie(@RequestBody Serie serie) {

        Serie serieAdded =  serieDao.save(serie);

        if (serieAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(serieAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/Serie/{id}")
    public void delSerie(@PathVariable int id){
        serieDao.deleteById(id);
    }
}
