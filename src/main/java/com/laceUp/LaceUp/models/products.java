package com.laceUp.LaceUp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class products {
    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String description;

    @Field
    private String gender;

    @Field
    private Integer price;

    @Field
    private String image;

    @Field
    private Integer quantity;

    @Field
    private Integer[] sizes;

    public products(String name, String description, String gender, Integer price, String image, Integer quantity,
            Integer[] sizes) {
        this.name = name;
        this.description = description;
        this.gender = gender;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.sizes = sizes;

        
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

    public Integer getPrice() {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer[] getSizes() {
        return sizes;
    }

    public void setSizes(Integer[] sizes) {
        this.sizes = sizes;
    }
}
