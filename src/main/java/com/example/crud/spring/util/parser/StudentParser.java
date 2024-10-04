package com.example.crud.spring.util.parser;

import com.example.crud.spring.dto.StudentDto;
import com.example.crud.spring.dto.StudentReturnDto;
import com.example.crud.spring.entity.Student;

public interface StudentParser {
    Student parseToEntity(StudentDto dto);
    StudentReturnDto parseToReturnDto(Student student);
}