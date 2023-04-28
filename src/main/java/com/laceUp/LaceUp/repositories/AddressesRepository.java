package com.laceUp.LaceUp.repositories;

import org.springframework.stereotype.Repository;

import com.laceUp.LaceUp.models.Addresses;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface AddressesRepository extends MongoRepository<Address, String> {

    void save(Addresses address);

}
