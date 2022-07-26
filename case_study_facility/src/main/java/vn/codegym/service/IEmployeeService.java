package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Employee;

import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Optional<Employee> findById(int id);

    void create(Employee employee);

    void update(Employee employee);

    void delete(int id);
}
