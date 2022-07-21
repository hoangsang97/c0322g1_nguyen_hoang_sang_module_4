package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Student;

import java.util.Optional;

public interface IStudentService {
    Page<Student> findAll(Pageable pageable);

    Optional<Student> findByID(int id);

    void create(Student student);
}
