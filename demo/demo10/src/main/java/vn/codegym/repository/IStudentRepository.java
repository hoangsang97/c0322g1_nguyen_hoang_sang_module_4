package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
}
