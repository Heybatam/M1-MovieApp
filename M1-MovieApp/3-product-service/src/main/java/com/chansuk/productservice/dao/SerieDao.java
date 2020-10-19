package com.chansuk.productservice.dao;

import com.chansuk.productservice.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerieDao extends JpaRepository<Serie, Integer> {
    Serie findById(int id);
    List<Serie> findByNomLike(String nom);
}
