package com.laceUp.LaceUp;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laceUp.LaceUp.models.products;
import com.laceUp.LaceUp.repositories.ProductRepository;

@RestController
@Service
public class productsEndpoints {

    private final ProductRepository productRepository;

    public productsEndpoints(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @PostMapping(path = "/CreateProduct", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createProduct(@RequestBody products product) {
        // save the product in the database
        productRepository.save(product);
        return ResponseEntity.ok("Product created successfully");
    }

    @DeleteMapping(path = "/DeleteProduct", produces = "application/json")
    public ResponseEntity<String> deleteProduct(@RequestParam String id) {
        // delete the product from the database
        productRepository.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully");
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
