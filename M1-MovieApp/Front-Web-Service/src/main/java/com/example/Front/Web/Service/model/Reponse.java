package com.example.Front.Web.Service.model;

import javax.persistence.*;

@Entity
@Table(name="REPONSE")
public class Reponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int note;
    private String comms;

    public Reponse() {
    }

    public Reponse(int id, int note, String comms) {
        this.id = id;
        this.note = note;
        this.comms = comms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getComms() {
        return comms;
    }

    public void setComms(String comms) {
        this.comms = comms;
    }
}

