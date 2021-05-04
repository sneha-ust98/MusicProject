package com.stackroute.JWTAuthentication_service.Service;


import com.stackroute.JWTAuthentication_service.Exception.UserAlreadyExistsException;
import com.stackroute.JWTAuthentication_service.Exception.UserNotFoundException;
import com.stackroute.JWTAuthentication_service.Model.User;

public interface UserService {
    User saveUser(User user) throws UserAlreadyExistsException;

    User findByIdandPassword(String id,String password) throws UserNotFoundException;
}
