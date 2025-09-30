package com.backend.curdproject.controller;

import com.backend.curdproject.entities.Model;
import com.backend.curdproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "user")
    public ResponseEntity<List<Model>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @GetMapping(path = "user/{userId}")
    public ResponseEntity<Model> getById(@PathVariable(name = "userId") Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getById(userId));
    }

    @PutMapping(path = "user/{userId}")
    public ResponseEntity<Model> updateUser(@PathVariable(name = "userId")Long userId, @RequestBody Model model){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userId,model));
    }
    @DeleteMapping(path = "user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "userId")Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("User with id " + userId + " has been deleted successfully");

    }

    @PostMapping(path = "user")
    public ResponseEntity<Model> addUser(@RequestBody Model model){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(model));
    }
}

