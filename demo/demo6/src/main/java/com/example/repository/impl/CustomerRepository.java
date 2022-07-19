package com.example.repository.impl;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;

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
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "sang", "nam"));
        customerList.add(new Customer(2, "dan", "nu"));
        customerList.add(new Customer(3, "duy", "nam"));
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
//        Session session = null;
//        List<Customer> customerList = null;
//        try {
//            session = ConnectionUtil.sessionFactory.openSession();
//            customerList = session.createQuery("FROM Customer").getResultList();
//        } finally {
//            if (session != null);
//            session.close();
//        }
//        return customerList;

//        TypedQuery<Customer> query = ConnectionUtil.entityManager.createQuery("SELECT s FROM Customer as s", Customer.class);
//        return query.getResultList();

        TypedQuery<Customer> query = entityManager
                .createQuery("SELECT s FROM Customer as s", Customer.class);
        return query.getResultList();
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
//        Transaction transaction = null;
//        Session session = null;
//        try {
//            session = ConnectionUtil.sessionFactory.openSession();
//            transaction = session.beginTransaction();
//
//            session.save(customer);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null){
//                transaction.rollback();
//            }
//        } finally {
//            if (session !=null) {
//                session.close();
//            }
//        }

        entityManager.persist(customer);
    }

    @Override
    public void update(int id, Customer customer) {
        entityManager.merge(customer);
//        for (Customer item: customerList) {
//            if (item.getId() == id) {
//                item.setName(customer.getName());
//                item.setGender(customer.getGender());
//            }
//        }
    }

    @Override
    public void delete(int id) {
//        customerList.removeIf(item -> item.getId() == id);
        entityManager.remove(id);
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
