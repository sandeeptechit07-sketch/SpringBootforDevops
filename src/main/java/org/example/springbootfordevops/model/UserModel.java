package org.example.springbootfordevops.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserModel {

    @Id
    private String id;

    private String name;
    private String email;

    public UserModel(){
    }

    public UserModel(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }
}