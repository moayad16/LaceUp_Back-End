package com.laceUp.LaceUp;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laceUp.LaceUp.models.orders;
import com.laceUp.LaceUp.repositories.OrderRepository;

@RestController
@Service
public class ordersEndpoints {
    
    private final OrderRepository orderRepository;

    public ordersEndpoints(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping(path = "/CreateOrder", consumes = "application/json", produces = "application/json")
    public void createOrder(@RequestBody orders order) {
        orderRepository.save(order);
    }

    @GetMapping(path = "/GetAllOrders", produces = "application/json")
    public Iterable<orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping(path = "/GetOrderById", produces = "application/json")
    public orders getOrderById(@RequestBody String id) {
        return orderRepository.findById(id).get();
    }
}
