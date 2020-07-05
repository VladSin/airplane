package org.example.airplane.sin.service.repository.impl;

import org.example.airplane.sin.dao.entities.Person;
import org.example.airplane.sin.dao.repository.PersonDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BaseServiceImplTest {

    @Mock
    PersonDao dao;

    @InjectMocks
    PersonServiceImpl service;

    @Test
    void add() {
        final Person personToAdd = new Person(null, "Person", "Person","Person@gmail.com");
        when(service.add(personToAdd)).thenReturn(new Person(1L, "Person", "Person","Person@gmail.com"));

        final Person addedPerson = service.add(personToAdd);
        assertNotNull(addedPerson);

        assertEquals(personToAdd.getName(), addedPerson.getName());
        assertEquals(personToAdd.getSurname(), addedPerson.getSurname());
        assertEquals(personToAdd.getEmail(), addedPerson.getEmail());
    }

    @Test
    void update() {
        final Person updatedPerson = new Person(1L, "PersonUpdate", "PersonUpdate","PersonUpdate@gmail.com");
        when(service.update(updatedPerson)).thenReturn(updatedPerson);

        final Person afterUpdatePerson = service.update(updatedPerson);
        assertEquals(updatedPerson.getName(), afterUpdatePerson.getName());
        assertEquals(updatedPerson.getSurname(), afterUpdatePerson.getSurname());
        assertEquals(updatedPerson.getEmail(), afterUpdatePerson.getEmail());
    }

    @Test
    void get() {
        final Person person = new Person(1L, "Person", "Person","Person@gmail.com");
        when(service.get(person.getId())).thenReturn(new Person(1L, "Person", "Person","Person@gmail.com"));

        final Person receivedPerson = service.get(person.getId());
        assertEquals(person.getName(), receivedPerson.getName());
        assertEquals(person.getSurname(), receivedPerson.getSurname());
        assertEquals(person.getEmail(), receivedPerson.getEmail());
    }

    @Test
    void delete() {
        final Person personToCreate = new Person(null, "Person", "Person","Person@gmail.com");
        when(service.create(personToCreate)).thenReturn(new Person(1L, "Person", "Person","Person@gmail.com"));

        final Person createdPerson = service.create(personToCreate);
        assertNotNull(createdPerson);

        service.delete(createdPerson.getId());
    }
}