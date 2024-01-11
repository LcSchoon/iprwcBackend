package com.example.iprwcbackend.repository;

import com.example.iprwcbackend.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductModelRepository extends JpaRepository<ProductModel, UUID> {
}
