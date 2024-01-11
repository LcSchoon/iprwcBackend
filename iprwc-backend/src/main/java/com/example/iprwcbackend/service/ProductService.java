package com.example.iprwcbackend.service;

import com.example.iprwcbackend.model.ProductModel;
import com.example.iprwcbackend.repository.ProductModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductModelRepository productModelRepository;

    @Autowired
    public ProductService(ProductModelRepository productModelRepository){ this.productModelRepository = productModelRepository;}
    public void saveProduct(ProductModel productModel){
        this.productModelRepository.save(productModel);
    }

    public void updateProduct(ProductModel productModel){
        this.productModelRepository.save(productModel);
    }

    public void deleteProduct(UUID id){
        this.productModelRepository.deleteById(id);
    }

    public List<ProductModel> getAllProducts(){
        return this.productModelRepository.findAll();
    }
}
