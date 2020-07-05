package org.example.airplane.sin.service.repository.impl;

import lombok.NoArgsConstructor;
import org.example.airplane.sin.dao.repository.BaseDao;
import org.example.airplane.sin.service.repository.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@NoArgsConstructor
@Service
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {

    private final BaseDao<T> baseDao;

    @Autowired
    public BaseServiceImpl(BaseDao baseDao){
        this.baseDao = baseDao;
    }

    public T add(T t) {
        baseDao.add(t);
        return t;
    }

    public T update(T t) {
        return baseDao.update(t);
    }

    public T get(Serializable id) {
        return baseDao.get(id);
    }

    public void delete(Serializable id) {
        baseDao.delete(id);
    }
}
