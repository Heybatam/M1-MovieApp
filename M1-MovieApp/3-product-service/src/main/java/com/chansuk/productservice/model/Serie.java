package com.chansuk.productservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SERIE")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;
    private String realisateur;
    private int duree;
    private int annee;
    private int nbSaison;

    public Serie() {
    }

    public Serie(int id, String nom, String description, String realisateur, int duree, int annee, int nbSaison) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.realisateur = realisateur;
        this.duree = duree;
        this.annee = annee;
        this.nbSaison = nbSaison;
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

    public int getNbSaison() {
        return nbSaison;
    }

    public void setNbSaison(int nbSaison) {
        this.nbSaison = nbSaison;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", duree=" + duree +
                ", annee=" + annee +
                ", nbSaison=" + nbSaison +
                '}';
    }
}
