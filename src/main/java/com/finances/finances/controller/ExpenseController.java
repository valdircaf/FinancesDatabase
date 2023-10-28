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

import com.finances.finances.entities.Expense;
import com.finances.finances.entities.User;
import com.finances.finances.service.ExpenseService;

@RestController
@RequestMapping
public class ExpenseController {
    
    @Autowired
    private ExpenseService service;

    @CrossOrigin
    @PostMapping(value = "/{id}/expense")
    public ResponseEntity<User> addExpenseToUser(@PathVariable Long id, @RequestBody Expense expense){
        User user = service.setExpenseToUser(id, expense);
        return ResponseEntity.ok().body(user);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{userId}/deleteexpense/{expenseId}")
    public ResponseEntity<?> addExpenseToUser(@PathVariable Long userId, @PathVariable Long expenseId){
        service.deleteExpense(userId, expenseId);
        return ResponseEntity.ok().body("Deleted");
    }
}
