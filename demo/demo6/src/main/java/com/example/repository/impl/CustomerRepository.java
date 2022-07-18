package com.example.repository.impl;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "sang", "nam"));
        customerList.add(new Customer(2, "dan", "nu"));
        customerList.add(new Customer(3, "duy", "nam"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        for (Customer item: customerList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void create(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void update(int id, Customer customer) {
        for (Customer item: customerList) {
            if (item.getId() == id) {
                item.setName(customer.getName());
                item.setGender(customer.getGender());
            }
        }
    }

    @Override
    public void delete(int id) {
        customerList.removeIf(item -> item.getId() == id);
    }

    @Override
    public List<Customer> search(String name) {
        List<Customer> customers = new ArrayList<>();
        for (Customer item: customerList) {
            if (item.getName().equals(name)) {
                customers.add(item);
            }
        }
        return customers;
    }
}
