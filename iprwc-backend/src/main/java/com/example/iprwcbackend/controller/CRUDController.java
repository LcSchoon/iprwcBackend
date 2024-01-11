package com.example.iprwcbackend.controller;

import com.example.iprwcbackend.service.CRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class CRUDController<ObjectType, Service extends CRUDService<ObjectType>> {

    protected final Service service;

    public CRUDController(Service service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestBody ObjectType entity) {
        service.create(entity);
    }

    @GetMapping(path = "{id}")
    public Optional<ObjectType> get(@PathVariable("id") UUID id) {
        return service.get(id);
    }

    @GetMapping
    public List<ObjectType> getAll() {
        return service.getAll();
    }

    @PutMapping(path = "{id}")
    public void update(@RequestBody ObjectType entity, @PathVariable UUID id) {
        service.update(entity);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
