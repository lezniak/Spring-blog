package com.example.demo.controller;

import com.example.demo.object.Post;
import com.example.demo.repository.postRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class postController {
    @Autowired
    postRepository postRepository;

    @GetMapping(value = "/posts")
    public String menuPost(Model model){
        return "post.html";
    }

    @PostMapping(value = "/posts")
    public String addPost(Model model, @ModelAttribute("Post") Post post){
        System.out.println(post.getContent());

        post.setCreatedDate(java.time.LocalDateTime.now());
        postRepository.save(post);
        return "post.html";
    }

    @DeleteMapping(value = "/posts")
    public void deletePost(){

    }
}
