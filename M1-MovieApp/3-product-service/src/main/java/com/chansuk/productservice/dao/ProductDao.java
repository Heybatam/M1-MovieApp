package com.chansuk.productservice.dao;

import com.chansuk.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Product findById(int id);
    List<Product> findByPrixGreaterThan(int prixLimit);
    List<Product> findByNomLike(String recherche);
}
