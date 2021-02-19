package com.example.demo.controller;

import com.example.demo.object.Roles;
import com.example.demo.object.User;
import com.example.demo.repository.roleRepository;
import com.example.demo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private userRepository userRepository;


    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login.html";
    }

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }
    // reigster form
    @GetMapping(value = "/register")
    public String registerGet(Model model){
        model.addAttribute("user", new User());
        return "register.html";
    }

    @PostMapping(value = "/register")
    public String registerPost(Model model, @ModelAttribute("User") User user){
        Roles defaultRole = new Roles(3,"USER"); // assign USER role to new users
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        userRepository.save(user);
        user.getRoles().add(defaultRole);
        userRepository.save(user);
    return "index.html";
    }


}
