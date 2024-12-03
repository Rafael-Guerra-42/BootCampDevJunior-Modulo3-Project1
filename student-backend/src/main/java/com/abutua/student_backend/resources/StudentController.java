package com.abutua.student_backend.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abutua.student_backend.models.Student;
@RestController
public class StudentController {
    private List<Student> students = Arrays.asList(
        new Student(1,"José Oliveira", "jose@email.com","(11)99999-1111", 1, 1),
        new Student(1,"Maria Santos", "maria@email.com","(11)99999-2222", 1, 1)
    );
    //private List<Student> students = new ArrayList<>();
    






    @GetMapping("students")
    public List<Student> getStudents(){
        return students;


    }
}
