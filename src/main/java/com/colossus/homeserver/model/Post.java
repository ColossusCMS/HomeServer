package com.colossus.homeserver.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String content;
    private String code;
    private int status;

    public Post() {}

    public Post(String content, String code) {
        this.content = content;
        this.code = code;
    }
}
