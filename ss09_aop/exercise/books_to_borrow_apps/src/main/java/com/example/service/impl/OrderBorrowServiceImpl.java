package com.example.service.impl;

import com.example.model.OrderBorrow;
import com.example.repository.IOrderBorrowRepository;
import com.example.service.IOrderBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBorrowServiceImpl implements IOrderBorrowService {

    @Autowired
    private IOrderBorrowRepository orderBorrowRepository;

    @Override
    public void create(OrderBorrow orderBorrow) {
        orderBorrowRepository.save(orderBorrow);
    }
}
