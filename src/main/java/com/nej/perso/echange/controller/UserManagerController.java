package com.nej.perso.echange.controller;


import com.nej.perso.echange.entities.Person;
import com.nej.perso.echange.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController()
public class UserManagerController {

    @Autowired
    PersonRepository personRepository;


    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser(@RequestParam String code
            , @RequestParam String libelle) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request


        /*
        Test t = new Test();
        t.setCode(code);
        t.setLibelle(libelle);
        testRepository.save(t);
*/
        return "Saved";
    }

    @GetMapping(path = "/eleves")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody
    Iterable<Person> getAll() {
        Iterable<Person> all = personRepository.findAll();
        return all;
    }

    @GetMapping(path = "eleve/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody
    Person getEleve(@PathVariable String id) {
        return personRepository.findById(Integer.valueOf(id).intValue()).orElseThrow();
    }

}
