package com.nej.perso.echange.ws;


import com.nej.perso.echange.entities.Test;
import com.nej.perso.echange.repositories.TestRepository;
import com.nej.perso.echange.repositories.TestRepository_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserManagerController {


    @Autowired
    TestRepository_2 testRepository;


    @GetMapping(value = "rest/echange/all")
    ResponseEntity getAll() {
        return ResponseEntity.ok("Done");
    }


    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser(@RequestParam String code
            , @RequestParam String libelle) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Test t = new Test();
        t.setCode(code);
        t.setLibelle(libelle);
        testRepository.save(t);

        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Test> getAllTest() {
        // This returns a JSON or XML with the users
        return testRepository.findAll();
    }

}
