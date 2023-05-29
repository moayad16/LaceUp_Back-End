package com.laceUp.LaceUp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document
public class User {

    @Id
    private String id;

    @Field
    private String email;

    @Field
    private String password;

    @Field 
    private String type;

    @Field
    private String name;

    
    
    public User(String email, String password, String type, String name) {
        this.email = email;
        this.password = password;
        this.type = (type != null)? type : "customer" ;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    
}
