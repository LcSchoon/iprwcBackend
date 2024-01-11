package com.example.iprwcbackend.controller;

import com.example.iprwcbackend.model.User;
import com.example.iprwcbackend.service.JWTService;
import com.example.iprwcbackend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RequestMapping("/api/v1/user")
@RestController
public class UserController extends CRUDController<User, UserService> {
    @Autowired
    private JWTService jwtUtil;

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        super(userService);
    }

    @Override
    public void create(@RequestBody User entity) {
        entity.setRole("READ");
        super.create(entity);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<User> get(@PathVariable("id") UUID id) {
        return super.get(id);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAll() {
        return super.getAll();
    }


    @DeleteMapping(path = "/byEmail/{email}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteByEmail(@PathVariable("email") String email) {
        userService.deleteByEmail(email);
    }

    @PutMapping(path = "/update/{email}")
    @PreAuthorize("hasRole('ADMIN')")
    public void update(@PathVariable String email, @RequestBody User updatedUser) {
        userService.updateUserByEmail(email, updatedUser);
    }


    @GetMapping(path = "/role")
    public ResponseEntity<JSONObject> getUserRole(HttpServletRequest request) {
        final String authorizationHeader = request.getHeader("Authorization");

        String jwt = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
        }
        UUID id = jwtUtil.extractID(jwt);
        Optional<User> user = userService.findById(id);
        JSONObject response = new JSONObject();
        response.put("role", user.get().getRole());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
