package com.example.demo.controller;

import com.example.demo.object.Post;
import com.example.demo.object.Roles;
import com.example.demo.object.User;
import com.example.demo.repository.postRepository;
import com.example.demo.repository.roleRepository;
import com.example.demo.repository.userRepository;
import com.example.demo.validation.registerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private userRepository userRepository;

    @Autowired
    private postRepository postRepository;

    @RequestMapping("/")
    public String index(Model model) {
        List<Post> lista = new ArrayList();
        postRepository.findAll().forEach(lista::add);
        Collections.reverse(lista);
        model.addAttribute("lista", lista);
        return "index.html";
    }

    // reigster form
    @GetMapping(value = "/register")
    public String registerGet(@RequestParam(required = false) String condition, Model model) {

        if (null == condition) {
            model.addAttribute("user", new User());
        }else if(condition.equals("succ")) {
            model.addAttribute("msg","succ");
        }else if(condition.equals("error")){
            model.addAttribute("msg","error");
        }
        return"register.html";
    }





    @PostMapping(value = "/register")
    public String registerPost(Model model, @ModelAttribute("User") User user){
        User userCheck =  userRepository.findByEmail(user.getEmail());
        if(!(null == userCheck) || user.getPassword().length()>20 || registerValidator.isNoLegit(user) || user.getName().length()>20 || user.getSurname().length()>20){
            return "redirect:/register?condition=error";
        }

            Roles defaultRole = new Roles(3, "USER"); // assign USER role to new users
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            System.out.println(user.getPassword());
            userRepository.save(user);
            user.getRoles().add(defaultRole);
            userRepository.save(user);
            return "redirect:/register?condition=succ";
    }

}
