package com.laceUp.LaceUp;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laceUp.LaceUp.models.User;
import com.laceUp.LaceUp.repositories.UserRepository;


@RestController
@Service
public class userEndpoints {

    private final UserRepository userRepository;

    public userEndpoints(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @PostMapping(path = "/CreateUser", consumes = "application/json", produces = "application/json")
    public void createUser(@RequestBody User user) {
        // save the user in the database
        userRepository.save(user);
    }
}
