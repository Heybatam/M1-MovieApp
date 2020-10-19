package com.example.Front.Web.Service.beans;

public class Music {


    private int id;
    private String nomAlbum;
    private String artist;
    private int annee;
    private int duree;

    public Music() {
    }

    public Music(int id, String nomAlbum, String artist, int annee,int duree) {
        this.id = id;
        this.nomAlbum = nomAlbum;
        this.artist = artist;
        this.annee = annee;
        this.duree = duree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomAlbum() {
        return nomAlbum;
    }

    public void setNomAlbum(String nomAlbum) {
        this.nomAlbum = nomAlbum;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", nomAlbum='" + nomAlbum + '\'' +
                ", artist='" + artist + '\'' +
                ", annee=" + annee +
                ", duree=" + duree +
                '}';
    }
}


