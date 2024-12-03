package com.abutua.student_backend.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abutua.student_backend.models.Shift;
import com.abutua.student_backend.models.Student;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
@CrossOrigin
public class StudentController {
    //private List<Student> students = Arrays.asList(
    //    new Student(1,"José Oliveira", "jose@email.com","(11)99999-1111", 1, 1),
    //    new Student(2,"Maria Santos", "maria@email.com","(11)99999-2222", 1, 1)
    //);
    private List<Student> students = new ArrayList<>();






    @GetMapping("students/{id}")
    public ResponseEntity <Student> getStudent(@PathVariable int id){
       
        Student stud = students.stream().filter(s->s.getId() == id).findFirst()
                               .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found"));
        

        return ResponseEntity.ok(stud);
    }

    @PostMapping("students")
    public ResponseEntity<Student> save(@RequestBody Student student){
        student.setId(students.size()+1);
        students.add(student);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(location).body(student);
    }


    @GetMapping("students")
    public List<Student> getStudents(){
        return students;


    }
}
