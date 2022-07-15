package com.example.repository;

import com.example.model.BoxLetter;

import java.util.List;

public interface IBoxLetterRepository {
    List<BoxLetter> FindAll();

    BoxLetter FindById(int id);

    void UpdateBox(int id, BoxLetter boxLetter);
}
