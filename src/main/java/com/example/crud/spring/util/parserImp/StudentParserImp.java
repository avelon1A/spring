package com.example.crud.spring.util.parserImp;

import com.example.crud.spring.dto.StudentDto;
import com.example.crud.spring.dto.StudentReturnDto;
import com.example.crud.spring.entity.Student;
import com.example.crud.spring.util.parser.StudentParser;
import org.springframework.stereotype.Component;

@Component
public class StudentParserImp implements StudentParser {

    @Override
    public Student parseToEntity(StudentDto dto) {
        if (dto == null) {
            return null;
        }
        return new Student(dto.getRollNo(), dto.getName(), dto.getAddress()) ;
    }

    @Override
    public StudentReturnDto parseToReturnDto(Student student) {
        if (student == null) {
            return  null;
        }
        else{
            return new StudentReturnDto(student.getId(),student.getRollNo(),student.getName(),student.getAddress());
        }
    }


}


