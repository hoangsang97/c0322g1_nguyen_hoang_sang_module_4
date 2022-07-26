package com.example.repository;

import com.example.model.OrderBorrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderBorrowRepository extends JpaRepository<OrderBorrow, Integer> {
}
