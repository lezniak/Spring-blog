package com.example.demo.repository;

import com.example.demo.object.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;


public interface roleRepository extends CrudRepository<Roles,Integer> {

}
