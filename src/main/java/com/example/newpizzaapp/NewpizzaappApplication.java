package com.example.newpizzaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class NewpizzaappApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewpizzaappApplication.class, args);
    }

}
