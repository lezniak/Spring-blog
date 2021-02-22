package com.example.demo.repository;

import com.example.demo.object.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface postRepository extends CrudRepository<Post,Integer> {
    public List<Post> findAll();
}
