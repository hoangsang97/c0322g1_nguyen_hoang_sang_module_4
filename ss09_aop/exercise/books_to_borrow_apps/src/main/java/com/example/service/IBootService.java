package com.example.service;

import com.example.model.Boot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBootService {
    Page<Boot> findAll(Pageable pageable);

    void updateAmount (int id);

    void payAmount(int id);
}
