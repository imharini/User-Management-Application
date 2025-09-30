package com.backend.curdproject.service;

import com.backend.curdproject.entities.Model;

import java.util.List;

public interface UserService {
    Model addUser(Model model);
    List<Model> getAllUser();
    Model getById(Long userId);
    Model updateUser(Long userId,Model model);
    void deleteUser(Long userId);

}
