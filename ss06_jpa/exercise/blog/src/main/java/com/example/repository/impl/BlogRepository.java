package com.example.repository.impl;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepository implements IBlogRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
       TypedQuery<Blog> query = entityManager.createQuery("select s from Blog s", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(int id) {
        TypedQuery<Blog> query = entityManager.createQuery("select s from Blog as s where s.id = :id", Blog.class).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void create(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public void update(Blog blog) {
        entityManager.merge(blog);
    }

    @Override
    public void delete(int id) {
        Blog blog = findById(id);
        entityManager.remove(blog);
    }
}
