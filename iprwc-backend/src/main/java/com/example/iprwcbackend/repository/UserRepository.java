package com.example.iprwcbackend.repository;

import com.example.iprwcbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByemailAndPassword(String email, String password);

    Optional<User> findUserByEmail(String email);


    Optional<User> findById(UUID id);

    void deleteByEmail(String email);

}


