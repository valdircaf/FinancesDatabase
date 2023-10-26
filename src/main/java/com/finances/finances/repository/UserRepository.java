package com.finances.finances.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finances.finances.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByLogin(String login);
}
