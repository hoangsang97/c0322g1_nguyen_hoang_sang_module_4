package com.example.service;

import com.example.model.BoxLetter;

import java.util.List;

public interface IBoxLetterService {
    List<BoxLetter> FindAll();

    String[] languages();

    Integer[] size();

    BoxLetter FindById(int id);

    void UpdateBox(int id, BoxLetter boxLetter);
}
