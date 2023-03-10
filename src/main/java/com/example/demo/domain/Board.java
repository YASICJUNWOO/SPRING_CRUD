package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Board {

    private Long id;
    private Integer authId;
    private String authName;
    private String title;
    private String content;

    public Board(Integer authId, String authName, String title, String content) {
        this.authId = authId;
        this.authName = authName;
        this.title = title;
        this.content = content;
    }
}
