package com.example.model;

public class BoxLetter {
    private int id;
    private String languages;
    private int size;
    private String filter;
    private String[] signature;

    public BoxLetter() {
    }

    public BoxLetter(int id, String languages, int size, String filter, String[] signature) {
        this.id = id;
        this.languages = languages;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String[] getSignature() {
        return signature;
    }

    public void setSignature(String[] signature) {
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
