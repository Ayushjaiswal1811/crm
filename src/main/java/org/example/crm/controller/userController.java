package org.example.crm.controller;

import org.example.crm.Dto.userReqDto;
import org.example.crm.model.User;
import org.example.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @PostMapping("/public/register")
    public ResponseEntity<String> adduser(@RequestBody userReqDto userDto){

        service.adduser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully.");
    }
}
