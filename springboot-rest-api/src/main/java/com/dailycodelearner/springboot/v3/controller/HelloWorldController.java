package com.dailycodelearner.springboot.v3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3")
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "hello-world";
    }
}
