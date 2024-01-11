package com.example.iprwcbackend.controller;

import com.example.iprwcbackend.model.ProductModel;
import com.example.iprwcbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/product")
@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void postProduct(@RequestBody ProductModel productModel) {
        this.productService.saveProduct(productModel);
    }

    @GetMapping
    public List<ProductModel> getProduct(){
        return this.productService.getAllProducts();
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void putProduct(@RequestBody ProductModel productModel){
        this.productService.updateProduct(productModel);
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProduct(@PathVariable("id") UUID uuid){
        this.productService.deleteProduct(uuid);
    }
}
