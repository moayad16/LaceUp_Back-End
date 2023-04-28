package com.laceUp.LaceUp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.laceUp.LaceUp.models.Addresses;
import com.laceUp.LaceUp.repositories.AddressesRepository;
import com.laceUp.LaceUp.utils.jwtHandler;


@RestController
@Service
@CrossOrigin(origins = "http://localhost:3000")
public class addressesEndpoints {

    private final AddressesRepository addressesRepository;

    @Autowired
    public addressesEndpoints(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    // The following post mapping will take a jwt token and a new address object and add the address to the user's address list
    @PostMapping(path="/createAddress", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createAddress(@RequestBody Addresses address, @RequestHeader("Authorization") String token) {
        System.out.println(token);
        Map<String, Object> response = jwtHandler.validateToken(token);
        if ((boolean) response.get("isValid")) {
            addressesRepository.save(address);
            return ResponseEntity.ok("Address created successfully");
        }
        return ResponseEntity.status(401).body("Invalid token");

    }


}
