package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Administrateur;
import com.example.demo.repositories.AdministrateurRepository;

@Service
public class UserService {

    @Autowired
    private AdministrateurRepository userRepository;

    public boolean authenticate(String email, String password) {
        Administrateur user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
