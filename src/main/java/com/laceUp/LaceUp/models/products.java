package com.laceUp.LaceUp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document
public class products {
    @Id
    private String _id;
    
    @Field
    private String name;
    
    @Field
    private String description;
    
    @Field
    private String gender;
    
    @Field
    private double price;
    
    @Field
    private String image;
    
    @Field
    private Integer[] sizes;
    
    @Field
    private String brand;
    
    
    public products(String name, String description, String gender, double price, String image,
    Integer[] sizes, String brand) {
        this.name = name;
        this.description = description;
        this.gender = gender;
        this.price = price;
        this.image = image;
        this.brand = brand;
        this.sizes = sizes;
    }

    public String getId() {
        return _id;
    }





}
