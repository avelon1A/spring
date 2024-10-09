package com.example.crud.spring.controller;

import com.example.crud.spring.dto.StudentDto;
import com.example.crud.spring.entity.Text;
import com.example.crud.spring.util.parser.StudentParser;
import com.example.crud.spring.dto.StudentReturnDto;
import com.example.crud.spring.entity.Student;
import com.example.crud.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;




@RestController
public class HomeController {

    private final StudentService studentService;
    private final StudentParser studentParser;
    private final Text text = new Text();

    @Autowired
    public HomeController(StudentService studentService, StudentParser studentParser) {
        this.studentService = studentService;
        this.studentParser = studentParser;

    }

    @GetMapping("/")
    public Text home() {
        return text;
    }

    @PostMapping("/saveStudent")
    public StudentReturnDto saveStudent(@RequestBody StudentDto studentDto) {
        Student student = studentParser.parseToEntity(studentDto);
        Student savedStudent = studentService.saveStudent(student);
        return studentParser.parseToReturnDto(savedStudent);
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
    @GetMapping("/getStudentByName")
      public List<Student> getStudentByName(@RequestParam  String name) {
        return studentService.findStudentsByName(name);
    }


}


