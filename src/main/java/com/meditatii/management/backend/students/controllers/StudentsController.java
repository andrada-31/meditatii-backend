package com.meditatii.management.backend.students.controllers;

import com.meditatii.management.backend.students.dto.CreateStudentDto;
import com.meditatii.management.backend.students.dto.UpdateStudentDto;
import com.meditatii.management.backend.students.entities.StudentEntity;
import com.meditatii.management.backend.students.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    @Autowired    // inject the service automatically
    private StudentService service;

    @GetMapping    // mark this as a get endpoint
    public List<StudentEntity> getStudents(){
        return service.getAllStudents();
    }

    @PostMapping   // mark this as a post endpoint
    public StudentEntity createStudent(@RequestBody CreateStudentDto dto){
        StudentEntity createdStudent = service.createStudent(dto);
        return createdStudent;
    }

    @PatchMapping
    public ResponseEntity<StudentEntity> updateStudent(@RequestBody UpdateStudentDto dto){
        try {
            StudentEntity updatedStudent = service.updateStudent(dto);
            return ResponseEntity.ok(updatedStudent);  // when we have the ok status then we return the student and status 200
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id){
        service.deleteStudent(id);
    }
}
