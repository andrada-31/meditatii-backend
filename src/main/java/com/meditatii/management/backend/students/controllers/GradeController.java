package com.meditatii.management.backend.students.controllers;


import com.meditatii.management.backend.students.dto.CreateGradeDto;
import com.meditatii.management.backend.students.entities.GradeEntity;
import com.meditatii.management.backend.students.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping
    public GradeEntity createGrade(@RequestBody CreateGradeDto dto){
        return gradeService.createGrade(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable String id){gradeService.deleteGrade(id);}
}
