package com.chansuk.productservice.model;

import javax.persistence.*;

@Entity
@Table(name="FILM")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;
    private String realisateur;
    private int duree;
    private int annee;

    public Film() {
    }

    public Film(int id, String nom, String description, String realisateur, int duree, int annee) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.realisateur = realisateur;
        this.duree = duree;
        this.annee = annee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", duree=" + duree +
                ", annee=" + annee +
                '}';
    }
}
