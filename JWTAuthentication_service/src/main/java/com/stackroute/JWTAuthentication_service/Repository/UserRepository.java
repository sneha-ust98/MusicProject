package com.stackroute.JWTAuthentication_service.Repository;


import com.stackroute.JWTAuthentication_service.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findByIdAndPassword(String id, String password);

}