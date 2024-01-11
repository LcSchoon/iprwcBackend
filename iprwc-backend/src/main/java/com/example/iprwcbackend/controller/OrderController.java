package com.example.iprwcbackend.controller;

import com.example.iprwcbackend.model.ShippingDetailsModel;
import com.example.iprwcbackend.repository.ShippingDetailsRepository;
import com.example.iprwcbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/order/shipping-details")
@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;}

    @PostMapping
    public void postOrder(@RequestBody ShippingDetailsModel shippingDetailsModel){
        this.orderService.saveProduct(shippingDetailsModel);
    }
}
