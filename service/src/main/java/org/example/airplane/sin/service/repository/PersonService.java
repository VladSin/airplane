package org.example.airplane.sin.service.repository;

import org.example.airplane.sin.dao.entities.Person;

public interface PersonService extends BaseService<Person> {

    Person create(Person person);

    void delete(Person person);
}
