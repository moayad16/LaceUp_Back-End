package com.laceUp.LaceUp;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.commons.codec.digest.DigestUtils;

import com.laceUp.LaceUp.models.User;
import com.laceUp.LaceUp.repositories.UserRepository;


@RestController
@Service
@CrossOrigin(origins = "http://localhost:3000")
public class userEndpoints {

    private final UserRepository userRepository;

    public userEndpoints(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @PostMapping(path = "/signup", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createUser(@RequestBody User user) {

        // check if the user already exists in the database
        if (userRepository.findOneByEmail(user.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }

        // hash the password before saving
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));

        // save the user in the database
        userRepository.save(user);
        return ResponseEntity.ok("User created successfully");
    }

    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> login(@RequestBody User user) {
        //retrieve user from database
        User userFromDB = userRepository.findOneByEmail(user.getEmail());
        
        // hash the password before comparing
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));

        // check if the user exists in the database
        if (userFromDB == null) {
            System.out.println("not found");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        // check if the password is correct
        if (!userFromDB.getPassword().equals(user.getPassword())) {
            System.out.println("wrong password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        return ResponseEntity.ok(userFromDB);    

    }


}
