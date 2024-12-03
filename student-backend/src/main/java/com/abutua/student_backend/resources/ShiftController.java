package com.abutua.student_backend.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abutua.student_backend.models.Shift;
@RestController
public class ShiftController {

    private List<Shift> shifts = Arrays.asList(
        new Shift(1, "Manhã"),
        new Shift(2, "Tarde"),
        new Shift(3,"Noite")
    );







    @GetMapping("shifts")
    public List<Shift> getShifts(){

        return shifts;
    }
}
