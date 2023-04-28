package com.laceUp.LaceUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.laceUp.LaceUp.models.User;
import com.laceUp.LaceUp.repositories.UserRepository;

@SpringBootApplication
public class LaceUpApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	@Autowired
	public LaceUpApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LaceUpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if(userRepository.findAll().isEmpty()) {
			userRepository.save(new User("admin", "admin", "admin", "admin")); 
		}
		
	}


}
