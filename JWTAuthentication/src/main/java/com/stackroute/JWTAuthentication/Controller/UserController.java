package com.stackroute.JWTAuthentication.Controller;

import com.stackroute.JWTAuthentication.Exception.UserAlreadyExistsException;
import com.stackroute.JWTAuthentication.Exception.UserNotFoundException;
import com.stackroute.JWTAuthentication.Model.User;
import com.stackroute.JWTAuthentication.Service.UserService;
import com.stackroute.JWTAuthentication.config.JWTTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

//Used the controller annotation
@RestController


public class UserController {

    private UserService userService;
    private JWTTokenGenerator jwtTokenGenerator;
    ResponseEntity<?> responseEntity;

    //Getting the values for message from property file

    @Value("${controller.exception.message1}")
    private String message1;

    @Value("${controller.exception.message2}")
    private String message2;

    @Value("${controller.exception.message3}")
    private String message3;



    @Autowired
    public UserController(UserService userService, JWTTokenGenerator jwtTokenGenerator) {
        this.userService = userService;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }


    //If user registration is a success, return status as Created else Conflict
    //uses POST mapping

    @PostMapping("register")
    public ResponseEntity<?> registerUser( @Valid @RequestBody User user) {
        try {
            User savedUser = userService.saveUser(user);
            responseEntity = new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    //ID and Password is checked
    //If credentials given are correct, token should be generated
    //else exception is thrown
    //uses "login" and POST

    @PostMapping("login/user")
    public ResponseEntity<?> loginUser( @RequestBody User user)  {
        try {
            if (user.getId() == null || user.getPassword() == null) {
                throw new UserNotFoundException(message1);
            }

            User userDetails = userService.findByIdandPassword(user.getId(),user.getPassword());

            if (userDetails == null) {
                throw new UserNotFoundException(message2);
            }

            responseEntity = new ResponseEntity<>(jwtTokenGenerator.generateToken(userDetails),HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException exc) {
        Map<String, String> errors = new HashMap<>();
        exc.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
