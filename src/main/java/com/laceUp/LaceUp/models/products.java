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

    public void setId(String id) {
        this._id = id;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer[] getSizes() {
        return sizes;
    }

    public void setSizes(Integer[] sizes) {
        this.sizes = sizes;
    }
}
