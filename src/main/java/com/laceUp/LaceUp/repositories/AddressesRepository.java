package com.laceUp.LaceUp.repositories;

import org.springframework.stereotype.Repository;

import com.laceUp.LaceUp.models.Addresses;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


@Repository
public interface AddressesRepository extends MongoRepository<Addresses, String> {

    @Query(value = "{'userId': ?0}", fields = "{'_id': 1, 'adress': 1, 'city': 1, 'phoneNumber': 1, 'region': 1}")
    List<Addresses> findAllByUserId(String userId);


}
