package com.example.iprwcbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.context.annotation.Primary;

@Entity
@Table(name = "shippingdetails")
public class ShippingDetailsModel {
    @JsonProperty("id")
    @Id
    @Column(name = "id")
    private String id;
    @JsonProperty("firstName")
    @Column(name = "firstname")
    private String firstName;
    @JsonProperty("lastName")
    @Column(name = "lastname")
    private String lastName;
    @JsonProperty("street")
    @Column(name = "street")
    private String street;
    @JsonProperty("houseNumber")
    @Column(name = "housenumber")
    private String houseNumber;
    @JsonProperty("zipCode")
    @Column(name = "zipcode")
    private String zipCode;
}
