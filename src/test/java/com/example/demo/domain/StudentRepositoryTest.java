package com.example.demo.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    StudentRepository studentRepository = StudentRepository.getInstance();

    @AfterEach
    void afterEach(){
        studentRepository.clearAll();
    }

    @Test
    void save() {
        //given
        Student student = new Student(12205179, "junwoo");
        Student student2 = new Student(12205046, "seonghun");

        //when
        Student savedStudent = studentRepository.save(student);
        Student savedStudent2 = studentRepository.save(student2);

        //then
        Student findStudent = StudentRepository.getInstance().findById(savedStudent.getStudentId());
        assertThat(findStudent).isEqualTo(savedStudent);
    }

    @Test
    void findAll() {
        //given
        Student student1 = new Student(12205179, "jw");
        Student student2 = new Student(1220516, "sh");

        studentRepository.save(student1);
        studentRepository.save(student2);

        //when
        List<Student> students = studentRepository.findAll();

        //then
        assertThat(students.size()).isEqualTo(2);
        assertThat(students).contains(student1, student2);

    }

    @Test
    void put() {
        //given
        Student student1 = new Student(12205179, "junwoo");
        Student student2 = new Student(12205178, "jw");

        studentRepository.save(student1);

        //when
        Student putedStudent = studentRepository.put(student1,student2);

        //then
        Student findStudent = StudentRepository.getInstance().findById(putedStudent.getStudentId());
        assertThat(findStudent.getName()).isEqualTo("jw");
    }

    @Test
    void delete() {
        //given
        Student student = new Student(12205179, "junwoo");
        Student student2 = new Student(12205046, "seonghun");

        studentRepository.save(student);

        //when
        studentRepository.delete(student2);
        List<Student> students = studentRepository.findAll();

        //then
        assertThat(students.size()).isEqualTo(0);
    }
}