package com.laceUp.LaceUp;

import java.util.List;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laceUp.LaceUp.models.products;
import com.laceUp.LaceUp.repositories.ProductRepository;
import com.laceUp.LaceUp.utils.jwtHandler;

@RestController
@Service
@CrossOrigin(origins = "http://localhost:3000")
public class productsEndpoints {

    private final ProductRepository productRepository;

    public productsEndpoints(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @PostMapping(path = "/CreateProduct", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createProduct(@RequestHeader("Authorization") String token, @RequestBody products product) {

        //validate token
        Map<String, Object> response = jwtHandler.validateToken(token);

        if (!(boolean) response.get("isValid")) {
            return ResponseEntity.status(401).body("Invalid token");
        }

        productRepository.save(product);
        return ResponseEntity.ok("Product created successfully");
    }

    @GetMapping(path = "/GetAllProducts", produces = "application/json")
    public List<products> getAllProducts() {


        return productRepository.findAll();
    }

    @GetMapping(path = "/GetProductById", produces = "application/json")
    public products getProductById(@RequestParam String id) {
        return productRepository.findById(id).get();
    }






}
