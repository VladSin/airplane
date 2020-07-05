package org.example.airplane.sin.dao.repository;

import java.io.Serializable;

public interface BaseDao<T> {

    T add(T t);

    T update(T t);

    T get(Serializable id);

    void delete(Serializable id);
}
