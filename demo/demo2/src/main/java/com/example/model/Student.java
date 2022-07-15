package com.example.model;

public class Student {
    private int id;
    private String name;
    private String[] languages;

    public Student() {
    }

    public Student(int id, String name, String[] languages) {
        this.id = id;
        this.name = name;
        this.languages = languages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
}
