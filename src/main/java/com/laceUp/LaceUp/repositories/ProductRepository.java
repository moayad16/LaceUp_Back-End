package com.laceUp.LaceUp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.laceUp.LaceUp.models.products;


@Repository
public interface ProductRepository extends MongoRepository<products, String> {
    @Query(value = "{}", fields = "{ '_id': 1, 'name': 1, 'description': 1, 'price': 1, 'quantity': 1, image: 1, sizes: 1, brand: 1, gender: 1, prod_id: 1}")
    List<products> findAllWithId();

    List<products> findAll();
    
}
