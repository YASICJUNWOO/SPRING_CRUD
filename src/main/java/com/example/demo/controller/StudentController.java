package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class StudentController {

    private StudentRepository studentRepository = StudentRepository.getInstance();

    //회원 등록 폼
    @RequestMapping("/form")
    public String form() {
        return "response/student/form";
    }

    //회원 등록 모듈
    //이미 학번이 있다면 실패 페이지로 리턴
    @RequestMapping("/save")
    public String save(@RequestParam Integer studentId, @RequestParam String name) {
        if(studentRepository.findById(studentId)!=null){
            return "response/exception/saveFail";
        }
        Student st = new Student(studentId, name);
        studentRepository.save(st);
        return "redirect:studentList";
    }

    //학생 목록
    @RequestMapping("/studentList")
    public String studentList(Model model) {
        model.addAttribute("studentList", studentRepository.findAll());
        return "response/student/studentList";
    }
}
