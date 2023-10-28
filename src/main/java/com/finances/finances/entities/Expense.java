package com.finances.finances.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;

    @JsonIgnore
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;
}
