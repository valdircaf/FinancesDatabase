package com.finances.finances.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finances.finances.entities.Expense;
import com.finances.finances.entities.User;
import com.finances.finances.repository.ExpenseRepository;
import com.finances.finances.repository.UserRepository;

@Service
public class ExpenseService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    public User setExpenseToUser(Long id, Expense expense) {
        Optional<User> currentUser = userRepository.findById(id);
        currentUser.get().setExpenses(expense);
        expense.setUser(currentUser.get());
        expenseRepository.save(expense);
        return currentUser.get();
    }

    public void deleteExpense(Long userId, Long expenseId) {
        Optional<User> currentUser = userRepository.findById(userId);
        for(int i = 0; i < currentUser.get().getExpenses().size(); i++){
            if(currentUser.get().getExpenses().get(i).getId() == expenseId){
                expenseRepository.deleteById(expenseId);
            }
        }
    }
    
}
