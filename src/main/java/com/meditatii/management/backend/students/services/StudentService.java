package com.meditatii.management.backend.students.services;

import com.meditatii.management.backend.shared.entities.ContactInfo;
import com.meditatii.management.backend.shared.repository.ContactInfoRepository;
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

    private StudentRepository studentRepository;
    private ContactInfoRepository contactInfoRepository;

    @Autowired
    public StudentService(StudentRepository repository, ContactInfoRepository contactInfoRepository) {
        this.studentRepository = repository;
        this.contactInfoRepository = contactInfoRepository;
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentEntity createStudent(CreateStudentDto dto) {
        ContactInfo contactInfo = contactInfoRepository.save(dto.getContactInfoEntity());
        StudentEntity studentEntity = dto.getStudentEntity(contactInfo);
        return studentRepository.save(studentEntity);
    }


    public StudentEntity updateStudent(UpdateStudentDto dto) throws NoSuchElementException {
        Optional<StudentEntity> result = studentRepository.findById(dto.getId());  // because it is possible to not return a student (if it doesn't exist)
        StudentEntity student = result.orElseThrow();  // return 404 if the student does not exist
        StudentEntity updatedStudentEntity = dto.updateStudentEntity(student);
//        contactInfoRepository.save(updatedStudentEntity.getContactInfo());  // we must always save the related object before saving the entity or use cascades in entity
        studentRepository.save(updatedStudentEntity);
        return student;
    }

    public void deleteStudent(String id){
        studentRepository.deleteById(id);
    }

}
