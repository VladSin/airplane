package org.example.airplane.sin.service.repository.impl;

import org.example.airplane.sin.dao.entities.Person;
import org.example.airplane.sin.dao.repository.PersonDao;
import org.example.airplane.sin.service.repository.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao){
        super(personDao);
        this.personDao = personDao;
    }

    public Person create(Person person) {
        if(person != null){
            return personDao.add(person);
        }
        return null;
    }

    public void delete(Person person) {
        if(person != null){
            personDao.delete(person.getId());
        }
    }
}
