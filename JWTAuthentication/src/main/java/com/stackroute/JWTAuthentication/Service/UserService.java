package com.stackroute.JWTAuthentication.Service;

import com.stackroute.JWTAuthentication.Exception.UserAlreadyExistsException;
import com.stackroute.JWTAuthentication.Exception.UserNotFoundException;
import com.stackroute.JWTAuthentication.Model.User;

public interface UserService {
    User saveUser(User user) throws UserAlreadyExistsException;

    User findByIdandPassword(String id,String password) throws UserNotFoundException;
}
