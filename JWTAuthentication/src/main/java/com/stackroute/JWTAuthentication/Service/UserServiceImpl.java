package com.stackroute.JWTAuthentication.Service;




import com.stackroute.JWTAuthentication.Exception.UserAlreadyExistsException;
import com.stackroute.JWTAuthentication.Exception.UserNotFoundException;
import com.stackroute.JWTAuthentication.Model.User;
import com.stackroute.JWTAuthentication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Value("${app.service.message1}")
    private String message1;

    @Value("${app.service.message2}")
    private String message2;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {

        Optional<User> userResult = userRepository.findById(user.getId());

        if (userResult.isPresent()) {
            throw new UserAlreadyExistsException(message1);
        }
        return userRepository.save(user);

    }

    @Override
    public User findByIdandPassword(String id, String password) throws UserNotFoundException {
        User authUser = userRepository.findByIdAndPassword(id, password);
        if (authUser == null) {
            throw new UserNotFoundException(message2);
        }
        return authUser;
    }
}

