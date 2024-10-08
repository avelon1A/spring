package com.example.crud.spring.dao;

import com.example.crud.spring.entity.Student;

import java.util.List;

public interface StudentDao {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student updateStudent(Student student);

    void deleteStudent(Long rollNo);

    boolean checkStudentExist(Long rollNo);

    Student getStudent(Long rollNo);

    List<Student> findStudentsByName(String name);



}
