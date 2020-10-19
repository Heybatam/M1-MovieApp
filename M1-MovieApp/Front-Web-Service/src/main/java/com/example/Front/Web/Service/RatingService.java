package com.example.Front.Web.Service;

import com.example.Front.Web.Service.beans.Film;
import com.example.Front.Web.Service.beans.Music;
import com.example.Front.Web.Service.dao.RatingDAO;
import com.example.Front.Web.Service.model.Rating;
import com.example.Front.Web.Service.model.Reponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin()
public class RatingService {



    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RatingDAO ratingDAO;

    @GetMapping("/")
    String hello(){
        return "Service rating: actif";
    }

    @GetMapping("/ratings")
    public List<Rating> retourReviews(){
        return ratingDAO.findAll();
    }


    @GetMapping("/ratings/{id}")
    Rating retour1Review(@PathVariable int id){
        return ratingDAO.findById(id);
    }

    @GetMapping("/ratings/nom/{nom}")
    public List<Rating> recupNomRev(@PathVariable String nom){
        return ratingDAO.findByNomLike(nom);
    }


    @PostMapping("/ratings")
    public ResponseEntity<Void> addFilm(@RequestBody Rating rating) {

        Rating ratingAdded = ratingDAO.save(rating);

        if (ratingAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(ratingAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }



    @GetMapping("/ratings/film/{id}")
    public ResponseEntity commsFilm(@PathVariable int id, @RequestBody Reponse reponse) {

        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
        ServiceInstance test = instances.get(0);

        //infos
        String hostname = test.getHost();
        int port = test.getPort();
        String microservice1Address = "http://" + hostname + ":" + port + "/Film/id/"+id;

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Film> response = restTemplate.getForEntity(microservice1Address, Film.class);

        Rating rating = new Rating(response.getBody().getNom(),reponse.getComms(), reponse.getNote());

        Rating ratingAdded =  ratingDAO.save(rating);

        if (ratingAdded == null) return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(ratingAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/ratings/music/{id}")
    public ResponseEntity<Void> commsAlbum(@PathVariable int id, @RequestBody Reponse reponse) {

        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
        ServiceInstance test = instances.get(0);

        //infos
        String hostname = test.getHost();
        int port = test.getPort();
        String microservice1Address = "http://" + hostname + ":" + port + "/Music/id/"+id;

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Music> response = restTemplate.getForEntity(microservice1Address, Music.class);

        Rating rating = new Rating(response.getBody().getNomAlbum(), reponse.getComms(), reponse.getNote());

        Rating ratingAdded =  ratingDAO.save(rating);

        if (ratingAdded == null) return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(ratingAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @PostMapping("/ratings/ici")
    public void ajoutRatings(@RequestBody Reponse reponse){
        Rating res = new Rating("ballec",reponse.getComms(),reponse.getNote());
        ratingDAO.save(res);
    }

    @DeleteMapping("/ratings/{id}")
    public void delRatings(@PathVariable int id){
        ratingDAO.deleteById(id);
    }

    public String defaultMessage() {
        return "Salut !";
    }

}


