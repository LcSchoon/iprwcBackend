package com.example.iprwcbackend.repository;

import com.example.iprwcbackend.model.ShippingDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShippingDetailsRepository extends JpaRepository<ShippingDetailsModel, UUID> {
}
