package com.abutua.student_backend.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PathVariable;
import com.abutua.student_backend.models.Student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
public class StudentController {
    private List<Student> students = Arrays.asList(
        new Student(1,"José Oliveira", "jose@email.com","(11)99999-1111", 1, 1),
        new Student(2,"Maria Santos", "maria@email.com","(11)99999-2222", 1, 1)
    );
    //private List<Student> students = new ArrayList<>();
    
    @GetMapping("students/{id}")
    public ResponseEntity <Student> getStudent(@PathVariable int id){
       
        Student stud = students.stream().filter(s->s.getId() == id).findFirst()
                               .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found"));
        

        return ResponseEntity.ok(stud);
    }




    @GetMapping("students")
    public List<Student> getStudents(){
        return students;


    }
}
