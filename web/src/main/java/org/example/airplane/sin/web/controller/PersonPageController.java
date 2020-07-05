package org.example.airplane.sin.web.controller;

import org.example.airplane.sin.dao.entities.Person;
import org.example.airplane.sin.service.repository.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/person")
public class PersonPageController {

    private static final String MAIN = "person/main";

    private PersonService personService;

    @Autowired
    public PersonPageController(PersonService personService){
        this.personService = personService;
    }


    @GetMapping(value = "/page")
    public String mainPage(ModelMap model) {
        return MAIN;
    }

    @PostMapping(value = "/add")
    public String addPerson(ModelMap model,
                            @Valid Person person, BindingResult br) {
        if (!br.hasErrors()) {
            if (person != null) {
                person = personService.create(person);
                model.put("person", person);
            }
        }
        model.put("person", personService.get(person.getId()));
        return MAIN;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updatePerson(ModelMap model, Person person) {
        if (person != null) {
            personService.update(person);
            model.put("message", "Person: " + person.getName() + " was update");
        }
        return MAIN;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePerson(ModelMap model, Person person) {
        if (person != null) {
            personService.delete(person);
            model.put("message", "Person: " + person.getName() + " was deleted");
        }
        return MAIN;
    }
}
