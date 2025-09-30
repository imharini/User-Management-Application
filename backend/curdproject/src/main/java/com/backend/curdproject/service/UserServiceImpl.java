package com.backend.curdproject.service;

import com.backend.curdproject.entities.Model;
import com.backend.curdproject.exception.UserNotFoundException;
import com.backend.curdproject.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Transactional
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    public UserRepo userRepo;

    @Override
    public Model addUser(Model model) {
        return userRepo.save(model);
    }

    @Override
    public List<Model> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public Model getById(Long userId) {
        return userRepo.findById(userId).
                orElseThrow(()->new UserNotFoundException(userId));
    }

    @Override
    public Model updateUser(Long userId, Model model) {
        Model productToUpdate = getById(userId);
        productToUpdate.setUsername(model.getUsername());
        productToUpdate.setName(model.getName());
        productToUpdate.setEmail(model.getEmail());
        userRepo.save(productToUpdate);
        return productToUpdate;
    }

    @Override
    public void deleteUser(Long userId) {
        Model productToDelete = getById(userId);
        userRepo.delete(productToDelete);
    }
}
