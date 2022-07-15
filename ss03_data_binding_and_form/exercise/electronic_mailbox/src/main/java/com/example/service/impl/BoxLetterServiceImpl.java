package com.example.service.impl;

import com.example.model.BoxLetter;
import com.example.repository.IBoxLetterRepository;
import com.example.repository.impl.BoxLetterRepositoryImpl;
import com.example.service.IBoxLetterService;

import java.util.List;

public class BoxLetterServiceImpl implements IBoxLetterService {
    private IBoxLetterRepository boxLetterRepository = new BoxLetterRepositoryImpl();

    @Override
    public List<BoxLetter> FindAll() {
        return boxLetterRepository.FindAll();
    }

    @Override
    public BoxLetter FindById(int id) {
        return boxLetterRepository.FindById(id);
    }

    @Override
    public void UpdateBox(int id, BoxLetter boxLetter) {
        boxLetterRepository.UpdateBox(id, boxLetter);
    }
}
