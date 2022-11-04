package com.javatechie.aws.controller;

import com.javatechie.aws.model.Person;
import com.javatechie.aws.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/savePerson")
    public Person addPerson(@RequestBody  Person person){
        return personRepository.addPerson(person);
    }

    @GetMapping("/getPerson/{personId}")
    public Person getPerson(@PathVariable("personId") String personID){
        return personRepository.findPersonByPersonId(personID);
    }
    @DeleteMapping("/deletePerson")
    public String deletePerson(@RequestBody Person person){
        return personRepository.deletePerson(person);
    }

    @PutMapping("/updatePerson")
    public String updatePerson(@RequestBody Person person){
        return personRepository.updatePerson(person);
    }
}
