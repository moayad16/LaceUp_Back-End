package com.laceUp.LaceUp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document
public class Addresses {

    @Id
    private String id;

    @Field 
    private String userId;

    @Field
    private String adress;

    @Field
    private String region;

    @Field 
    private String city;

    @Field
    private String phoneNumber;
    
    public Addresses(String userId, String adress, String city, String phoneNumber, String region) {
        this.adress = adress;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
        this.region = region;
    }

    
    public String getAdress() {
        return adress;
    }

    
}
