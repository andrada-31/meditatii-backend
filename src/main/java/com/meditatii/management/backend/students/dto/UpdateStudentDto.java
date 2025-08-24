package com.meditatii.management.backend.students.dto;

import com.meditatii.management.backend.students.entities.GradeLevel;
import com.meditatii.management.backend.students.entities.StudentEntity;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateStudentDto {
    private String id;
    private String name;
    private Date dateOfBirth;
    private String school;
    private GradeLevel gradeLevel;
    private Double hourlyRate;

    public StudentEntity updateStudentEntity(StudentEntity student){
        if(this.getDateOfBirth() != null)
            student.setDateOfBirth(this.getDateOfBirth());

        if(this.getName() != null)
            student.setName(this.getName());

        if(this.getSchool() != null)
            student.setSchool(this.getSchool());

        if(this.getGradeLevel() != null)
            student.setGradeLevel(this.getGradeLevel());

        if(this.getHourlyRate() != null)
            student.setHourlyRate(this.getHourlyRate());

        return student;
    }
}
