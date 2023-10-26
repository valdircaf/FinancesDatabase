package com.finances.finances.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finances.finances.entities.User;
import com.finances.finances.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        List<User> list = repository.findAll();
        return list;
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.get();
    }

    public User addNewUser(User user) {
        User newUser = repository.save(user);
        return newUser;
    }

    public boolean verifyUser(String login){
        Optional<User> existingUser = repository.findByLogin(login);
        return existingUser.isPresent();
    }
}
