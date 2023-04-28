package com.laceUp.LaceUp.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class customerProduct extends products {

    @Field
    private int size;

    public customerProduct(String name, String description, String gender, double price, String image,
            Integer[] sizes, String brand, int size) {
        super(name, description, gender, price, image, sizes, brand);
        this.size = size;
    }

    // getter and setter for the new field
    public int getSize() {
        return this.size;
    }

    public void setCategory(int size) {
        this.size = size;
    }
}
