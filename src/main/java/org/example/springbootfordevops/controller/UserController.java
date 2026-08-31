package org.example.springbootfordevops.controller;


import org.example.springbootfordevops.model.UserModel;
import org.example.springbootfordevops.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/employees")
public class UserController{

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) { this.userRepository = userRepository; }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel userModel){
        return userRepository.save(userModel);
    }

    @GetMapping
    public List<UserModel> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserModel getUser(@PathVariable String id){
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(
            @PathVariable String id,
            @RequestBody UserModel userModel){
        return userRepository.findById(id).
                map(existingRecord -> {
                    existingRecord.setName(userModel.getName());
                    existingRecord.setEmail(userModel.getEmail());

                    return userRepository.save(existingRecord);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

}