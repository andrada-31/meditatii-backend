package com.meditatii.management.backend.students.dto;

import com.meditatii.management.backend.students.entities.GradeEntity;
import com.meditatii.management.backend.students.entities.GradeType;
import com.meditatii.management.backend.students.entities.StudentEntity;
import lombok.Data;

import java.util.Date;

@Data
public class CreateGradeDto {
    private String studentId;
    private Double points;
    private Date date;
    private GradeType gradeType;

    public GradeEntity getGradeEntity(StudentEntity student){
        GradeEntity entity = new GradeEntity();
        entity.setPoints(points);
        entity.setDate(date);
        entity.setGradeType(gradeType);
        entity.setStudent(student);
        return entity;
    }
}
