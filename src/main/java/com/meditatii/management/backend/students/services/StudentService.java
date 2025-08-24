package com.meditatii.management.backend.students.services;

import com.meditatii.management.backend.students.dto.CreateStudentDto;
import com.meditatii.management.backend.students.dto.UpdateStudentDto;
import com.meditatii.management.backend.students.entities.StudentEntity;
import com.meditatii.management.backend.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<StudentEntity> getAllStudents() {
        return repository.findAll();
    }

    public StudentEntity createStudent(CreateStudentDto dto) {
        return repository.save(dto.getStudentEntity());
    }


    public StudentEntity updateStudent(UpdateStudentDto dto) throws NoSuchElementException {
        Optional<StudentEntity> result = repository.findById(dto.getId());  // because it is possible to not return a student (if it doesn't exist)
        StudentEntity student = result.orElseThrow();
        repository.save(dto.updateStudentEntity(student));
        return student;
    }

    public void deleteStudent(String id){
        repository.deleteById(id);
    }

}
