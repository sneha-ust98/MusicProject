package com.stackroute.JWTAuthentication_service.Exception;

public class UserAlreadyExistsException extends Exception{
    private String message;

    public UserAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
    public UserAlreadyExistsException(){
    }
}
