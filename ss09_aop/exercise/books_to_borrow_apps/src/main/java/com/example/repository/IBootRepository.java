package com.example.repository;

import com.example.model.Boot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IBootRepository extends JpaRepository<Boot, Integer> {

    @Modifying
    @Query(value = "update boot set amount = amount - 1 where id = :id", nativeQuery = true)
    void updateAmount(@Param("id") int id);

    @Modifying
    @Query(value = "update boot set amount = amount + 1 where id = :id", nativeQuery = true)
    void payAmount(@Param("id") int id);
}
