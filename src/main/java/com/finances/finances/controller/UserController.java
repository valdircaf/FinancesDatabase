package com.finances.finances.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finances.finances.entities.User;
import com.finances.finances.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService service;
    
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<?> addNewUser(@RequestBody User user){
        if(service.verifyUser(user.getLogin()) == false){
            User newUser = service.addNewUser(user);
            return ResponseEntity.ok().body(newUser);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/{id}")
    @CrossOrigin
    public ResponseEntity<?> addNewUser(@PathVariable Long id, @RequestBody User user){
        User obj = service.updateSalary(id, user);
		return ResponseEntity.ok().body(obj);
    }
}

