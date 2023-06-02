package com.laceUp.LaceUp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
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


        Map<String, Object> response = jwtHandler.validateToken(token);

        if ((boolean) response.get("isValid")) {
            System.out.println(address.getAdress());
            addressesRepository.save(address);
            return ResponseEntity.ok("Address created successfully");
        }

        System.out.println("Invalid token");
        return ResponseEntity.status(401).body("Invalid token");

    }

    @GetMapping(path="/getAddresses", produces = "application/json")
    public ResponseEntity<Iterable<Addresses>> getAddresses(@RequestHeader("Authorization") String token, @RequestParam String userId) {

        Map<String, Object> response = jwtHandler.validateToken(token);

        if ((boolean) response.get("isValid")) {
            return ResponseEntity.ok(addressesRepository.findAllByUserId(userId));
        }

        System.out.println("Invalid token");
        return ResponseEntity.status(401).body(null);

    }




}
