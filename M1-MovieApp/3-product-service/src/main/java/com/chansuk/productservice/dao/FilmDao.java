package com.chansuk.productservice.dao;

import com.chansuk.productservice.model.Film;
import com.chansuk.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmDao extends JpaRepository<Film, Integer> {
    Film findById(int id);
    List<Film> findByNomLike(String nom);
}
