package com.laceUp.LaceUp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document
public class orders {

    @Id
    private String id;

    @Field
    private String user_Id;

    @Field
    private Object[] products;

    @Field
    private String status;

    @Field
    private String date;

    @ Field
    private String address;

    @Field
    private String phone_number;

    @Field
    private Integer total_price;

    public orders(String user_Id, Object[] products, String status, String date, String address, String phone_number, Integer total_price) {
        this.user_Id = user_Id;
        this.products = products;
        this.status = status;
        this.date = date;
        this.address = address;
        this.phone_number = phone_number;
        this.total_price = total_price;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public Object[] getProducts() {
        return products;
    }

    public void setProducts(String[] products) {
        this.products = products;
    }

    
    
}
