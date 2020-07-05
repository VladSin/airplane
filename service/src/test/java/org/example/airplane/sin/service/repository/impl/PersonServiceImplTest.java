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
class PersonServiceImplTest {

    @Mock
    PersonDao dao;

    @InjectMocks
    PersonServiceImpl service;

    @Test
    void create() {
        final Person personToCreate = new Person(null, "Person", "Person","Person@gmail.com");
        when(service.create(personToCreate)).thenReturn(new Person(1L, "Person", "Person","Person@gmail.com"));

        final Person createdPerson = service.create(personToCreate);
        assertNotNull(createdPerson);

        assertEquals(personToCreate.getName(), createdPerson.getName());
        assertEquals(personToCreate.getSurname(), createdPerson.getSurname());
        assertEquals(personToCreate.getEmail(), createdPerson.getEmail());
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