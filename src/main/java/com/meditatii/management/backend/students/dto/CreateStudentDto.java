package com.meditatii.management.backend.students.dto;

import com.meditatii.management.backend.students.entities.GradeLevel;
import com.meditatii.management.backend.students.entities.StudentEntity;
import lombok.Data;

import java.util.Date;

@Data
public class CreateStudentDto {
    private String name;
    private Date dateOfBirth;
    private String school;
    private GradeLevel gradeLevel;
    private Double hourlyRate;

    public StudentEntity getStudentEntity(){
        StudentEntity entity = new StudentEntity();
        entity.setName(name);
        entity.setSchool(school);
        entity.setGradeLevel(gradeLevel);
        entity.setHourlyRate(hourlyRate);
        entity.setDateOfBirth(dateOfBirth);
        return entity;
    }
}
