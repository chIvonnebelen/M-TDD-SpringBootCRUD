package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    @GetMapping()
    public String showHomePages(){
        return "index";
    }
}
