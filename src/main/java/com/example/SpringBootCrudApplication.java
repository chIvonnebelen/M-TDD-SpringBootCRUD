package com.example;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class SpringBootCrudApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootCrudApplication.class, args);
    }

   /* @Autowired
    private UserRepository repo;


    @Override
    public void run(String... args) throws Exception {
        User user1= new User(1, new Date("12, 1, 2023"), "kiki@gmail.com","Sebastian", "Quinteros");
        repo.save(user1);
        User user2= new User(2, new Date("12, 1, 2023"), "kiki@gmail.com","Sebastian", "Quinteros");
        repo.save(user2);
     */
    }

