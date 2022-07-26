package com.example.service.impl;

import com.example.model.Borrow;
import com.example.repository.IBorrowRepository;
import com.example.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements IBorrowService {

    @Autowired
    private IBorrowRepository borrowRepository;

    @Override
    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }
}
