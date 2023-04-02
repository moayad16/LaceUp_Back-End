package com.laceUp.LaceUp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.laceUp.LaceUp.models.orders;


@Repository
public interface OrderRepository extends MongoRepository<orders, String> {
    
}
