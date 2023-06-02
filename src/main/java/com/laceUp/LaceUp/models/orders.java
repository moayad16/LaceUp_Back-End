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

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public customerProduct[] getProducts() {
        return products;
    }

    public void setProducts(customerProduct[] products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Addresses getAddress() {
        return address;
    }

    public void setAddress(Addresses address) {
        this.address = address;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
    

    
    
}
