package com.backend.curdproject.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long userId){
        super("could not found the user with the id");
    }
}
