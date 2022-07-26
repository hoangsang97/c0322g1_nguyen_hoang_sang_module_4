package com.example.service.impl;

import com.example.model.Boot;
import com.example.repository.IBootRepository;
import com.example.service.IBootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BootService implements IBootService {

    @Autowired
    private IBootRepository bootRepository;

    @Override
    public Page<Boot> findAll(Pageable pageable) {
        return bootRepository.findAll(pageable);
    }

    @Override
    public void updateAmount(int id) {
        bootRepository.updateAmount(id);
    }

    @Override
    public void payAmount(int id) {
        bootRepository.payAmount(id);
    }
}
