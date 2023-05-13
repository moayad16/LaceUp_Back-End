package com.laceUp.LaceUp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import com.laceUp.LaceUp.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query(value = "{ 'email' : ?0 }", fields="{ '_id': 1, 'email': 1, 'password': 1, 'type': 1, 'name': 1 }")
    User findOneByEmail(String email);

    // this query will return all the users of type customer in the database
    @Query(value = "{ 'type' : 'customer' }", fields="{ '_id': 1, 'email': 1, 'password': 1, 'type': 1, 'name': 1 }")
    Iterable<User> findAllCustomers();

}
