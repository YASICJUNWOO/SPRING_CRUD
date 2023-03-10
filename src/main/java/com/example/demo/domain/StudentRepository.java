package com.example.demo.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {

    //학생 저장소 객체 (유일 - final)
    private final static StudentRepository instatnce = new StudentRepository();

    //유일한 학생 저장소 접근 방식
    public static StudentRepository getInstance() {
        return instatnce;
    }

    //------------------------------------------------------------------------

    //실제 학생 데이터를 저장할 컨테이너
    private static Map<Integer, Student> store = new HashMap<>();

    //학생등록
    public Student save(Student student) {
        store.put(student.getStudentId(), student);
        return student;
    }

    //학생 수정
    public Student put(Student student1 , Student student2) {
        store.get(student1.getStudentId()).setName(student2.getName());
        return store.get(student1.getStudentId());
    }

    //학생 삭제
    public void delete(Student student) {
        store.remove(student.getStudentId());
    }

    //------------------------------------------------------------------------

    //전체 학생 조회
    public List<Student> findAll() {
        return new ArrayList<>(store.values());
    }


    //------------------------------------------------------------------------

    //테스트를 위한 전체 삭제 메소드
    void clearAll(){
        store.clear();
    }

    //테스트를 위한 학번으로 학생 찾기
    public Student findById(int studentId) {
        return store.get(studentId);
    }

}
