package com.laceUp.LaceUp;

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

import com.laceUp.LaceUp.models.orders;
import com.laceUp.LaceUp.repositories.OrderRepository;
import com.laceUp.LaceUp.utils.jwtHandler;

@RestController
@Service
@CrossOrigin(origins = "http://localhost:3000")
public class ordersEndpoints {
    
    private final OrderRepository orderRepository;

    public ordersEndpoints(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping(path = "/CreateOrder", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createOrder(@RequestBody orders order, @RequestHeader("Authorization") String token) {
        
        Map<String, Object> response = jwtHandler.validateToken(token);
        if ((boolean) response.get("isValid")){
            orderRepository.save(order);
            return ResponseEntity.ok("Order Placed");
        }

        return ResponseEntity.status(401).body("Invalid Token");
    }

    @GetMapping(path = "/GetAllUserOrders", produces = "application/json")
    public ResponseEntity<Iterable<orders>> getAllUserOrders(@RequestHeader("Authorization") String token, @RequestParam String userId) {
        Map<String, Object> response = jwtHandler.validateToken(token);
        if ((boolean) response.get("isValid")) {
            return ResponseEntity.ok(orderRepository.findAllByUserId(userId));
        }
        return ResponseEntity.status(401).body(null);
    }


    @GetMapping(path = "/GetAllOrders", produces = "application/json")
    public Iterable<orders> getAllOrders(@RequestHeader("Authorization") String token) {

        Map<String, Object> response = jwtHandler.validateToken(token);

        if (!(boolean) response.get("isValid")) {
            return null;
        }
        
        return orderRepository.findAll();
    }

}
