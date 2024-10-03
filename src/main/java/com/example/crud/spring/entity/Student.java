package com.example.crud.spring.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private  Long rollNo;

    private String name;

    private String address;


  public Student() {

  }

    public Student(Long rollNo, String address, String name) {
        this.rollNo = rollNo;
        this.address = address;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", Address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRollNo() {return rollNo;}

    public void setRollNo(Long rollNo) {this.rollNo = rollNo;}


}
