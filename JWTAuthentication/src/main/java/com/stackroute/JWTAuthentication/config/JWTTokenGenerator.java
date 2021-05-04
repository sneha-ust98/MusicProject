package com.stackroute.JWTAuthentication.config;

import com.stackroute.JWTAuthentication.Model.User;

import java.util.Map;

public interface JWTTokenGenerator {

    Map<String, String> generateToken(User user);
}

