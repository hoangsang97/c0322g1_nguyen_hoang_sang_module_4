package com.example.service.impl;

import com.example.model.Listen;
import com.example.repository.IListenRepository;
import com.example.service.IListenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListenService implements IListenService {
    @Autowired
    private IListenRepository listenRepository;

    @Override
    public List<Listen> findAll() {
        return listenRepository.findAll();
    }

    @Override
    public Listen findById(int id) {
        return listenRepository.findById(id);
    }

    @Override
    public void create(Listen listen) {
        listenRepository.create(listen);
    }

    @Override
    public void update(int id, Listen listen) {
        listenRepository.update(id, listen);
    }

    @Override
    public void delete(int id) {
        listenRepository.delete(id);
    }

    @Override
    public List<Listen> search(String name) {
        return listenRepository.search(name);
    }
}
