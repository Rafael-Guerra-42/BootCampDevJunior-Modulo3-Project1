package com.abutua.student_backend.models;

public class Student {
    private int id;
    private String name;
    private String email;
    private String phone;
    private int idCourse;
    private int idShift;

    public Student(int id, String name, String email, String phone, int idCourse, int idShift){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.idCourse = idCourse;
        this.idShift =idShift;
    }





    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getIdCourse() {
        return idCourse;
    }
    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }
    public int getIdShift() {
        return idShift;
    }
    public void setIdShift(int idShift) {
        this.idShift = idShift;
    }
}
