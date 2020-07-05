package org.example.airplane.sin.dao.repository.impl;

import org.example.airplane.sin.dao.entities.Person;
import org.example.airplane.sin.dao.repository.PersonDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao {

    public PersonDaoImpl(EntityManager entityManager){
        super(entityManager);
        clazz = Person.class;
    }
}
