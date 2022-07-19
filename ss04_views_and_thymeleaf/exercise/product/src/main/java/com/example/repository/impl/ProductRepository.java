package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("select s from Product as s", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> query = entityManager.createQuery("select s from Product as s where s.id = :id", Product.class).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void create(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void update(int id, Product product) {
        entityManager.merge(product);
    }

    @Override
    public void delete(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> search(String name) {
        TypedQuery<Product> query = entityManager.createQuery("select s from Product as s where s.productName like : name", Product.class).setParameter("name", name);
        return query.getResultList();
    }
}
