package com.example.repository.impl;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        Session session = null;
        List<Customer> customerList = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            customerList = session.createQuery("FROM Customer ").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Session session = null;
        Customer customer = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            customer = (Customer) session.createQuery("from Customer where id = :id").setParameter("id", id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return customer;
    }

    @Override
    public void create(Customer customer) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(customer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(int id, Customer customer) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(customer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;

        Customer customer = findById(id);

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.delete(customer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Customer> search(String name) {
        List<Customer> customerList = findAll();
        List<Customer> customers = new ArrayList<>();
        for (Customer item : customerList) {
            if (item.getName().equals(name)) {
                customers.add(item);
            }
        }
        return customers;
    }
}
