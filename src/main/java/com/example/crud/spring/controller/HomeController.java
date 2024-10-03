package com.example.crud.spring.controller;


import com.example.crud.spring.entity.Student;
import com.example.crud.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @PostMapping("/saveStudent")
    public Student saveData(@RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
    @DeleteMapping("/delete/{rollNo}")
    public void deleteStudent(@PathVariable Long rollNo) {
        studentService.deleteStudent(rollNo);
    }

    @GetMapping("/getStudent/{rollNo}")
    public Student getStudent(@PathVariable Long rollNo) {
        return studentService.getStudent(rollNo);
    }

}
