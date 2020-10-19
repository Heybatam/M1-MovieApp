package com.example.Front.Web.Service.dao;

import com.example.Front.Web.Service.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingDAO extends JpaRepository<Rating, Integer> {

    Rating findById(int id);
    List<Rating> findByNomLike(String nom);
}
