package com.example.crud.spring.service.imp;

import com.example.crud.spring.dao.StudentDao;
import com.example.crud.spring.entity.Student;
import com.example.crud.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    private StudentDao studentDao;


    @Autowired
    public void StudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @Override
    public Student saveStudent(Student student) {
   return studentDao.saveStudent(student);

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

    @Override
    public List<Student> findStudentsByName(String name) {
        return studentDao.findStudentsByName(name);
    }


}
