package com.chansuk.productservice.web;

import com.chansuk.productservice.dao.FilmDao;
import com.chansuk.productservice.dao.MusicDao;
import com.chansuk.productservice.model.Film;
import com.chansuk.productservice.model.Music;
import com.chansuk.productservice.model.Product;
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
public class FilmController {
    @Autowired
    private FilmDao filmDao;

    //Récupérer la liste des produits
    @RequestMapping(value = "/Film", method = RequestMethod.GET)
    public List<Film> allFilms() {
        return filmDao.findAll();
    }

    //Récupérer un produit par son Id
    @GetMapping(value = "/Film/id/{id}")
    public Film oneFilm(@PathVariable int id) {
        return filmDao.findById(id);
    }

    @GetMapping(value = "/Film/nom/{recherche}")
    public List<Film> testRequest(@PathVariable String recherche) {
        return filmDao.findByNomLike("%"+recherche+"%");
    }

    //ajouter un produit
    @PostMapping(value = "/Film")
    public ResponseEntity<Void> addFilm(@RequestBody Film film) {

        Film musicAdded =  filmDao.save(film);

        if (musicAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(musicAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/Film/{id}")
    public void suppFilm(@PathVariable int id){
        filmDao.deleteById(id);
    }
}
