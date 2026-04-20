package com.meditatii.management.backend.students.services;

import com.meditatii.management.backend.students.dto.CreateGradeDto;
import com.meditatii.management.backend.students.entities.GradeEntity;
import com.meditatii.management.backend.students.entities.StudentEntity;
import com.meditatii.management.backend.students.repositories.GradeRepository;
import com.meditatii.management.backend.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository, StudentRepository studentRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
    }

    public GradeEntity createGrade(CreateGradeDto createGradeDto){
        Optional<StudentEntity> student = studentRepository.findById(createGradeDto.getStudentId());
        StudentEntity studentEntity = student.orElseThrow();
        GradeEntity grade = createGradeDto.getGradeEntity(studentEntity);
        return gradeRepository.save(grade);
    }

    public void deleteGrade(String id){gradeRepository.deleteById(id);}
}
