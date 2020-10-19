package com.example.Front.Web.Service.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="Rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String comms;

    @Min(1)
    @Max(10)
    private int note;

    public Rating() {
    }

    public Rating(String nom, String comms, @Min(1) @Max(10) int note) {
        this.nom = nom;
        this.comms = comms;
        this.note = note;
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

    public String getComms() {
        return comms;
    }

    public void setComms(String comms) {
        this.comms = comms;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
