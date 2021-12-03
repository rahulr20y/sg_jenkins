package com.example.mydemoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Environment environment;

    @Autowired
    public DemoController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/")
    public ResponseEntity<?> getStatus()
    {
        return ResponseEntity.ok("Hello From helloController Listing on Port: "+environment.getProperty("local.server.port"));
    }
    @GetMapping("/hello")
    public ResponseEntity<?> sayHello(@RequestParam("message") String message)
    {
        return ResponseEntity.ok("hello "+message);
    }
}
