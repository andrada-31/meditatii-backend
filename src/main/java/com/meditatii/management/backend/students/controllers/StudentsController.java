package com.meditatii.management.backend.students.controllers;

import com.meditatii.management.backend.students.entities.StudentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    @GetMapping
    public List<StudentEntity> getStudents(){
        StudentEntity student1 = new StudentEntity("123bbb", "Ana");
        StudentEntity student2 = new StudentEntity("aaa123", "Marius");

        List<StudentEntity> students = new ArrayList<StudentEntity>();
        students.add(student1);
        students.add(student2);

        return students;
    }
}
