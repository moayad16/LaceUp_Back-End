package com.laceUp.LaceUp;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.laceUp.LaceUp.models.User;
import com.laceUp.LaceUp.models.orders;
import com.laceUp.LaceUp.models.products;
import com.laceUp.LaceUp.repositories.AddressesRepository;
import com.laceUp.LaceUp.repositories.OrderRepository;
import com.laceUp.LaceUp.repositories.ProductRepository;
import com.laceUp.LaceUp.repositories.UserRepository;
import com.laceUp.LaceUp.utils.jwtHandler;


@RestController
@Service
@CrossOrigin(origins = "http://localhost:3000")
public class globalEndpoints {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final AddressesRepository addressesRepository;

    @Autowired
    public globalEndpoints(UserRepository userRepository, ProductRepository productRepository, OrderRepository orderRepository, AddressesRepository addressesRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.addressesRepository = addressesRepository;
    }

    @GetMapping(path = "/downloadData" , produces = "application/json")
    public ResponseEntity<Map<String, Object>> downloadData(@RequestHeader("Authorization") String token) {
        Map<String, Object> response = jwtHandler.validateToken(token);

        if ((boolean) response.get("isValid")) {
            Map<String, Object> data = new HashMap<String, Object>();

            Iterable <User> users = userRepository.findAllCustomers();
            for (User user : users) {
                user.setPassword("");
            }
            data.put("users", users);
            data.put("products", productRepository.findAll());
            data.put("orders", orderRepository.findAll());
            data.put("addresses", addressesRepository.findAll());
            return ResponseEntity.ok(data);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @GetMapping(path = "/GetAllUsers", produces = "application/json")
    public Iterable<User> getAllUsers(@RequestHeader("Authorization") String token) {

        Map<String, Object> response = jwtHandler.validateToken(token);

        if (!(boolean) response.get("isValid")) {
            return null;
        }

        // this code will search for all the users of type customer in the database
        Iterable<User> users =  userRepository.findAllCustomers();

        for (User user : users) {
            user.setPassword("********");
        }

        return users;

    }

    @GetMapping(path = "/GetAllUsersOrders", produces = "application/json")
    public ResponseEntity<Map<String, Object>> getAllOrders(@RequestHeader("Authorization") String token) {

        Map<String, Object> response = jwtHandler.validateToken(token);

        if (!(boolean) response.get("isValid")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        // this code will search for all the users of type customer in the database
        Iterable<orders> orders =  orderRepository.findAll();

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("orders", orders);
    

        return ResponseEntity.ok(data);

    }

    @PostMapping(path = "/ModifyOrder", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Map<String, Object>> modifyOrder(@RequestHeader("Authorization") String token, @RequestBody List<Object> body) {

        Map<String, Object> response = jwtHandler.validateToken(token);

        if (!(boolean) response.get("isValid")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

       for (int i=0; i<body.size(); i++) {
              Map<String, Object> order = (Map<String, Object>) body.get(i);
              String orderId = (String) order.get("id");
              String status = (String) order.get("status");
    
              orders orderObj = orderRepository.findById(orderId).orElse(null);
    
              if (orderObj == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
              }
    
              orderObj.setStatus(status);
              orderRepository.save(orderObj);
       }

        return ResponseEntity.ok(null);

    }

    @PostMapping(path = "/EditProduct", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Map<String, Object>> editProduct(@RequestHeader("Authorization") String token, @RequestBody products product) {

        Map<String, Object> response = jwtHandler.validateToken(token);

        if (!(boolean) response.get("isValid")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        // delete the old version of the product and save the new one
        productRepository.deleteById(product.getId());
        productRepository.save(product);

        return ResponseEntity.ok(null);

    }

    @DeleteMapping(path = "/DeleteProduct", produces = "application/json")
    public ResponseEntity<Map<String, Object>> deleteProduct(@RequestHeader("Authorization") String token, @RequestParam String id) {

        Map<String, Object> response = jwtHandler.validateToken(token);

        if (!(boolean) response.get("isValid")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        // delete the old version of the product and save the new one
        productRepository.deleteById(id);

        return ResponseEntity.ok(null);

    }

}
