package com.nej.perso.echange.controller;


import com.nej.perso.echange.entities.Person;
import com.nej.perso.echange.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController()
@RequestMapping("/v1/persons")
public class UserManagerController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping
    public ResponseEntity createPerson(@RequestBody Person student){
        //TODO validate person type: [student, father, mother]
        student.setUuid(UUID.randomUUID().toString());
        personRepository.save(student);

        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/students/{studentUUID}/parents")
    @Transactional
    public ResponseEntity setParent(@PathVariable("studentUUID") String studentUuid, @RequestBody Person parent){
        //TODO validate inputs

        //FIXME review
        Person student = personRepository.findByUuid(studentUuid);
        if(student == null){
            return ResponseEntity.notFound().build();
        }
        parent.setUuid(UUID.randomUUID().toString());
        Person persistentParent = personRepository.save(parent);
        //TODO create an enum
        String type = parent.getType();
        switch (type){
            case "father":
                student.setFather(persistentParent);
                break;

            case "mother":
                student.setMother(persistentParent);
                break;

            default:
                return ResponseEntity.badRequest().build();
        }
        personRepository.save(student);

        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/students/{studentUUID}/correspondent")
    @Transactional
    public ResponseEntity setCorrespondent(@PathVariable("studentUUID") String studentUuid, @RequestBody Person correspondent){
        //TODO validate inputs
        Person student = personRepository.findByUuid(studentUuid);
        if(student == null){
            return ResponseEntity.notFound().build();
        }
        correspondent.setUuid(UUID.randomUUID().toString());
        Person persistentCorrespondent = personRepository.save(correspondent);
        student.setCorrespondent(persistentCorrespondent);
        personRepository.save(student);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    @GetMapping(path = "/eleves")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody
    Iterable<Person> getAll() {
        return personRepository.findAll();
    }

    @GetMapping(path = "eleve/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody
    Person getEleve(@PathVariable String id) {
        return personRepository.findById(Integer.valueOf(id).intValue()).orElseThrow();
    }

}
