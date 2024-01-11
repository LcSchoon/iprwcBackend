package com.example.iprwcbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {


    private String email;
    private String password;

    //need default constructor for JSON Parsing
    public AuthenticationRequest() {

    }

    public AuthenticationRequest(
            @JsonProperty String email,
            @JsonProperty String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}