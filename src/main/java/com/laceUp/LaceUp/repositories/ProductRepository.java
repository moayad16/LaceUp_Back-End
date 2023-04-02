package com.laceUp.LaceUp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.laceUp.LaceUp.models.products;


@Repository
public interface ProductRepository extends MongoRepository<products, String> {
    
}
