package com.chansuk.productservice.web;

import com.chansuk.productservice.dao.ProductDao;
import com.chansuk.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@EnableEurekaClient
@RestController
@CrossOrigin()
public class ProductController {

    @Autowired
    private ProductDao productDao;


    //Récupérer la liste des produits
    @RequestMapping(value = "/Produits", method = RequestMethod.GET)

    public List<Product> listeProduits() {
        return productDao.findAll();
    }


    //Récupérer un produit par son Id
    @GetMapping(value = "/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return productDao.findById(id);
    }

    @GetMapping(value = "test/Produits/{recherche}")
    public List<Product> testeDeRequetes(@PathVariable String recherche) {
        return productDao.findByNomLike("%"+recherche+"%");
    }

    @GetMapping(value = "test/Produits/{prixLimit}")
    public List<Product> testeDeRequetes(@PathVariable int prixLimit) {
        return productDao.findByPrixGreaterThan(400);
    }


    //ajouter un produit
    @PostMapping(value = "/Produits")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Product product) {

        Product productAdded =  productDao.save(product);

        if (productAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }



    @DeleteMapping("/Produits/{id}")
    public void suppProduits(@PathVariable int id){
        productDao.deleteById(id);
    }

}