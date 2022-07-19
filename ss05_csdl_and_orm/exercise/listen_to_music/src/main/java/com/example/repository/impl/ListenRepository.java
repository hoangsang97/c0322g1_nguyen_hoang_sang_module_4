package com.example.repository.impl;

import com.example.model.Listen;
import com.example.repository.IListenRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ListenRepository implements IListenRepository {

    @Override
    public List<Listen> findAll() {
        Session session = null;
        List<Listen> listenList  = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            listenList = session.createQuery("FROM Listen").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return listenList;
    }

    @Override
    public Listen findById(int id) {
        Session session = null;
        Listen listen = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            listen = (Listen) session.createQuery("FROM Listen where id = :id").setParameter("id",id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return listen;
    }

    @Override
    public void create(Listen listen) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(listen);
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
    public void update(int id, Listen listen) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(listen);
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
        Transaction transaction = null;
        Session session = null;

        Listen listen = findById(id);

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.delete(listen);
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
    public List<Listen> search(String name) {
        Session session = null;
        List<Listen> listenList = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            listenList = session.createQuery("from Listen where listenName like :name").setParameter("name", name).getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return listenList;
    }
}
