package com.chansuk.productservice.dao;

import com.chansuk.productservice.model.Music;
import com.chansuk.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicDao extends JpaRepository<Music, Integer> {
    Music findById(int id);
    List<Music> findByNomAlbumLike(String recherche);
}
