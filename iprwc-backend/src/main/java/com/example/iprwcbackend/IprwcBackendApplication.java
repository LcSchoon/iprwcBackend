package com.example.iprwcbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = {"com.example.iprwcbackend"})
public class IprwcBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(IprwcBackendApplication.class, args);
    }

}
