package org.example.airplane.sin.dao.repository.impl;

import org.example.airplane.sin.dao.config.DaoConfig;
import org.example.airplane.sin.dao.entities.Person;
import org.example.airplane.sin.dao.repository.BaseDao;
import org.example.airplane.sin.dao.repository.PersonDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
@Commit
class PersonDaoImplTest {

    @Autowired
    private PersonDao personDao;

    @Test
    void add() {
        final Person personToSave = new Person();
        personToSave.setName("Person");
        personToSave.setSurname("Person");
        personToSave.setEmail("Person@gmail.com");

        final Person savedPerson = personDao.add(personToSave);
        assertNotNull(savedPerson);

        assertEquals(personToSave.getName(), savedPerson.getName());
        assertEquals(personToSave.getSurname(), savedPerson.getSurname());
        assertEquals(personToSave.getEmail(), savedPerson.getEmail());
    }

    @Test
    void update() {
        final Person personToSave = new Person();
        personToSave.setName("Person");
        personToSave.setSurname("Person");
        personToSave.setEmail("Person@gmail.com");

        final Person savedPerson = personDao.add(personToSave);

        final Person personToUpdate = new Person();
        personToSave.setId(savedPerson.getId());
        personToSave.setName("PersonUpdate");
        personToSave.setSurname("PersonUpdate");
        personToSave.setEmail("PersonUpdate@gmail.com");

        final Person updatedPerson = personDao.update(personToUpdate);
        assertNotNull(updatedPerson);

        assertEquals(personToUpdate.getName(), updatedPerson.getName());
        assertEquals(personToUpdate.getSurname(), updatedPerson.getSurname());
        assertEquals(personToUpdate.getEmail(), updatedPerson.getEmail());
    }

    @Test
    void get() {
        final Person personToSave = new Person();
        personToSave.setName("Person");
        personToSave.setSurname("Person");
        personToSave.setEmail("Person@gmail.com");

        final Person savedPerson = personDao.add(personToSave);
        final Person receivedPerson = personDao.get(savedPerson.getId());

        assertEquals(savedPerson.getName(), receivedPerson.getName());
        assertEquals(savedPerson.getSurname(), receivedPerson.getSurname());
        assertEquals(savedPerson.getEmail(), receivedPerson.getEmail());
    }

    @Test
    void delete() {
        final Person personToSave = new Person();
        personToSave.setName("Person");
        personToSave.setSurname("Person");
        personToSave.setEmail("Person@gmail.com");

        final Person savedPerson = personDao.add(personToSave);
        personDao.delete(savedPerson.getId());

        final Person deletedPerson = personDao.get(savedPerson.getId());
        assertNull(deletedPerson);
    }
}