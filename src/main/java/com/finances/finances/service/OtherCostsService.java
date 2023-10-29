package com.finances.finances.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finances.finances.entities.OtherCosts;
import com.finances.finances.entities.User;
import com.finances.finances.repository.OtherCostsRepository;
import com.finances.finances.repository.UserRepository;

@Service
public class OtherCostsService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private OtherCostsRepository repository;

    public User setOtherCostToUser(Long id, OtherCosts otherCosts) {
        Optional<User> currentUser = userRepository.findById(id);
        currentUser.get().setOtherCosts(otherCosts);
        otherCosts.setUser(currentUser.get());
        repository.save(otherCosts);
        return currentUser.get();
    }

    public void deleteExpense(Long userId, Long otherCostId) {
        Optional<User> currentUser = userRepository.findById(userId);
        for(int i = 0; i < currentUser.get().getOtherCosts().size(); i++){
            if(currentUser.get().getOtherCosts().get(i).getId() == otherCostId){
                repository.deleteById(otherCostId);
            }
        }
    }

    
}
