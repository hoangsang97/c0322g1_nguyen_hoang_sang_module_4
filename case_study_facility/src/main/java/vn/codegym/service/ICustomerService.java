package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAllCustomer();

    Optional<Customer> findById(int id);

    void create(Customer customer);

    void update(Customer customer);

    void delete(int id);

    Page<Customer> search(String name, Pageable pageable);
}
