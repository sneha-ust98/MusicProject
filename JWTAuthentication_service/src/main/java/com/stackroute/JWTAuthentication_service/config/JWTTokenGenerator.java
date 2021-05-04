package com.stackroute.JWTAuthentication_service.config;


import com.stackroute.JWTAuthentication_service.Model.User;

import java.util.Map;

public interface JWTTokenGenerator {

    Map<String, String> generateToken(User user);
}

