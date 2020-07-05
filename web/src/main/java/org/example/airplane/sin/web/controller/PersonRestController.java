package org.example.airplane.sin.web.controller;

import org.example.airplane.sin.dao.entities.Person;
import org.example.airplane.sin.service.repository.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonRestController {

    private PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping(value = "")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        Person newPerson = personService.create(person);
        return new ResponseEntity<Person>(newPerson, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id){
        Person person = personService.get(id);
        if (person == null){
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id,
                                               @RequestBody Person newPerson){
        Person person = personService.get(id);

        if(person == null){
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        person.setName(newPerson.getName());
        person.setSurname(newPerson.getSurname());
        person.setEmail(newPerson.getEmail());

        newPerson = personService.update(person);
        return new ResponseEntity<Person>(newPerson, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletePerson(@PathVariable("id") Long id){
        personService.delete(id);
        return "OK";
    }
}
