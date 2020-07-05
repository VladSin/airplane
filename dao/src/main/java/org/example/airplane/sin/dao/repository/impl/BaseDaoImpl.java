package org.example.airplane.sin.dao.repository.impl;

import lombok.Getter;
import org.example.airplane.sin.dao.repository.BaseDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
    Class<T> clazz;

    @PersistenceContext
    @Getter
    private final EntityManager entityManager;

    public BaseDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public T add(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T update(T t) {
        entityManager.merge(t);
        return t;
    }

    @Override
    public T get(Serializable id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public void delete(Serializable id) {
        T t = entityManager.find(clazz, id);
        entityManager.remove(t);
    }
}
