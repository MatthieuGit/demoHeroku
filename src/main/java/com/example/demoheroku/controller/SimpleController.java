package com.example.demoheroku.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("")
    public String getWelcome() {
        return "Bienvenue chez moi";
    }
}
