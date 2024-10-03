package com.example.crud.spring.service;

import com.example.crud.spring.dao.StudentDao;
import com.example.crud.spring.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{

    private StudentDao studentDao;


    @Autowired
    public void StudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @Override
    public void saveStudent(Student student) {
    studentDao.saveStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
     return   studentDao.getAllStudents();
    }

    @Override
    public Student updateStudent(Student student) {

        if(studentDao.checkStudentExist(student.getRollNo())){
            return  studentDao.updateStudent(student);
        }
        else {
             studentDao.saveStudent(student);
             return  student;
        }

    }

    @Override
    public void deleteStudent(Long rollNo) {
        studentDao.deleteStudent(rollNo);

    }

    @Override
    public Student getStudent(Long rollNo) {
        return  studentDao.getStudent(rollNo);
    }


}
