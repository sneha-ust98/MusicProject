package com.stackroute.JWTAuthentication_service.Exception;


@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {

    private String message;


    public UserNotFoundException(String message) {

        super(message);
        this.message=message;
    }
    public UserNotFoundException(){

    }
}