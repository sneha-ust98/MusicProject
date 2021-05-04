package com.stackroute.JWTAuthentication_service.Bootstrap;



import com.stackroute.JWTAuthentication_service.Model.User;
import com.stackroute.JWTAuthentication_service.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataBootstrap implements CommandLineRunner {

    private UserRepository userRepository;


     // To get the property values

    @Value("${app.seeddata.id1}")
    private String id1;

    @Value("${app.seeddata.id2}")
    private String id2;

    @Value("${app.seeddata.password1}")
    private String password1;

    @Value("${app.seeddata.password2}")
    private String password2;

    @Value("${app.seeddata.firstname1}")
    private String firstname1;

    @Value("${app.seeddata.firstname2}")
    private String firstname2;

    @Value("${app.seeddata.lastname1}")
    private String lastname1;

    @Value("${app.seeddata.lastname2}")
    private String lastname2;

    @Value("${app.seeddata.phoneNo1}")
    private String phoneNo1;

    @Value("${app.seeddata.phoneNo2}")
    private String phoneNo2;


    @Value("${app.seeddata.logMessage}")
    private String logMessage;



     // Use constructor based DI to inject UserRepository here
    @Autowired
    public DataBootstrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(id1, password1, firstname1,lastname1,phoneNo1);
        User user2 = new User(id2, password2, firstname2, lastname2,phoneNo2);
        userRepository.save(user1);
        userRepository.save(user2);
        log.debug(logMessage);
    }
}


