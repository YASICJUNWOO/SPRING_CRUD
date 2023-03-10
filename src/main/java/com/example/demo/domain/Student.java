package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Student {
    private int studentId;
    private String name;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }
}
