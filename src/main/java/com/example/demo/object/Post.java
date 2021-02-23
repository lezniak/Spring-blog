package com.example.demo.object;

import org.w3c.dom.Text;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_post;
    private String content;
    private Integer author;

    public Post() {
    }

    public Post(String content, Integer author) {
        this.content = content;
        this.author = author;
    }

    public Integer getId_post() {
        return id_post;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }
}
