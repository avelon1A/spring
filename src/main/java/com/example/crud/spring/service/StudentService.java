package com.example.crud.spring.service;

import com.example.crud.spring.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student updateStudent(Student student);

    void deleteStudent(Long rollNo);

    Student getStudent(Long rollNo);

     List<Student> findStudentsByName(String name) ;

}
