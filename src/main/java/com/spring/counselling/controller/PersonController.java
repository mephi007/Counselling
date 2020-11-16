package com.spring.counselling.controller;

import com.spring.counselling.models.Mentee;
import com.spring.counselling.models.Person;
import com.spring.counselling.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/mentee")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/")
    public ResponseEntity<Person> createOrUpdateMentee(@RequestBody Mentee mentee){
        Person person = personService.createOrUpdate(mentee);
        return new ResponseEntity<Person>(person, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Person> getMenteeByUserName(@PathVariable("username") String username){
        Person person = personService.getMenteeByUserName(username);
        if(person != null) {
            return new ResponseEntity<Person>(person, new HttpHeaders(), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{username}")
    public HttpStatus deleteMenteeByUsername(@PathVariable("username") String username){
        return personService.deleteMentee(username)==true? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }
}
