package com.meditatii.management.backend.students.services;

import com.meditatii.management.backend.shared.entities.ContactInfo;
import com.meditatii.management.backend.shared.repository.ContactInfoRepository;
import com.meditatii.management.backend.students.dto.CreateParentDto;
import com.meditatii.management.backend.students.dto.UpdateParentDto;
import com.meditatii.management.backend.students.entities.ParentEntity;
import com.meditatii.management.backend.students.entities.StudentEntity;
import com.meditatii.management.backend.students.repositories.ParentRepository;
import com.meditatii.management.backend.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ParentService {

    private final ParentRepository parentRepository;
    private final ContactInfoRepository contactInfoRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public ParentService(ParentRepository parentRepository, ContactInfoRepository contactInfoRepository, StudentRepository studentRepository) {
        this.parentRepository = parentRepository;
        this.contactInfoRepository = contactInfoRepository;
        this.studentRepository = studentRepository;
    }

    public ParentEntity createParent(CreateParentDto dto){
        ContactInfo contactInfo = contactInfoRepository.save(dto.getContactInfoEntity());
        ParentEntity parentEntity = dto.getParentEntity(contactInfo);
        ParentEntity parentSaved = parentRepository.save(parentEntity);
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(dto.getStudentId());
        StudentEntity student = studentEntityOptional.orElseThrow();
        student.setParent(parentSaved); // facem legatura dintre student-parent
        studentRepository.save(student);
        return parentSaved;
    }

    public ParentEntity updateParent(UpdateParentDto dto) throws NoSuchElementException {
        Optional<ParentEntity> result = parentRepository.findById(dto.getId());
        ParentEntity parent = result.orElseThrow();
        ParentEntity updatedParentEntity = dto.updateParentEntity(parent);
        parentRepository.save(updatedParentEntity);
        return parent;
    }
}
