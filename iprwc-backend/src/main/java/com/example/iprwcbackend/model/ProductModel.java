package com.example.iprwcbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "product")
public class ProductModel {
    @Id
    @JsonProperty("id")
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID _id;
    @JsonProperty("name")
    @Column(name = "name")
    private String name;
    @JsonProperty("price")
    @Column(name = "price")
    private float price;
    @JsonProperty("description")
    @Column(name = "description")
    private String description;
    @JsonProperty("imagePath")
    @Column(name = "imagepath")
    private String imagePath;

    public UUID get_id() {
        return _id;
    }
}
