package com.example.repository;

import com.example.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepository extends JpaRepository<Borrow, Integer> {
}
