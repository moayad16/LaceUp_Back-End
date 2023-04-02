package com.laceUp.LaceUp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.laceUp.LaceUp.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
