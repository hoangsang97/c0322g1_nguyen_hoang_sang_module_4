package com.example.service;

import com.example.model.Borrow;

import java.util.List;

public interface IBorrowService {
    List<Borrow> findAll();
}
