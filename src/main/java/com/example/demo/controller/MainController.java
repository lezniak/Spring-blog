package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login.html";
    }

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

}
