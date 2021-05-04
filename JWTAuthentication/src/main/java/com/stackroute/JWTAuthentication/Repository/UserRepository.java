package com.stackroute.JWTAuthentication.Repository;




import com.stackroute.JWTAuthentication.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findByIdAndPassword(String id, String password);

}