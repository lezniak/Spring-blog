package com.example.demo.controller;

import com.example.demo.object.Post;
import com.example.demo.repository.postRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class postController {
    @Autowired
    postRepository postRepository;
    @GetMapping(value = "/post")
    public String menuPost(){
        return "post.html";
    }

    @PostMapping(value = "/post")
    public void addPost(@RequestBody Post post){

    }

    @DeleteMapping(value = "/post")
    public void deletePost(){

    }
}
