package com.abutua.student_backend.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abutua.student_backend.models.Course;
import com.abutua.student_backend.models.Shift;

@RestController
public class CourseController {
    
    private List<Course> courses = Arrays.asList (
        new Course(1,"Java"),
        new Course(2, "Amgular"),
        new Course(3, "Html"),
        new Course(4, "Bootstrap")
    );

    //private List<Course> courses1 = new ArrayList<>();
    @GetMapping("courses")
    public List<Course>  getCourses(){

        return courses;
    }
    

}
