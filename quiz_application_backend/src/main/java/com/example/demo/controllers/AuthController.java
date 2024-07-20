package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Administrateur;
import com.example.demo.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Ajoutez votre domaine front-end ici
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/api/login", consumes = "application/json")
    public ResponseEntity<String> login(@RequestBody Administrateur user) {
        if (userService.authenticate(user.getEmail(), user.getPassword())) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed.");
        }
    }
}
