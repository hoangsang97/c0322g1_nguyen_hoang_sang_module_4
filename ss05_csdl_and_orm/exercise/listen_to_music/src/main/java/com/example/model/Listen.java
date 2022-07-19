package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Listen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String listenName;
    private String artist;
    private String category;
    private String pathFile;

    public Listen() {
    }

    public Listen(int id, String listenName, String artist, String category, String pathFile) {
        this.id = id;
        this.listenName = listenName;
        this.artist = artist;
        this.category = category;
        this.pathFile = pathFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListenName() {
        return listenName;
    }

    public void setListenName(String listenName) {
        this.listenName = listenName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
}
