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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getId() {
        return id;
    }

    
}
