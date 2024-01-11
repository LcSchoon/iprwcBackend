package com.example.iprwcbackend.service;

import com.example.iprwcbackend.model.User;
import com.example.iprwcbackend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService extends CRUDServiceClass<User, UserRepository> {
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> findUserByEmail(String email) {
        Optional<User> foundUser = repository.findUserByEmail(email);
        return foundUser;
    }

    @Override
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        super.create(user);
    }

    @Override
    public void update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        super.update(user);
    }


    public Optional<User> findById(UUID id) {
        Optional<User> foundUser = repository.findById(id);
        return foundUser;
    }

    @Transactional
    public void deleteByEmail(String email) {
        repository.deleteByEmail(email);
    }

    @Transactional
    public void updateUserByEmail(String email, User updatedUser) {
        User existingUser = repository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));


        if (updatedUser.getPassword() != null) {
            existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }
        if (updatedUser.getRole() != null) {
            existingUser.setRole(updatedUser.getRole());
        }


        repository.save(existingUser);
    }

}
