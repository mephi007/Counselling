package com.spring.counselling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {

    @GetMapping("/")
    public String welcomePage(){
        return "Welcome to Counselling";
    }
}
