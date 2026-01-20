package org.example.crm.controller;

import org.example.crm.model.User;
import org.example.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class userController {
    @Autowired
    private UserService service;

    @GetMapping
    public String userSecurity(){
        return "User logged in.";
    }
    @PostMapping("/add")
    public ResponseEntity<String> adduser(@RequestBody User user){
        service.adduser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully.");
    }
}
