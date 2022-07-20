package com.example.repository.impl;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select s from Customer as s", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(int id) {
        TypedQuery<Customer> query = entityManager.createQuery("select s from Customer as s where s.id = : id", Customer.class).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void create(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void update(int id, Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public void delete(int id) {
        Customer customer = findById(id);
        entityManager.remove(customer);
    }

    @Override
    public List<Customer> search(String name) {
        TypedQuery<Customer> query = entityManager.createQuery("select s from Customer as s where s.name like ? 1", Customer.class).setParameter(1, "%" + name + "%");
        return query.getResultList();
    }
}
