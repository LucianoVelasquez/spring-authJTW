package com.AuthJWT.authJWT.controllers;

import com.AuthJWT.authJWT.entities.User;
import com.AuthJWT.authJWT.services.UserServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping
    public List<User> list(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

}
