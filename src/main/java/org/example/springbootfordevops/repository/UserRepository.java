package org.example.springbootfordevops.repository;

//import org.apache.catalina.User;
import org.example.springbootfordevops.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, String> {

}