package com.example.crud.spring.dao;

import com.example.crud.spring.entity.Student;
import com.example.crud.spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentDaoImp implements  StudentDao{

    private StudentRepository studentRepository;


    @Autowired
    public void StudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
     return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long rollNo) {
        studentRepository.deleteById(rollNo);
    }

    @Override
    public boolean checkStudentExist(Long rollNo) {
       return studentRepository.existsById(rollNo);
    }

    @Override
    public Student getStudent(Long rollNo) {
        return studentRepository.findById(rollNo).get();
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

}
