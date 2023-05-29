package com.laceUp.LaceUp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document
public class orders {

    @Id
    private String id;

    @Field
    private String userId;

    @Field
    private customerProduct[] products;

    @Field
    private String status;

    @Field
    private String date;

    @ Field
    private Addresses address;
    
    @Field
    private double total_price;
    
    
    public orders(String userId, customerProduct[] products, String status, String date, Addresses address, double total_price) {
        this.userId = userId;
        this.products = products;
        this.status = status;
        this.date = date;
        this.address = address;
        this.total_price = total_price;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    

    
    
}
