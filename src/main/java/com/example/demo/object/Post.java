package com.example.demo.object;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import com.example.demo.object.User;
import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_post;
    private String content;
    @CreatedDate
    private LocalDateTime createdDate;

    public Integer getId_post() {
        return id_post;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}