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

    @Field
    private String phone_number;

    @Field
    private String address;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User(String email, String password, String type, String name, String phone_number, String address) {
        this.email = email;
        this.password = password;
        this.type = type;
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     @Override
     public String toString() {
        return String.format("User[id=%s, email='%s', password='%s']", id, email, password);
     }
    
}
