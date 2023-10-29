package com.finances.finances.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finances.finances.entities.OtherCosts;
import com.finances.finances.entities.User;
import com.finances.finances.service.OtherCostsService;

@RestController
@RequestMapping
public class OtherCostsController {
    
    @Autowired
    private OtherCostsService service;

    @CrossOrigin
    @PostMapping(value = "/{id}/othercosts")
    public ResponseEntity<User> addExpenseToUser(@PathVariable Long id, @RequestBody OtherCosts otherCosts){
        User user = service.setOtherCostToUser(id, otherCosts);
        return ResponseEntity.ok().body(user);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{userId}/deletecost/{otherCostId}")
    public ResponseEntity<?> addExpenseToUser(@PathVariable Long userId, @PathVariable Long otherCostId){
        service.deleteExpense(userId, otherCostId);
        return ResponseEntity.ok().body("Deleted");
    }
}
