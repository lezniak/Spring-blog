package com.example.demo.object;

import javax.persistence.*;


@Entity
public class Roles {

    public Roles(Integer role_id) {
        this.role_id = role_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;

    private String name;

    public Roles() {

    }

    public Integer getId() {
        return role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
