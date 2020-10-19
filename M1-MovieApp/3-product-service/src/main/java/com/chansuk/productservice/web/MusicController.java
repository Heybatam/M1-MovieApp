package com.chansuk.productservice.web;

import com.chansuk.productservice.dao.MusicDao;
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
public class MusicController {

    @Autowired
    private MusicDao musicDao;


    //Récupérer la liste des produits
    @RequestMapping(value = "/Music", method = RequestMethod.GET)
    public List<Music> listeMusic() {
        return musicDao.findAll();
    }

    //Récupérer un produit par son Id
    @GetMapping(value = "/Music/id/{id}")
    public Music aafficheMusic(@PathVariable int id) {
        return musicDao.findById(id);
    }

    @GetMapping(value = "/Music/nom/{recherche}")
    public List<Music> testeDeRequetes(@PathVariable String recherche) {
        return musicDao.findByNomAlbumLike("%"+recherche+"%");
    }

    //ajouter un produit
    @PostMapping(value = "/Music")
    public ResponseEntity<Void> ajoutMusict(@RequestBody Music music) {

        Music musicAdded =  musicDao.save(music);

        if (musicAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(musicAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/Music/{id}")
    public void delMusic(@PathVariable int id){musicDao.deleteById(id);}
}
