package com.example.iprwcbackend.service;

import com.example.iprwcbackend.model.ShippingDetailsModel;
import com.example.iprwcbackend.repository.ShippingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final ShippingDetailsRepository shippingDetailsService;

    @Autowired
    public OrderService(ShippingDetailsRepository shippingDetailsService){
        this.shippingDetailsService = shippingDetailsService;}
    public void saveProduct(ShippingDetailsModel shippingDetailsModel){
        this.shippingDetailsService.save(shippingDetailsModel);
    }
}
