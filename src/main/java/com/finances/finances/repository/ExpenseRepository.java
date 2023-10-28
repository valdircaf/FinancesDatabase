package com.finances.finances.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finances.finances.entities.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
    
}
