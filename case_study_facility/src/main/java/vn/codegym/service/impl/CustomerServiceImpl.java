package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Customer;
import vn.codegym.repository.ICustomerRepository;
import vn.codegym.service.ICustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAllCustomer(pageable);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer.getCustomerType().getId(), customer.getName(), customer.getDateOfBirth(), customer.getGender()
                , customer.getIdCard(), customer.getPhoneNumber(), customer.getEmail(), customer.getAddress(), customer.getId());
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }

    @Override
    public Page<Customer> search(String name, Pageable pageable) {
        return customerRepository.search("%" + name + "%", pageable);
    }
}
