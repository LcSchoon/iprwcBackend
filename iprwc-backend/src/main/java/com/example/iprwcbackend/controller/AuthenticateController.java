package com.example.iprwcbackend.controller;

import com.example.iprwcbackend.model.AuthenticationRequest;
import com.example.iprwcbackend.model.User;
import com.example.iprwcbackend.service.JWTService;
import com.example.iprwcbackend.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthenticateController {

    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserService userService;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/authenticate")
    public ResponseEntity<Object> JWTrelease(@RequestBody AuthenticationRequest authenticationRequest) {
        String email = authenticationRequest.getEmail();
        String rawPassword = authenticationRequest.getPassword();

        Optional<User> optionalUser = userService.findUserByEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (passwordEncoder.matches(rawPassword, user.getPassword())) {
                String jwt = jwtService.generateToken(user);
                JSONObject response = new JSONObject();
                response.put("idToken", jwt);
                response.put("email", user.getEmail());
                response.put("expiresIn", this.jwtService.getEXPIRATION_DURATION());
                response.put("localId", user.getId());
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("User does not exist or incorrect password", HttpStatus.UNAUTHORIZED);
    }

}
