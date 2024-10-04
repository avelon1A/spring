package com.example.crud.spring.dto;

public class StudentReturnDto {

        private Long id;
        private Long rollNo;
        private String name;
        private String address;

        public StudentReturnDto(Long id,Long rollNo, String name, String address) {
            this.id = id;
            this.rollNo = rollNo;
            this.name = name;
            this.address = address;

        }
        public Long getRollNo() {
            return rollNo;
        }

        public void setRollNo(Long rollNo) {
            this.rollNo = rollNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
        public Long getId() {
            return id;
        }
    }
