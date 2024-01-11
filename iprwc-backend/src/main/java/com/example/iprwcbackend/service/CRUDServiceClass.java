package com.example.iprwcbackend.service;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class CRUDServiceClass<ObjectType, Repository extends CrudRepository<ObjectType, UUID>> implements CRUDService<ObjectType> {

    protected final Repository repository;

    public CRUDServiceClass(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void create(ObjectType entity) {
        repository.save(entity);
    }

    @Override
    public Optional<ObjectType> get(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<ObjectType> getAll() {
        return (List<ObjectType>) repository.findAll();
    }

    @Override
    public void update(ObjectType entity) {
        repository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
