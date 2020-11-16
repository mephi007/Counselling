package com.spring.counselling.controller;

import com.spring.counselling.models.Mentee;
import com.spring.counselling.models.Person;
import com.spring.counselling.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/mentee")
    public ResponseEntity<Person> createOrUpdate(@RequestBody Mentee mentee){
        Person person = personService.createOrUpdate(mentee);
        return new ResponseEntity<Person>(person, new HttpHeaders(), HttpStatus.OK);
    }
}
