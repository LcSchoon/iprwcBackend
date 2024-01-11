package com.example.iprwcbackend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CRUDService<ObjectType> {
    void create(ObjectType entity);

    Optional<ObjectType> get(UUID id);

    List<ObjectType> getAll();

    void update(ObjectType entity);

    void delete(UUID id);
}
