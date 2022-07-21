package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Listen;

import java.util.Optional;

public interface IListenService {
    Page<Listen> findAll(Pageable pageable);

    Optional<Listen> findById(int id);

    void create(Listen listen);

    void update(Listen listen);

    void delete(int id);

    Page<Listen> search(String name, Pageable pageable);
}
